package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.time.Duration;

public class LocatorsChecker {
    private final AppiumDriver driver;

    public LocatorsChecker(AppiumDriver driver) {
        this.driver = driver;
    }

    public void checkPage(Class<?> pageClass) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        System.out.println("\n========== " + pageClass.getSimpleName() + " ==========");

        int found = 0;
        int missing = 0;

        for (Field field : pageClass.getDeclaredFields()) {

            if (!field.getType().equals(By.class))
                continue;

            try {

                By locator = (By) field.get(null);

                wait.until(ExpectedConditions.presenceOfElementLocated(locator));

                System.out.printf("✅ %-30s %s%n",
                        field.getName(),
                        locator);

                found++;

            } catch (TimeoutException e) {

                try {
                    By locator = (By) field.get(null);

                    System.out.printf("❌ %-30s %s%n",
                            field.getName(),
                            locator);

                } catch (Exception ignored) {}

                missing++;

            } catch (Exception e) {

                System.out.println("⚠️ " + field.getName());

            }

        }

        System.out.println("-------------------------------------");
        System.out.println("Found : " + found);
        System.out.println("Missing : " + missing);
    }
}