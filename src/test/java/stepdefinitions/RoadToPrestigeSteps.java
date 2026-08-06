package stepdefinitions;

import hooks.*;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;

public class RoadToPrestigeSteps {

    // Use PageManager from hooks
    private final RoadToPrestigePage rtp = Hooks.getPageManager().getRoadToPrestigePage();



    @Then("the user is on the Card benefits page - Start tab")
    public void redirectedToCardBenefitsPageStartTab() {
        try{
            Assert.assertTrue(
                    rtp.isSMACStartFocused(),
                    "SMAC start tab is not focused. Assertion failed."
            );

            System.out.println("✅ redirected to Card benefits page - Start tab");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @Then("the user will redirects to Card benefits page - SMAC tab")
    public void redirectedToCardBenefitsPageSMACTab() {
        try{
            Assert.assertTrue(
                    rtp.isSMACFocused(),
                    "SMAC tab is not focused. Assertion failed."
            );

            System.out.println("✅ redirected to Card benefits page - SMAC tab");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @Then("the user is on the Card benefits page - SMAC Prestige tab")
    public void redirectedToCardBenefitsPagePrestigeTab() {
        try{
            Assert.assertTrue(
                    rtp.isSMACPrestigeFocused(),
                    "SMAC Prestige tab is not focused. Assertion failed."
            );

            System.out.println("✅ redirected to Card benefits page - Prestige tab");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @And("RTP Widget is visible")
    public void rtpWidgetIsVisible() {
        try{
            Assert.assertTrue(
                    rtp.isRTPWidgetVisible(),
                    "RTP widget is expected to be visible. Assertion failed."
            );

            System.out.println("✅ RTP Widget is visible");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @Then("RTP Widget is not visible")
    public void rtpWidgetIsNotVisible() {
        try{
            Assert.assertFalse(
                    rtp.isRTPWidgetVisible(),
                    "RTP widget is not expected. Assertion failed."
            );

            Assert.assertFalse(
                    rtp.isRTPWidgetVisible_prestige(),
                    "RTP widget is not expected. Assertion failed."
            );

            System.out.println("✅ RTP Widget is not visible");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @And("the user clicks the back button - RTP")
    public void clickOnBackButtonRTP() {
        try{
            rtp.clickRTPBackBtn();
            System.out.println("✅ click on back button - RTP");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @When("the user clicks the Cards benefits - SMAC")
    public void clickOnCardsBenefitsSMAC() {
        try{
            rtp.clickCardsBenefits_SMAC();
            System.out.println("✅ click on Cards benefits - SMAC");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @When("the user clicks the Cards benefits - SMAC Start")
    public void clickOnCardsBenefitsSMACStart() {
        try{
            rtp.clickCardsBenefits_SMAC_Start();
            System.out.println("✅ click on Cards benefits - SMAC Start");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @When("the user clicks the Cards benefits - SMAC Prestige")
    public void clickOnCardsBenefitsSMACPrestige() {
        try{
            rtp.clickCardsBenefits_SMAC_Prestige();
            System.out.println("✅ click on Cards benefits - SMAC Prestige");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }

    @And("RTP Widget is visible - Prestige")
    public void rtpWidgetIsVisiblePrestige() {
        try{
            Assert.assertTrue(
                    rtp.isRTPWidgetVisible_prestige(),
                    "RTP widget - Prestige is expected. Assertion failed."
            );

            System.out.println("✅ RTP Widget - Prestige is visible");
        } catch (Exception e) {
            System.err.println("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("❌ RTP test failed due to exception.", e);
        }
    }
}