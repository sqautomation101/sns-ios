package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.util.LinkedHashMap;
import java.util.Map;

public final class LoginLocators {

    private LoginLocators() {}

    public static final By SPLASH_SCR_AND = AppiumBy.androidUIAutomator("" +
            "new UiSelector()" +
            ".className(\"android.view.View\")" +
            ".instance(2)");
    public static final By SPLASH_SCR_IOS = AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"SMAC&SHOP\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther");

    public static final By USERNAME_FIELD = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"login_username_field\"]");
    public static final By PASSWORD_FIELD = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"login_password_field\"]");
    public static final By TOBECLEAR_PW = AppiumBy.xpath("//*[@text = '••••' and @resource-id='login_password_field']");
    public static final By LOGIN_BTN_IOS = AppiumBy.accessibilityId("login_button");
    public static final By LOGIN_BTN_AND = AppiumBy.accessibilityId("login_button");
    public static final By LOGIN_BACK_BTN = AppiumBy.accessibilityId("login_back_button");
    public static final By NEW_REG_HEADER = AppiumBy.accessibilityId("New Account Registration");
    public static final By NEW_REG_LBL = AppiumBy.accessibilityId("The email/mobile number used is unregistered. Please register a new account.");
    public static final By REGISTER_BTN = AppiumBy.accessibilityId("login_registration_popup_register_button, Register");
    public static final By REG_CLOSE_BTN = AppiumBy.accessibilityId("login_registration_popup_close_button");
    public static final By FORGOT_BTN = AppiumBy.accessibilityId("login_forgot_password_button");
    public static final By FORGOT_PASS_FIELD = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"forgot_password_email_or_num_field\"]");
    public static final By FORGOT_PASS_CONFIRM_BTN = AppiumBy.accessibilityId("forgot_password_confirm_button");
    public static final By FORGOT_PASS_BACK = AppiumBy.accessibilityId("forgot_password_back_button");


    // -----------------------
    // ERROR LOGGING LOCATORS
    // -----------------------
    public static final By ERR_BLANK_FIELD = AppiumBy.accessibilityId("This field is required");
    public static final By ERR_INVALID_INP = AppiumBy.accessibilityId("Please enter a valid mobile number or email address");
    public static final By ERR_INVALID_PWORD = AppiumBy.accessibilityId("Please enter a valid mobile number or email address");
    public static final By ERR_INCORRECT_CREDS = AppiumBy.accessibilityId("login_error_message, Invalid Email/Mobile Number or Password");

    public static Map<String, By> getBasicLocators() {

        Map<String, By> locators = new LinkedHashMap<>();

        locators.put("Username", USERNAME_FIELD);
        locators.put("Password", PASSWORD_FIELD);
        locators.put("Login Button", LOGIN_BTN_AND);
        locators.put("Forgot Password", FORGOT_BTN);
        locators.put("Back button - Login", LOGIN_BACK_BTN);

        return locators;
    }
}