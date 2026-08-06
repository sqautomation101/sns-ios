package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class OfflineVirtualCardLocators {

    private OfflineVirtualCardLocators() {}

    //LOCATORS
    public static final By VIEW_VIRTUAL_CARD_SMAC_CLOSE_BTN = AppiumBy.accessibilityId("Close");

    public static final By VIEW_VIRTUAL_CARD_OFFLINE_MODAL_TITLE = AppiumBy.accessibilityId("no_internet_dialog_title");
    public static final By VIEW_VIRTUAL_CARD_OFFLINE_MODAL_DESC = AppiumBy.accessibilityId("no_internet_dialog_description");
    public static final By VIEW_VIRTUAL_CARD_OFFLINE_MODAL_REFRESH_BTN = AppiumBy.accessibilityId("no_internet_dialog_refresh_button");
    public static final By OFFLINE_MODAL_VIEW_VIRTUAL_SMAC = AppiumBy.accessibilityId("no_internet_dialog_view_virtual_smac_button");
    public static final By OFFLINE_NOCACHE_NOTE = AppiumBy.accessibilityId("Virtual SMAC will be available after your first login. You can even view it while offline!");
    public static final By offlineHeader = AppiumBy.accessibilityId("offline_qr_title, SMAC QR");
    public static final By OFFLINE_QRBC_BACK = AppiumBy.accessibilityId("offline_qr_back_button");
    public static final By OFFLINE_SHOW_QR = AppiumBy.accessibilityId("offline_qr_show_qr_button");
    public static final By OFFLINE_SHOW_BARCODE = AppiumBy.accessibilityId("offline_qr_show_barcode_button");

    public static final By TOAST_OFFLINE = AppiumBy.accessibilityId("no_internet_connection_dialog");
    public static final By TOAST_BACK_ONLINE = AppiumBy.accessibilityId("back_online_dialog");
    public static final By OFFLINE_QR = AppiumBy.accessibilityId("offline_qr_code");
    public static final By dateTime_qr = AppiumBy.accessibilityId("dynamic_qr_timestamp");
    public static final By OFFLINE_CARD_NUMBER_QR = AppiumBy.xpath("//*[contains(@content-desc, 'offline_qr_card_number')]");

    public static final By OFFLINE_EARN_PTS = AppiumBy.accessibilityId("offline_qr_present_earn_points_text, Present this to earn SMAC Points!");
    public static final By OFFLINE_BARCODE = AppiumBy.accessibilityId("offline_qr_barcode_image");
    public static final By dateTime_barcode = AppiumBy.accessibilityId("offline_qr_barcode_date_text");
    public static final By OFFLINE_CARD_NUMBER_BARCODE = AppiumBy.xpath("//*[contains(@content-desc, 'offline_qr_barcode_card_number_text')]");

    public static final By OFFLINE_TIER_COLOR_START = AppiumBy.accessibilityId("offline_qr_smac_card_color_container_smac_start");
    public static final By OFFLINE_TIER_COLOR_SMAC = AppiumBy.accessibilityId("offline_qr_smac_card_color_container_smac_blue");
    public static final By OFFLINE_TIER_COLOR_PRESTIGE = AppiumBy.accessibilityId("offline_qr_smac_card_color_container_smac_prestige");
}