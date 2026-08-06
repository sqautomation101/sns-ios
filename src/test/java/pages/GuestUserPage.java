package pages;

import io.appium.java_client.AppiumDriver;

import base.*;
import locators.GuestUserLocators;

public class GuestUserPage extends BasePage {

    public static int timeout = 15;

    // Constructor
    public GuestUserPage(AppiumDriver driver) {
        super(driver);
    }


    public boolean isGuestHomepageVisible() {
        waitUniqueElement(GuestUserLocators.GUEST_LOGIN, 15);

        boolean guest_login = isElementVisible("Guest - Login", GuestUserLocators.GUEST_LOGIN, 5);
        logStatus("Guest - Login", guest_login);

        boolean guest_SearchProduct = isElementVisible("Guest - Search a product", GuestUserLocators.GUEST_SEARCH_PRODUCT, 5);
        logStatus("Guest - Search product", guest_SearchProduct);

        return guest_login & guest_SearchProduct;
    }


    public void clickGuestLogin(){
        tap("Guest - Login", GuestUserLocators.GUEST_LOGIN, timeout);
    }
}
