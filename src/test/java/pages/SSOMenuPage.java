package pages;

import base.*;
import locators.SSOMenuLocators;

import io.appium.java_client.AppiumDriver;

public class SSOMenuPage extends BasePage {

    public static int timeout = 30;

    

    // CONSTRUCTOR
    public SSOMenuPage(AppiumDriver driver) {
        super(driver);
    }

    // Check if SSO menu is visible
    public boolean isSSOMenuVisible() {
        waitUniqueElement(SSOMenuLocators.SSO_VIEW_VIRTUAL_SMAC, 30);

        boolean ssoGetStarted = isElementVisible("Get Started", SSOMenuLocators.SSO_GET_STARTED, timeout);
        logStatus("SSO - Get Started", ssoGetStarted);

        boolean ssoSignUpBtn = isElementVisible("Sign Up", SSOMenuLocators.SSO_SIGNUP_BTN, timeout);
        logStatus("SSO - Sign Up", ssoSignUpBtn);

        boolean ssoLogin = isElementVisible("SSO Login", SSOMenuLocators.SSO_INITIAL_LOGIN_BTN, timeout);
        logStatus("SSO - Login", ssoLogin);

        boolean ssoContinueAsGuest =  isElementVisible("Continue as Guest", SSOMenuLocators.SSO_CONTINUE_AS_GUEST_BTN, timeout);
        logStatus("SSO - Continue As Guest", ssoContinueAsGuest);

        boolean ssoViewVirtualSMAC =  isElementVisible("View Virtual SMAC", SSOMenuLocators.SSO_VIEW_VIRTUAL_SMAC, timeout);
        logStatus("SSO - View Virtual SMAC", ssoViewVirtualSMAC);

        return ssoGetStarted & ssoSignUpBtn & ssoLogin & ssoContinueAsGuest & ssoViewVirtualSMAC;
    }

    // Click buttons
    public void clickSSOLoginBtn() {
        tap("SSO Login", SSOMenuLocators.SSO_INITIAL_LOGIN_BTN, 10);
    }

    public void clickSSOSignupBtn() {
        tap("SSO Sign up", SSOMenuLocators.SSO_SIGNUP_BTN, 10);
    }

    public void clickSSOContAsGuestBtn() {
        tap("SSO Continue as guest", SSOMenuLocators.SSO_CONTINUE_AS_GUEST_BTN, 10);
    }

    public void clickSSOViewVirtualSMACBtn() {
        tap("SSO View virtual SMAC", SSOMenuLocators.SSO_VIEW_VIRTUAL_SMAC, timeout);
    }

    // Check Virtual SMAC modal when no account is logged in
    public boolean isVirtualSmacModalVisible_NoAccountLoggedYet() {
        waitUniqueElement(SSOMenuLocators.SSO_VIRTUAL_SMAC_NO_CACHE_DESC, 20);

        boolean noCache_hdr = isElementVisible("No login history - header", SSOMenuLocators.SSO_VIRTUAL_SMAC_NO_CACHE_HDR, 10);
        logStatus("No login history - header", noCache_hdr);

        boolean noCache_desc =  isElementVisible("No login history - desc", SSOMenuLocators.SSO_VIRTUAL_SMAC_NO_CACHE_DESC, 10);
        logStatus("No login history - desc", noCache_desc);

        boolean noCache_close =  isElementVisible("No login history - close", SSOMenuLocators.SSO_VIRTUAL_SMAC_NO_CACHE_CLOSE, 10);
        logStatus("No login history - close", noCache_close);

        return noCache_hdr & noCache_desc & noCache_close;
    }

    public void clickClose_VirtualSMACModal_NoCache() {
        tap("Virtual SMAC - No cache - Close", SSOMenuLocators.SSO_VIRTUAL_SMAC_NO_CACHE_CLOSE, 10);

    }
}