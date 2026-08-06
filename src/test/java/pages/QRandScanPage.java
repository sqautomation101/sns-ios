package pages;

import io.appium.java_client.AppiumDriver;

import hooks.*;
import locators.QRAndScanLocators;
import base.*;

public class QRandScanPage extends BasePage {

    private final CardComponent card = Hooks.getPageManager().getCardComponent();

    public QRandScanPage(AppiumDriver driver) {
        super(driver);
    }


    public void clickShowQR() {
        tap("Show QR", QRAndScanLocators.QAS_SHOW_QR, 15);
    }


    public void clickShowBarcode() {
        tap("Show Barcode", QRAndScanLocators.QAS_SHOW_BARCODE, 15);
    }


    public void clickPayWithPoints() {
        tap("Pay With Points", QRAndScanLocators.QAS_PAY_WITH_POINTS, 15);
    }

//    public boolean isQRPageDisplayed_NL() {
//        waitUniqueElement(QRAndScanLocators.QAS_SHOW_BARCODE, 30);
//
//        boolean qr_hdr = isElementVisible("Header label", QRAndScanLocators.QAS_EARN_POINTS, 10);
//        logStatus("QR - Header", qr_hdr);
//
//        boolean qr_cn = isElementVisible("QR card number", QRAndScanLocators.QAS_CARD_NUMBER, 10);
//        logStatus("QR - Card number", qr_cn);
//
//        boolean qr_dateTime_nl = isElementVisible("QR - datetime", QRAndScanLocators.QAS_DATETIME_QR,10);
//        logStatus("QR - Date-Time (NL)", qr_dateTime_nl);
//
//        boolean QRAndScanLocators.QAS_SHOW_QR = isElementVisible("Show QR", QRAndScanLocators.QAS_SHOW_QR, 10);
//        logStatus("QR - Show QR", QRAndScanLocators.QAS_SHOW_QR);
//
//        boolean QRAndScanLocators.QAS_SHOW_BARCODE = isElementVisible("Show barcode", QRAndScanLocators.QAS_SHOW_BARCODE, 10);
//        logStatus("QR - Show Barcode", QRAndScanLocators.QAS_SHOW_BARCODE);
//
//        boolean pwp = isElementVisible("Pay with points", QRAndScanLocators.QAS_PAY_WITH_POINTS,10);
//        logStatus("QR - Pay With Points", pwp);
//
//        return qr_hdr & qr_cn & qr_dateTime_nl & QRAndScanLocators.QAS_SHOW_QR & QRAndScanLocators.QAS_SHOW_BARCODE & pwp;
//    }


    public boolean isQRButtonsDisplayed(){
        waitUniqueElement(QRAndScanLocators.QAS_PAY_WITH_POINTS, 60);

        boolean showQRBtn = isElementVisible("Show QR button", QRAndScanLocators.QAS_SHOW_QR, 10);
        logStatus("QR - Show QR button", showQRBtn);

        boolean showBarcodeBtn = isElementVisible("Show Barcode button", QRAndScanLocators.QAS_SHOW_BARCODE, 10);
        logStatus("QR - Show Barcode button", showBarcodeBtn);

        boolean payWithPointsBtn = isElementVisible("Pay With Points button", QRAndScanLocators.QAS_PAY_WITH_POINTS, 10);
        logStatus("QR - Pay With Points button", payWithPointsBtn);
        
        return showQRBtn & showBarcodeBtn & payWithPointsBtn;
    }


    public boolean isQRPageDisplayed_General() {
        waitUniqueElement(QRAndScanLocators.QAS_PAY_WITH_POINTS, 60);
        
        boolean qr_hdr = isElementVisible("Header label", QRAndScanLocators.QAS_EARN_POINTS, 10);
        logStatus("QR - Header", qr_hdr);

        boolean qr_qrCode = isElementVisible("QR code", QRAndScanLocators.QAS_DYNAMIC_QR, 10);
        logStatus("QR - QR code", qr_qrCode);

        boolean qr_cardNUmber = isElementVisible("QR card number", QRAndScanLocators.QAS_CARD_NUMBER, 10);
        logStatus("QR - card number", qr_cardNUmber);

        boolean qr_dateTime = isElementVisible("QR datetime", QRAndScanLocators.QAS_DATETIME_QR, 10);
        logStatus("QR - datetime", qr_dateTime);
        
        return qr_hdr & qr_qrCode & qr_cardNUmber & qr_dateTime & isQRButtonsDisplayed();
    }


    public boolean isBCPageDisplayed_General() {
        waitUniqueElement(QRAndScanLocators.QAS_PAY_WITH_POINTS, 60);

        boolean bc_hdr = isElementVisible("Header label", QRAndScanLocators.QAS_EARN_POINTS, 10);
        logStatus("Barcode - Header", bc_hdr);

        boolean bc_Code = isElementVisible("Barcode", QRAndScanLocators.QAS_DYNAMIC_BARCODE, 10);
        logStatus("Barcode - Barcode code", bc_Code);

        boolean bc_cardNUmber = isElementVisible("Barcode card number", QRAndScanLocators.QAS_CARD_NUMBER, 10);
        logStatus("Barcode - card number", bc_cardNUmber);

        boolean bc_dateTime = isElementVisible("Barcode datetime", QRAndScanLocators.QAS_DATETIME_BARCODE, 10);
        logStatus("Barcode - datetime", bc_dateTime);

        return bc_hdr & bc_Code & bc_cardNUmber & bc_dateTime & isQRButtonsDisplayed();

    }


    public boolean isPayWithPointsPageVisible() {
        return isElementVisible("Scanner", QRAndScanLocators.QAS_PWP_SCANNER_CAM, 10) &
                isElementVisible("PWP Instructions", QRAndScanLocators.QAS_PWP_INSTRUCTIONS, 10) &
                isElementVisible("Show QR", QRAndScanLocators.QAS_SHOW_QR, 10) &
                isElementVisible("Show barcode", QRAndScanLocators.QAS_SHOW_BARCODE, 10) &
                isElementVisible("Pay with points", QRAndScanLocators.QAS_PAY_WITH_POINTS, 10);
    }


    public String QAS_getTier(){
        return card.verifyTier(QRAndScanLocators.QAS_CARD_NUMBER, ",", "-");
    }
    public String getCardBIN_QAS(){
        waitUniqueElement(QRAndScanLocators.QAS_CARD_NUMBER, 60);
        return card.verifyStatus(QRAndScanLocators.QAS_CARD_NUMBER, ",","-");
    }


    public boolean isLowerBannerVisiblePerTier_QAS() {
        String tier = QAS_getTier();

        switch (tier) {
            case "SMAC Start":
                System.out.println("*** Start ***");
                return isElementVisible("Start - Lower banner", QRAndScanLocators.TIER_COLOUR_START, 15);
            case "SMAC Blue":
                System.out.println("*** SMAC ***");
                return isElementVisible("SMAC - Lower banner", QRAndScanLocators.TIER_COLOUR_SMAC, 15);
            case "SMAC Prestige":
                System.out.println("*** Prestige ***");
                return isElementVisible("Prestige - Lower banner", QRAndScanLocators.TIER_COLOUR_PRESTIGE, 15);
            default:
                return false;
        }
    }

}
