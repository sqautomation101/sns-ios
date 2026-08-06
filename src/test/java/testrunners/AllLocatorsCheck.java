package testrunners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import locators.AccountLocators;
import locators.CardLinkingLocators;
import locators.HomepageLocators;
import locators.InboxLocators;
import locators.LoginLocators;
import locators.ManageCardsLocators;
import locators.OfflineVirtualCardLocators;
import locators.PointsHistoryLocators;
import locators.QRAndScanLocators;
import locators.SSOMenuLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CardLinkingPage;
import pages.LoginPage;
import pages.SSOMenuPage;
import util.TestDataManager;

import java.net.URL;
import java.time.Duration;
import java.util.Map;

/**
 * Self-navigating locator diagnostic across every logged-in feature, PLUS
 * the SSO/Login screens and the MOM (Mom Card) registration flow. Does NOT
 * go through Hooks/Cucumber (no app-data reset) — instead it logs out
 * whatever's currently active on the device (if anything), lands on the SSO
 * menu, and logs in as the pre-seeded test account "Charlene Kiyuwey"
 * (mobile 09455472018, from Login_TD.csv), which is already linked to a MOM
 * card with an incomplete registration — so the MOM Continue banner shows
 * immediately on Manage Cards without needing to link a new card + OTP.
 *
 * IMPORTANT: this logs out of whatever account is currently on the device
 * and leaves it logged in as Charlene Kiyuwey afterward — it does not know
 * how to restore your original session.
 *
 * Also drives Card Linking (login as "Rhie Nier", a dedicated no-cards-linked
 * test account, then links a real unused Start-tier card pulled from
 * SMAC_Start_TestCards.csv via the same TestDataManager.Start_getUnusedCardNumber
 * the real Cucumber suite uses — writeBack=false, matching established
 * convention, so the CSV isn't mutated) and Offline Virtual Card (login as
 * "Olivia Rodrigo" to cache her card, then toggle airplane mode via adb).
 *
 * Deliberately excluded, and why:
 *  - Card Blocking: the block action is real and irreversible for the
 *    physical card, so only the button's presence on the Manage Cards page
 *    is checked — it is never tapped.
 *  - MOM form Proceed button: filled in but never tapped — submitting would
 *    permanently complete this test account's MOM registration, so the
 *    Continue banner would stop appearing on future runs.
 *
 * IMPORTANT: Offline Virtual Card toggles airplane mode on this physical
 * device mid-run. Network is always restored in a finally block even if
 * something above it throws, but the device will be briefly offline while
 * this section runs.
 *
 * Four sections are individually skippable via -D flags, since Card
 * Linking, MOM form, and Offline Virtual Card are all notably slower than
 * the rest, and LOGIN is unnecessary if you're already logged in:
 *   mvn -o -q test -Dtest=AllLocatorsCheck \
 *       -DskipLogin=true -DskipMom=true -DskipCardLinking=true -DskipOffline=true
 * All four default to false (full run). -DskipLogin=true starts straight
 * at Homepage using whatever account is already active on the device,
 * instead of logging out and back in as Charlene Kiyuwey.
 *
 * Run: mvn -o -q test -Dtest=AllLocatorsCheck
 */
public class AllLocatorsCheck {

    private static final String APP_PACKAGE = "com.dac.smacnshop";
    private static final String DEVICE_UDID = "RFCY901XJYB";
    private static final String MOM_TEST_ACCOUNT_MOBILE = "09455472018";
    private static final String MOM_TEST_ACCOUNT_PASSWORD = "Temp1234!!";
    private static final String CARD_LINKING_TEST_ACCOUNT_MOBILE = "09289356334"; // Rhie Nier
    private static final String CARD_LINKING_TEST_ACCOUNT_PASSWORD = "Temp1234!!";
    private static final String OFFLINE_TEST_ACCOUNT_MOBILE = "09244418164"; // Olivia Rodrigo, SMAC Start
    private static final String OFFLINE_TEST_ACCOUNT_PASSWORD = "Temp1234!!";

    // These sections are slow for genuine reasons (Card Linking waits on a
    // real backend response after OTP; Offline Virtual Card has fixed 4s
    // settle sleeps around each adb network toggle; MOM form drives several
    // dropdown selections; LOGIN does a full logout/login round-trip) —
    // skip whichever you don't need:
    //   mvn -o -q test -Dtest=AllLocatorsCheck -DskipLogin=true -DskipMom=true -DskipCardLinking=true -DskipOffline=true
    //
    // -DskipLogin=true is for when you're already logged in on the device
    // and just want to check locators against whatever account is active —
    // the script starts straight at Homepage instead of logging out and
    // back in as Charlene Kiyuwey. Note this also means the MOM Card check
    // (which needs Charlene Kiyuwey specifically) will likely report n/a
    // unless the currently logged-in account happens to be pre-seeded with
    // an incomplete MOM registration too.
    private static final boolean SKIP_LOGIN = Boolean.parseBoolean(System.getProperty("skipLogin", "false"));
    private static final boolean SKIP_MOM = Boolean.parseBoolean(System.getProperty("skipMom", "false"));
    private static final boolean SKIP_CARD_LINKING = Boolean.parseBoolean(System.getProperty("skipCardLinking", "false"));
    private static final boolean SKIP_OFFLINE = Boolean.parseBoolean(System.getProperty("skipOffline", "false"));

    private int pass = 0;
    private int fail = 0;

    @Test
    public void checkAllLocators() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("13")
                .setUdid(DEVICE_UDID)
                .setAppPackage(APP_PACKAGE)
                .setAppWaitActivity("com.dac.smacnshop.*")
                .setAutomationName("UiAutomator2")
                .setNoReset(true)   // do NOT clear app data / log out
                .setFullReset(false)
                .setNewCommandTimeout(Duration.ofMinutes(10));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        try {
            driver.activateApp(APP_PACKAGE);
            Thread.sleep(800);

            if (SKIP_LOGIN) {
                System.out.println("\n===== LOGIN (SSO + Login as Charlene Kiyuwey) =====\n⏭️  skipped (-DskipLogin=true) — assuming already logged in, starting at Homepage\n");
                goHome(driver);
            } else {
                runSection(driver, "LOGIN (SSO + Login as Charlene Kiyuwey)", this::checkLogin);
            }
            runSection(driver, "HOMEPAGE", this::checkHomepage);
            runSection(driver, "QR / SCAN", this::checkQrScreen);
            runSection(driver, "ACCOUNT", this::checkAccount);
            runSection(driver, "MANAGE CARDS", this::checkManageCards);
            runSection(driver, "POINTS HISTORY", this::checkPointsHistory);
            runSection(driver, "INBOX", this::checkInbox);

            if (SKIP_CARD_LINKING) {
                System.out.println("\n===== CARD LINKING (login as Rhie Nier) =====\n⏭️  skipped (-DskipCardLinking=true)\n");
            } else {
                runSection(driver, "CARD LINKING (login as Rhie Nier)", this::checkCardLinking);
            }

            if (SKIP_OFFLINE) {
                System.out.println("\n===== OFFLINE VIRTUAL CARD (login as Olivia Rodrigo) =====\n⏭️  skipped (-DskipOffline=true)\n");
            } else {
                runSection(driver, "OFFLINE VIRTUAL CARD (login as Olivia Rodrigo)", this::checkOfflineVirtualCard);
            }

            System.out.println("\n===== OVERALL SUMMARY: " + pass + " passed, " + fail + " failed =====\n");
            System.out.println("Skipped (see class doc for why): Card Blocking (action), MOM form Proceed (submission)\n");

        } finally {
            driver.quit(); // ends the automation session only, app data stays intact (noReset=true)
        }
    }

    private interface Section {
        void run(AndroidDriver driver) throws Exception;
    }

    private void runSection(AndroidDriver driver, String title, Section section) {
        System.out.println("\n===== " + title + " =====\n");
        try {
            section.run(driver);
        } catch (Exception e) {
            System.out.println("⚠️  SECTION ERROR in " + title + ": " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // LOGIN (SSO menu + Login screen), then log in as the pre-seeded
    // MOM test account
    // ---------------------------------------------------------------
    private void checkLogin(AndroidDriver driver) throws InterruptedException {
        // If a session is already active (Homepage bottom nav visible),
        // log out of it first so we land on the SSO menu.
        if (isPresent(driver, HomepageLocators.BOTNAV_HOME)) {
            WebElement acctTab = waitClickable(driver, HomepageLocators.BOTNAV_ACCT, 5);
            if (acctTab != null) {
                acctTab.click();
                Thread.sleep(800);
                WebElement logoutBtn = waitClickable(driver, AccountLocators.LOGOUT_BTN, 5);
                if (logoutBtn != null) {
                    logoutBtn.click();
                    Thread.sleep(2000);
                }
            }
        }

        checkPresence(driver, "SSO_GET_STARTED", SSOMenuLocators.SSO_GET_STARTED);
        checkPresence(driver, "SSO_INITIAL_LOGIN_BTN", SSOMenuLocators.SSO_INITIAL_LOGIN_BTN);
        checkPresence(driver, "SSO_SIGNUP_BTN", SSOMenuLocators.SSO_SIGNUP_BTN);
        checkPresence(driver, "SSO_CONTINUE_AS_GUEST_BTN", SSOMenuLocators.SSO_CONTINUE_AS_GUEST_BTN);
        checkPresence(driver, "SSO_VIEW_VIRTUAL_SMAC", SSOMenuLocators.SSO_VIEW_VIRTUAL_SMAC);

        SSOMenuPage ssoMenu = new SSOMenuPage(driver);
        LoginPage login = new LoginPage(driver);

        checkInteraction("(tap SSO Login button)", ssoMenu::clickSSOLoginBtn);
        Thread.sleep(800);

        checkPresence(driver, "USERNAME_FIELD", LoginLocators.USERNAME_FIELD);
        checkPresence(driver, "PASSWORD_FIELD", LoginLocators.PASSWORD_FIELD);
        checkPresence(driver, "LOGIN_BTN_AND", LoginLocators.LOGIN_BTN_AND);
        checkPresence(driver, "LOGIN_BACK_BTN", LoginLocators.LOGIN_BACK_BTN);
        checkPresence(driver, "FORGOT_BTN", LoginLocators.FORGOT_BTN);

        // Reuse the same helper the real Cucumber suite drives login with
        // (LoginSteps "Card Link - {string}") instead of hand-rolled
        // click/type logic — it uses BasePage's proven tap()/type() and
        // waitForClickable() instead of a raw WebElement.click()/sendKeys().
        boolean loggedIn;
        try {
            login.verifySuccessfulLogin_SSOLoginOnly(MOM_TEST_ACCOUNT_MOBILE, MOM_TEST_ACCOUNT_PASSWORD);
            loggedIn = true;
        } catch (Throwable e) {
            loggedIn = false;
        }
        report("(login as Charlene Kiyuwey succeeds)", "(interaction)", loggedIn);
        if (!loggedIn && isPresent(driver, LoginLocators.ERR_INCORRECT_CREDS)) {
            System.out.println("⚠️  login failed with an incorrect-credentials error — check MOM_TEST_ACCOUNT_MOBILE/PASSWORD against Login_TD.csv");
        }

        // Extra confirmation beyond verifySuccessfulLogin_SSOLoginOnly's own
        // check (username field invisibility) — make sure Homepage actually
        // rendered, since a keyboard-close re-layout alone could otherwise
        // satisfy that condition without a real navigation happening.
        boolean onHomepage = isPresent(driver, HomepageLocators.BOTNAV_HOME);
        if (!onHomepage) {
            try {
                new WebDriverWait(driver, Duration.ofSeconds(20))
                        .until(ExpectedConditions.presenceOfElementLocated(HomepageLocators.BOTNAV_HOME));
                onHomepage = true;
            } catch (Exception e) {
                onHomepage = false;
            }
        }
        if (!onHomepage) {
            System.out.println("DEBUG_PAGE_SOURCE_POST_LOGIN_START\n" + driver.getPageSource() + "\nDEBUG_PAGE_SOURCE_POST_LOGIN_END");
        }
        report("(lands on Homepage after login)", "(interaction)", onHomepage);
        Thread.sleep(500);
    }

    // ---------------------------------------------------------------
    // HOMEPAGE
    // ---------------------------------------------------------------
    private void checkHomepage(AndroidDriver driver) throws InterruptedException {
        goHome(driver);

        checkPresence(driver, "CARDPOINTS_AND", HomepageLocators.CARDPOINTS_AND);
        checkPresence(driver, "CARDNUMBER_AND", HomepageLocators.CARDNUMBER_AND);
        checkPresence(driver, "MANAGECARDSWIDGET", HomepageLocators.MANAGECARDSWIDGET);
        checkPresence(driver, "PTSHISTORYWIDGET", HomepageLocators.PTSHISTORYWIDGET);
        checkPresence(driver, "PLAYWIDGET", HomepageLocators.PLAYWIDGET);
        checkPresence(driver, "LINKCARDWIDGET", HomepageLocators.LINKCARDWIDGET);
        checkPresence(driver, "GOSHOPPING_HDR", HomepageLocators.GOSHOPPING_HDR);
        checkPresence(driver, "SEARCH_BTN", HomepageLocators.SEARCH_BTN);
        checkPresence(driver, "BOTNAV_HOME", HomepageLocators.BOTNAV_HOME);
        checkPresence(driver, "BOTNAV_VOUCHERS", HomepageLocators.BOTNAV_VOUCHERS);
        checkPresence(driver, "BOTNAV_ACCT", HomepageLocators.BOTNAV_ACCT);
        checkPresence(driver, "BOTNAV_INBOX", HomepageLocators.BOTNAV_INBOX);

        // Tier-dependent, mutually exclusive — only one renders per account.
        checkOptional(driver, "BOTNAV_QR_START", HomepageLocators.BOTNAV_QR_START);
        checkOptional(driver, "BOTNAV_QR_SMAC", HomepageLocators.BOTNAV_QR_SMAC);
        checkOptional(driver, "BOTNAV_QR_PRESTIGE", HomepageLocators.BOTNAV_QR_PRESTIGE);
    }

    // ---------------------------------------------------------------
    // QR / SCAN
    // ---------------------------------------------------------------
    private void checkQrScreen(AndroidDriver driver) throws InterruptedException {
        goHome(driver);
        if (!goToQrTab(driver)) {
            System.out.println("❌ FAIL  could not find any QR tab (Start/SMAC/Prestige) in bottom nav — aborting section");
            fail++;
            return;
        }

        checkPresence(driver, "QAS_SHOW_QR", QRAndScanLocators.QAS_SHOW_QR);
        checkPresence(driver, "QAS_SHOW_BARCODE", QRAndScanLocators.QAS_SHOW_BARCODE);
        checkPresence(driver, "QAS_PAY_WITH_POINTS", QRAndScanLocators.QAS_PAY_WITH_POINTS);

        WebElement showQr = waitClickable(driver, QRAndScanLocators.QAS_SHOW_QR, 5);
        if (showQr != null) {
            showQr.click();
            Thread.sleep(800);
            checkPresence(driver, "QAS_DYNAMIC_QR", QRAndScanLocators.QAS_DYNAMIC_QR);
            checkPresence(driver, "QAS_DATETIME_QR", QRAndScanLocators.QAS_DATETIME_QR);
            checkPresence(driver, "QAS_CARD_NUMBER", QRAndScanLocators.QAS_CARD_NUMBER);
            checkOptional(driver, "TIER_COLOUR_START", QRAndScanLocators.TIER_COLOUR_START);
            checkOptional(driver, "TIER_COLOUR_SMAC", QRAndScanLocators.TIER_COLOUR_SMAC);
            checkOptional(driver, "TIER_COLOUR_PRESTIGE", QRAndScanLocators.TIER_COLOUR_PRESTIGE);
            goHome(driver);
            goToQrTab(driver);
        } else {
            System.out.println("⚠️  skipped Show QR sub-screen — button not found");
        }

        WebElement showBarcode = waitClickable(driver, QRAndScanLocators.QAS_SHOW_BARCODE, 5);
        if (showBarcode != null) {
            showBarcode.click();
            Thread.sleep(800);
            checkPresence(driver, "QAS_DYNAMIC_BARCODE", QRAndScanLocators.QAS_DYNAMIC_BARCODE);
            checkPresence(driver, "QAS_DATETIME_BARCODE", QRAndScanLocators.QAS_DATETIME_BARCODE);
            goHome(driver);
            goToQrTab(driver);
        } else {
            System.out.println("⚠️  skipped Show Barcode sub-screen — button not found");
        }

        WebElement payWithPoints = waitClickable(driver, QRAndScanLocators.QAS_PAY_WITH_POINTS, 5);
        if (payWithPoints != null) {
            payWithPoints.click();
            Thread.sleep(800);
            checkPresence(driver, "QAS_PWP_INSTRUCTIONS", QRAndScanLocators.QAS_PWP_INSTRUCTIONS);
            checkPresence(driver, "QAS_PWP_SCANNER_CAM", QRAndScanLocators.QAS_PWP_SCANNER_CAM);
            System.out.println("⚪ n/a  QAS_EARN_POINTS  ->  only renders after scanning a live merchant code, not checked here");
        } else {
            System.out.println("⚠️  skipped Pay with Points sub-screen — button not found");
        }
    }

    // ---------------------------------------------------------------
    // ACCOUNT
    // ---------------------------------------------------------------
    private void checkAccount(AndroidDriver driver) throws InterruptedException {
        goHome(driver);
        WebElement acctTab = waitClickable(driver, HomepageLocators.BOTNAV_ACCT, 10);
        if (acctTab == null) {
            System.out.println("❌ FAIL  could not find Account tab — aborting section");
            fail++;
            return;
        }
        acctTab.click();
        Thread.sleep(800);

        checkPresence(driver, "MANAGE_MY_ACCT", AccountLocators.MANAGE_MY_ACCT);
        checkPresence(driver, "HELP_AND_INFO", AccountLocators.HELP_AND_INFO);
        checkPresence(driver, "ACCT_MANAGE_CARDS", AccountLocators.ACCT_MANAGE_CARDS);
        checkPresence(driver, "ACCT_PTS_HISTORY", AccountLocators.ACCT_PTS_HISTORY);
        // Present-only — never tapped, logging out would end the whole session.
        checkPresence(driver, "LOGOUT_BTN", AccountLocators.LOGOUT_BTN);

        WebElement helpInfo = waitClickable(driver, AccountLocators.HELP_AND_INFO, 5);
        if (helpInfo != null) {
            helpInfo.click();
            Thread.sleep(800);
            checkPresence(driver, "HAI_FAQ", AccountLocators.HAI_FAQ);
            checkPresence(driver, "HAI_TERMS", AccountLocators.HAI_TERMS);
            checkPresence(driver, "HAI_PRIVACY_POLICY", AccountLocators.HAI_PRIVACY_POLICY);
            checkPresence(driver, "HAI_RETURN_POLICY", AccountLocators.HAI_RETURN_POLICY);
            checkPresence(driver, "HAI_REQ_FOR_ACCT_DELETION", AccountLocators.HAI_REQ_FOR_ACCT_DELETION);
            // Help & Info is a real pushed screen (no bottom nav under it),
            // unlike the QR overlay — hardware back works normally here.
            driver.navigate().back();
            Thread.sleep(800);
        } else {
            System.out.println("⚠️  skipped Help & Information sub-screen — button not found");
        }
    }

    // ---------------------------------------------------------------
    // MANAGE CARDS
    // ---------------------------------------------------------------
    private void checkManageCards(AndroidDriver driver) throws InterruptedException {
        goHome(driver);
        WebElement widget = waitClickable(driver, HomepageLocators.MANAGECARDSWIDGET, 10);
        if (widget == null) {
            System.out.println("❌ FAIL  could not find Manage Cards widget on Homepage — aborting section");
            fail++;
            return;
        }
        widget.click();
        Thread.sleep(1200);

        checkPresence(driver, "MC_TRANSFER_PTS", ManageCardsLocators.MC_TRANSFER_PTS);
        // Present-only — never tapped, this really blocks the physical card.
        checkPresence(driver, "MC_BLOCK_CARD", ManageCardsLocators.MC_BLOCK_CARD);
        checkPresence(driver, "MC_SHOW_CARD", ManageCardsLocators.MC_SHOW_CARD);
        checkOptional(driver, "MC_LINK_CARD_BTN", ManageCardsLocators.MC_LINK_CARD_BTN);
        checkOptional(driver, "MC_LINK_CARD_BTN_EMPTY", ManageCardsLocators.MC_LINK_CARD_BTN_EMPTY);
        checkPresence(driver, "MC_LINKED_CARD_COUNTER", ManageCardsLocators.MC_LINKED_CARD_COUNTER);
        checkPresence(driver, "MC_INFO_ICON", ManageCardsLocators.MC_INFO_ICON);
        checkPresence(driver, "MC_CARD_CONTAINER", ManageCardsLocators.MC_CARD_CONTAINER);
        checkPresence(driver, "MC_CARD_LOGO", ManageCardsLocators.MC_CARD_LOGO);
        checkPresence(driver, "MC_CARD_DISPLAY_NAME", ManageCardsLocators.MC_CARD_DISPLAY_NAME);
        checkPresence(driver, "MC_MAIN_CARD_NUMBER", ManageCardsLocators.MC_MAIN_CARD_NUMBER);
        checkPresence(driver, "MC_CARD_TYPE", ManageCardsLocators.MC_CARD_TYPE);
        checkPresence(driver, "MC_CARD_MEMBER_SINCE", ManageCardsLocators.MC_CARD_MEMBER_SINCE);
        checkOptional(driver, "MC_CARD_BADGE", ManageCardsLocators.MC_CARD_BADGE);
        checkOptional(driver, "MC_CLAIM_PRESTIGE_BTN", ManageCardsLocators.MC_CLAIM_PRESTIGE_BTN);

        WebElement showCard = waitClickable(driver, ManageCardsLocators.MC_SHOW_CARD, 5);
        if (showCard != null) {
            showCard.click();
            Thread.sleep(1500);
            checkPresence(driver, "MC_SHOWCARD_QR_TAB", ManageCardsLocators.MC_SHOWCARD_QR_TAB);
            checkPresence(driver, "MC_SHOWCARD_BC_TAB", ManageCardsLocators.MC_SHOWCARD_BC_TAB);
            checkOptional(driver, "MC_SHOWCARD_TIER_LOGO_QRBC_START", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_START);
            checkOptional(driver, "MC_SHOWCARD_TIER_LOGO_QRBC_SMAC", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_SMAC);
            checkOptional(driver, "MC_SHOWCARD_TIER_LOGO_QRBC_PRESTIGE", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_PRESTIGE);
            checkOptional(driver, "MC_SHOWCARD_BRAND_QRBC_START", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_START);
            checkOptional(driver, "MC_SHOWCARD_BRAND_QRBC_SMAC", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_SMAC);
            checkOptional(driver, "MC_SHOWCARD_BRAND_QRBC_PRESTIGE", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_PRESTIGE);
            checkPresence(driver, "MC_SHOWCARD_DYNAMIC_QR", ManageCardsLocators.MC_SHOWCARD_DYNAMIC_QR);
            checkPresence(driver, "MC_SHOWCARD_QRBC_DATETIME", ManageCardsLocators.MC_SHOWCARD_QRBC_DATETIME);
            checkPresence(driver, "MC_SHOWCARD_QRBC_CN", ManageCardsLocators.MC_SHOWCARD_QRBC_CN);

            WebElement bcTab = waitClickable(driver, ManageCardsLocators.MC_SHOWCARD_BC_TAB, 5);
            if (bcTab != null) {
                bcTab.click();
                Thread.sleep(800);
                checkPresence(driver, "MC_SHOWCARD_DYNAMIC_BC", ManageCardsLocators.MC_SHOWCARD_DYNAMIC_BC);
            } else {
                System.out.println("⚠️  skipped barcode tab — MC_SHOWCARD_BC_TAB not found");
            }
        } else {
            System.out.println("⚠️  skipped Show Card sub-screen — button not found");
        }

        if (SKIP_MOM) {
            System.out.println("⏭️  MOM Card check skipped (-DskipMom=true)");
            return;
        }

        // Back to Manage Cards main page for the MOM banner (Show Card is a
        // separate sub-screen, doesn't affect the banner below it).
        goHome(driver);
        WebElement widgetAgain = waitClickable(driver, HomepageLocators.MANAGECARDSWIDGET, 10);
        if (widgetAgain != null) {
            widgetAgain.click();
            Thread.sleep(1200);
            checkMomCard(driver);
        } else {
            System.out.println("⚠️  skipped MOM Card check — could not return to Manage Cards page");
        }
    }

    // ---------------------------------------------------------------
    // MOM CARD (Mom Card registration) — only relevant for a test account
    // pre-seeded with a MOM card whose registration form is incomplete
    // (e.g. Charlene Kiyuwey, logged into by the LOGIN section above).
    // The Proceed button is deliberately never tapped — see class doc.
    // ---------------------------------------------------------------
    private void checkMomCard(AndroidDriver driver) throws InterruptedException {
        checkOptional(driver, "MC_MOM_BANNER_TEXT", ManageCardsLocators.MC_MOM_BANNER_TEXT);
        checkOptional(driver, "MOM_CONTINUE_BTN", CardLinkingLocators.MOM_CONTINUE_BTN);

        WebElement continueBtn = waitClickable(driver, CardLinkingLocators.MOM_CONTINUE_BTN, 5);
        if (continueBtn == null) {
            System.out.println("⚠️  skipped MOM form — Continue button not found (account may not be pre-seeded with an incomplete MOM registration)");
            return;
        }
        continueBtn.click();
        Thread.sleep(1500);

        CardLinkingPage cardLink = new CardLinkingPage(driver);

        checkPresence(driver, "MOM_FORM_OTHER_INFO", CardLinkingLocators.MOM_FORM_OTHER_INFO);
        checkPresence(driver, "MOM_FORM_ADDR_HDR", CardLinkingLocators.MOM_FORM_ADDR_HDR);
        checkPresence(driver, "MOM_FORM_ADDR_DESCHDR", CardLinkingLocators.MOM_FORM_ADDR_DESCHDR);
        checkOptional(driver, "form_MOM_LINKED_HDR", CardLinkingLocators.form_MOM_LINKED_HDR);
        checkPresence(driver, "MOM_FORM_ADDR_HOUSE_NUM", CardLinkingLocators.MOM_FORM_ADDR_HOUSE_NUM);
        checkPresence(driver, "MOM_FORM_ADDR_PROVINCE", CardLinkingLocators.MOM_FORM_ADDR_PROVINCE);

        cardLink.Enter_Addr_HouseNumber("Suite 1");
        hideKeyboard(driver);

        checkInteraction("PROVINCE_ALBAY (select)", cardLink::select_Addr_Province);
        checkPresence(driver, "MOM_FORM_ADDR_CITY", CardLinkingLocators.MOM_FORM_ADDR_CITY);
        checkInteraction("CITY_DARAGA (select)", cardLink::select_Addr_City);
        checkPresence(driver, "MOM_FORM_ADDR_BRGY", CardLinkingLocators.MOM_FORM_ADDR_BRGY);
        checkInteraction("BRGY_ALCALA (select)", cardLink::select_Addr_Brgy);
        checkPresence(driver, "MOM_FORM_ADDR_POSTAL_CODE", CardLinkingLocators.MOM_FORM_ADDR_POSTAL_CODE);

        WebElement postal = driver.findElement(CardLinkingLocators.MOM_FORM_ADDR_POSTAL_CODE);
        postal.clear();
        postal.sendKeys("2110");
        hideKeyboard(driver);

        checkPresence(driver, "MOM_FORM_PREG_DET_HDR", CardLinkingLocators.MOM_FORM_PREG_DET_HDR);
        checkPresence(driver, "MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_YES", CardLinkingLocators.MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_YES);
        checkPresence(driver, "MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_NO", CardLinkingLocators.MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_NO);

        checkInteraction("(tap Yes to reveal pregnancy stage)", cardLink::click_PregDet_Yes);
        checkPresence(driver, "MOM_FORM_PREG_DET_KID_COUNT", CardLinkingLocators.MOM_FORM_PREG_DET_KID_COUNT);
        checkPresence(driver, "MOM_FORM_PREG_DET_PREG_STAGE", CardLinkingLocators.MOM_FORM_PREG_DET_PREG_STAGE);
        checkInteraction("PREG_STAGE_2ND_TRI (select)", cardLink::select_PregnancyStage);

        checkInteraction("(enter kids count to reveal kids age)", () -> {
            cardLink.tap("Kids count", CardLinkingLocators.MOM_FORM_PREG_DET_KID_COUNT, 5);
            pressText(driver, "2");
            hideKeyboard(driver);
        });
        checkPresence(driver, "MOM_FORM_PREG_DET_KIDS_AGE", CardLinkingLocators.MOM_FORM_PREG_DET_KIDS_AGE);
        checkInteraction("(fill kids age so the form is valid)", () -> {
            cardLink.tap("Kids Age", CardLinkingLocators.MOM_FORM_PREG_DET_KIDS_AGE, 5);
            pressText(driver, "5,7");
            hideKeyboard(driver);
        });

        checkPresence(driver, "FORM_PROCEED_BTN", CardLinkingLocators.FORM_PROCEED_BTN);
        System.out.println("⚪ n/a  Proceed button intentionally not tapped — submitting would permanently complete this test account's MOM registration");
    }

    // ---------------------------------------------------------------
    // POINTS HISTORY
    // (transaction-line-item locators are account/data-specific and not
    // checked here — only the structural elements of the page)
    // ---------------------------------------------------------------
    private void checkPointsHistory(AndroidDriver driver) throws InterruptedException {
        goHome(driver);
        WebElement widget = waitClickable(driver, HomepageLocators.PTSHISTORYWIDGET, 10);
        if (widget == null) {
            System.out.println("❌ FAIL  could not find Points History widget on Homepage — aborting section");
            fail++;
            return;
        }
        widget.click();
        Thread.sleep(800);

        checkPresence(driver, "PH_HDR", PointsHistoryLocators.PH_HDR);
        checkPresence(driver, "PH_BANNER", PointsHistoryLocators.PH_BANNER);
        checkPresence(driver, "PH_BACK", PointsHistoryLocators.PH_BACK);
    }

    // ---------------------------------------------------------------
    // INBOX
    // ---------------------------------------------------------------
    private void checkInbox(AndroidDriver driver) throws InterruptedException {
        goHome(driver);
        WebElement inboxTab = waitClickable(driver, HomepageLocators.BOTNAV_INBOX, 10);
        if (inboxTab == null) {
            System.out.println("❌ FAIL  could not find Inbox tab — aborting section");
            fail++;
            return;
        }
        inboxTab.click();
        Thread.sleep(800);

        checkPresence(driver, "INBOX_HDR", InboxLocators.INBOX_HDR);

        boolean noMessages = isPresent(driver, InboxLocators.INBOX_NOMESSAGES);
        boolean hasNotif = isPresent(driver, InboxLocators.INBOX_NOTIF_1_TITLE);
        if (noMessages) {
            System.out.println("✅ FOUND INBOX_NOMESSAGES  ->  " + InboxLocators.INBOX_NOMESSAGES);
            pass++;
        } else if (hasNotif) {
            System.out.println("✅ FOUND INBOX_NOTIF_1_TITLE  ->  " + InboxLocators.INBOX_NOTIF_1_TITLE);
            pass++;
            checkPresence(driver, "INBOX_NOTIF_1_BODY", InboxLocators.INBOX_NOTIF_1_BODY);

            WebElement notif = waitClickable(driver, InboxLocators.INBOX_NOTIF_1_TITLE, 5);
            if (notif != null) {
                notif.click();
                Thread.sleep(800);
                checkPresence(driver, "INBOX_BACK_BTN", InboxLocators.INBOX_BACK_BTN);
                checkPresence(driver, "INBOX_INNER_HDR", InboxLocators.INBOX_INNER_HDR);
                checkPresence(driver, "INBOX_INNER_BODY", InboxLocators.INBOX_INNER_BODY);
            }
        } else {
            System.out.println("❌ FAIL  neither INBOX_NOMESSAGES nor INBOX_NOTIF_1_TITLE matched — inbox state locators may be broken");
            fail++;
        }
    }

    // ---------------------------------------------------------------
    // CARD LINKING — logs in as "Rhie Nier" (a dedicated account with zero
    // linked cards, per CardLinking.feature's Background), links a real
    // unused Start-tier card number, completes OTP ("000000", the fixed
    // staging-env OTP CardLinkingSteps.java already uses), and confirms the
    // success screen. Pulls the card via the same TestDataManager method the
    // real Cucumber suite calls, with writeBack=false — same as established
    // convention, so no CSV file is mutated.
    // ---------------------------------------------------------------
    private void checkCardLinking(AndroidDriver driver) throws InterruptedException {
        reLoginAs(driver, CARD_LINKING_TEST_ACCOUNT_MOBILE, CARD_LINKING_TEST_ACCOUNT_PASSWORD);
        if (!waitForHomepage(driver)) {
            System.out.println("❌ FAIL  could not reach Homepage as Rhie Nier — aborting section");
            fail++;
            return;
        }

        WebElement linkCardWidget = waitClickable(driver, HomepageLocators.LINKCARDWIDGET, 10);
        if (linkCardWidget == null) {
            System.out.println("❌ FAIL  could not find Link Cards widget on Homepage — aborting section");
            fail++;
            return;
        }
        linkCardWidget.click();
        Thread.sleep(1200);

        CardLinkingPage cardLink = new CardLinkingPage(driver);

        checkPresence(driver, "CARD_LINKING_HDR", CardLinkingLocators.CARD_LINKING_HDR);
        checkPresence(driver, "CARD_LINKING_IMG", CardLinkingLocators.CARD_LINKING_IMG);
        checkPresence(driver, "CARD_LINKING_DESC", CardLinkingLocators.CARD_LINKING_DESC);
        checkPresence(driver, "CARD_NUM_FIELD", CardLinkingLocators.CARD_NUM_FIELD);
        checkPresence(driver, "LINK_BTN", CardLinkingLocators.LINK_BTN);
        checkPresence(driver, "CARD_LINKING_BACK", CardLinkingLocators.CARD_LINKING_BACK);
        checkPresence(driver, "ACTIVATION_INSTRUCTIONS_BTN", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_BTN);

        WebElement aiBtn = waitClickable(driver, CardLinkingLocators.ACTIVATION_INSTRUCTIONS_BTN, 5);
        if (aiBtn != null) {
            aiBtn.click();
            Thread.sleep(800);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_HDR", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_HDR);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_SMAC_HDR", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_SMAC_HDR);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_SMAC_DESC", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_SMAC_DESC);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_HDR", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_HDR);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_MOM_HDR", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_MOM_HDR);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_MOM_DESC", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_MOM_DESC);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_ACE_HDR", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_ACE_HDR);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_ACE_DESC", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_ACE_DESC);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_TK_HDR", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_TK_HDR);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_TK_DESC", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_TK_DESC);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_LYBC_HDR", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_LYBC_HDR);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_LYBC_DESC", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_LYBC_DESC);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_SEND_TO", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_SEND_TO);
            checkPresence(driver, "ACTIVATION_INSTRUCTIONS_MODAL_INST_CLOSE", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_CLOSE);
            try {
                cardLink.clickActivationInstructionsCloseBtn();
            } catch (Exception ignored) {
            }
            Thread.sleep(800);
        } else {
            System.out.println("⚠️  skipped Activation Instructions modal — button not found");
        }

        Map<String, String> cardRow;
        String cardNumberTD;
        try {
            // Same call the real "User can link SMAC Start card" scenario
            // makes (CardLinkingSteps.java) — writeBack=false, matching
            // established convention, so SMAC_Start_TestCards.csv is left
            // untouched.
            cardRow = TestDataManager.Start_getUnusedCardNumber("BA", "822", "false", false);
            cardNumberTD = cardRow.get("CardNumber");
        } catch (Exception e) {
            System.out.println("❌ FAIL  could not fetch an unused Start-tier card number from SMAC_Start_TestCards.csv: " + e.getMessage());
            fail++;
            return;
        }

        try {
            cardLink.enterCardNumber(cardNumberTD);
        } catch (Exception ignored) {
        }
        Thread.sleep(500);

        checkInteraction("(Link Your Card button enabled after entering card number)", () -> {
            if (!cardLink.isLinkYourCardBtnEnabled()) {
                throw new RuntimeException("Link Your Card button not enabled");
            }
        });
        checkInteraction("(tap Link Your Card)", cardLink::clickLinkYourCardBtn);
        Thread.sleep(1000);

        checkPresence(driver, "OTP_HDR", CardLinkingLocators.OTP_HDR);
        checkPresence(driver, "OTP_ICON", CardLinkingLocators.OTP_ICON);
        checkPresence(driver, "OTP_FIELD", CardLinkingLocators.OTP_FIELD);
        checkPresence(driver, "OTP_DID_NOT_RECEIVE", CardLinkingLocators.OTP_DID_NOT_RECEIVE);
        checkPresence(driver, "OTP_RESEND", CardLinkingLocators.OTP_RESEND);

        checkInteraction("(enter correct OTP)", () -> cardLink.enterOTP("000000"));
        Thread.sleep(1500);

        checkOptional(driver, "LOADING_ICN", CardLinkingLocators.LOADING_ICN);
        checkOptional(driver, "LOADING_TXT", CardLinkingLocators.LOADING_TXT);

        // Some card types show a Link Voucher congrats modal before the
        // success screen — optional, tier-dependent, dismiss if present.
        WebElement voucherClose = waitClickable(driver, CardLinkingLocators.VOUCHER_CLOSE_BTN, 5);
        if (voucherClose != null) {
            checkPresence(driver, "VOUCHER_CONGRATS_HDR", CardLinkingLocators.VOUCHER_CONGRATS_HDR);
            checkPresence(driver, "VOUCHER_CONGRATS_DESC", CardLinkingLocators.VOUCHER_CONGRATS_DESC);
            checkPresence(driver, "VOUCHER_PROCEED_BTN", CardLinkingLocators.VOUCHER_PROCEED_BTN);
            voucherClose.click();
            Thread.sleep(800);
        }

        boolean successScreenAppeared;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.presenceOfElementLocated(CardLinkingLocators.SUCCESS_TNX));
            successScreenAppeared = true;
        } catch (Exception e) {
            successScreenAppeared = false;
        }
        report("(card linking success screen appears)", "(interaction)", successScreenAppeared);

        checkPresence(driver, "SUCCESS_HDR", CardLinkingLocators.SUCCESS_HDR);
        checkPresence(driver, "SUCCESS_TNX", CardLinkingLocators.SUCCESS_TNX);
        checkPresence(driver, "SUCCESS_SUBTXT", CardLinkingLocators.SUCCESS_SUBTXT);
        checkPresence(driver, "SUCCESS_SUBTXT2", CardLinkingLocators.SUCCESS_SUBTXT2);
        checkPresence(driver, "SUCCESS_BACK_TO_HOME", CardLinkingLocators.SUCCESS_BACK_TO_HOME);

        try {
            cardLink.clickCardLinkingSuccessBackToHome();
        } catch (Exception ignored) {
        }
        Thread.sleep(1000);
        report("(returns to Homepage after linking)", "(interaction)", waitForHomepage(driver));
    }

    // ---------------------------------------------------------------
    // OFFLINE VIRTUAL CARD — logs in as "Olivia Rodrigo" (SMAC Start tier)
    // to cache her card locally, then toggles airplane mode via adb to
    // reach the offline QR/barcode screens. Network is ALWAYS restored in
    // the finally block, even if a check above throws.
    // ---------------------------------------------------------------
    private void checkOfflineVirtualCard(AndroidDriver driver) throws InterruptedException {
        reLoginAs(driver, OFFLINE_TEST_ACCOUNT_MOBILE, OFFLINE_TEST_ACCOUNT_PASSWORD);
        if (!waitForHomepage(driver)) {
            System.out.println("❌ FAIL  could not reach Homepage as Olivia Rodrigo — aborting section");
            fail++;
            return;
        }

        System.out.println("Disabling network (airplane-mode equivalent) via adb...");
        setNetworkEnabled(false);
        Thread.sleep(4000);

        try {
            checkOptional(driver, "TOAST_OFFLINE", OfflineVirtualCardLocators.TOAST_OFFLINE);
            checkPresence(driver, "VIEW_VIRTUAL_CARD_OFFLINE_MODAL_TITLE", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_TITLE);
            checkPresence(driver, "VIEW_VIRTUAL_CARD_OFFLINE_MODAL_DESC", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_DESC);
            checkPresence(driver, "VIEW_VIRTUAL_CARD_OFFLINE_MODAL_REFRESH_BTN", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_REFRESH_BTN);
            checkPresence(driver, "OFFLINE_MODAL_VIEW_VIRTUAL_SMAC", OfflineVirtualCardLocators.OFFLINE_MODAL_VIEW_VIRTUAL_SMAC);

            WebElement viewVirtual = waitClickable(driver, OfflineVirtualCardLocators.OFFLINE_MODAL_VIEW_VIRTUAL_SMAC, 10);
            if (viewVirtual != null) {
                viewVirtual.click();
                Thread.sleep(1200);

                checkPresence(driver, "offlineHeader", OfflineVirtualCardLocators.offlineHeader);
                checkPresence(driver, "OFFLINE_QR", OfflineVirtualCardLocators.OFFLINE_QR);
                checkPresence(driver, "dateTime_qr", OfflineVirtualCardLocators.dateTime_qr);
                checkPresence(driver, "OFFLINE_CARD_NUMBER_QR", OfflineVirtualCardLocators.OFFLINE_CARD_NUMBER_QR);
                checkPresence(driver, "OFFLINE_EARN_PTS", OfflineVirtualCardLocators.OFFLINE_EARN_PTS);
                checkPresence(driver, "OFFLINE_SHOW_QR", OfflineVirtualCardLocators.OFFLINE_SHOW_QR);
                checkPresence(driver, "OFFLINE_SHOW_BARCODE", OfflineVirtualCardLocators.OFFLINE_SHOW_BARCODE);
                checkOptional(driver, "OFFLINE_TIER_COLOR_START", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_START);
                checkOptional(driver, "OFFLINE_TIER_COLOR_SMAC", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_SMAC);
                checkOptional(driver, "OFFLINE_TIER_COLOR_PRESTIGE", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_PRESTIGE);

                WebElement showBarcode = waitClickable(driver, OfflineVirtualCardLocators.OFFLINE_SHOW_BARCODE, 5);
                if (showBarcode != null) {
                    showBarcode.click();
                    Thread.sleep(800);
                    checkPresence(driver, "OFFLINE_BARCODE", OfflineVirtualCardLocators.OFFLINE_BARCODE);
                    checkPresence(driver, "dateTime_barcode", OfflineVirtualCardLocators.dateTime_barcode);
                    checkPresence(driver, "OFFLINE_CARD_NUMBER_BARCODE", OfflineVirtualCardLocators.OFFLINE_CARD_NUMBER_BARCODE);
                } else {
                    System.out.println("⚠️  skipped offline barcode view — OFFLINE_SHOW_BARCODE not found");
                }

                WebElement backBtn = waitClickable(driver, OfflineVirtualCardLocators.OFFLINE_QRBC_BACK, 5);
                if (backBtn != null) {
                    backBtn.click();
                    Thread.sleep(800);
                }
            } else {
                System.out.println("⚠️  skipped offline QR/barcode views — OFFLINE_MODAL_VIEW_VIRTUAL_SMAC not found");
            }
        } finally {
            System.out.println("Restoring network connectivity...");
            setNetworkEnabled(true);
            Thread.sleep(4000);
            checkOptional(driver, "TOAST_BACK_ONLINE", OfflineVirtualCardLocators.TOAST_BACK_ONLINE);
        }
    }

    private void setNetworkEnabled(boolean enabled) {
        String state = enabled ? "enable" : "disable";
        try {
            new ProcessBuilder("adb", "-s", DEVICE_UDID, "shell", "svc", "wifi", state).start().waitFor();
            new ProcessBuilder("adb", "-s", DEVICE_UDID, "shell", "svc", "data", state).start().waitFor();
        } catch (Exception e) {
            System.out.println("⚠️  failed to " + state + " network via adb: " + e.getMessage());
        }
    }

    /**
     * Logs out of whatever account is currently active (if any) and logs in
     * as the given account — used to switch test accounts between sections
     * that each need a specific pre-seeded account. Does not re-verify
     * SSO/Login locators (already covered by the LOGIN section).
     */
    private void reLoginAs(AndroidDriver driver, String mobile, String password) throws InterruptedException {
        goHome(driver);
        if (isPresent(driver, HomepageLocators.BOTNAV_HOME)) {
            WebElement acctTab = waitClickable(driver, HomepageLocators.BOTNAV_ACCT, 10);
            if (acctTab != null) {
                acctTab.click();
                Thread.sleep(800);
                WebElement logoutBtn = waitClickable(driver, AccountLocators.LOGOUT_BTN, 5);
                if (logoutBtn != null) {
                    logoutBtn.click();
                    Thread.sleep(2000);
                }
            }
        }

        SSOMenuPage ssoMenu = new SSOMenuPage(driver);
        LoginPage login = new LoginPage(driver);
        try {
            ssoMenu.clickSSOLoginBtn();
        } catch (Exception ignored) {
        }
        Thread.sleep(800);
        try {
            login.verifySuccessfulLogin_SSOLoginOnly(mobile, password);
        } catch (Throwable ignored) {
        }
        Thread.sleep(1000);
    }

    private boolean waitForHomepage(AndroidDriver driver) {
        if (isPresent(driver, HomepageLocators.BOTNAV_HOME)) {
            return true;
        }
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated(HomepageLocators.BOTNAV_HOME));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ---------------------------------------------------------------
    // Shared helpers
    // ---------------------------------------------------------------

    /**
     * Climbs back to Homepage regardless of how many pushed screens deep the
     * previous section left the app (Help & Info, Manage Cards, Points
     * History etc. are full screens with no bottom nav, so a single back
     * tap isn't always enough). Falls back to relaunching the app if
     * backing out ever overshoots to the OS launcher.
     */
    private void goHome(AndroidDriver driver) throws InterruptedException {
        for (int i = 0; i < 4 && !isPresent(driver, HomepageLocators.BOTNAV_HOME); i++) {
            try {
                driver.navigate().back();
            } catch (Exception ignored) {
            }
            Thread.sleep(700);
        }
        if (!isPresent(driver, HomepageLocators.BOTNAV_HOME)) {
            driver.activateApp(APP_PACKAGE);
            Thread.sleep(1200);
        }
        // Longer wait + settle time here: some accounts (e.g. Prestige tier,
        // with its extra "Maintain Prestige" banner) take noticeably longer
        // to finish rendering Homepage than the base SMAC-tier layout.
        WebElement homeTab = waitClickable(driver, HomepageLocators.BOTNAV_HOME, 10);
        if (homeTab != null) {
            homeTab.click();
            Thread.sleep(1500);
        }
    }

    /** Tier-dependent QR tab: only one of Start/SMAC/Prestige is present. */
    private boolean goToQrTab(AndroidDriver driver) {
        return tapFirstPresent(driver,
                HomepageLocators.BOTNAV_QR_START,
                HomepageLocators.BOTNAV_QR_SMAC,
                HomepageLocators.BOTNAV_QR_PRESTIGE);
    }

    private boolean tapFirstPresent(AndroidDriver driver, By... locators) {
        for (By locator : locators) {
            WebElement el = waitClickable(driver, locator, 3);
            if (el != null) {
                el.click();
                return true;
            }
        }
        return false;
    }

    private void checkPresence(AndroidDriver driver, String name, By locator) {
        boolean found = isPresent(driver, locator);
        System.out.println((found ? "✅ PASS " : "❌ FAIL ") + name + "  ->  " + locator);
        if (found) pass++; else fail++;
    }

    /**
     * For locators that are one of several mutually-exclusive alternatives
     * (tier variants, optional eligibility-based buttons) — report presence
     * without counting a miss as a failure.
     */
    private void checkOptional(AndroidDriver driver, String name, By locator) {
        boolean found = isPresent(driver, locator);
        System.out.println((found ? "✅ FOUND " : "⚪ n/a  ") + name + "  ->  " + locator);
        if (found) pass++;
    }

    private boolean isPresent(AndroidDriver driver, By locator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private WebElement waitClickable(AndroidDriver driver, By locator, int timeoutSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            return null;
        }
    }

    private void report(String name, String detail, boolean ok) {
        System.out.println((ok ? "✅ PASS " : "❌ FAIL ") + name + "  ->  " + detail);
        if (ok) pass++; else fail++;
    }

    private interface ThrowingRunnable {
        void run() throws Exception;
    }

    /** Runs a form interaction (dropdown select, tap-to-reveal) and reports success/failure. */
    private void checkInteraction(String name, ThrowingRunnable interaction) {
        boolean ok;
        try {
            interaction.run();
            ok = true;
        } catch (Exception e) {
            ok = false;
        }
        report(name, "(interaction)", ok);
    }

    private void hideKeyboard(AndroidDriver driver) {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            // Keyboard wasn't showing — nothing to do.
        }
    }

    /**
     * Types via native Android key events instead of WebElement.sendKeys(),
     * so it keeps working even if the focused field's WebElement goes stale
     * mid-type from a rebuild triggered by the app's own onChanged handler
     * (same issue MOMFormLocatorCheck hit on this exact form).
     */
    private void pressText(AndroidDriver driver, String text) {
        for (char c : text.toCharArray()) {
            AndroidKey key = (c == ',') ? AndroidKey.COMMA : AndroidKey.valueOf("DIGIT_" + c);
            driver.pressKey(new KeyEvent(key));
        }
    }
}
