package stepdefinitions;

import hooks.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import locators.LoginLocators;
import org.testng.Assert;
import pages.*;
import util.LocatorsChecker;

import java.util.List;

public class SSOMenuSteps {

    // Use PageManager from hooks
    private final SSOMenuPage ssoMenu = Hooks.getPageManager().getSSOMenuPage();
    private AppiumDriver driver;

    @Given("the user is on the SSO menu")
    public void ssoMenuDisplayed() {
        try {
            Assert.assertTrue(
                    ssoMenu.isSSOMenuVisible(),
                    "❌ SSO Menu is not visible"
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks on SSO Login button")
    public void theyClickedOnLoginButtonOnSSOMenu() {
        try {
            ssoMenu.clickSSOLoginBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user clicks on Sign up button")
    public void theUserClicksOnSignUpButton() {
        try{
            ssoMenu.clickSSOSignupBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Continue as Guest button")
    public void theUserClicksOnContinueAsGuestButton() {
        try{
            ssoMenu.clickSSOContAsGuestBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks on View Virtual SMAC button")
    public void theUserClicksOnViewVirtualSMACButton() {
        try{
            ssoMenu.clickSSOViewVirtualSMACBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Virtual SMAC modal is displayed -  No account logged yet")
    public void virtualSMACModalShouldDisplay_noAccountloggedYet() {
        try{
            Assert.assertTrue(
                    ssoMenu.isVirtualSmacModalVisible_NoAccountLoggedYet(),
                    "Virtual SMAC - No cache is expected. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("basic SSO Locators are retained")
    public void basicSSOLocatorsAreRetained() {
        try{
//            LocatorsChecker checker = new LocatorsChecker(driver);
//
//            List<String> failed = checker.checkPage(LoginLocators.getBasicLocators());
//
//            Assert.assertTrue(failed.isEmpty(),
//                    "Broken locators: " + failed);
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
}
