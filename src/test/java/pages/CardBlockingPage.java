package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import locators.CardBlockingLocators;

public class CardBlockingPage extends BasePage {

    public static int timeout = 5;

    // Constructor
    public CardBlockingPage(AppiumDriver driver) {
        super(driver);
    }


    public boolean isBlockCardPageVisible(){
        waitUniqueElement(CardBlockingLocators.blockCardInfoText, 10);

        boolean backButton = isElementVisible("Block card - Back", CardBlockingLocators.BLOCK_BACK_BTN, 5);
        logStatus("Card Block - Back", backButton);
        boolean blockHeader = isElementVisible("Block card - Header", CardBlockingLocators.BLOCK_HDR, 5);
        logStatus("Block Card - Header", blockHeader);
        boolean tierLogo = isElementVisible("Block Card - Tier image", CardBlockingLocators.BLOCK_IMG_TIER, 5);
        logStatus("Block Card - Tier image", tierLogo);
        boolean infoText = isElementVisible("Block Card - Info text", CardBlockingLocators.blockCardInfoText, 5);
        logStatus("Block Card - Info text", infoText);

        boolean replacementText = isElementVisible("Block Card - Replacement text", CardBlockingLocators.BLOCK_REPLACEMENT_TXT, 5);
        logStatus("Block Card - Replacement text", replacementText);

        boolean blockCard = isElementVisible("Block Card - Block card btn", CardBlockingLocators.BLOCK_BTN, 5);
        logStatus("Block Card - Block card btn", blockCard);

        boolean cardNumber = isElementVisible("Block card - Card number", CardBlockingLocators.BLOCK_CARD_NUMBER, 5);
        logStatus("Block Card - Card number", cardNumber);

        return backButton & blockHeader & tierLogo & infoText & replacementText & blockCard & cardNumber;


    }


    public boolean isBlockTierImageVisible(String code){
        waitUniqueElement(CardBlockingLocators.BLOCK_IMG_TIER, 10);

        String tierImgText = getContentDesc(CardBlockingLocators.BLOCK_IMG_TIER);

        String extractedProductCode= tierImgText.split("_")[3];

        System.out.println("Product code: " + extractedProductCode);

        if(code.equals(extractedProductCode)){
            return true;
        } else {
            return false;
        }
    }


    public void clickBlockBtn(){
        tap("Block - Block Btn", CardBlockingLocators.BLOCK_BTN, 10);
    }

    public boolean isCardBlockingSuccessPageVisible(){
        waitUniqueElement(CardBlockingLocators.BLOCK_SUCCESS_BACK_TO_LOYALTY, 30);

        boolean blockSuccess_backToLoyalty = isElementVisible("Block success - Back to loyalty", CardBlockingLocators.BLOCK_SUCCESS_BACK_TO_LOYALTY, 10);
        logStatus("Block success - Back to loyalty", blockSuccess_backToLoyalty);

        boolean blockSuccess_back = isElementVisible("Block success - Back btn", CardBlockingLocators.BLOCK_SUCCESS_BACK_BUTTON, 10);
        logStatus("Block success - Back btn", blockSuccess_back);

        boolean blockSuccess_hdr = isElementVisible("Block success - hdr", CardBlockingLocators.BLOCK_SUCCESS_HDR, 10);
        logStatus("Block success - hdr", blockSuccess_hdr);

        boolean blockSuccess_icon = isElementVisible("Block success - Icon", CardBlockingLocators.BLOCK_SUCCESS_ICON, 10);
        logStatus("Block success - Icon", blockSuccess_backToLoyalty);

        boolean blockSuccess_CN = isElementVisible("Block success - Card number", CardBlockingLocators.BLOCK_SUCCESS_CARD_NUMBER, 10);
        logStatus("Block success - Back to loyalty", blockSuccess_CN);

//        boolean blockSuccess_CardType = isElementVisible("Block success - Card type", CardBlockingLocators.BLOCK_SUCCESS_CARD_TYPE, 10);
//        logStatus("Block success - Card type", blockSuccess_CardType);

        return blockSuccess_hdr & blockSuccess_back & blockSuccess_icon /*& blockSuccess_CardType*/ & blockSuccess_CN & blockSuccess_backToLoyalty;
    }


    public void clickBackToLoyaltyBtn(){
        tap("Block success - Back to loyalty", CardBlockingLocators.BLOCK_SUCCESS_BACK_TO_LOYALTY, 10);
    }


    public String getBlock_CardNumber(){
        waitUniqueElement(CardBlockingLocators.BLOCK_CARD_NUMBER, 10);
        return getContentDesc(CardBlockingLocators.BLOCK_CARD_NUMBER);
    }


    public String getBlockSuccess_CardType(){
        waitUniqueElement(CardBlockingLocators.BLOCK_SUCCESS_CARD_TYPE, 10);
        return getContentDesc(CardBlockingLocators.BLOCK_SUCCESS_CARD_TYPE);

    }
}
