////package util;
////
////import io.appium.java_client.android.AndroidDriver;
////
////public class UtilNetwork {
////
////    public AndroidDriver driver;
////
////    public UtilNetwork(AndroidDriver driver) {
////        this.driver = driver;
////    }
////
////    // 🔹 Ensure Wi-Fi ON
////    public void waitForInternetConnection(int timeoutSeconds) {
////        int waited = 0;
////
////        while (waited < timeoutSeconds * 1000) {
////            try {
////                Process process = Runtime.getRuntime().exec(
////                        "adb shell ping -c 1 8.8.8.8"
////                );
////
////                if (process.waitFor() == 0) {
////                    return; // Internet is working
////                }
////
////            } catch (Exception ignored) {}
////
////            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
////            waited += 1000;
////        }
////
////        throw new RuntimeException("Internet not available after waiting");
////    }
////
////    public void ensureWifiOn() {
////        try {
////            if (!driver.getConnection().isWiFiEnabled()) {
////                System.out.println("Wi-Fi is OFF, turning it ON...");
////                driver.toggleWifi();
////            }
////
////            waitForInternetConnection(20); // 🔥 important
////
////            System.out.println("Wi-Fi + Internet confirmed ON ✅");
////
////        } catch (Exception e) {
////            throw new RuntimeException("Failed to ensure Wi-Fi is ON", e);
////        }
////    }
////
////    public boolean isWifiAndInternetReady() {
////        try {
////            if (!driver.getConnection().isWiFiEnabled()) {
////                return false;
////            }
////
////            // Check actual internet by pinging 8.8.8.8
////            Process process = Runtime.getRuntime().exec("adb shell ping -c 1 8.8.8.8");
////            return process.waitFor() == 0;
////        } catch (Exception e) {
////            return false;
////        }
////    }
////
////
//////    // Ensure Wi-Fi is ON
//////    public void ensureWifiOn() {
//////        try {
//////            if (!driver.getConnection().isWiFiEnabled()) {
//////                System.out.println("Wi-Fi is OFF, turning it ON...");
//////                driver.toggleWifi();
//////
//////                // Wait until Wi-Fi is ON
//////                int waited = 0;
//////                int timeout = 10; // seconds
//////                while (!driver.getConnection().isWiFiEnabled() && waited < timeout * 1000) {
//////                    Thread.sleep(500);
//////                    waited += 500;
//////                }
//////
//////                if (!driver.getConnection().isWiFiEnabled()) {
//////                    throw new RuntimeException("Failed to turn ON Wi-Fi");
//////                }
//////            } else {
//////                System.out.println("Wi-Fi is already ON");
//////            }
//////        } catch (Exception e) {
//////            throw new RuntimeException("Error ensuring Wi-Fi is ON", e);
//////        }
//////    }
////
////    // Optional: Check Wi-Fi status
////    public boolean isWifiOn() {
////        try {
////            return driver.getConnection().isWiFiEnabled();
////        } catch (Exception e) {
////            return false;
////        }
////    }
////
////    public void enableWifi() {
////        driver.toggleWifi();
////    }
////
////    public void disableWifi() {
////        driver.toggleWifi();
////    }
////
////    public boolean isOnline() {
////        return driver.getConnection().isWiFiEnabled();
////    }
////
////    public void setAirplaneMode(boolean enable, int wait) {
////        try {
////            // 1️⃣ Try Appium first
////            driver.toggleAirplaneMode();
////            Thread.sleep(wait);
////            System.out.println("Airplane mode toggled using Appium");
////        } catch (Exception e) {
////            System.out.println("Appium toggle failed. Falling back to ADB...");
////            toggleAirplaneModeUsingAdb(enable);
////        }
////    }
////
////    public void toggleAirplaneModeUsingAdb(boolean enable) {
////        try {
////            String mode = enable ? "1" : "0";
////            String state = enable ? "true" : "false";
////
////            Runtime.getRuntime().exec(
////                    "adb shell settings put global airplane_mode_on " + mode
////            );
////
////            Runtime.getRuntime().exec(
////                    "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state " + state
////            );
////
////            System.out.println("Airplane mode set to " + enable + " using ADB");
////        } catch (Exception ex) {
////            throw new RuntimeException("Failed to toggle airplane mode via ADB", ex);
////        }
////    }
////
////}
////
//////import io.appium.java_client.android.AndroidDriver;
//////
//////import java.io.BufferedReader;
//////import java.io.InputStreamReader;
//////
//////public class UtilNetwork {
//////
//////    public final AndroidDriver driver;
//////
//////    public UtilNetwork(AndroidDriver driver) {
//////        this.driver = driver;
//////    }
//////
//////    /*** Check if Wi-Fi is ON via ADB ***/
//////    public boolean isWifiOn() {
//////        try {
//////            Process process = Runtime.getRuntime().exec("adb shell dumpsys wifi | grep 'Wi-Fi is'");
//////            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//////            String line = reader.readLine();
//////            if (line != null && line.toLowerCase().contains("enabled")) {
//////                return true;
//////            }
//////        } catch (Exception e) {
//////            System.err.println("Failed to check Wi-Fi: " + e.getMessage());
//////        }
//////        return false;
//////    }
//////
//////    /*** Enable Wi-Fi if not already ON ***/
//////    public void enableWifi() {
//////        try {
//////            if (!isWifiOn()) {
//////                Runtime.getRuntime().exec("adb shell svc wifi enable");
//////                waitForWifiState(true, 10); // wait up to 10s for Wi-Fi to turn on
//////            }
//////        } catch (Exception e) {
//////            throw new RuntimeException("Failed to enable Wi-Fi", e);
//////        }
//////    }
//////
//////    /*** Disable Wi-Fi if ON ***/
//////    public void disableWifi() {
//////        try {
//////            if (isWifiOn()) {
//////                Runtime.getRuntime().exec("adb shell svc wifi disable");
//////                waitForWifiState(false, 10); // wait up to 10s for Wi-Fi to turn off
//////            }
//////        } catch (Exception e) {
//////            throw new RuntimeException("Failed to disable Wi-Fi", e);
//////        }
//////    }
//////
//////    /*** Ensure Wi-Fi is ON (Appium first, fallback to ADB) ***/
//////    public void ensureWifiOn() {
//////        try {
//////            if (!isWifiOn()) {
//////                System.out.println("[DEBUG] Wi-Fi is OFF, enabling via ADB...");
//////                Runtime.getRuntime().exec("adb shell svc wifi enable");
//////                waitForWifiState(true, 10);
//////                System.out.println("[DEBUG] Wi-Fi enabled ✅");
//////            } else {
//////                System.out.println("[DEBUG] Wi-Fi already ON");
//////            }
//////        } catch (Exception e) {
//////            throw new RuntimeException("Failed to ensure Wi-Fi is ON", e);
//////        }
//////    }
//////
//////    /*** Toggle airplane mode via ADB only ***/
//////    public void setAirplaneMode(boolean enable, int waitMs) {
//////        try {
//////            String mode = enable ? "1" : "0";
//////            String state = enable ? "true" : "false";
//////
//////            // Set airplane mode
//////            Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on " + mode);
//////
//////            // Broadcast the change
//////            Runtime.getRuntime().exec(
//////                    "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state " + state
//////            );
//////
//////            Thread.sleep(waitMs);
//////            System.out.println("[DEBUG] Airplane mode set to " + enable + " via ADB");
//////
//////        } catch (Exception ex) {
//////            throw new RuntimeException("Failed to toggle airplane mode via ADB", ex);
//////        }
//////    }
//////
//////    /*** Fallback method to toggle airplane mode via ADB ***/
//////    public void toggleAirplaneModeUsingAdb(boolean enable) {
//////        try {
//////            String mode = enable ? "1" : "0";
//////            String state = enable ? "true" : "false";
//////
//////            Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on " + mode);
//////            Runtime.getRuntime().exec(
//////                    "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state " + state
//////            );
//////            Thread.sleep(1000); // wait a bit for the state to take effect
//////        } catch (Exception ex) {
//////            throw new RuntimeException("Failed to toggle airplane mode via ADB", ex);
//////        }
//////    }
//////
//////    /*** Wait for Wi-Fi to reach expected state ***/
//////    public void waitForWifiState(boolean expectedEnabled, int timeoutSeconds) throws Exception {
//////        int waited = 0;
//////        while (waited < timeoutSeconds * 1000) {
//////            if (isWifiOn() == expectedEnabled) {
//////                return;
//////            }
//////            Thread.sleep(500);
//////            waited += 500;
//////        }
//////        throw new RuntimeException("Wi-Fi did not reach expected state: " + expectedEnabled);
//////    }
//////}
//
//
//package util;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//
//public class UtilNetwork {
//
//    public AppiumDriver driver;
//
//    public UtilNetwork(AppiumDriver driver) {
//        this.driver = driver;
//    }
//
//    // 🔹 Wait until internet is reachable (works for BOTH Android & iOS)
//    public void waitForInternetConnection(int timeoutSeconds) {
//        int waited = 0;
//
//        while (waited < timeoutSeconds * 1000) {
//            try {
//                Process process = Runtime.getRuntime().exec("ping -c 1 8.8.8.8");
//
//                if (process.waitFor() == 0) {
//                    return; // Internet is working
//                }
//
//            } catch (Exception ignored) {}
//
//            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
//            waited += 1000;
//        }
//
//        throw new RuntimeException("Internet not available after waiting");
//    }
//
//    // 🔹 Ensure network is ready
//    public void ensureWifiOn() {
//        try {
//            String platform = driver.getCapabilities().getPlatformName().toString();
//
//            if (platform.equalsIgnoreCase("android")) {
//                AndroidDriver androidDriver = (AndroidDriver) driver;
//
//                if (!androidDriver.getConnection().isWiFiEnabled()) {
//                    System.out.println("Wi-Fi is OFF, turning it ON...");
//                    androidDriver.toggleWifi();
//                }
//
//                waitForInternetConnection(20);
//                System.out.println("Wi-Fi + Internet confirmed ON ✅");
//
//            } else if (platform.equalsIgnoreCase("ios")) {
//                // iOS cannot toggle WiFi → only check connection
//                System.out.println("iOS detected - checking internet connection only...");
//                waitForInternetConnection(20);
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to ensure network is ready", e);
//        }
//    }
//
//    // 🔹 Check if network is ready
//    public boolean isWifiAndInternetReady() {
//        try {
//            String platform = driver.getCapabilities().getPlatformName().toString();
//
//            if (platform.equalsIgnoreCase("android")) {
//                AndroidDriver androidDriver = (AndroidDriver) driver;
//
//                if (!androidDriver.getConnection().isWiFiEnabled()) {
//                    return false;
//                }
//            }
//
//            // Works for BOTH platforms
//            Process process = Runtime.getRuntime().exec("ping -c 1 8.8.8.8");
//            return process.waitFor() == 0;
//
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    // 🔹 Optional helpers (safe for Android only)
//    public boolean isWifiOn() {
//        try {
//            if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("android")) {
//                return ((AndroidDriver) driver).getConnection().isWiFiEnabled();
//            }
//        } catch (Exception ignored) {}
//        return false;
//    }
//
//    public void enableWifi() {
//        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("android")) {
//            ((AndroidDriver) driver).toggleWifi();
//        }
//    }
//
//    public void disableWifi() {
//        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("android")) {
//            ((AndroidDriver) driver).toggleWifi();
//        }
//    }
//
//    public boolean isOnline() {
//        return isWifiAndInternetReady();
//    }
//
//    // 🔹 Airplane mode (Android only)
//    public void setAirplaneMode(boolean enable, int wait) {
//        if (!driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("android")) {
//            System.out.println("Airplane mode not supported on iOS via Appium");
//            return;
//        }
//
//        try {
//            ((AndroidDriver) driver).toggleAirplaneMode();
//            Thread.sleep(wait);
//            System.out.println("Airplane mode toggled using Appium");
//        } catch (Exception e) {
//            System.out.println("Appium toggle failed. Falling back to ADB...");
//            toggleAirplaneModeUsingAdb(enable);
//        }
//    }
//
//    public void toggleAirplaneModeUsingAdb(boolean enable) {
//        if (!driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("android")) return;
//
//        try {
//            String mode = enable ? "1" : "0";
//            String state = enable ? "true" : "false";
//
//            Runtime.getRuntime().exec(
//                    "adb shell settings put global airplane_mode_on " + mode
//            );
//
//            Runtime.getRuntime().exec(
//                    "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state " + state
//            );
//
//            System.out.println("Airplane mode set to " + enable + " using ADB");
//        } catch (Exception ex) {
//            throw new RuntimeException("Failed to toggle airplane mode via ADB", ex);
//        }
//    }
//}

package util;

import io.appium.java_client.AppiumDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * This is used for Offline virtual card scenario
 * */
public class UtilNetwork {

    private AppiumDriver driver;

    public UtilNetwork(AppiumDriver driver) {
        this.driver = driver;
    }

    // -------------------- NETWORK TOGGLE --------------------
    public boolean enableNetwork() {
        try {
            String platform = driver.getCapabilities().getPlatformName().toString();

            if (!platform.equalsIgnoreCase("android")) {
                System.out.println("iOS: cannot toggle network, only check internet");
                return false;
            }

            // Check Wi-Fi state first
            boolean wifiWasOff = isWifiOff();

            if (wifiWasOff) {
                System.out.println("🌐 Enabling network on emulator...");
                Runtime.getRuntime().exec("adb shell svc wifi enable");
                Runtime.getRuntime().exec("adb shell svc data enable");
                Thread.sleep(4000);
                System.out.println("✅ Network enabled on emulator");
            } else {
                System.out.println("🌐 Wi-Fi already ON, no need to toggle network");
            }

            return wifiWasOff; // return true if network was previously off
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to enable network", e);
        }
    }

    private boolean isWifiOff() {
        try {
            Process process = Runtime.getRuntime().exec("adb shell dumpsys wifi | grep 'Wi-Fi is'");
            java.util.Scanner s = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
            String output = s.hasNext() ? s.next() : "";
            return output.contains("disabled");
        } catch (Exception e) {
            return true; // assume off if we can't detect
        }
    }

    public void disableNetwork() {
        try {
            String platform = driver.getCapabilities().getPlatformName().toString();
            if (!platform.equalsIgnoreCase("android")) return;

            System.out.println("🔌 Disabling network on emulator...");
            Runtime.getRuntime().exec("adb shell svc wifi disable");
            Runtime.getRuntime().exec("adb shell svc data disable");
            Thread.sleep(3000);
            System.out.println("❌ Network disabled");
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to disable network", e);
        }
    }

    // -------------------- INTERNET CHECK --------------------
    public boolean isReallyOnline() {
        try {
            URL url = new URL("https://www.google.com/generate_204");
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setConnectTimeout(3000);
            urlc.setReadTimeout(3000);
            urlc.setRequestMethod("GET");
            urlc.connect();
            return urlc.getResponseCode() == 204;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForInternetConnection(int timeoutSeconds) {
        int waited = 0;
        while (waited < timeoutSeconds * 1000) {
            if (isReallyOnline()) return;
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            waited += 1000;
        }
        throw new RuntimeException("❌🌐 Internet not available after waiting");
    }

    // -------------------- APP RELAUNCH --------------------
    public void relaunchApp() {
        try {
            String platform = driver.getCapabilities().getPlatformName().toString();

            if (platform.equalsIgnoreCase("android")) {
                String appPackage = (String) driver.getCapabilities().getCapability("appPackage");
                driver.executeScript("mobile: terminateApp", Map.of("appId", appPackage));
                Thread.sleep(2000);
                driver.executeScript("mobile: activateApp", Map.of("appId", appPackage));

            } else if (platform.equalsIgnoreCase("ios")) {
                String bundleId = (String) driver.getCapabilities().getCapability("bundleId");
                driver.executeScript("mobile: terminateApp", Map.of("bundleId", bundleId));
                Thread.sleep(2000);
                driver.executeScript("mobile: activateApp", Map.of("bundleId", bundleId));
            }

            Thread.sleep(3000);
            System.out.println("🔄 App relaunched");

        } catch (Exception e) {
            throw new RuntimeException("❌🚀 Failed to relaunch app", e);
        }
    }

    // -------------------- LAUNCH APP WITH INTERNET --------------------
    public void launchAppAndEnsureInternet() {
        try {
            System.out.println("🚀 Launching app...");

            // Enable network and check if it was previously off
            boolean networkWasOff = enableNetwork();

            // Wait until internet is reachable
            waitForInternetConnection(20);

            // Only relaunch if network was previously off
            if (networkWasOff) {
                relaunchApp();
            } else {
                System.out.println("✅🌐 App launched, network already ON, no relaunch needed");
            }

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to launch app with internet", e);
        }
    }
}