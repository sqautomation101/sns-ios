package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import hooks.Hooks;
import base.*;
import util.*;
import locators.HomepageLocators;


public class HomePage extends BasePage {


    private final CardComponent card = Hooks.getPageManager().getCardComponent();


    // Constructor
    public HomePage(AppiumDriver driver) {
        super(driver);
    }


    public boolean isHomepageDisplayed(){
        waitUniqueElement(HomepageLocators.refer_hdr, 60);

        boolean rfr_title = isElementVisible("Referal - Title", HomepageLocators.refer_hdr, 10);
        logStatus("Referal - Title", rfr_title);

        boolean rfr_desc = isElementVisible("Referal - Description", HomepageLocators.refer_desc, 10);
        logStatus("Referal - Description", rfr_desc);

        boolean rfr_copy = isElementVisible("Referal - Copy", HomepageLocators.refer_copy, 10);
        logStatus("Referal - Copy", rfr_copy);

        boolean rfr_share = isElementVisible("Referal - Share", HomepageLocators.refer_share, 10);
        logStatus("Referal - Share", rfr_share);

        boolean search_btn_shop = isElementVisible("Homepage - Shop - Search", HomepageLocators.SEARCH_BTN, 10);
        logStatus("Homepage - Shop - Search", search_btn_shop);

        return rfr_title && rfr_desc && rfr_copy && rfr_share && search_btn_shop;

    }


    public boolean isMainCardWidgetDisplayed(){
        waitUniqueElement(HomepageLocators.MANAGECARDSWIDGET, 30);

        WebElement By_cardNumber = waitHelper.waitForVisibility_Bylocator(HomepageLocators.CARDNUMBER_AND, 15);
        WebElement By_cardPoints = waitHelper.waitForVisibility_Bylocator(HomepageLocators.CARDPOINTS_AND, 15);

        boolean cn = isElementVisible("Card number", By_cardNumber, 15);
        logStatus("Card - card number", cn);

        boolean pts = isElementVisible("Card points", By_cardPoints, 15);
        logStatus("Card - Card points", pts);

        boolean manageCard = isElementVisible("Manage card widget", HomepageLocators.MANAGECARDSWIDGET, 15);
        logStatus("Card - Manage card widget", manageCard);

        boolean play =  isElementVisible("Play widget", HomepageLocators.PLAYWIDGET, 15);
        logStatus("Card - Play widget", play);

        boolean ptsHistory = isElementVisible("PTS History", HomepageLocators.PTSHISTORYWIDGET, 15);
        logStatus("Card - Points History", ptsHistory);

        boolean linkCard = isElementVisible("Link Card", HomepageLocators.LINKCARDWIDGET, 15);
        logStatus("Card - Link Card", linkCard);

        return cn && pts && play && manageCard && ptsHistory && linkCard;
    }

    public boolean isRTP_MaintainPrestigeVisible(){
        return isElementVisible("RTP - Maintain Prestige", HomepageLocators.RTP_MAINTAIN, 15);
    }

    public boolean isRTPVisible(){
        return isElementVisible("RTP",  HomepageLocators.RTP_ORIGINAL, 15);
    }


    public boolean isGoShoppingHeaderDisplayed() { return isElementVisible("Go shopping header", HomepageLocators.GOSHOPPING_HDR, 15); }


    public void clickSearchBtn(){
        tap("Search btn", HomepageLocators.SEARCH_BTN, 15);
    }


    public boolean verifyShopUniversalSearchScreen(){
        return  isElementVisible("Shop universal screen", HomepageLocators.SHOP_UNIV_SEARCH_BACK, 15);
    }


    public void clickPointHistoryWidget() {
        tap("Pts history widget", HomepageLocators.PTSHISTORYWIDGET, 15);
    }


    public void clickManageCards() throws InterruptedException {
        tap("Manage cards widget", HomepageLocators.MANAGECARDSWIDGET, 15);
    }

    public void clickHomeLinkCardWidget(){
        tap("Link Card Widget", HomepageLocators.LINKCARDWIDGET, 30);
    }


    public void clickCardNumber() {
        isElementVisible("Prismic", HomepageLocators.PRISMIC, 30);
        tap("Card number", HomepageLocators.CARDNUMBER_AND, 10);
    }

    public String extractCardNumber() {
        return card.extractCardNumber(HomepageLocators.CARDNUMBER_AND, 4);
    }


    public boolean isCardNumberMasked(String cardNumber) {
        String[] parts = cardNumber.split("-");

        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid card format: " + cardNumber);
        }

        return parts[0].equals("XXXX") && parts[1].equals("XXXX");
    }

    public String getExpectedVirtualCardNumber(String Name) {
        String maskedVN = TestDataManager.getCardNumberFromAccount(Name, "Virtual");
        return card.addDelimiterToCardNumber(maskedVN,"-");
    }


    //REMOVED
//    public String extractGreetings() {
//        WebElement greetingElement = driver.findElement(homeGreeting_and);
//        String contentDesc = greetingElement.getAttribute("content-desc");
//
//        int start = contentDesc.indexOf("Hi ") + 3;
//        String name = contentDesc.substring(start).trim(); // take everything after Hi,
//
//        //System.out.println("Extracted: " + name);
//        return name;
//    }



    public String verifyHighestTier_hp(){

        if (isElementVisible("SMAC Start", HomepageLocators.CARD_STARTLOGO, 15)){
            return "SMAC Start";
        } else if (isElementVisible("SMAC Regular", HomepageLocators.CARD_SMACLOGO, 15)) {
            return "SMAC Regular";
        } else if (isElementVisible("SMAC Prestige", HomepageLocators.CARD_PRESTIGELOGO, 15)) {
            return "SMAC Prestige";
        } else {
            return "Unknown tier";
        }
    }


    public void clickRTP() {
        tap("RTP btn", HomepageLocators.RTP_MAINTAIN, 30);
    }


    public boolean isBottomNavVisible(){
        waitUniqueElement(HomepageLocators.BOTNAV_HOME, 40);

        boolean home =isElementVisible("Home", HomepageLocators.BOTNAV_HOME, 10);
        logStatus("Home", home);

        boolean voucher =isElementVisible("Voucher", HomepageLocators.BOTNAV_VOUCHERS, 10);
        logStatus("Voucher", voucher);

        boolean acct = isElementVisible("Account", HomepageLocators.BOTNAV_ACCT, 10);
        logStatus("Account", acct);

        boolean inbox = isElementVisible("Inbox", HomepageLocators.BOTNAV_INBOX, 10);
        logStatus("Inbox", inbox);


        return
                home && voucher && acct && inbox &&
                (isElementVisible("QR Start", HomepageLocators.BOTNAV_QR_START, 10) |
                isElementVisible("QR SMAC", HomepageLocators.BOTNAV_QR_SMAC, 10) |
                isElementVisible("QR Prestige", HomepageLocators.BOTNAV_QR_PRESTIGE, 10));
    }


    public void clickBotNav_Voucher() {
        boolean isEnabled = isElementEnabled("Vouchers", HomepageLocators.BOTNAV_VOUCHERS);

        if (isEnabled) {
            tap("Vouchers", HomepageLocators.BOTNAV_VOUCHERS,10);
        } else {
            System.out.println("Unable to tap. Element is not yet ready");
        }
    }


    public void clickBotNav_QR_Start() {
        boolean isEnabled = isElementEnabled("QR", HomepageLocators.BOTNAV_QR_START);

        if (isEnabled){
            tap("QR", HomepageLocators.BOTNAV_QR_START,10);
        } else {
            System.out.println("Unable to tap. Element is not yet ready");
        }
    }


    public void clickBotNav_QR_SMAC() {
        boolean isEnabled = isElementEnabled("QR", HomepageLocators.BOTNAV_QR_SMAC);

        if (isEnabled){
            tap("QR", HomepageLocators.BOTNAV_QR_SMAC,10);
        } else {
            System.out.println("Unable to tap. Element is not yet ready");
        }
    }


    public void clickBotNav_QR_Prestige() {
        boolean isEnabled = isElementEnabled("QR", HomepageLocators.BOTNAV_QR_PRESTIGE);

        if (isEnabled){
            tap("QR", HomepageLocators.BOTNAV_QR_PRESTIGE,10);
        } else {
            System.out.println("Unable to tap. Element is not yet ready");
        }
    }


    public void clickBotNav_Acc() {
        boolean isEnabled = isElementEnabled("Account", HomepageLocators.BOTNAV_ACCT);

        if (isEnabled){
            tap("Account", HomepageLocators.BOTNAV_ACCT,10);
        } else {
            System.out.println("Unable to tap. Element is not yet ready");
        }
    }


    public void clickBotNav_Inbox() {
        boolean isEnabled = isElementEnabled("Inbox", HomepageLocators.BOTNAV_INBOX);

        if (isEnabled){
            tap("Inbox", HomepageLocators.BOTNAV_INBOX,10);
        } else {
            System.out.println("Unable to tap. Element is not yet ready");
        }
    }

    //REMOVED
//    public void clickBotNav_Shop() {
//        boolean isEnabled = isElementEnabled("Shop", BotNav_Shop);
//
//        if (isEnabled){
//            tap("Shop", BotNav_Shop,10);
//        } else {
//            System.out.println("Unable to tap. Element is not yet ready");
//        }
//    }


    public void clickBotNav_Home() {
        boolean isEnabled = isElementEnabled("Home", HomepageLocators.BOTNAV_HOME);

        if (isEnabled){
            tap("Home", HomepageLocators.BOTNAV_HOME,10);
        } else {
            System.out.println("Unable to tap. Element is not yet ready");
        }
    }


    public boolean verifyQRButtonTier(String tier){
        if(tier.equalsIgnoreCase("Start")){
            return isElementVisible("QR Start", HomepageLocators.BOTNAV_QR_START, 10);
        } else if (tier.equalsIgnoreCase("SMAC")) {
            return isElementVisible("QR SMAC", HomepageLocators.BOTNAV_QR_SMAC, 10);
        } else if (tier.equalsIgnoreCase("Prestige")) {
            return isElementVisible("QR Prestige", HomepageLocators.BOTNAV_QR_PRESTIGE, 10);
        } else {
            return false;
        }
    }
}