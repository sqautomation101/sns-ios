package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import locators.*;
import base.*;

public class LoginPage extends BasePage {

    // for locator timeout
    public static int timeout = 15;


    public LoginPage(AppiumDriver driver) {
        super(driver); // initializes driver + helpers + PageFactory
    }


    public boolean isSSOLoginVisible() {
        waitUniqueElement(LoginLocators.LOGIN_BTN_AND, 30);

        boolean uname = isElementVisible("Username", LoginLocators.USERNAME_FIELD, timeout);
        boolean pword = isElementVisible("Password", LoginLocators.PASSWORD_FIELD, timeout);
        boolean login = isElementVisible("Login", LoginLocators.LOGIN_BTN_AND, timeout);
        boolean loginBack = isElementVisible("Login back", LoginLocators.LOGIN_BACK_BTN, timeout);

        logStatus("SSO Login - Username", uname);
        logStatus("SSO Login - Password", pword);
        logStatus("SSO Login - Login back", loginBack);
        logStatus("SSO Login - Login btn", login);

        return uname & pword & login & loginBack;
    }


    public boolean isNewAcctRegModalVisible(){
            waitUniqueElement(LoginLocators.NEW_REG_HEADER, 5);

            boolean newAcct_hdr = isElementVisible("New Account Registration", LoginLocators.NEW_REG_HEADER, timeout);
            logStatus("New Account Registration - Header", newAcct_hdr);

            boolean newAcct_lbl = isElementVisible("New Account Registration - Desc", LoginLocators.NEW_REG_LBL, timeout);
            logStatus("New Account Registration - Desc", newAcct_lbl);

            boolean newAcct_RegistrationBtn = isElementVisible("Register btn", LoginLocators.REGISTER_BTN, timeout);
            logStatus("New Account Registration - Register Btn", newAcct_RegistrationBtn);

            boolean newAcct_BackBtn = isElementVisible("Register btn", LoginLocators.REG_CLOSE_BTN, timeout);
            logStatus("New Account Registration - Back Btn", newAcct_BackBtn);

            return newAcct_hdr & newAcct_lbl & newAcct_RegistrationBtn & newAcct_BackBtn;
    }


    public boolean isLoginCredentialsIncorrect(){
        return isElementVisible("Incorrect creds error", LoginLocators.ERR_INCORRECT_CREDS, timeout);
    }


    public void enterUsername(String username) {
        waitUniqueElement(LoginLocators.USERNAME_FIELD, timeout);
        tap("Username", LoginLocators.USERNAME_FIELD, timeout);
        type("Username", LoginLocators.USERNAME_FIELD, timeout, username); // type() from BasePage
    }


    public void enterPassword(String password) {
        waitUniqueElement(LoginLocators.PASSWORD_FIELD, timeout);
        tap("Password", LoginLocators.PASSWORD_FIELD, timeout);
        type("Password", LoginLocators.PASSWORD_FIELD, timeout, password);
    }


    public void clickOnFinalLoginButton() {
        tap_Crossplatform("Login btn", LoginLocators.LOGIN_BTN_AND, LoginLocators.LOGIN_BTN_IOS, timeout);
    }


    public boolean isFinalLoginBtnEnable(int timeoutInSeconds) {
        try {
            WebElement btn = waitForClickable_Crossplatform("Final Login Button", LoginLocators.LOGIN_BTN_AND, LoginLocators.LOGIN_BTN_IOS, timeoutInSeconds);
            return Boolean.parseBoolean(btn.getAttribute("enabled"));
        } catch (TimeoutException e) {
            System.err.println("❌ Final Login Button not clickable after " + timeoutInSeconds + "s");
            return false;
        }
    }


    public boolean isUsernameFieldEmpty(){
        return isElementVisible("Blank uname error", LoginLocators.ERR_BLANK_FIELD, 5);
    }


    public boolean isPasswordFieldEmpty(){
        return isElementVisible("Blank password error", LoginLocators.ERR_BLANK_FIELD, 5);
    }


    public boolean isUsernameFieldInvalid(){
        return isElementVisible("Invalid Uname error", LoginLocators.ERR_INVALID_INP, 5);
    }


    public boolean isPasswordFieldInvalid(){
        return isElementVisible("Invalid pword error", LoginLocators.ERR_INVALID_PWORD, 5);
    }


    public void clickForgotBtn() {
        tap("Forgot btn", LoginLocators.FORGOT_BTN, timeout);
    }


    public boolean isForgotPasswordPageVisible(){
        waitUniqueElement(LoginLocators.FORGOT_PASS_FIELD, 10);

        boolean fp_ForgotPassEmail = isElementVisible("Forgot password email field", LoginLocators.FORGOT_PASS_FIELD , timeout);
        logStatus("Forgot Password Page - Email/Mobile field", fp_ForgotPassEmail);

        boolean fp_Confirm = isElementVisible("Confirm btn", LoginLocators.FORGOT_PASS_CONFIRM_BTN, timeout);
        logStatus("Forgot Password Page - Confirm", fp_Confirm);

        boolean fp_BackBtn = isElementVisible("Back btn", LoginLocators.FORGOT_PASS_BACK, timeout);
        logStatus("Forgot Password Page - Back Btn", fp_BackBtn);

        return fp_ForgotPassEmail & fp_Confirm & fp_BackBtn;
    }


    public void clearUnameField(){
        clearText("Username field", LoginLocators.USERNAME_FIELD, 5);
    }


    public void clearPwordField(){
        clearText("Password field", LoginLocators.TOBECLEAR_PW, 5);
    }


    public void verifySuccessfulLogin_SSOLoginOnly(String username, String password){
        if (isSSOLoginVisible()) {
            enterUsername(username);
            enterPassword(password);
            clickOnFinalLoginButton();
            waitForInvisibility("Username", LoginLocators.USERNAME_FIELD, 60);
            //waitUniqueElement(LoginLocators.BOTNAV_HOME, 30);
        } else {
            Assert.fail("SSO login not visible, cannot proceed.");
        }
    }

}
