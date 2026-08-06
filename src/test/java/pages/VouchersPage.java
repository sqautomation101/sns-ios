package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import base.*;

public class VouchersPage extends BasePage {
    //LOCATORS
    private By vouchersHdr = AppiumBy.androidUIAutomator("" +
            "new UiSelector()" +
            ".className(\"android.view.View\")" +
            ".resourceId(\"voucher_title\")");

    //CONSTRUCTOR
    public VouchersPage(AppiumDriver driver) {
        super(driver);
    }

    //VOUCHERS PAGE VERIFICATION
    public boolean isVouchersPageDisplayed() {
        return isElementVisible("Vouchers hdr", vouchersHdr, 60);
    }

}