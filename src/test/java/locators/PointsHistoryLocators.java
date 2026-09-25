package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class PointsHistoryLocators {

    private PointsHistoryLocators() {}

    //LOCATORS

    /*** Points History Page ***/
    public static final By PH_BACK = AppiumBy.accessibilityId("points_history_back_button");
    public static final By PH_HDR = AppiumBy.accessibilityId("points_history_title");
    public static final By PH_BANNER = AppiumBy.accessibilityId("points_history_memo_text");
    public static final By PH_ITEM_PTS_TRANS_AS_SENDER = AppiumBy.accessibilityId("points_history_item_adj_title, Points Transfer (Sender)");
    public static final By PH_ITEM_PTS_TRANS_AS_RECEIVER = AppiumBy.accessibilityId("points_history_item_adj_title, Points Transfer (Recipient)");
//    public static final By ptsHistoryContainer = AppiumBy.androidUIAutomator(
//            "new UiSelector()" +
//                    ".className(\"android.view.View\")" +
//                    ".instance(10)"
//    );

    //LYBC_awd
    public static final By PH_ITEM_AWD_LYBC_TITLE = AppiumBy.accessibilityId("points_history_item_awd_title, THE BODY SHOP: Marquee Mall");
    public static final By PH_ITEM_LYBC_AWD_DATE = AppiumBy.accessibilityId("points_history_item_awd_date, Aug 1, 2026 - 10:17 AM");
    public static final By PH_ITEM_LYBC_AWD_PTS = AppiumBy.accessibilityId("points_history_item_awd_points, +50 Pts");

    //Awarding index 5 .. ACE_awd
    public static final By PH_ITEM_AWD_TITLE = AppiumBy.accessibilityId("points_history_item_awd_title, ACE HARDWARE: City Mall Tarlac");
    public static final By PH_ITEM_ACE_AWD_DATE = AppiumBy.accessibilityId("points_history_item_awd_date, Aug 10, 2026 - 4:16 PM");
    public static final By PH_ITEM_ACE_AWD_PTS = AppiumBy.accessibilityId("points_history_item_awd_points, +50 Pts");

    //Awarding index 8 ... TK_awd
    public static final By PH_ITEM_AWD_TK_TITLE = AppiumBy.accessibilityId("points_history_item_awd_title, DS: Batangas 123");
    public static final By PH_ITEM_TK_AWD_DATE = AppiumBy.accessibilityId("points_history_item_awd_date, Aug 1, 2026 - 10:29 AM");
    public static final By PH_ITEM_TK_AWD_PTS = AppiumBy.accessibilityId("points_history_item_awd_points, +51 Pts");

    //Awarding index  ... MOM_awd
    public static final By PH_ITEM_AWD_MOM_TITLE = AppiumBy.accessibilityId("points_history_item_awd_title, BABY COMPANY: SM Fairview");
    public static final By PH_ITEM_MOM_AWD_DATE = AppiumBy.accessibilityId("points_history_item_awd_date, Jul 31, 2026 - 1:53 PM");
    public static final By PH_ITEM_MOM_AWD_PTS = AppiumBy.accessibilityId("points_history_item_awd_points, +200 Pts");

    //Redemption index  ... ACE_red
    public static final By PH_ITEM_RED_TITLE = AppiumBy.accessibilityId("points_history_item_red_title, ACE HARDWARE: SM Baguio");
    public static final By PH_ITEM_ACE_RED_DATE = AppiumBy.accessibilityId("points_history_item_red_date, Aug 10, 2026 - 4:12 PM");
    public static final By PH_ITEM_ACE_RED_PTS = AppiumBy.accessibilityId("points_history_item_red_points, -150 Pts");

    //Redemption index 4 ... LYBC_red
    public static final By PH_ITEM_RED_LYBC_TITLE = AppiumBy.accessibilityId("points_history_item_red_title, THE BODY SHOP: Rockwell");
    public static final By PH_ITEM_LYBC_RED_DATE = AppiumBy.accessibilityId("points_history_item_red_date, Aug 10, 2026 - 5:06 PM");
    public static final By PH_ITEM_LYBC_RED_PTS = AppiumBy.accessibilityId("points_history_item_red_points, -50 Pts");

    //Redemption index  ... TK_red
    public static final By PH_ITEM_RED_TK_TITLE = AppiumBy.accessibilityId("points_history_item_red_title, DS: Batangas 123");
    public static final By PH_ITEM_TK_RED_DATE = AppiumBy.accessibilityId("points_history_item_red_date, Aug 10, 2026 - 5:13 PM");
    public static final By PH_ITEM_TK_RED_PTS = AppiumBy.accessibilityId("points_history_item_red_points, -50 Pts");

    //Redemption index  ... MOM_red
    public static final By PH_ITEM_RED_MOM_TITLE = AppiumBy.accessibilityId("points_history_item_red_title, BABY COMPANY: Head Office");
    public static final By PH_ITEM_MOM_RED_DATE = AppiumBy.accessibilityId("points_history_item_red_date, Aug 9, 2026 - 5:26 PM");
    public static final By PH_ITEM_MOM_RED_PTS = AppiumBy.accessibilityId("points_history_item_red_points, -50 Pts");

    //BDOR to SMAC
    public static final By PH_ITEM_BDORTOSMAC_TITLE = AppiumBy.accessibilityId("points_history_item_awd_title, Points converted: BDO");
//    public static final By BDORtoSMACDate = AppiumBy.accessibilityId("points_history_item_awd_4_date, Sep 14, 2026 - 3:18 PM");
//    public static final By BDORtoSMACPoints = AppiumBy.accessibilityId("points_history_item_awd_4_points, +10 Pts");

    //PAL to SMAC
    public static final By PH_ITEM_PALTOSMAC_TITLE = AppiumBy.accessibilityId("points_history_item_awd_title, PAL MABUHAY MILES: Conversion");

    //AIR ASIA to SMAC
    public static final By PH_ITEM_AIRTOSMAC_TITLE = AppiumBy.accessibilityId("points_history_item_awd_title, Points converted: Air Asia Points");

    //SMAC to PAL
    public static final By PH_ITEM_SMACTOPAL_TITLE = AppiumBy.accessibilityId("points_history_item_red_title, Points converted: SMAC to PAL Mabuhay Miles");

    //SMAC to AIR ASIA
    public static final By PH_ITEM_SMACTOAIR_TITLE = AppiumBy.accessibilityId("points_history_item_red_title, Points converted: SMAC to Air Asia Points");

    /*** PH Transaction Details ***/ //Points transfer
    public static final By PH_TRANS_DET_BACK_BTN = AppiumBy.accessibilityId("transaction_detail_back_button"); //
    public static final By PH_TRANS_DET_TITLE = AppiumBy.accessibilityId("transaction_detail_title"); //
    public static final By PH_POINTS_TRANSF_ICON = AppiumBy.accessibilityId("transaction_detail_success_icon");


    public static final By PH_TRANS_DET_DYNAMIC_TITLE =  AppiumBy.accessibilityId("transaction_detail_dynamic_title");
    public static final By PH_TRANS_DET_REF_NO = AppiumBy.accessibilityId("transaction_detail_ref_no");
    public static final By PH_TRANS_DET_PTS_LBL = AppiumBy.accessibilityId("transaction_detail_points_label");
    public static final By PH_TRANS_DET_PTS_VAL = AppiumBy.accessibilityId("transaction_detail_points_value");
    public static final By PH_TRANS_DET_DATE_LBL = AppiumBy.accessibilityId("transaction_detail_date_label");
    public static final By PH_TRANS_DET_DATE_VAL =  AppiumBy.accessibilityId("transaction_detail_date_value");
    public static final By PH_TRANS_DET_CARD_LBL = AppiumBy.accessibilityId("transaction_detail_card_label");
    public static final By PH_TRANS_DET_CARD_VAL = AppiumBy.accessibilityId("transaction_detail_card_value");
    public static final By PH_TRANS_DET_AMOUNT_LBL = AppiumBy.accessibilityId("transaction_detail_amount_label");
    public static final By PH_TRANS_DET_POINTS_LBL = AppiumBy.accessibilityId("transaction_detail_pts_label");
    public static final By PH_TRANS_DET_POINTS_VAL =  AppiumBy.accessibilityId("transaction_detail_pts_value");
}