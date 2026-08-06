package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.*;

import java.time.Duration;


public class BasePage {

    protected AppiumDriver driver;
    protected final UtilWait waitHelper;
    protected final UtilNetwork networkHelper;
    protected final UtilScroll scrollHelper;

    public BasePage(AppiumDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver must be set! Did hooks initialize it?");
        }
        this.driver = driver;

        // Utilities
        this.waitHelper = new UtilWait(driver, 20);
        this.scrollHelper = new UtilScroll(driver, 20);
        this.networkHelper = new UtilNetwork(driver);

        // PageFactory
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    protected String getContentDesc(By locator){
        waitUniqueElement(locator, 5);
        return driver.findElement(locator).getAttribute("contentDescription");
    }

    protected String getText(By locator){
        waitUniqueElement(locator, 5);
        return driver.findElement(locator).getAttribute("text");
    }

    public WebElement waitForVisibility(String name, By locator, int timeout) {

        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(String elementName, By locator, int timeoutInSeconds) {

        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForClickable(String elementName, WebElement element, int timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        try {
            WebElement clickable =
                    wait.until(ExpectedConditions.elementToBeClickable(element));

            Thread.sleep(500);
            System.out.println("👆 " + elementName + " is clickable");
            return clickable;

        } catch (TimeoutException e) {
            System.err.println("❌ Timeout: " + elementName + " not clickable");
            throw e;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    protected boolean isElementVisible(String name, WebElement element, int timeout) {

        try {
            waitHelper.waitForVisible_usingWebElement(element, timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementVisible(String name, By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementPresent(String name, By locator, int timeout) {
        try {
            waitHelper.waitUntilPresent_By(locator, timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementNotVisible(String elementName, By locator, int timeoutInSeconds) {
        waitUniqueElement(locator, timeoutInSeconds);
        boolean invisible = waitForInvisibility(elementName, locator, timeoutInSeconds);
        if (invisible) {
            System.out.println("🙈 " + elementName + " is not visible as expected.");
        } else {
            System.err.println("❌ " + elementName + " still visible after " + timeoutInSeconds + "s");
        }
        return invisible;
    }

    protected boolean waitForInvisibility(String name, By locator, int timeout) {
        try {
            System.out.println(name + " waiting to be invisible...");
            boolean result = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.invisibilityOfElementLocated(locator));
            System.out.println("🙈 " + name + " is now invisible.");
            return result;

        } catch (TimeoutException e) {
            System.out.println("❌ " + name + " still visible after timeout.");
            return false;
        }
    }

    public void waitUniqueElement(By locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void logStatus(String elementName, boolean status) {
        System.out.println("🔍" + elementName + ": " + (status ? "VISIBLE ✅" : "NOT VISIBLE ❌"));
    }

    public void tap(String name, By locator, int timeout) {
        waitUniqueElement(locator, timeout);
        WebElement element = waitForClickable(name, locator, timeout);
        element.click();
        System.out.println("📱 Clicked: " + name);
    }

    public void tap(String name, WebElement element, int timeout) {
        WebElement clickable = waitForClickable(name, element, timeout);
        clickable.click();
        System.out.println("📱 Clicked: " + name);
    }

    public void tap_Crossplatform(String name, By androidLocator, By iosLocator, int timeout) {
        WebElement element = waitForClickable_Crossplatform(name, androidLocator, iosLocator, timeout);
        element.click();
        System.out.println("📱 Clicked: " + name);
    }

    protected void type(String name, WebElement element, int timeout, String input) {
        WebElement el = waitForClickable(name, element, timeout);
        el.clear();
        el.sendKeys(input);
        System.out.println("✏️ Typed: " + input);
    }

    protected void type_2(String name, By locator, int timeout, String input) {
        WebElement el = waitForClickable(name, locator, timeout);
        el.sendKeys(input);
        System.out.println("✏️ Typed: " + input);
    }

    protected void type(String name, By locator, int timeout, String input) {
        waitUniqueElement(locator, timeout);
        WebElement el = waitForClickable(name, locator, timeout);
        el.clear();
        el.sendKeys(input);
        System.out.println("✏️ Typed: " + input);
    }

    protected void type_noClear(String name, By locator, int timeout, String input) throws InterruptedException {
        waitUniqueElement(locator, timeout);
        WebElement el = waitForClickable(name, locator, timeout);
        el.sendKeys(input);
        System.out.println("✏️ Typed (No clear): " + input);
        Thread.sleep(500);

//        driver.switchTo().activeElement().sendKeys(input);
    }

    protected void clearText(String name, By locator, int timeout) {
        waitForClickable(name, locator, timeout).clear();
    }

    public boolean isElementEnabled(String name, By locator) {
        waitUniqueElement(locator, 15);
        return driver.findElement(locator).isEnabled();
    }

    public String isElementSelected(String name, By locator, int timeout) {
        //waitUniqueElement(locator, timeout);
        WebElement element = waitForVisibility(name, locator, timeout);
        return element.getAttribute("selected");
    }

    public boolean isElementVisible_Crossplatform(String elementName, By androidLocator, By iosLocator) {
        By locator;
        if (driver instanceof AndroidDriver) {
            if (androidLocator == null) {
                throw new RuntimeException("Android locator is required for Android platform");
            }
            locator = androidLocator;
            System.out.println("🤖 locator found: " + locator);
        } else if (driver instanceof IOSDriver) {
            if (iosLocator == null) {
                throw new RuntimeException("iOS locator is required for iOS platform");
            }
            locator = iosLocator;
            System.out.println("🍎 locator found: " + locator);
        } else {
            throw new RuntimeException("Unsupported platform");
        }

        try {
            WebElement element = driver.findElement(locator);
            System.out.println(elementName + " is visible.");
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitForClickable_Crossplatform(String elementName, By androidLocator, By iosLocator, int timeoutInSeconds) {

        By locator;

        if (driver instanceof AndroidDriver) {
            if (androidLocator == null) {
                throw new RuntimeException("Android locator is required for Android platform");
            }
            locator = androidLocator;

        } else if (driver instanceof IOSDriver) {
            if (iosLocator == null) {
                throw new RuntimeException("iOS locator is required for iOS platform");
            }
            locator = iosLocator;

        } else {
            throw new RuntimeException("Unsupported platform");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("👆 " + elementName + " is clickable");
            return element;

        } catch (TimeoutException e) {
            System.err.println("❌ Timeout: " + elementName + " not clickable");
            throw e;
        }
    }

    public WebElement findElement_Crossplatform(String elementName, By androidLocator, By iosLocator, int timeoutInSeconds) {

        By locator;

        if (driver instanceof AndroidDriver) {
            if (androidLocator == null) {
                throw new RuntimeException("Android locator is required for Android platform");
            }
            locator = androidLocator;

        } else if (driver instanceof IOSDriver) {
            if (iosLocator == null) {
                throw new RuntimeException("iOS locator is required for iOS platform");
            }
            locator = iosLocator;

        } else {
            throw new RuntimeException("Unsupported platform");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        try {
            WebElement element = driver.findElement(locator);
            System.out.println("🔍 " + elementName + " is found.");
            return element;

        } catch (TimeoutException e) {
            System.err.println("❌ Timeout: " + elementName + " not found.");
            throw e;
        }
    }

    public String extractText_Crossplatform(String elementName, By androidLocator, By iosLocator) {
        String platform = driver.getCapabilities().getPlatformName().toString();

        WebElement greetingElement = findElement_Crossplatform(
                elementName, androidLocator, iosLocator, 10
        );

        String attributeValue;

        if (platform.equalsIgnoreCase("android")) {
            attributeValue = greetingElement.getAttribute("content-desc");
        } else if (platform.equalsIgnoreCase("ios")) {
            attributeValue = greetingElement.getAttribute("label");
        } else {
            throw new RuntimeException("Unsupported platform: " + platform);
        }

        return attributeValue;
    }

    public void native_back(){
        driver.navigate().back();
    }

    public void clickWhenEnabled(String elementName, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        wait.until(d -> {
            WebElement element = d.findElement(locator);
            boolean isEnabled = element.isEnabled();
            System.out.println("Enabled? " + isEnabled);
            return isEnabled;

        });

        driver.findElement(locator).click();
        System.out.println("👆 Clicked on enabled element: " + elementName);
    }

    public boolean isEnabled(String elementName, By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

            wait.until(d -> d.findElement(locator).isEnabled());

            System.out.println("👆 Enabled element: " + elementName);
            return true;
        } catch (TimeoutException e) {
            System.out.println("❌ Element is not enabled: " + elementName);
            return false;
        }
    }
}