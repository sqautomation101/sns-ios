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

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                System.out.println("🔴 Quitting Appium session: " + driver.getSessionId());
                driver.quit();
                System.out.println("🟢 Appium session quit.");
            } catch (Exception e) {
                System.err.println("❌ Failed to quit Appium session:");
                e.printStackTrace();
            } finally {
                driver = null;
            }
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

            XCUITestOptions options = new XCUITestOptions()
                    .setPlatformName("iOS")
                    .setAutomationName("XCUITest")
                    .setUdid("F2E8376C-3F3E-4A74-B8F7-68449BD6F167")
                    .setBundleId("com.dac.smacnshop")
                    .setDeviceName("iPhone 15")
                    .setPlatformVersion("18.6")
                    .setNoReset(false)
                    .setFullReset(false)
                    .setResetOnSessionStartOnly(true)
                    .setUseNewWDA(false)
                    .setAutoAcceptAlerts(true)
                    .setWdaStartupRetries(4)
                    .setWdaLaunchTimeout(Duration.ofSeconds(120))
                    .setNewCommandTimeout(Duration.ofSeconds(300));

            driver = new IOSDriver(
                    new URL("http://127.0.0.1:4723"),
                    options
            );

            System.out.println("✅🍎 iOS driver created: "
                    + driver.getSessionId());

            return (IOSDriver) driver;

        } catch (Exception e) {
            throw new RuntimeException("iOS driver creation failed", e);
        }
    }
}