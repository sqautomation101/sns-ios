package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class GuestUserLocators {

    private GuestUserLocators() {}

    public static final By GUEST_LOGIN = AppiumBy.accessibilityId("empty_smac_card_button");
    public static final By GUEST_SEARCH_PRODUCT = AppiumBy.accessibilityId("home_search_button");
}