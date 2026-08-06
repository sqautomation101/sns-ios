package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class SSOMenuLocators {

    private SSOMenuLocators() {}

    // LOCATORS (iOS accessibility IDs)
    public static final By SSO_GET_STARTED = AppiumBy.accessibilityId("Let’s get started!");
    public static final By SSO_INITIAL_LOGIN_BTN = AppiumBy.accessibilityId("onboarding_login_button");
    public static final By SSO_SIGNUP_BTN = AppiumBy.accessibilityId("onboarding_signup_button");
    public static final By SSO_CONTINUE_AS_GUEST_BTN = AppiumBy.accessibilityId("onboarding_guest_button");
    public static final By SSO_VIEW_VIRTUAL_SMAC = AppiumBy.accessibilityId("onboarding_view_virtual_smac_button");

    public static final By SSO_VIRTUAL_SMAC_NO_CACHE_HDR = AppiumBy.accessibilityId("Virtual SMAC");
    public static final By SSO_VIRTUAL_SMAC_NO_CACHE_DESC = AppiumBy.accessibilityId(
            "Virtual SMAC will be available after your first login. You can even view it while offline!");
    public static final By SSO_VIRTUAL_SMAC_NO_CACHE_CLOSE = AppiumBy.accessibilityId("close_button");
}