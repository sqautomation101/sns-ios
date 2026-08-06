package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;

/**
 * Scroll helper
 * */
public class UtilScroll {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public UtilScroll(AppiumDriver driver, int seconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    // =========================
    // 🔹 Vertical scroll
    // =========================
    public void swipeUp2() {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;

        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger =
                new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                startY));

        swipe.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(500),
                PointerInput.Origin.viewport(),
                startX,
                endY));

        swipe.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endY   = (int) (size.height * 0.8);

        performSwipe(startX, startY, startX, endY, 600);
    }

    public void swipeDown() {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8); // start LOWER
        int endY   = (int) (size.height * 0.2); // move UP

        performSwipe(startX, startY, startX, endY, 600);
    }

    public void swipeInsideScrollView(WebElement scrollView) {
        Dimension size = scrollView.getSize();
        Point location = scrollView.getLocation();

        int startX = location.getX() + size.width / 2;
        int startY = location.getY() + (int) (size.height * 0.8);
        int endY   = location.getY() + (int) (size.height * 0.2);

        performSwipe(startX, startY, startX, endY, 600);
    }

    public void scrollDownToElement(By locator, int maxScrolls) throws InterruptedException {

        for (int i = 0; i < maxScrolls; i++) {

            List<WebElement> elements = driver.findElements(locator);

            if (!elements.isEmpty()) {

                try {
                    if (elements.get(0).isDisplayed()
                            && elements.get(0).getRect().getHeight() > 0) {
                        return;
                    }
                } catch (Exception ignored) {}
            }

            swipeDown();
            Thread.sleep(1500);
        }

        throw new NoSuchElementException(
                "Element not found after scrolling: " + locator
        );
    }

    // =========================
    // 🔹 Horizontal swipe inside container
    // =========================

    public void swipeLeft(WebElement container) {
        Rectangle rect = container.getRect();
        int y = rect.y + rect.height / 2;
        int startX = rect.x + (int)(rect.width * 0.8);
        int endX = rect.x + (int)(rect.width * 0.2);

        performSwipe(startX, y, endX, y, 500);
    }

    public void swipeRight(WebElement container) {
        Rectangle rect = container.getRect();
        int y = rect.y + rect.height / 2;
        int startX = rect.x + (int)(rect.width * 0.2);
        int endX = rect.x + (int)(rect.width * 0.8);

        performSwipe(startX, y, endX, y, 500);
    }

    public int countAllCards(By carouselLocator, int maxSwipes) {
        int count = 1;
        for (int i = 0; i < maxSwipes; i++) {
            WebElement carousel = driver.findElement(carouselLocator);
            swipeLeft(carousel);
            count++;
        }
        return count;
    }

    public void swipeUpInsideElement(WebElement element) {

        Rectangle rect = element.getRect();

        int startX = rect.x + rect.width / 2;

        int startY = rect.y + (int)(rect.height * 0.8); // bottom area
        int endY   = rect.y + (int)(rect.height * 0.2); // top area

        performSwipe(startX, startY, startX, endY, 600);
    }

    public void scrollToElement(By locator, int maxScrolls) {

        for (int i = 0; i < maxScrolls; i++) {

            List<WebElement> elements = driver.findElements(locator);

            if (!elements.isEmpty()
                    && elements.get(0).isDisplayed()) {

                return;
            }

            swipeUp();
        }

        throw new NoSuchElementException(
                "Element not found: " + locator);
    }

    // =========================
    // 🔹 Modal gestures
    // =========================

    public void swipeDownToDismissModal(WebElement modal) {
        Rectangle rect = modal.getRect();
        int startX = rect.x + rect.width / 2;
        int startY = rect.y + (int)(rect.height * 0.05);
        int endY = rect.y + rect.height;

        performSwipe(startX, startY, startX, endY, 500);
    }

    // =========================
    // 🔹 Core W3C swipe helper
    // =========================

    private void performSwipe(int startX, int startY, int endX, int endY, int durationMs) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

        public void swipeUntilCardNumberVisible(By carouselLocator, String target, int maxSwipes) {

        for (int i = 0; i < maxSwipes; i++) {

            // Re-find the carousel each time to avoid stale element
            WebElement carousel = driver.findElement(carouselLocator);

            List<WebElement> visibleCards = carousel.findElements(AppiumBy.className("android.view.View"));

            for (WebElement card : visibleCards) {
                String contentDesc = card.getAttribute("contentDescription");

                if (contentDesc != null && contentDesc.contains(target)) {
                    System.out.println("✅ Found card: " + contentDesc);
                    return;
                }
            }

            swipeLeft(carousel);
        }

        throw new NoSuchElementException("❌ Card not found after swiping.");
    }

    public void swipeLeftUntilCardLogoVisible(By carouselLocator, String target, int maxSwipes) {

        for (int i = 0; i < maxSwipes; i++) {

            // Re-find the carousel each time to avoid stale element
            WebElement carousel = driver.findElement(carouselLocator);

            List<WebElement> visibleCards = carousel.findElements(AppiumBy.className("android.view.View"));

            for (WebElement card : visibleCards) {
                String contentDesc = card.getAttribute("contentDescription");

                if (contentDesc != null && contentDesc.contains(target)) {
                    System.out.println("✅ Found card: " + contentDesc);
                    return;
                }
            }

            swipeLeft(carousel);
        }

        throw new NoSuchElementException("❌ Card not found after swiping.");
    }
}