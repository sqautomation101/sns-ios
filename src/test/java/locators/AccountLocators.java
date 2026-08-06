package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class AccountLocators {

    private AccountLocators() {}

    public static final By MANAGE_MY_ACCT = AppiumBy.accessibilityId("Manage Online Account");
    public static final By HELP_AND_INFO = AppiumBy.accessibilityId("Help & Information");
    public static final By ACCT_MANAGE_CARDS = AppiumBy.accessibilityId("Manage Cards");
    public static final By ACCT_PTS_HISTORY = AppiumBy.accessibilityId("Points History");

    //Help and infor page
    public static final By HAI_FAQ = AppiumBy.accessibilityId("FAQ");
    public static final By HAI_TERMS = AppiumBy.accessibilityId("Terms & Conditions");
    public static final By HAI_PRIVACY_POLICY= AppiumBy.accessibilityId("Privacy Policy");
    public static final By HAI_RETURN_POLICY = AppiumBy.accessibilityId("Return Policy");
    public static final By HAI_REQ_FOR_ACCT_DELETION = AppiumBy.accessibilityId("Request for Account Deletion");
    public static final By HAI_BACK_AND = By.xpath("//android.widget.Button");
    public static final By HAI_BACK_IOS = By.xpath("//XCUIElementTypeButton");

    public static final By LOGGING_OUT_TXT = AppiumBy.accessibilityId("Logging out...");
    public static final By LOGOUT_BTN = AppiumBy.accessibilityId("Logout");
}