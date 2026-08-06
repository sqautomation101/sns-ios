package stepdefinitions;

import hooks.*;
import pages.*;
import locators.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class GuestUserSteps {


    private final GuestUserPage guestUserPage = Hooks.getPageManager().getGuestUserPage();
    private final HomePage home = Hooks.getPageManager().getHomePage();

    @Then("the user is on the guest homepage")
    public void guestHomepageIsDisplayed() {
        try{
//            String name = home.extractGreetings();
//            String expectedName = "Guest";
            Assert.assertTrue(
                    guestUserPage.isGuestHomepageVisible(),
                    "Guest Main card should be displayed. Assertion failed"
            );

            Assert.assertTrue(
                    home.isBottomNavVisible(),
                    "Guest Bottom nav should be displayed. Assertion failed"
            );

//            Assert.assertEquals(
//                    name, expectedName,
//                    "Guest greeting should be displayed. Assertion failed"
//            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks the Login button in the main card widget")
    public void userClicksOnLoginButtonInTheMainCardWidget() {
        guestUserPage.clickGuestLogin();
    }

    @And("the guest user clicks the inbox icon")
    public void userClicksOnTheInboxIcon() { home.clickBotNav_Inbox();}

    @And("the guest user clicks the vouchers icon")
    public void userClicksOnTheVouchersIcon() { home.clickBotNav_Voucher(); }

    @And("the guest user clicks the QR icon")
    public void userClicksOnTheQRIcon() {
        home.clickBotNav_QR_Start();
    }

    @And("the guest user clicks the account icon")
    public void userClicksOnTheAccountIcon() {
        home.clickBotNav_Acc();
    }

    //@DEFERRED
//    @And("the guest user clicks the shop icon")
//    public void userClicksOnTheShopIcon() {
//        home.clickBotNav_Shop();
//    }

}
