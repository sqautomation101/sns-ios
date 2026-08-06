package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class HomepageLocators {

    private HomepageLocators() {}

    //Main card locators
    public static final By CARDPOINTS_AND = AppiumBy.xpath("//*[contains(@content-desc, 'home_points_balance_')]");
    public static final By CARDPOINTS_IOS = AppiumBy.accessibilityId("home_points_balance");
    public static final By CARDNUMBER_AND = AppiumBy.xpath("//*[contains(@content-desc, 'home_card_number_text_')]");
    public static final By CARDNUMBER_IOS = AppiumBy.accessibilityId("home_card_number_text");
    public static final By RTP_MAINTAIN = AppiumBy.accessibilityId("Maintain Prestige");
    public static final By RTP_ORIGINAL = AppiumBy.accessibilityId("Road to Prestige");
    public static final By MANAGECARDSWIDGET = AppiumBy.accessibilityId("home_manage_cards_button");
    public static final By PTSHISTORYWIDGET = AppiumBy.accessibilityId("home_points_history_button");
    public static final By PLAYWIDGET = AppiumBy.accessibilityId("home_play_button");
    public static final By LINKCARDWIDGET = AppiumBy.accessibilityId("home_link_cards_button");

    // SMAC TIER LOGO
    public static final By CARD_STARTLOGO = AppiumBy.accessibilityId("home_smac_card_image_Start");
    public static final By CARD_SMACLOGO = AppiumBy.accessibilityId("home_smac_card_image_SMAC");
    public static final By CARD_PRESTIGELOGO = AppiumBy.accessibilityId("home_smac_card_image_Prestige");

    public static final By GOSHOPPING_HDR = AppiumBy.accessibilityId("SHOP");
    public static final By SEARCH_BTN = AppiumBy.accessibilityId("home_search_button");
    public static final By SHOP_UNIV_SEARCH_BACK = AppiumBy.accessibilityId("Back");


    /*** Locators for bottom navigation ***/
    public static final By BOTNAV_HOME = AppiumBy.accessibilityId("bottom_nav_home_button");
    public static final By BOTNAV_VOUCHERS = AppiumBy.accessibilityId("bottom_nav_vouchers_button");
    public static final By BOTNAV_QR_START = AppiumBy.accessibilityId("bottom_nav_qr_card_smac_start");
    public static final By BOTNAV_QR_SMAC = AppiumBy.accessibilityId("bottom_nav_qr_card_smac_smac");
    public static final By BOTNAV_QR_PRESTIGE = AppiumBy.accessibilityId("bottom_nav_qr_card_smac_prestige");
    public static final By BOTNAV_ACCT = AppiumBy.accessibilityId("bottom_nav_account_button");
    public static final By BOTNAV_INBOX = AppiumBy.accessibilityId("bottom_nav_inbox_button");


    public static final By PRISMIC = AppiumBy.androidUIAutomator(
            "new UiSelector()" +
                    ".className(\"android.widget.ImageView\")" +
                    ".instance(8)"
    );

    //Referal section TO BE REMOVED
    public static final By refer_hdr =  AppiumBy.accessibilityId("refer_friends_card_title");
    public static final  By refer_desc =   AppiumBy.accessibilityId("refer_friends_card_subtitle");
    public static final By refer_copy =  AppiumBy.xpath("//*[@resource-id = 'refer_friends_card_code_button']");
    public static final By refer_share =  AppiumBy.accessibilityId("refer_friends_card_share_button");
}