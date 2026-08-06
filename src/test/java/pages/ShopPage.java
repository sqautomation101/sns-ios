package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import base.*;

public class ShopPage extends BasePage {

    // for locator timeout
    public static int timeout = 30;

    private By SMACbtnBack = AppiumBy.accessibilityId("Back");

    //CONSTRUCTOR
    public ShopPage(AppiumDriver driver) {
        super(driver); // initializes driver + helpers + PageFactory
    }

    //LOCATORS


    public boolean isShopVisible() {
        return isElementVisible("SMAC btn", SMACbtnBack, 30);
    }

}
