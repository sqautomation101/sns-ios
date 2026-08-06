package pages;

import base.*;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class RoadToPrestigePage extends BasePage {

    private final int timeout = 30;

    protected By SMACStartimgHdr = AppiumBy.accessibilityId("rtp_header_image_start");
    protected By SMACimgHdr = AppiumBy.accessibilityId("rtp_header_image_smac");
    protected By SMACPrestigeimgHdr = AppiumBy.accessibilityId("rtp_header_image_prestige");

    protected By cardsBenefitsSMACStartFocused = AppiumBy.accessibilityId("rtp_benefits_icon_start, Start");
    protected By cardsBenefitsSMACFocused = AppiumBy.accessibilityId("rtp_benefits_icon_smac, SMAC");
    protected By cardsBenefitsSMACPrestigeFocused = AppiumBy.accessibilityId("rtp_benefits_icon_prestige, Prestige");

    protected By SMACStartUnfocused = AppiumBy.accessibilityId("Start");
    protected By SMACUnfocused = AppiumBy.accessibilityId("SMAC");
    protected By SMACPrestigeUnfocused = AppiumBy.accessibilityId("Prestige");

    protected By RTPWidget = AppiumBy.accessibilityId("Reach P200,000 within 12 months to unlock SMAC Prestige!");
    protected By RTPWidget_Prestige = AppiumBy.accessibilityId("Reach P200,000 to maintain SMAC Prestige until Oct 01, 2026");
    protected By RTP_Back = AppiumBy.accessibilityId("rtp_back_button");

    /*** Constructor ***/
    public RoadToPrestigePage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isSMACStartFocused() {
        return isElementVisible("SMAC Start tab - Focused", cardsBenefitsSMACStartFocused, 30) &&
                isElementVisible("SMAC - Unfocused", SMACUnfocused, 10) &&
                isElementVisible("SMAC Prestige - Unfocused", SMACPrestigeUnfocused, 10) &&
                isElementVisible("SMAC Start img", SMACStartimgHdr, 10) &&
                isElementVisible("Cards benefits - Back", RTP_Back, 10);
    }


    public boolean isSMACFocused() {
        return isElementVisible("SMAC tab - Focused", cardsBenefitsSMACFocused, 30) &&
                isElementVisible("SMAC Start - Unfocused", SMACStartUnfocused, 10) &&
                isElementVisible("SMAC Prestige - Unfocused", SMACPrestigeUnfocused, 10) &&
                isElementVisible("SMAC img", SMACimgHdr, 10) &&
                isElementVisible("Cards benefits - Back", RTP_Back, 10);
    }

    public boolean isSMACPrestigeFocused() {
        return isElementVisible("SMAC Prestige tab - Focused", cardsBenefitsSMACPrestigeFocused, 30) &&
                isElementVisible("SMAC Start - Unfocused", SMACStartUnfocused, 10) &&
                isElementVisible("SMAC - Unfocused", SMACUnfocused, 10) &&
                isElementVisible("SMAC Prestige img", SMACPrestigeimgHdr, 10) &&
                isElementVisible("Cards benefits - Back", RTP_Back, 10);
    }

    public boolean isRTPWidgetVisible() {
        return isElementVisible("RTP Widget", RTPWidget, 5) ;
    }

    public boolean isRTPWidgetVisible_prestige() {
        return isElementVisible("RTP Widget - Prestige", RTPWidget_Prestige, 5) ;
    }

    public void clickRTPBackBtn() {
        tap("RTP - Back", RTP_Back, timeout);
    }

    public void clickCardsBenefits_SMAC_Start() {
        tap("Unfocused - SMAC Start", SMACStartUnfocused, timeout);
    }

    public void clickCardsBenefits_SMAC() {
        tap("Unfocused - SMAC", SMACUnfocused, timeout);
    }

    public void clickCardsBenefits_SMAC_Prestige() {
        tap("Unfocused - SMAC Prestige", SMACPrestigeUnfocused, timeout);
    }
}
