package pages;

import io.appium.java_client.AppiumDriver;
import util.UtilScroll;

import base.*;
import hooks.*;
import locators.PointsHistoryLocators;

public class PointsHistoryPage extends BasePage {

    // for locator timeout
    public static int timeout = 30;
    private CardComponent card = Hooks.getPageManager().getCardComponent();
    private UtilScroll scroll;

    //CONSTRUCTOR
    public PointsHistoryPage(AppiumDriver driver) {
        super(driver);
        scroll = new UtilScroll(driver, 10);
    }


    public boolean isPointsHistoryPageVisible() {
        waitUniqueElement(PointsHistoryLocators.PH_HDR, 60);

        boolean ptsHx_Back = isElementVisible("Pts History - Back", PointsHistoryLocators.PH_BACK, 10);
        logStatus("Points history - Back", ptsHx_Back);

        boolean ptsHx_hdr = isElementVisible("Pts History hdr", PointsHistoryLocators.PH_HDR, 10);
        logStatus("Points history hdr", ptsHx_hdr);

        boolean ptsHx_banner = isElementVisible("Pts History memo", PointsHistoryLocators.PH_BANNER, 10);
        logStatus("Points history memo", ptsHx_banner);

        return ptsHx_Back & ptsHx_hdr & ptsHx_banner;
    }


    public void clickBackBtnPointsHistory(){
        tap("Pts history - Back btn", PointsHistoryLocators.PH_BACK,10);
    }


    public void clickTransDetailsBackBtn(){
        tap("Pts history - Trans Det - Back btn", PointsHistoryLocators.PH_TRANS_DET_BACK_BTN,10);
    }


    public void clickPtsHistoryTransaction(String sce){
        switch(sce){
            case "Point transfer as Receiver":
                tap("Point transfer as Receiver item", PointsHistoryLocators.PH_ITEM_PTS_TRANS_AS_RECEIVER, 10 );
                break;
            case "Point transfer as Sender":
                tap("Point transfer as Sender item", PointsHistoryLocators.PH_ITEM_PTS_TRANS_AS_SENDER, 10 );
                break;
            case "Redemption":
            case "red-ACE":
                tap("Redemption item, ACE", PointsHistoryLocators.PH_ITEM_RED_TITLE, 10 );
                break;
            case "Awarding":
            case "awd-ACE":
                tap("Awarding item, ACE", PointsHistoryLocators.PH_ITEM_AWD_TITLE, 10 );
                break;
            case "awd-TK":
                tap("Awarding item, TK", PointsHistoryLocators.PH_ITEM_AWD_TK_TITLE, 10 );
                break;
            case "awd-MOM":
                tap("Awarding item, MOM", PointsHistoryLocators.PH_ITEM_AWD_MOM_TITLE, 10 );
                break;
            case "awd-LYBC":
                tap("Awarding item, LYBC", PointsHistoryLocators.PH_ITEM_AWD_LYBC_TITLE, 10 );
                break;
            case "red-LYBC":
                tap("Red-LYBC", PointsHistoryLocators.PH_ITEM_RED_LYBC_TITLE, 10 );
                break;
            case "red-TK":
                tap("Red-TK", PointsHistoryLocators.PH_ITEM_RED_TK_TITLE, 10 );
                break;
            case "red-MOM":
                tap("Red-MOM", PointsHistoryLocators.PH_ITEM_RED_MOM_TITLE, 10 );
                break;
            case "BDOR to SMAC":
                tap("BDOR to SMAC item", PointsHistoryLocators.PH_ITEM_BDORTOSMAC_TITLE, 10 );
                break;
            case "PAL to SMAC":
                tap("PAL to SMAC item",PointsHistoryLocators.PH_ITEM_PALTOSMAC_TITLE, 10 );
                break;
            case "SMAC to PAL":
                tap("SMAC to PAL item",PointsHistoryLocators.PH_ITEM_SMACTOPAL_TITLE, 10 );
                break;
            case "AIR ASIA to SMAC":
                tap("AIR ASIA to SMAC item",PointsHistoryLocators.PH_ITEM_AIRTOSMAC_TITLE, 10 );
                break;
            case "SMAC to AIR ASIA":
                tap("AIR ASIA to SMAC item",PointsHistoryLocators.PH_ITEM_SMACTOAIR_TITLE, 10 );
                break;

            default:
                throw new IllegalArgumentException("Unknown scenario: " + sce);
        }
    }


    public boolean isPtsHistoryTextAdjVisible(){
        return isElementVisible("Pts History - Text Adj memo", PointsHistoryLocators.PH_BANNER, 10);
    }


    public boolean isPointsTransferInnerPageVisible_General(){
        waitUniqueElement(PointsHistoryLocators.PH_TRANS_DET_BACK_BTN, 60);

        boolean inner_hdr = isElementVisible("Pts History - Inner - Header", PointsHistoryLocators.PH_TRANS_DET_TITLE, 10);
        logStatus("Points History - Inner - Header", inner_hdr);

        boolean inner_Back = isElementVisible("Pts History - Inner - Back", PointsHistoryLocators.PH_TRANS_DET_BACK_BTN, 10);
        logStatus("Points History - Inner - Back", inner_Back);

        boolean inner_ptsTransferIcon = isElementVisible("Pts History - Inner - Icon", PointsHistoryLocators.PH_POINTS_TRANSF_ICON, 10);
        logStatus("Points History - Inner - Icon", inner_ptsTransferIcon);

        return inner_ptsTransferIcon & inner_hdr & inner_Back;
    }


    public boolean isPointsTransferInnerPageVisible_Specific(String tranType){
        boolean commonElements = isElementVisible("Pts History - Inner - Dynamic title", PointsHistoryLocators.PH_TRANS_DET_DYNAMIC_TITLE, 15) &
                isElementVisible("Pts History - Inner - RefNo", PointsHistoryLocators.PH_TRANS_DET_REF_NO, 10) &
                isElementVisible("Pts History - Inner - Lbl - Date", PointsHistoryLocators.PH_TRANS_DET_DATE_LBL, 10);

        switch (tranType){
            case "transfers - Sender":
            case "transfers - Receiver":
                return commonElements &&
                        isElementVisible("Pts History - Inner - Lbl - Pts", PointsHistoryLocators.PH_TRANS_DET_PTS_LBL, 10) &
                        isElementVisible("Pts History - Inner - Val - Pts", PointsHistoryLocators.PH_TRANS_DET_PTS_VAL, 10) &
                        isElementVisible("Pts History - Inner - Lbl - Card", PointsHistoryLocators.PH_TRANS_DET_CARD_LBL, 10) &
                        isElementVisible("Pts History - Inner - Val - Card", PointsHistoryLocators.PH_TRANS_DET_CARD_VAL, 10) ;
            case "Redemption":
            case "Awarding":
                return commonElements &&
                        isElementVisible("Pts History - Inner - Lbl - Pts", PointsHistoryLocators.PH_TRANS_DET_POINTS_LBL, 10) &
                        isElementVisible("Pts History - Inner - Lbl - Card", PointsHistoryLocators.PH_TRANS_DET_CARD_LBL, 10) &
                        isElementVisible("Pts History - Inner - Lbl - Amount", PointsHistoryLocators.PH_TRANS_DET_AMOUNT_LBL, 10);

            default:
                throw new IllegalArgumentException("Unknown transaction type: " + tranType);
        }
    }


    public String getPtsHistoryDate(String tranType){
        switch (tranType){
            case "awd-LYBC":
                return card.extractContentDesc_2(PointsHistoryLocators.PH_ITEM_LYBC_AWD_DATE, ",", 1);
            case "awd-ACE":
                return card.extractContentDesc_2(PointsHistoryLocators.PH_ITEM_ACE_AWD_DATE, ",", 1);
            case "awd-TK":
                return card.extractContentDesc_2(PointsHistoryLocators.PH_ITEM_TK_AWD_DATE, ",", 1);
            case "awd-MOM":
                return card.extractContentDesc_2(PointsHistoryLocators.PH_ITEM_MOM_AWD_DATE, ",", 1);
            case "red-ACE":
                return card.extractContentDesc_2(PointsHistoryLocators.PH_ITEM_ACE_RED_DATE, ",", 1);
            case "red-TK":
                return card.extractContentDesc_2(PointsHistoryLocators.PH_ITEM_TK_RED_DATE, ",", 1);
            case "red-MOM":
                return card.extractContentDesc_2(PointsHistoryLocators.PH_ITEM_MOM_RED_DATE, ",", 1);
            case "red-LYBC":
                return card.extractContentDesc_2(PointsHistoryLocators.PH_ITEM_LYBC_RED_DATE, ",", 1);
            default:
                throw new IllegalArgumentException("Unknown transaction type: " + tranType);
        }
    }


    public String getPtsHistoryTitle(String tranType){
        switch (tranType){
            case "Redemption":
            case "red-ACE":
                return card.extractFromContentDesc("Redemption - ACE title", PointsHistoryLocators.PH_ITEM_RED_TITLE, ",", 1);
                //System.out.println(transactionTitle);
            case "Awarding":
            case "awd-ACE":
                return card.extractFromContentDesc("Awarding - ACE title", PointsHistoryLocators.PH_ITEM_AWD_TITLE, ",", 1);
            case "awd-TK":
                return card.extractFromContentDesc("Awarding - TK title", PointsHistoryLocators.PH_ITEM_AWD_TK_TITLE, ",", 1);
            case "awd-MOM":
                return card.extractFromContentDesc("Awarding - MOM title", PointsHistoryLocators.PH_ITEM_AWD_MOM_TITLE, ",", 1);
            case "awd-LYBC":
                return card.extractFromContentDesc("Awarding - LYBC title", PointsHistoryLocators.PH_ITEM_AWD_LYBC_TITLE, ",", 1);
            case "red-LYBC":
                return card.extractFromContentDesc("Redemption - LYBC title", PointsHistoryLocators.PH_ITEM_RED_LYBC_TITLE, ",", 1);
            case "red-TK":
                return card.extractFromContentDesc("Redemption - TK title", PointsHistoryLocators.PH_ITEM_RED_TK_TITLE, ",", 1);
            case "red-MOM":
                return card.extractFromContentDesc("Redemption - MOM title", PointsHistoryLocators.PH_ITEM_RED_MOM_TITLE, ",", 1);
            case "BDOR to SMAC":
                return card.extractFromContentDesc("BDOR to SMAC title", PointsHistoryLocators.PH_ITEM_BDORTOSMAC_TITLE, ",", 1);
            case "PAL to SMAC":
                return card.extractFromContentDesc("PAL to SMAC title", PointsHistoryLocators.PH_ITEM_PALTOSMAC_TITLE, ",", 1);
            case "SMAC to PAL":
                return card.extractFromContentDesc("SMAC to PAL title", PointsHistoryLocators.PH_ITEM_SMACTOPAL_TITLE, ",", 1);
            case "AIR ASIA to SMAC":
                return card.extractFromContentDesc("AIR ASIA to SMAC title", PointsHistoryLocators.PH_ITEM_AIRTOSMAC_TITLE, ",", 1);
            case "SMAC to AIR ASIA":
                return card.extractFromContentDesc("SMAC to AIR ASIA title", PointsHistoryLocators.PH_ITEM_SMACTOAIR_TITLE, ",", 1);

            default:
                throw new IllegalArgumentException("Unknown transaction type: " + tranType);
        }
    }


    public String getPtsHistoryTitle_Inner(){
        String transactionTitle = card.extractFromContentDesc("Inner - Dynamic Title", PointsHistoryLocators.PH_TRANS_DET_DYNAMIC_TITLE, ",", 1);
        //System.out.println(transactionTitle);
        return transactionTitle;
    }


    public String getPtsHistoryPts_Inner(){
        String transactionPts = card.extractFromContentDesc("Inner - Points", PointsHistoryLocators.PH_TRANS_DET_POINTS_VAL, ",", 1);
        cleanPositivePointsValue(transactionPts);
        //System.out.println(transactionTitle);
        return transactionPts;
    }


    public String getPtsHistoryDate_Inner(){
        String transactionDate = card.extractContentDesc_2(PointsHistoryLocators.PH_TRANS_DET_DATE_VAL, ",", 1);
        //System.out.println(transactionTitle);
        return transactionDate;
    }


    public String cleanPositivePointsValue(String rawPointsValue){
        String cleanedPointsValue = rawPointsValue.replace("+", "");
        System.out.println("Cleaned points value: " + cleanedPointsValue);
        return cleanedPointsValue;
    }


    public boolean verifyItem_TransactionType(String transactionType){
        switch (transactionType){
            case "Redemption":
            case "red-ACE":
                return isElementVisible("Pts History - Item - Redemption - ACE", PointsHistoryLocators.PH_ITEM_RED_TITLE, 10);
            case "Awarding":
            case "awd-ACE":
                return isElementVisible("Pts History - Item - Awarding - ACE", PointsHistoryLocators.PH_ITEM_AWD_TITLE, 10);
            case "awd-LYBC":
                return isElementVisible("Pts History - Item - Awarding - LYBC", PointsHistoryLocators.PH_ITEM_AWD_LYBC_TITLE, 10);
            case "awd-MOM":
                return isElementVisible("Pts History - Item - Awarding - MOM", PointsHistoryLocators.PH_ITEM_AWD_MOM_TITLE, 10);
            case "awd-TK":
                return isElementVisible("Pts History - Item - awd-TK", PointsHistoryLocators.PH_ITEM_AWD_TK_TITLE, 10);
            case "red-LYBC":
                return isElementVisible("Pts History - Item - red-LYBC", PointsHistoryLocators.PH_ITEM_RED_LYBC_TITLE, 10);
            case "red-MOM":
                return isElementVisible("Pts History - Item - red-MOM", PointsHistoryLocators.PH_ITEM_RED_MOM_TITLE, 10);
            case "red-TK":
                return isElementVisible("Pts History - Item - red-TK", PointsHistoryLocators.PH_ITEM_RED_TK_TITLE, 10);
            case "BDOR to SMAC":
                return isElementVisible("Pts History - Item - BDOR to SMAC", PointsHistoryLocators.PH_ITEM_BDORTOSMAC_TITLE, 10);
            case "PAL to SMAC":
                return isElementVisible("Pts History - Item - PAL to SMAC", PointsHistoryLocators.PH_ITEM_PALTOSMAC_TITLE, 10);
            case "AIR ASIA to SMAC":
                return isElementVisible("Pts History - Item - AIR ASIA to SMAC", PointsHistoryLocators.PH_ITEM_AIRTOSMAC_TITLE, 10);
            case "SMAC to PAL":
                return isElementVisible("Pts History - Item - SMAC to PAL", PointsHistoryLocators.PH_ITEM_SMACTOPAL_TITLE, 10);
            case "SMAC to AIR ASIA":
                return isElementVisible("Pts History - Item - SMAC to AIR ASIA", PointsHistoryLocators.PH_ITEM_SMACTOAIR_TITLE, 10);

            default:
                throw new IllegalArgumentException("Unknown transaction type: " + transactionType);
        }
    }


    public String getTransDateFromPointsHistoryList(String tranType){
        switch (tranType){
            case "ACE":
                return card.extractFromContentDesc("Date - ACE", PointsHistoryLocators.PH_ITEM_ACE_AWD_DATE, ",", 1);

            default:
                throw new IllegalArgumentException("Unknown transaction type: " + tranType);
        }
    }


    public String getPointsValFromPointsHistoryList(String transactionType){
            switch (transactionType){
                case "awd-ACE":
                    return card.extractFromContentDesc("PH - + Point value", PointsHistoryLocators.PH_ITEM_ACE_AWD_PTS, ",", 1);
                case "awd-LYBC":
                    return card.extractFromContentDesc("PH - Points - LYBC", PointsHistoryLocators.PH_ITEM_LYBC_AWD_PTS, ",", 1);
                case "awd-TK":
                    return card.extractFromContentDesc("PH - Points - TK", PointsHistoryLocators.PH_ITEM_TK_AWD_PTS, ",", 1);
                case "awd-MOM":
                    return card.extractFromContentDesc("PH - Points - MOM", PointsHistoryLocators.PH_ITEM_MOM_AWD_PTS, ",", 1);
                case "red-ACE":
                    return card.extractFromContentDesc("PH - Points - ACE - Red", PointsHistoryLocators.PH_ITEM_ACE_RED_PTS, ",", 1);
                case "red-LYBC":
                    return card.extractFromContentDesc("PH - Points - LYBC - Red", PointsHistoryLocators.PH_ITEM_LYBC_RED_PTS, ",", 1);
                case "red-TK":
                    return card.extractFromContentDesc("PH - Points - TK - Red", PointsHistoryLocators.PH_ITEM_TK_RED_PTS, ",", 1);
                case "red-MOM":
                    return card.extractFromContentDesc("PH - Points - MOM - Red", PointsHistoryLocators.PH_ITEM_MOM_RED_PTS, ",", 1);

                default:
                    throw new IllegalArgumentException("Unknown transaction type: " + transactionType);
            }
    }


    public Boolean isValuePositive(String transactionType){
        String pts = getPointsValFromPointsHistoryList(transactionType);

        if (pts.startsWith("+")) {
            return true;
        } else {
            return false;
        }
    }

    public void scrollDown_PH(){
        scrollHelper.swipeUp();
    }
}