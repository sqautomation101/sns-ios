package pages;

import base.*;
import locators.AccountLocators;
import io.appium.java_client.AppiumDriver;

public class AccountPage extends BasePage {

    public static int timeout = 5;

    // Constructor
    public AccountPage(AppiumDriver driver) {
        super(driver);
    }


    public boolean isAccountPageVisible() {
        waitUniqueElement(AccountLocators.LOGOUT_BTN, 60);

        boolean manageMyAcct = isElementVisible("Account - Manage Online Account", AccountLocators.MANAGE_MY_ACCT, 5);
        logStatus("Account - Manage Online Account", manageMyAcct);

        boolean HAI = isElementVisible("Account - Help and info", AccountLocators.HELP_AND_INFO, 5);
        logStatus("Account - Help and info", HAI);

        boolean acct_ManageCards = isElementVisible("Account - Manage Cards", AccountLocators.ACCT_MANAGE_CARDS, 5);
        logStatus("Account - Manage Cards", acct_ManageCards);

        boolean acct_PointsHistory = isElementVisible("Account - Points History", AccountLocators.ACCT_PTS_HISTORY, 5);
        logStatus("Account - Points History", acct_PointsHistory);

        boolean logout = isElementVisible("Account - Logout", AccountLocators.LOGOUT_BTN, 5);
        logStatus("Account - Logout", logout);

        return manageMyAcct & HAI & acct_ManageCards & HAI & acct_PointsHistory & logout;
    }


    public void clickHelpAndInfo() {
        tap("Help and info", AccountLocators.HELP_AND_INFO, timeout);
    }


    public void clickManageCards() {
        waitUniqueElement(AccountLocators.ACCT_MANAGE_CARDS, 60);
        tap("Manage Cards", AccountLocators.ACCT_MANAGE_CARDS, 5);
    }


    public void clickPointsHistory() {
        waitUniqueElement(AccountLocators.ACCT_PTS_HISTORY, 60);
        tap("Points History", AccountLocators.ACCT_PTS_HISTORY, timeout);
    }


    public void clickLogout() {
        waitUniqueElement(AccountLocators.LOGOUT_BTN, 60);
        tap("Logout btn", AccountLocators.LOGOUT_BTN, timeout);
    }


    public boolean isLoggingOutTxtVisible(){
        return isElementVisible("Logging out text", AccountLocators.LOGGING_OUT_TXT, timeout);
    }


    public boolean isHelpAndInfoPageVisible(){
        waitUniqueElement(AccountLocators.HAI_REQ_FOR_ACCT_DELETION, 60);

        boolean HAI_Back = isElementVisible_Crossplatform("HAI - Back", AccountLocators.HAI_BACK_AND, AccountLocators.HAI_BACK_IOS);
        logStatus("HAI - Back", HAI_Back);

        boolean HAI_faq = isElementVisible("HAI - FAQ", AccountLocators.HAI_FAQ, 5);
        logStatus("HAI - FAQ", HAI_faq);

        boolean HAI_TNC = isElementVisible("HAI - T&C", AccountLocators.HAI_TERMS, 5);
        logStatus("HAI - T&C", HAI_TNC);

        boolean HAI_PP =  isElementVisible("HAI - PP", AccountLocators.HAI_PRIVACY_POLICY, 5);
        logStatus("HAI - PP", HAI_PP);

        boolean HAI_RP =  isElementVisible("HAI - RP", AccountLocators.HAI_RETURN_POLICY, 5);
        logStatus("HAI - RP", HAI_RP);

        boolean HAI_ReqDeletion = isElementVisible("HAI - Request for Acct Deletion", AccountLocators.HAI_REQ_FOR_ACCT_DELETION, 5);
        logStatus("HAI - Request for Acct Deletion", HAI_ReqDeletion);

        return HAI_Back & HAI_faq & HAI_TNC & HAI_PP & HAI_RP & HAI_ReqDeletion;
    }
}
