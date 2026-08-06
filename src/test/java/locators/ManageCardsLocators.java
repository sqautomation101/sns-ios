package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class ManageCardsLocators {

    private ManageCardsLocators() {}

    //LOCATORS
    public static final By MC_BACK_BTN = AppiumBy.accessibilityId("app_bar_back_button");
    public static final By MC_TRANSFER_PTS = AppiumBy.accessibilityId("manage_cards_transfer_points_button");
    public static final By MC_BLOCK_CARD = AppiumBy.xpath("//*[contains(@content-desc, 'manage_cards_block_card_button')]");
    public static final By MC_SHOW_CARD = AppiumBy.accessibilityId("manage_cards_show_cards_button");
    public static final By MC_LINK_CARD_BTN = AppiumBy.accessibilityId("manage_cards_linked_add_card_button");
    public static final By MC_LINK_CARD_BTN_EMPTY = AppiumBy.accessibilityId("manage_cards_empty_link_card_button");
    public static final By MC_LINKED_CARD_COUNTER = AppiumBy.xpath("//*[contains(@content-desc,'manage_cards_linked_count')]");
    public static final By MC_INFO_ICON = AppiumBy.accessibilityId("manage_cards_info_tooltip");

    //Main card
    public static final By MC_MAIN_CONTAINER_SHOW_CARD =  AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View");

    public static final By MC_SHOWCARD_QR_TAB =  AppiumBy.accessibilityId("dynamic_qr_tab_qr_code");
    public static final By MC_SHOWCARD_BC_TAB =  AppiumBy.accessibilityId("dynamic_qr_tab_barcode");

    public static final By MC_SHOWCARD_TIER_LOGO_QRBC_START = AppiumBy.accessibilityId("dynamic_qr_card_image_SMAC Start");
    public static final By MC_SHOWCARD_BRAND_QRBC_START = AppiumBy.accessibilityId("dynamic_qr_card_brand_SMAC Start");
    public static final By MC_SHOWCARD_TIER_LOGO_QRBC_SMAC = AppiumBy.accessibilityId("dynamic_qr_card_image_SMAC");
    public static final By MC_SHOWCARD_BRAND_QRBC_SMAC = AppiumBy.accessibilityId("dynamic_qr_card_brand_SMAC");
    public static final By MC_SHOWCARD_TIER_LOGO_QRBC_PRESTIGE = AppiumBy.accessibilityId("dynamic_qr_card_image_SMAC Prestige");
    public static final By MC_SHOWCARD_BRAND_QRBC_PRESTIGE = AppiumBy.accessibilityId("dynamic_qr_card_brand_SMAC Prestige");
    public static final By MC_SHOWCARD_DYNAMIC_QR =  AppiumBy.accessibilityId("dynamic_qr_code");
    public static final By MC_SHOWCARD_DYNAMIC_BC =  AppiumBy.accessibilityId("dynamic_barcode");
    public static final By MC_SHOWCARD_QRBC_DATETIME =  AppiumBy.accessibilityId("dynamic_qr_timestamp");
    public static final By MC_SHOWCARD_QRBC_CN =   AppiumBy.xpath("//*[contains(@content-desc,'dynamic_card_number')]");

    //Points transfer page
    public static final By MC_PT_HDR = AppiumBy.accessibilityId("points_transfer_title");
    public static final By MC_PT_BACK = AppiumBy.accessibilityId("points_transfer_back_button");
    public static final By MC_PT_RECIPIENT_HDR = AppiumBy.accessibilityId("points_transfer_user_name");
    public static final By MC_PT_SMAC_NUM_BTN = AppiumBy.accessibilityId("points_transfer_smac_number_button");
    public static final By MC_PT_FAVE = AppiumBy.accessibilityId("points_transfer_favorites_button");
    public static final By MC_PT_DONE = AppiumBy.accessibilityId("points_transfer_done_button");

    //Card container for Card carousel
    public static final By MC_CARD_CONTAINER = AppiumBy.xpath("//*[contains(@content-desc,'manage_cards_smac_card')]");
    public static final By MC_SCRIM = AppiumBy.accessibilityId("Scrim");

    //CARD CONTENTS
    public static final By MC_CARD_LOGO = AppiumBy.xpath("//*[contains(@content-desc,'manage_cards_card_logo_image')]");
    public static final By MC_CARD_DISPLAY_NAME = AppiumBy.xpath("//*[contains(@content-desc, 'manage_cards_display_name')]");
    public static final By MC_CARD_VIRTUAL_NUM = AppiumBy.xpath("//*[contains(@content-desc, 'manage_cards_virtual_card_number')]");
    public static final By MC_CARD_TYPE = AppiumBy.xpath("//*[contains(@content-desc, 'manage_cards_card_type')]");
    public static final By MC_MAIN_CARD_NUMBER = AppiumBy.xpath("//*[contains(@content-desc, 'manage_cards_card_number')]");
    public static final By MC_CARD_MEMBER_SINCE = AppiumBy.xpath("//*[contains(@content-desc, 'manage_cards_member_since')]");
    public static final By MC_CARD_BADGE = AppiumBy.xpath("//*[contains(@content-desc, 'manage_cards_expiry_badge')]");
    public static final By MC_CLAIM_PRESTIGE_BTN = AppiumBy.accessibilityId("manage_cards_claim_prestige_button");

    //PRESTIGE UNLOCKED MODAL
    public static final By MC_PRESTIGE_UNLOCK_BACK = AppiumBy.accessibilityId("manage_cards_prestige_popup_close_button");
    public static final By MC_PRESTIGE_UNLOCK_IMG =  AppiumBy.accessibilityId("manage_cards_prestige_popup_image");
    public static final By MC_PRESTIGE_UNLOCK_HDR =  AppiumBy.accessibilityId("manage_cards_prestige_popup_title");
    public static final By MC_PRESTIGE_UNLOCK_DESC =   AppiumBy.accessibilityId("manage_cards_prestige_popup_description");

    // MOM registration banner (the "mom container" shown on this page when
    // an SNS-linked physical card hasn't completed the MOM questionnaire
    // yet — see shouldShowMomContainer in manage_card_page.dart). The
    // Continue button itself is CardLinkingLocators.MOM_CONTINUE_BTN
    // (manage_cards_mom_registration_button) — reused here rather than
    // duplicated, since CardLinkingPage.clickMOMContinueButton() already
    // drives it.
    public static final By MC_MOM_BANNER_TEXT = AppiumBy.accessibilityId("Ready to continue your Mom Card registration? Complete the form now and receive exclusive vouchers!");
}