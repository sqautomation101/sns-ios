package stepdefinitions;

import hooks.*;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.*;

public class AccountSteps {

    // Use PageManager from hooks
    private final AccountPage account = Hooks.getPageManager().getAccountPage();

    @Then("the user is on the Account Page")
    public void AccountPageShouldBeVisible() {
        try{
            Assert.assertTrue(
                    account.isAccountPageVisible(),
                    "Account page should be display. Assertion failed"
            );
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
    @When("the user clicks the Account - Manage cards")
    public void clicksOnLoyaltyCards() {
        try{
            account.clickManageCards();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
    @When("the user clicks the Help and information")
    public void clicksOnHelpAndInformation() {
        try{
            account.clickHelpAndInfo();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on the Help and Information Page")
    public void redirectedToHelpAndInformationPage() {
        try{
            Assert.assertTrue(
                    account.isHelpAndInfoPageVisible(),
                    "Help and information page is expected. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks the Logout")
    public void clicksOnLogout() {
        try{
            account.clickLogout();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Points history from Account page")
    public void theUserClicksThePointsHistoryFromAccountPage() {
        try {
            account.clickPointsHistory();
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
}
