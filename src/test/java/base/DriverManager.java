package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

    private static AppiumDriver driver;

    // ✅ Always create fresh driver
    public static AppiumDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public static AppiumDriver createDriver() {
        String platform = System.getProperty("platform", "android");
        System.out.println("🚀 System property 'platform': " + platform);

        platform = platform.toLowerCase();

        if (platform.equals("ios")) {
            return createIOSDriver();
        } else if (platform.equals("android")) {
            return createAndroidDriver();
        } else {
            throw new RuntimeException("Unknown platform: " + platform);
        }
    }

    private static void waitForAppium() throws InterruptedException {
        int retries = 30;

        while (retries-- > 0) {
            try {
                URL url = new URL("http://127.0.0.1:4723/status");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(2000);
                conn.setReadTimeout(2000);

                if (conn.getResponseCode() == 200) {
                    return;
                }
            } catch (Exception ignored) {}

            Thread.sleep(2000);
        }

        throw new RuntimeException("❌ Appium server not ready");
    }

    public static AndroidDriver createAndroidDriver() {
        try {

            waitForAppium();

            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setPlatformVersion("13")
                    //.setUdid("adb-R5GYC0FDK7Y-Ba1z57._adb-tls-connect._tcp") //Wireless
                    .setUdid("emulator-5554")
                    .setAppPackage("com.dac.smacnshop")
                    .setAppWaitActivity("com.dac.smacnshop.*")
                    .setAutomationName("UiAutomator2")

                    .setNoReset(false)
                    .setFullReset(false)

                    .autoGrantPermissions()
                    .setNewCommandTimeout(Duration.ofMinutes(10));

            AndroidDriver driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    options
            );

            System.out.println("🛞 Driver created: " + driver.getSessionId());
            return driver;

        } catch (Exception e) {
            throw new RuntimeException("Android driver creation failed", e);
        }
    }

    public static IOSDriver createIOSDriver() {
        try {
            String appPath = System.getProperty("user.dir") + "/src/test/resources/app/Runner.app";
            File app = new File(appPath);
            if (!app.exists()) throw new RuntimeException("❌ App not found: " + appPath);

            XCUITestOptions options = new XCUITestOptions()
                    .setPlatformName("iOS")
                    .setAutomationName("XCUITest")
                    .setDeviceName("iPhone 15 Pro")
                    .setPlatformVersion("17.5")
                    .setApp(appPath)
                    .setNoReset(false)
                    .setFullReset(false) //do not reinstall app
                    .setResetOnSessionStartOnly(true) //wipes data
                    .setUseNewWDA(true)
                    .setAutoAcceptAlerts(true)
                    .setWdaStartupRetries(4)
                    .setWdaLaunchTimeout(Duration.ofSeconds(120))
                    .setNewCommandTimeout(Duration.ofSeconds(300));

            IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("✅🍎 iOS driver created: " + driver.getSessionId());
            return driver;
        } catch (Exception e) {
            throw new RuntimeException("iOS driver creation failed", e);
        }
    }
}