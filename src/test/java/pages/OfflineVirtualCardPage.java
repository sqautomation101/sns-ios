package pages;

import io.appium.java_client.AppiumDriver;

import base.*;
import hooks.*;
import locators.OfflineVirtualCardLocators;

public class OfflineVirtualCardPage extends BasePage {

    public static int timeout = 15;

    private final CardComponent card = Hooks.getPageManager().getCardComponent();

    // Constructor
    public OfflineVirtualCardPage(AppiumDriver driver) {
        super(driver);
    }


    public void toggleAirplaneMode(){
        networkHelper.disableNetwork();
    }


    public void turnOnWifi(){
        networkHelper.enableNetwork();
    }


    public String getTier_QR(){
        return card.verifyTier(OfflineVirtualCardLocators.OFFLINE_CARD_NUMBER_QR, ",", "-");
    }


    public String getTier_BC(){
        return card.verifyTier(OfflineVirtualCardLocators.OFFLINE_CARD_NUMBER_BARCODE, ",", "-");
    }


    public String getCardBIN_QR(){
        return card.verifyStatus(OfflineVirtualCardLocators.OFFLINE_CARD_NUMBER_QR, ",","-");
    }


    public String getCardBIN_BC(){
        return card.verifyStatus(OfflineVirtualCardLocators.OFFLINE_CARD_NUMBER_BARCODE, ",","-");

    }


    public boolean waitUntilOfflineModalIsHidden(){
        return waitForInvisibility("Offline title", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_TITLE, 5);
    }


    public boolean isOfflinemodalVisible() {
        waitUniqueElement(OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_TITLE, 10);

        boolean offTitle = isElementVisible("Offline title", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_TITLE, timeout);
        logStatus("Offline modal - Title", offTitle);

        boolean offDesc = isElementVisible("Offline desc", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_DESC, timeout);
        logStatus("Offline modal - Desc", offDesc);

        boolean offRefresh = isElementVisible("Refresh", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_REFRESH_BTN, timeout);
        logStatus("Offline modal - Refresh", offRefresh);

        boolean offViewVirtualSMAC = isElementVisible("View Virtual SMAC", OfflineVirtualCardLocators.OFFLINE_MODAL_VIEW_VIRTUAL_SMAC, timeout);
        logStatus("Offline modal - View VirtualSMAC", offViewVirtualSMAC);

        return offTitle & offDesc & offRefresh & offViewVirtualSMAC;
    }


    public boolean isVirtualSmacModalVisible_NoLoginHistory() {
        return isElementVisible("Offline - No cache - Hdr", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_TITLE, timeout) &&
                isElementVisible("Offline - No cache - desc", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_DESC, timeout) &&
                isElementVisible("Offline - No cache - Refresh", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_REFRESH_BTN, timeout) &&
                isElementVisible("Offline - No cache - Note", OfflineVirtualCardLocators.OFFLINE_NOCACHE_NOTE, timeout);
    }


    public boolean isViewVirtualCardEnabled() {
        return isElementEnabled("Offline - View Virtual SMAC", OfflineVirtualCardLocators.OFFLINE_MODAL_VIEW_VIRTUAL_SMAC);
    }


    public boolean isOfflineQRVisible_General() {
        waitUniqueElement(OfflineVirtualCardLocators.OFFLINE_EARN_PTS, timeout);

        boolean offQRBC_hdr = isElementVisible("Present to earn", OfflineVirtualCardLocators.OFFLINE_EARN_PTS, 10);
        logStatus("Offline QRBC - Visible", offQRBC_hdr);

//        boolean dateTime_QR = isElementVisible("Date", dateTime_qr, 10);
//        logStatus("Offline QR - Date", dateTime_QR);

        boolean qr = isElementVisible("Offline QR - QR Code", OfflineVirtualCardLocators.OFFLINE_QR, 10);
        logStatus("Offline QR - QR Code", qr);

        boolean cn = isElementVisible("Offline QR - Card number", OfflineVirtualCardLocators.OFFLINE_CARD_NUMBER_QR, 10);
        logStatus("Offline QR - Card number", cn);

        return offQRBC_hdr /*& dateTime_QR*/ & qr & cn;
    }


    public boolean isLowerBannerVisiblePerTier() {
        String tier = getTier_QR();

        switch (tier) {
            case "SMAC Start":
                System.out.println("*** Start ***");
                return isElementVisible("Start - Lower banner", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_START, 15);
            case "SMAC Blue":
                System.out.println("*** SMAC ***");
                return isElementVisible("SMAC - Lower banner", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_SMAC, 15);
            case "SMAC Prestige":
                System.out.println("*** Prestige ***");
                return isElementVisible("Prestige - Lower banner", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_PRESTIGE, 15);
            default:
                return false;
        }
    }


    public boolean isOfflineBarcodeVisible(String tier) {
        System.out.println("===== NEW VERSION 2026-06-19 =====");
        waitUniqueElement(OfflineVirtualCardLocators.OFFLINE_BARCODE, 10);

        boolean bc = isElementVisible("Offline Barcode - barcode", OfflineVirtualCardLocators.OFFLINE_BARCODE, 5);
        logStatus("Offline Barcode - barcode", bc);

        boolean cn= isElementVisible("Start - Card number", OfflineVirtualCardLocators.OFFLINE_CARD_NUMBER_BARCODE, 10);
        logStatus("Offline Barcode - Card number", cn);
        boolean common = cn & bc;

        switch (tier) {
            case "SMAC Start":
                System.out.println("*** Start ***");
                boolean tier_Start = isElementVisible("Start - Lower banner", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_START, 5);
                logStatus("Start - Lower banner", tier_Start);

                return common & tier_Start;

            case "SMAC Blue":
                System.out.println("*** SMAC ***");
                boolean tier_SMAC = isElementVisible("SMAC - Lower banner", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_SMAC, 5);
                logStatus("Start - Lower banner", tier_SMAC);

                return common & tier_SMAC;

            case "SMAC Prestige":
                System.out.println("*** Prestige ***");
                boolean tier_Prestige = isElementVisible("Prestige - Lower banner", OfflineVirtualCardLocators.OFFLINE_TIER_COLOR_PRESTIGE, 5);
                logStatus("Prestige - Lower banner", tier_Prestige);

                return common & tier_Prestige;

            default:
                System.out.println("Invalid tier. Please check");
                return false;
        }
    }


    public void clickCloseButton_NoCache() {
        tap("No cache - Close btn", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_SMAC_CLOSE_BTN, timeout);
    }


    public void clickOffline_Refresh() {
        tap("Offline", OfflineVirtualCardLocators.VIEW_VIRTUAL_CARD_OFFLINE_MODAL_REFRESH_BTN, timeout);
    }


    public void clickOffline_ViewVirtualSMAC() {
        tap("Offline - View virtual card", OfflineVirtualCardLocators.OFFLINE_MODAL_VIEW_VIRTUAL_SMAC, timeout);
    }


    public void clickOffline_ShowBarcode() {
        tap("Offline - Show barcode", OfflineVirtualCardLocators.OFFLINE_SHOW_BARCODE, timeout);
    }


    public void clickOffline_ShowBarcode_BackBtn() {
        tap("Show barcode - Back", OfflineVirtualCardLocators.OFFLINE_QRBC_BACK, timeout);
    }


    public void clickOffline_ShowQR() {
        tap("Offline - Show QR", OfflineVirtualCardLocators.OFFLINE_SHOW_QR, timeout);
    }


    public void clickOffline_ShowQR_BackBtn() {
        tap("Show QR - Back", OfflineVirtualCardLocators.OFFLINE_QRBC_BACK, timeout);
    }


    public boolean isOfflineToastVisible() {
        return isElementVisible("Offline Toast", OfflineVirtualCardLocators.TOAST_OFFLINE, 15);
    }


    public boolean isBckOnlineToastVisible() {
        return isElementVisible("Back online Toast", OfflineVirtualCardLocators.TOAST_BACK_ONLINE, 15);
    }


    public boolean isViewVirtualSMACEnabled() {
        return isElementEnabled("View Virtual SMAC", OfflineVirtualCardLocators.OFFLINE_MODAL_VIEW_VIRTUAL_SMAC);
    }
}