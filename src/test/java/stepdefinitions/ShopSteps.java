package stepdefinitions;

import hooks.*;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;


public class ShopSteps {

    private final ShopPage shop = Hooks.getPageManager().getShopPage();



    @Then("the user is on the Shop page")
    public void theUserIsOnTheShopPage() {
        try {
            Assert.assertTrue(
                    shop.isShopVisible(),
                    "❌ SSO Menu is not visible"
            );

            System.out.println("✅ The user is the on SSO menu");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ Login test failed. See above logs.");
        }

    }
}
