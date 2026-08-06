package stepdefinitions;

import hooks.*;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;

public class RegistrationSteps {

    // Use PageManager from hooks
    private final RegistrationPage registration = Hooks.getPageManager().getRegistrationPage();



    @Then("Sign Up Menu is visible")
    public void signUpMenuShouldBeVisible() {
        try{
            Assert.assertTrue(
                    registration.isRegistrationPageVisible(),
                    "Registration page should be expected. Assertion failed."
            );

            System.out.println("✅ Sign Up Menu is visible");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ Registration test failed due to exception.", e);
        }
    }
}