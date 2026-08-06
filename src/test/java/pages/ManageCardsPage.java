package pages;

import hooks.Hooks;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

//import packages
import base.*;
import locators.ManageCardsLocators;

import java.util.List;

public class ManageCardsPage extends BasePage {

    // for locator timeout
    public static int timeout = 15;
    private final CardComponent card = Hooks.getPageManager().getCardComponent();

    //CONSTRUCTOR
    public ManageCardsPage(AppiumDriver driver) {
        super(driver); // initializes driver + helpers + PageFactory
    }


    public boolean isManageCardPageVisible_General(){
        waitUniqueElement(ManageCardsLocators.MC_BLOCK_CARD, 60);

        boolean manageCardBack = isElementVisible("Manage card - Back", ManageCardsLocators.MC_BACK_BTN, timeout);
        logStatus("Manage Card - Back", manageCardBack);

        boolean blockCardBtn = isElementVisible("Block card", ManageCardsLocators.MC_BLOCK_CARD, timeout);
        logStatus("Manage Card - Block card", blockCardBtn);

        boolean transferPointsBtn = isElementVisible("Transfer points", ManageCardsLocators.MC_TRANSFER_PTS, timeout);
        logStatus("Manage Card - Transfer points", transferPointsBtn);

        boolean showCardBtn = isElementVisible("Show card", ManageCardsLocators.MC_SHOW_CARD, timeout);
        logStatus("Manage Card - Show card", showCardBtn);

        boolean linkCardBtn_Linked = isElementVisible("Link card", ManageCardsLocators.MC_LINK_CARD_BTN, 10);
        logStatus("Manage Card - Link card button", linkCardBtn_Linked);

        boolean linkCardBtn_NotLinked = isElementVisible("Link card (NL)", ManageCardsLocators.MC_LINK_CARD_BTN_EMPTY, 10);
        logStatus("Manage Card - Link card (NL)", linkCardBtn_NotLinked);

        return manageCardBack && blockCardBtn && transferPointsBtn && showCardBtn && (linkCardBtn_Linked || linkCardBtn_NotLinked);
    }


    public boolean isPtsTransferVisible_General(){
        waitUniqueElement(ManageCardsLocators.MC_PT_FAVE, 10);

        boolean transfer_Back = isElementVisible("Transfer back", ManageCardsLocators.MC_PT_BACK, 5);
        logStatus("Points Transfer - back", transfer_Back);

        boolean transfer_hdr = isElementVisible("Points transfer - Header", ManageCardsLocators.MC_PT_HDR, 5);
        logStatus("Points Transfer - Header", transfer_hdr);

        boolean transfer_RecipientHdr = isElementVisible("Points transfer - Transfer recipient hdr", ManageCardsLocators.MC_PT_RECIPIENT_HDR, 5);
        logStatus("Points Transfer - Transfer recipient", transfer_RecipientHdr);

        boolean smacNumber = isElementVisible("Points transfer - SMAC Number", ManageCardsLocators.MC_PT_SMAC_NUM_BTN, 5);
        logStatus("Points transfer - SMAC Number", smacNumber);

        boolean fave = isElementVisible("Points transfer - Favorites", ManageCardsLocators.MC_PT_FAVE, 5);
        logStatus("Points transfer - Favorites", fave);

        boolean done = isElementVisible("Points Transfer - Done", ManageCardsLocators.MC_PT_DONE, 5);
        logStatus("Points transfer - Done", done);

        return transfer_Back && transfer_hdr && transfer_RecipientHdr && smacNumber && fave && done;
    }


    public void clickManageCardBackButton(){
        tap("Manage card - Back", ManageCardsLocators.MC_BACK_BTN, timeout);
    }


    public void clickTransferPtsButton(){
        tap("Manage card - Transfer Pts", ManageCardsLocators.MC_TRANSFER_PTS, timeout);
    }


    public void clickLinkCardBtn(){
        if(isElementVisible("Manage Card - Link Card - NL", ManageCardsLocators.MC_LINK_CARD_BTN_EMPTY, timeout)){
            tap("Manage card - Link Card", ManageCardsLocators.MC_LINK_CARD_BTN_EMPTY, timeout);
            System.out.println("Clicked: Manage Card - Link Card - NL");
        }else {
            tap("Manage card - Link Card", ManageCardsLocators.MC_LINK_CARD_BTN, timeout);
        }
    }


    public void clickBlockCardBtn(){
        tap("Manage card - Block Card", ManageCardsLocators.MC_BLOCK_CARD, timeout);
    }


    public boolean isBlockCardEnabled(){
        return isElementEnabled("Block card", ManageCardsLocators.MC_BLOCK_CARD);
    }


    public boolean isShowCardEnabled(){
        return isElementEnabled("Show card", ManageCardsLocators.MC_SHOW_CARD);
    }


    public void clickShowCard(){
        waitUniqueElement(ManageCardsLocators.MC_SHOW_CARD, timeout);
        tap("Manage card - Show card", ManageCardsLocators.MC_SHOW_CARD, timeout);
    }


    public void clickShowCard_Barcode(){
        tap("Show card - Barcode", ManageCardsLocators.MC_SHOWCARD_BC_TAB, timeout);
    }


    public boolean isShowCard_QR_Visible(){
        boolean qr = isElementVisible("Show card - QR code", ManageCardsLocators.MC_SHOWCARD_DYNAMIC_QR, 30);
        logStatus("Show card - QR code", qr);

        boolean cn = isElementVisible("Show card - Card number", ManageCardsLocators.MC_SHOWCARD_QRBC_CN, 10);
        logStatus("Show card - Card number", cn);

        boolean dateTime = isElementVisible("Show card - Datetime", ManageCardsLocators.MC_SHOWCARD_QRBC_DATETIME, 10);
        logStatus("Show card - Datetime", dateTime);

        boolean qrtab = isElementVisible("Show card - QR Tab", ManageCardsLocators.MC_SHOWCARD_QR_TAB, timeout);
        logStatus("Show card - QR tab", qrtab);

        boolean barcodetab = isElementVisible("Show card - Barcode tab", ManageCardsLocators.MC_SHOWCARD_BC_TAB, timeout);
        logStatus("Show card - Barcode tab", barcodetab);

        return cn && dateTime && qrtab && barcodetab && qr;
    }


    public boolean isShowCard_BC_Visible(){
        boolean qrtab = isElementVisible("Show card - QR Tab", ManageCardsLocators.MC_SHOWCARD_QR_TAB, 10);
        logStatus("Show card - QR_tab", qrtab);

        boolean barcodetab = isElementVisible("Show card - Barcode tab", ManageCardsLocators.MC_SHOWCARD_BC_TAB, 10);
        logStatus("Show card - Barcode tab", barcodetab);

        boolean barcode = isElementVisible("Show card - Barcode", ManageCardsLocators.MC_SHOWCARD_DYNAMIC_BC, 10);
        logStatus("Show card - Barcode - Barcode tab", barcode);

        boolean bc_datetime = isElementVisible("Show card - Datetime", ManageCardsLocators.MC_SHOWCARD_QRBC_DATETIME, 10);
        logStatus("Show card - Barcode - Datetime", bc_datetime);

        return barcode && bc_datetime && qrtab && barcodetab ;
    }


    public String verifyBlockButtonChangedPlaceholder(){
        return card.extractFromContentDesc("Block card" +
                "", ManageCardsLocators.MC_BLOCK_CARD, ",", 1);
    }


    public String verifyTier_QRBC(){
        return card.verifyTier(ManageCardsLocators.MC_SHOWCARD_QRBC_CN, ",", "-");
    }


    public String verifyIfCardVirtual_QRBC(){
        return card.verifyStatus(ManageCardsLocators.MC_SHOWCARD_QRBC_CN, ",", "-");
    }


    public boolean showCard_verifyContentPerTier_QR() throws InterruptedException {
        Thread.sleep(1000);
        String currentTier = verifyTier_QRBC();
        System.out.println("Highest tier: " + currentTier);

        switch (currentTier) {
            case "SMAC Start":
                return isElementVisible("Show card - Start - QR - Logo", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_START, timeout) &&
                        isElementVisible("Show card - Start - QR - Brand", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_START, timeout) &&
                        isShowCard_QR_Visible();
            case "SMAC Blue":
                return isElementVisible("Show card - SMAC - QR - Logo", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_SMAC, timeout) &&
                        isElementVisible("Show card - SMAC - QR - Brand", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_SMAC, timeout) &&
                        isShowCard_QR_Visible();
            case "SMAC Prestige":
                return isElementVisible("Show card - Prestige - QR - Logo", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_PRESTIGE, timeout) &&
                        isElementVisible("Show card - Prestige - QR - Brand", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_PRESTIGE, timeout) &&
                        isShowCard_QR_Visible();
            default:
                return false;
        }
    }


    public boolean showCard_verifyContentPerTier_BC(String currentTier){
        switch (currentTier) {
            case "SMAC Start":
                return isElementVisible("Show card - Start - QR - Logo", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_START, timeout) &&
                        isElementVisible("Show card - Start - QR - Brand", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_START, timeout) &&
                        isShowCard_BC_Visible();
            case "SMAC Blue":
                return isElementVisible("Show card - SMAC - QR - Logo", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_SMAC, timeout) &&
                        isElementVisible("Show card - SMAC - QR - Brand", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_SMAC, timeout) &&
                        isShowCard_BC_Visible();
            case "SMAC Prestige":
                return isElementVisible("Show card - Prestige - QR - Logo", ManageCardsLocators.MC_SHOWCARD_TIER_LOGO_QRBC_PRESTIGE, timeout) &&
                        isElementVisible("Show card - Prestige - QR - Brand", ManageCardsLocators.MC_SHOWCARD_BRAND_QRBC_PRESTIGE, timeout) &&
                        isShowCard_BC_Visible();
            default:
                return false;
        }
    }


    public boolean isShowCard_QR_selected(){
        String isSelected_St = isElementSelected("QR Tab - Active", ManageCardsLocators.MC_SHOWCARD_QR_TAB, timeout);
        return Boolean.parseBoolean(isSelected_St);
    }


    public boolean isShowCard_Barcode_selected(){
        String isSelected_St = isElementSelected("Bar Tab - Active", ManageCardsLocators.MC_SHOWCARD_BC_TAB, timeout);
        return Boolean.parseBoolean(isSelected_St);
    }


    public boolean linkedCardCount() throws InterruptedException {
        Integer cardCount = scrollHelper.countAllCards(ManageCardsLocators.MC_CARD_CONTAINER, 9); //PREV 4

        String extractCardCount = card.extractFromContentDesc("Linked card counter", ManageCardsLocators.MC_LINKED_CARD_COUNTER, ",", 1);

        Integer cardCountFromCounter = Integer.parseInt(extractCardCount.split(" ")[0].trim());

        System.out.println("Card count: " + cardCount + "\nCard count from counter: " + cardCountFromCounter + "\n");

        if (cardCount.equals(cardCountFromCounter)) {
            System.out.println("[T] Card count matches with the counter.");
            return true;
        }else{
            System.out.println("[F] Card count DOES NOT matches with the counter.");
            return false;
        }
    }


    public String cleanCardNumber(String delimiterCN){
        return card.cleanCardNumber("Card number main", ManageCardsLocators.MC_MAIN_CARD_NUMBER, delimiterCN);
    }


    public String cleanCardNumber_ShowCard_QR(){
        return card.cleanCardNumber("QRBC Card number", ManageCardsLocators.MC_SHOWCARD_QRBC_CN, "-");
    }


    public String extractMC_CN(){
        return card.extractAndNormaliseCardNumber_(ManageCardsLocators.MC_MAIN_CARD_NUMBER);
    }


    public boolean isClaimPrestigeOverlayDisplayed() {
        return isElementVisible("Claim prestige button", ManageCardsLocators.MC_CLAIM_PRESTIGE_BTN, 5);
    }


    public void clickClaimPrestige(){
        tap("Claim prestige button", ManageCardsLocators.MC_CLAIM_PRESTIGE_BTN, timeout);
    }


    public boolean isClaimPrestigeModalVisible() {
        waitUniqueElement(ManageCardsLocators.MC_PRESTIGE_UNLOCK_BACK, timeout);

        boolean prestige_unlock_back = isElementVisible("Prestige unlocked - Back", ManageCardsLocators.MC_PRESTIGE_UNLOCK_BACK, timeout);
        logStatus("Prestige unlocked - Back", prestige_unlock_back);

        boolean prestige_unlock_img = isElementVisible("Prestige unlocked - Image", ManageCardsLocators.MC_PRESTIGE_UNLOCK_IMG, timeout);
        logStatus("Prestige unlocked - Image", prestige_unlock_img);

        boolean prestige_unlock_hdr = isElementVisible("Prestige unlocked - Hdr", ManageCardsLocators.MC_PRESTIGE_UNLOCK_HDR, timeout);
        logStatus("Prestige unlocked - Back", prestige_unlock_hdr);

        boolean prestige_unlock_desc = isElementVisible("Prestige unlocked - Desc", ManageCardsLocators.MC_PRESTIGE_UNLOCK_DESC, timeout);
        logStatus("Prestige unlocked - Back", prestige_unlock_desc);

        return prestige_unlock_back && prestige_unlock_img && prestige_unlock_hdr && prestige_unlock_desc;

    }


    public void clickPrestigeUnlock_Back(){
        tap("Prestige unlocked - Back", ManageCardsLocators.MC_PRESTIGE_UNLOCK_BACK, timeout);
    }


    public void swipeUntilCardVisible(String cardNumber){
        scrollHelper.swipeUntilCardNumberVisible(ManageCardsLocators.MC_CARD_CONTAINER, cardNumber, 100);
    }

//    public void swipeUntilCardLogoVisible(String cardType){
//        scrollHelper.swipeLeftUntilCardLogoVisible(ManageCardsLocators.MC_CARD_CONTAINER, cardType, 100);
//    }


    public void scrollDown(){
        WebElement startPoint = driver.findElement(ManageCardsLocators.MC_MAIN_CONTAINER_SHOW_CARD);

        scrollHelper.swipeDownToDismissModal(startPoint);

    }


    public boolean isCardExpired(){
        return isElementVisible("Expired badge", ManageCardsLocators.MC_CARD_BADGE, timeout);
    }


    public int countVisibleCards() {

        WebElement carousel = driver.findElement(ManageCardsLocators.MC_CARD_CONTAINER);

        List<WebElement> cards = carousel.findElements(AppiumBy.className("android.view.View"));
        Integer countCards = cards.size();
        System.out.println("Card count is " + countCards);
        return countCards;
    }

    public void clickOutsideTheModal() {
        tap("Overlay", ManageCardsLocators.MC_SCRIM, timeout);
    }


    public void clickInfoIcon() {
        tap("Info", ManageCardsLocators.MC_INFO_ICON, timeout);
    }


    public boolean isCardContentVisible(){
        waitUniqueElement(ManageCardsLocators.MC_CARD_DISPLAY_NAME, 60);

        boolean displayName = isElementVisible("Display name", ManageCardsLocators.MC_CARD_DISPLAY_NAME, timeout);
        logStatus("Display name", displayName);

        boolean cardLogo = isElementVisible("Card logo", ManageCardsLocators.MC_CARD_LOGO, timeout);
        logStatus("Card logo", cardLogo);

        boolean virtualCN = isElementVisible("Virtual Card Number", ManageCardsLocators.MC_CARD_VIRTUAL_NUM, timeout);
        logStatus("Virtual Card Number", virtualCN);

        boolean cardType = isElementVisible("Card type", ManageCardsLocators.MC_CARD_TYPE, timeout);
        logStatus("Card type", cardType);

        boolean physicalCard = isElementVisible("Physical Card Number", ManageCardsLocators.MC_MAIN_CARD_NUMBER, timeout);
        logStatus("Physical Card Number", physicalCard);

        return displayName && cardLogo && virtualCN && cardType && physicalCard;
    }

    public String getCardTypeImage(){
        return card.extractFromContentDesc("Card type - Image", ManageCardsLocators.MC_CARD_LOGO, ",", 1);
    }

    public String getCardType(){
        return card.extractFromContentDesc("Card type", ManageCardsLocators.MC_CARD_TYPE, ",", 1);
    }

    public String getActualNameOnCard(){
        return card.extractFromContentDesc("Name on card", ManageCardsLocators.MC_CARD_DISPLAY_NAME, ",", 1);
    }
}