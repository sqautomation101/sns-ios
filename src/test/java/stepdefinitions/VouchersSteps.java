package stepdefinitions;

import hooks.*;
import io.cucumber.java.en.Then;
import pages.*;
import org.testng.Assert;

public class VouchersSteps {

    private final VouchersPage vouchersPage = Hooks.getPageManager().getVouchersPage();



    @Then("the user is on the vouchers page")
    public void theUserIsOnTheVouchersPage() {
        try{
            Assert.assertTrue(
                    vouchersPage.isVouchersPageDisplayed(),
                    "❌ Vouchers page is not visible. Assertion failed."
            );

            System.out.println("✅ The user is on the vouchers page");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ Vouchers test failed. See above logs.");
        }
    }
}
