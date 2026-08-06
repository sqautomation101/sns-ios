package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Wait helper
 * */
public class UtilWait {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public UtilWait(AppiumDriver driver, int seconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        this.wait.pollingEvery(Duration.ofMillis(300))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    // 🔹 Hard wait (use sparingly)
    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // =========================
    // 🔹 USING WEBELEMENT
    // =========================

    public WebElement waitForClickable_usingWebElement(WebElement element, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisible_usingWebElement(WebElement element, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForInvisibility_usingWebElement(WebElement element, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    // =========================
    // 🔹 USING BY LOCATOR
    // =========================

    public WebElement waitForVisibility_Bylocator(By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilVisible_By(By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilPresent_By(By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}