package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;
import util.*;

public class HomePageSteps {

    private final HomePage home = Hooks.getPageManager().getHomePage();
    private final ManageCardsPage manageCard = Hooks.getPageManager().getManageCardsPage();

    /*** Homepage redirections ***/

    @Then("the user is on the Homepage")
    public void shouldRedirectedToHomepage() {
        try{

            Assert.assertTrue(
                    home.isHomepageDisplayed(),
                    "❌ Homepage-General is not visible. Assertion failed."
            );

            Assert.assertTrue(
                    home.isMainCardWidgetDisplayed(),
                    "❌ Main card widget is not visible. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the search a product button")
    public void theUserClicksTheSearchAProductButton() {
        try{
            home.clickSearchBtn();

        }catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user will redirects to shop's universal search screen")
    public void theUserIsRedirectedToShopSUniversalSearchScreen() {
        try{
            Assert.assertTrue(
                    home.verifyShopUniversalSearchScreen(),
                    "Shop universal screen is expected. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

//    @Then("the homepage greeting widget is displayed properly - SMAC Start")
//    public void theHomepageGreetingWidgetShouldBeDisplayedProperly_SMACStart() {
//        try {
//            String actualName = home.extractGreetings();
//            String highestTier = home.verifyHighestTier_hp();
//            String expectedName = TestDataManager.getGreetingName("Olivia Rodrigo");
//
//            System.out.println("Actual: " + actualName + "\nExpected: " + expectedName);
//
//            switch (highestTier) {
//                case "SMAC Start":
//                    Assert.assertEquals(actualName, expectedName,
//                            "❌ Name is not matched with expected greeting. Assertion failed.");
//                case "SMAC Regular":
//                case "SMAC Prestige":
//                    break;
//                default:
//                    Assert.fail("❌ Name is not matched with expected greeting");
//            }
//        } catch (Exception e){
//            Assert.fail("❌ Test failed due to exception: " );
//        }
//    }
//
//    @Then("the homepage greeting widget is visible - SMAC")
//    public void theHomepageGreetingWidgetShouldBeDisplayedProperly_SMAC() {
//        try {
//            String name = home.extractGreetings();
//            String highestTier = home.verifyHighestTier_hp();
//            String expectedName = TestDataManager.getGreetingName("Sabrina Carpenter");
//
//            switch (highestTier) {
//                case "SMAC Regular":
//                    Assert.assertEquals(name, expectedName,
//                            "❌ Name is not matched with expected greeting. Assertion failed.");
//                case "SMAC Start":
//                case "SMAC Prestige":
//                    break;
//                default:
//                    Assert.fail("❌ Name is not matched with expected greeting");
//            }
//        } catch (Exception e) {
//            Assert.fail("❌ Test failed due to exception.", e);
//        }
//    }
//
//    @Then("the homepage greeting widget is visible - SMAC Prestige")
//    public void theHomepageGreetingWidgetShouldBeDisplayedProperly_SMACPrestige() {
//        try {
//            String name = home.extractGreetings();
//            String highestTier = home.verifyHighestTier_hp();
//            String expectedName = TestDataManager.getGreetingName("Maddy Perez");
//
//            switch (highestTier) {
//                case "SMAC Prestige":
//                    Assert.assertEquals(name, expectedName,
//                            "❌ Name is not matched with expected greeting. Assertion failed.");
//                    break;
//                case "SMAC Regular":
//                case "SMAC Start":
//                default:
//                    Assert.fail("❌ Name is not matched with expected greeting");
//            }
//        } catch (Exception e) {
//            Assert.fail("❌ Test failed due to exception.", e);
//        }
//    }

//    @Then("the inbox button is visible")
//    public void theInboxButtonShouldBeDisplayed() {
//        try{
//            Assert.assertTrue(home.isInboxBtnVisible(),
//                    "Inbox button is not visible. Assertion failed.");
//
//        } catch (Exception e){
//            Assert.fail("❌ Test failed due to exception: " + e);
//        }
//    }

    @Then("the Main card widget is visible")
    public void theMainCardWidgetShouldBeDisplayedProperly() {
        try {
            Assert.assertTrue(home.isMainCardWidgetDisplayed(), 
                    "Main card is not displayed. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("Go shopping header is visible")
    public void goShoppingHeaderShouldBeDisplayed() {
        try {
            Assert.assertTrue(home.isGoShoppingHeaderDisplayed(),
                    "Go Shopping Header is not displayed. Assertion failed.");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Manage card widget")
    public void theUserClicksOnManageCardWidget() {
        try {
            home.clickManageCards();
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    /*** Points history redirection ***/
    @When("the user clicks the Points history widget")
    public void theUserClicksOnPointsHistoryWidget() {
        try{
            home.clickPointHistoryWidget();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on the Manage card Page")
    public void shouldBeRedirectedToManageCardPage() {
        try {
            Assert.assertTrue(
                    manageCard.isManageCardPageVisible_General(),
                    "Manage Card Page is not displayed. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the virtual card number is masked")
    public void theVirtualCardNumberIsMasked() {
        try {
            String actualCardNumber = home.extractCardNumber();

            Assert.assertTrue(
                    home.isCardNumberMasked(actualCardNumber),
                    "Card number is expected to be masked. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
    @Then("the virtual card number is unmasked")
    public void theVirtualCardNumberIsUnmasked() {
        try {
            String actualCardNumber = home.extractCardNumber();
            String expectedCardNumber = home.getExpectedVirtualCardNumber("Olivia Rodrigo");

            Assert.assertEquals(actualCardNumber, expectedCardNumber,
                    "Card number is expected to be unmasked. Assertion failed.");
            System.out.print("✅ The virtual card number is unmasked");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the virtual card number")
    public void clicksOnVirtualCardNumber() {
        try {
            home.clickCardNumber();
            System.out.print("✅ Clicks on virtual card number");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("SMAC Start default virtual card is visible")
    public void smacStartDefaultVirtualCardShouldBeDisplayed() {
        try {
            String actualTier = home.verifyHighestTier_hp();

            Assert.assertEquals(
                    actualTier, "SMAC Start",
                    "❌ Account logged in is not SMAC Start. Assertion failed."
            );

            System.out.print("✅ SMAC Start default virtual card is displayed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("SMAC default virtual card is visible")
    public void smacDefaultVirtualCardShouldBeDisplayed() {
        try {
            String actualTier = home.verifyHighestTier_hp();

            Assert.assertEquals(
                    actualTier, "SMAC Regular",
                    "❌ Account logged in is not SMAC Regular. Assertion failed."
            );

            System.out.print("✅ SMAC default virtual card is displayed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("SMAC Prestige default virtual card is visible")
    public void smacPrestigeDefaultVirtualCardShouldBeDisplayed() {
        try {
            String actualTier = home.verifyHighestTier_hp();

            Assert.assertEquals(
                    actualTier, "SMAC Prestige",
                    "❌ Account logged in is not SMAC Prestige. Assertion failed."
            );

            System.out.print("✅ SMAC Prestige default virtual card is displayed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Prestige bar")
    public void clicksOnPrestigeBar() {
        home.clickRTP();
    }

    /*** Bottom navigation redirections ***/
    @When("the user clicks the vouchers navigation")
    public void theUserClicksOnTheVouchersIcon() {
        home.clickBotNav_Voucher();
    }

    @When("the user clicks the QR - Start")
    public void theUserClicksOnTheQRIcon() {
        home.clickBotNav_QR_Start();
    }

    @When("the user clicks on QR - SMAC icon")
    public void theUserClicksOnTheQRSMACIcon() {
        home.clickBotNav_QR_SMAC();
    }

    @When("the user clicks on QR - Prestige icon")
    public void theUserClicksOnTheQRPrestigeIcon() {
        home.clickBotNav_QR_Prestige();
    }

    @When("the user clicks the Account navigation")
    public void theUserClicksOnTheAccountIcon() {
        home.clickBotNav_Acc();
    }

//    @When("the user clicks the shop navigation")
//    public void theUserClicksOnTheShopIcon() {
//        home.clickBotNav_Shop();
//    }

    @And("the user clicks the Home navigation")
    public void theUserClicksOnHomeIcon() {
        home.clickBotNav_Home();
    }

    @Then("the QR button is reflected as {string} tier")
    public void theQRButtonIsReflectedAsTier(String tier) {
        try{
            Assert.assertTrue(home.verifyQRButtonTier(tier),
                    "QR button tier is not Equal to the logged in account. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user clicks on Homepage Link Card")
    public void theUserClicksOnHomepageLinkCard() {
        try{
            home.clickHomeLinkCardWidget();
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("Bottom nav - QR is {string}")
    public void bottomNavQRVerification(String tier) {
        try{
            Assert.assertTrue(home.verifyQRButtonTier(tier),
                    "Unidentified tier. Assertion failed.");
        }catch (Exception e){
            Assert.fail("❌ Homepage test failed due to exception.", e);
        }
    }

    @Then("bottom navigation is displayed")
    public void guestHomepageIsDisplayed() {
        try{

            Assert.assertTrue(
                    home.isBottomNavVisible(),
                    "❌ Bottom Nav is not visible. Assertion failed."
            );
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

}
