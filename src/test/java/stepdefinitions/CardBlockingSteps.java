package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AccountPage;
import pages.CardBlockingPage;

public class CardBlockingSteps {

    // Use PageManager from hooks
    private final CardBlockingPage cardBlocking = Hooks.getPageManager().getCardBlockingPage();

    String block_CardNumber;

    @Then("the user is on the Block Card page")
    public void redirectedToBlockCardPage() {
        try {
            Assert.assertTrue(cardBlocking.isBlockCardPageVisible(),
                    "Block card page is NOT displayed. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the block tier image is {string}")
    public void theBlockTierImageIs(String code) {
        try {
            switch (code) {
                case "822":
                    Assert.assertTrue(cardBlocking.isBlockTierImageVisible(code));
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks the Block - Block card")
    public void theUserClicksTheBlockBlockCard() {
        try {
            cardBlocking.clickBlockBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("Blocking success screen is displayed")
    public void blockingSuccessScreenIsDisplayed() {
        try {
            Assert.assertTrue(cardBlocking.isCardBlockingSuccessPageVisible(),
                    "Block card success page is NOT displayed. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks on Back to Loyalty")
    public void theUserClicksOnBackToLoyalty() {
        try {
            cardBlocking.clickBackToLoyaltyBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
}
