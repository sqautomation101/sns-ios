package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class CardBlockingLocators {

    private CardBlockingLocators() {}

    //Block card page
    public static final By BLOCK_HDR = AppiumBy.accessibilityId("block_card_title");
    public static final By BLOCK_BACK_BTN = AppiumBy.accessibilityId("block_card_back_button");
    public static final By BLOCK_IMG_TIER = AppiumBy.xpath("//*[contains(@content-desc,'block_card_image')]");
    public static final By BLOCK_CARD_NUMBER = AppiumBy.xpath("//*[contains(@content-desc,'block_card_number')]");
    public static final By blockCardInfoText = AppiumBy.accessibilityId("block_card_info_text");
    public static final By BLOCK_REPLACEMENT_TXT = AppiumBy.accessibilityId("block_card_replacement_text");
    public static final By BLOCK_BTN = AppiumBy.accessibilityId("block_card_button");

    public static final By BLOCK_SUCCESS_BACK_BUTTON = AppiumBy.accessibilityId("block_card_success_back_button");
    public static final By BLOCK_SUCCESS_HDR = AppiumBy.accessibilityId("block_card_success_title, Block Card");
    public static final By BLOCK_SUCCESS_ICON = AppiumBy.accessibilityId("block_card_success_image");
    public static final By BLOCK_SUCCESS_CARD_NUMBER = AppiumBy.xpath("//*[contains(@content-desc, 'block_card_success_card_number')]");
    public static final By BLOCK_SUCCESS_CARD_TYPE = AppiumBy.xpath("//*[contains(@content-desc, 'block_card_success_card_type')]");
    public static final By BLOCK_SUCCESS_BACK_TO_LOYALTY = AppiumBy.accessibilityId("block_card_success_back_to_loyalty_button");


}