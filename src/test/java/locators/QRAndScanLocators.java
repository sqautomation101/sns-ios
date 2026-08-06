package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class QRAndScanLocators {

    private QRAndScanLocators() {}

    //LOCATORS
    public static final By QAS_SHOW_QR =  AppiumBy.accessibilityId("home_qr_show_qr_button");
    public static final By QAS_SHOW_BARCODE =  AppiumBy.accessibilityId("home_qr_show_barcode_button");
    public static final By QAS_PAY_WITH_POINTS =  AppiumBy.accessibilityId("home_qr_pay_with_points_button");

    public static final By QAS_PWP_INSTRUCTIONS = AppiumBy.accessibilityId("home_qr_scanner_instruction_text");
    public static final By QAS_PWP_SCANNER_CAM = AppiumBy.accessibilityId("home_qr_scanner_camera");

    public static final By QAS_CARD_NUMBER = AppiumBy.xpath("//*[contains(@content-desc, 'card_number')]");

    public static final By QAS_EARN_POINTS = AppiumBy.accessibilityId("home_qr_present_earn_points_text");
    public static final By QAS_DYNAMIC_QR = AppiumBy.accessibilityId("home_smac_qr");
    public static final By QAS_DYNAMIC_BARCODE = AppiumBy.accessibilityId("home_qr_barcode_image");
    public static final By QAS_DATETIME_BARCODE = AppiumBy.accessibilityId("home_qr_barcode_date_text");
    public static final By QAS_DATETIME_QR = AppiumBy.accessibilityId("dynamic_qr_timestamp");
    public static final By TIER_COLOUR_START = AppiumBy.accessibilityId("home_qr_smac_card_color_container_smac_start");
    public static final By TIER_COLOUR_SMAC = AppiumBy.accessibilityId("home_qr_smac_card_color_container_smac_blue");
    public static final By TIER_COLOUR_PRESTIGE = AppiumBy.accessibilityId("home_qr_smac_card_color_container_smac_prestige");
}