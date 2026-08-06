package hooks;

import base.DriverManager;
import base.PageManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import util.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.Properties;

public class Hooks {


    private static AppiumDriver driver;
    private static PageManager pageManager;

    // Module (Feature) tracking
    private static Map<String, Long> moduleStartTime = new HashMap<>();
    private static Map<String, Long> moduleEndTime = new HashMap<>();


    // --------------------- SUITE HOOKS ---------------------
    @BeforeAll
    public static void beforeAll() {
        System.out.println("🚀 Suite started...");

        File dir = new File("target/allure-results");
        dir.mkdirs();

        Properties props = new Properties();
        props.setProperty("Platform", "Android");
        props.setProperty("Device", "Pixel 5 - Android 13");
        props.setProperty("Environment", "Stg");
        props.setProperty("Release", "24");
        props.setProperty("Automation", "Appium");

        try (FileOutputStream fos =
                     new FileOutputStream("target/allure-results/environment.properties")) {
            props.store(fos, null);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterAll
    public static void afterAll() {
        if (moduleStartTime.isEmpty() || moduleEndTime.isEmpty()) {
            System.out.println("⚠️ No modules executed. Cannot calculate suite duration.");
            return;
        }

        // Get earliest module start and latest module end
        long suiteStartMillis = moduleStartTime.values().stream().min(Comparator.naturalOrder()).get();
        long suiteEndMillis = moduleEndTime.values().stream().max(Comparator.naturalOrder()).get();

        String suiteStartTime = TimeUtil.formatMillis(suiteStartMillis);
        String suiteEndTime = TimeUtil.formatMillis(suiteEndMillis);
        String suiteDuration = TimeUtil.formatDuration(suiteStartMillis, suiteEndMillis);

        System.out.println("🏁 Suite End: " + suiteEndTime);
        System.out.println("⏱ Total Duration: " + suiteDuration);

        // Write Suite CSV using first module start & last module end
        CSVWriterUtil.writeSuiteSummary(suiteStartTime, suiteEndTime, suiteDuration);

        // Write Module Timing CSV
        CSVWriterUtil.writeModuleTimings(moduleStartTime, moduleEndTime);
    }

    @Before(order = 0) // runs before all scenarios
    public void loadGlobalTestData() throws Exception {
        TestDataManager.loadAllData();// loads all CSVs once
        System.out.println("🟢 Loading CSVs...");
    }

    @Before(order = 0)
    public void setSeverity(Scenario scenario) {

        if (scenario.getSourceTagNames().contains("@critical")) {
            Allure.label("severity", "blocker");

        } else if (scenario.getSourceTagNames().contains("@high")) {
            Allure.label("severity", "critical");

        } else if (scenario.getSourceTagNames().contains("@medium")) {
            Allure.label("severity", "normal");

        } else if (scenario.getSourceTagNames().contains("@low")) {
            Allure.label("severity", "minor");
        }
    }

//    private static TestContext testContext;
//
//    @Before(order = 0)
//    public void setUpTestContext() {
//        testContext = new TestContext();
//    }
//
//    public static TestContext getTestContext() {
//        return testContext;
//    }

    @Before(order = 1)
    public void resetApp() throws Exception {

        ProcessBuilder builder = new ProcessBuilder(
                "adb",
                "shell",
                "pm",
                "clear",
                "com.dac.smacnshop");

        Process process = builder.start();
        process.waitFor();
        System.out.println("🟢 Clearing App...");
    }

    // --------------------- SCENARIO HOOKS ---------------------
    @Before(order = 2)
    public void setUpDriver(Scenario scenario) throws IOException, InterruptedException {
        System.out.println("🟢 Setting up Driver...");
        if (scenario.getSourceTagNames().contains("@ios")) {
            driver = DriverManager.createIOSDriver();
            pageManager = new PageManager(driver);
        } else if (scenario.getSourceTagNames().contains("@android")) {
            driver = DriverManager.createAndroidDriver();
            pageManager = new PageManager(driver);
        } else {
            throw new RuntimeException("❌ No platform tag (@ios or @android)");
        }
    }

    @Before(order = 3)
    public void beforeScenario(Scenario scenario) {
        String module = getFeatureName(scenario);
        moduleStartTime.putIfAbsent(module, TimeUtil.nowMillis());
        System.out.println("🟢 Capturing duration...");
    }

    @Before(order = 4)
    public void ensureAppHasInternet(Scenario scenario) {
        if (driver == null) return;

        UtilNetwork network = new UtilNetwork(driver);

        try {
            System.out.println("🔹 Ensuring app has internet before scenario: " + scenario.getName());

            // Launch app first and check internet
            network.launchAppAndEnsureInternet();

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to ensure internet for scenario: " + scenario.getName(), e);
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    // This runs first
    @After(order = 3)
    public void attachFailureScreenshot(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            System.out.println("📸 Attaching screenshot to Allure...");
            attachScreenshot();
        }
    }

    @After(order = 2)
    public void afterScenario(Scenario scenario) {
        String module = getFeatureName(scenario);
        moduleEndTime.put(module, TimeUtil.nowMillis());
        System.out.println("🔴 Capturing duration...");
    }

    @After(order = 1)
    public void tearDown() {

        try {
            if (driver != null) {
                driver.quit();
                Thread.sleep(2000);
            }
        } catch (Exception ignored) {}

        driver = null;
        pageManager = null;

        System.out.println("🟢 Driver cleanup...");
    }



    // --------------------- GETTERS ---------------------
    public static AppiumDriver getDriver() { return driver; }
    public static PageManager getPageManager() { return pageManager; }

    // --------------------- HELPER ---------------------
    private String getFeatureName(Scenario scenario) {
        try {
            Path path = new File(scenario.getUri()).toPath();
            for (String line : Files.readAllLines(path)) {
                line = line.trim();
                if (line.startsWith("Feature:")) {
                    return line.replace("Feature:", "").trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unknown Feature";
    }
}