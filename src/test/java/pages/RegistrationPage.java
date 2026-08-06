package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

//import packages
import base.*;

public class RegistrationPage extends BasePage {

    // for locator timeout
    public static int timeout = 30;

    //LOCATORS

    protected By detailsTab = AppiumBy.accessibilityId("1 Details");
    protected By linkCardTab = AppiumBy.accessibilityId("2 Link Card");
    protected By verificationTab = AppiumBy.accessibilityId("3 Verification");
    protected By SignUpHdr = AppiumBy.accessibilityId("header_title");
    protected By registerBtn = AppiumBy.accessibilityId("register_submit_button");
    protected By fnameField = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").resourceId(\"register_first_name_field\")"
    );


    protected By lnameField = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").resourceId(\"register_last_name_field\")"
    );
    protected By mobileField = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").resourceId(\"register_mobile_field\")"
    );
    protected By emailField = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").resourceId(\"register_email_field\")"
    );
    protected By passwordField = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").resourceId(\"register_password_field\")"
    );
    protected By confirmPassField = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").resourceId(\"register_confirm_password_field\")"
    );
    protected By promotionsChk = AppiumBy.accessibilityId("register_marketing_checkbox");
    protected By termsChk = AppiumBy.accessibilityId("register_terms_checkbox");
    protected By regCloseBtn = AppiumBy.accessibilityId("register_back_button");
    protected By regGoogle = AppiumBy.accessibilityId("register_google_button");
    protected By regFB = AppiumBy.accessibilityId("register_facebook_button");
    protected By regApple = AppiumBy.accessibilityId("register_apple_button");

    //CONSTRUCTOR
    public RegistrationPage(AppiumDriver driver) {
        super(driver); // initializes driver + helpers + PageFactory
    }

    public boolean isRegistrationPageVisible(){
        /*return isElementVisible("Register btn", registerBtn, timeout) &&
                isElementVisible("Sign up hdr", SignUpHdr, timeout) &&
                isElementVisible("Reg close btn", regCloseBtn, timeout) &&
                isElementVisible("Firstname", fnameField, timeout) &&
                isElementVisible("lastnmae", lnameField, timeout) &&
                isElementVisible("Mobile", mobileField, timeout) &&
                isElementVisible("Email", emailField, timeout) &&
                isElementVisible("Password", passwordField, timeout) &&
                isElementVisible("Confirm Password", confirmPassField, timeout) &&
                isElementVisible("Terms", termsChk, timeout) &&
                isElementVisible("Promotions", promotionsChk, timeout) &&
                isElementVisible("Reg google btn", regGoogle, timeout) &&
                isElementVisible("Reg FB btn", regFB, timeout) &&
                isElementVisible("Reg Apple btn", regApple, timeout);*/
        return isElementVisible("Details tab", detailsTab, 5) &&
                isElementVisible("Link card", linkCardTab, 5) &&
                isElementVisible("Verification", verificationTab, 5);
    }
}