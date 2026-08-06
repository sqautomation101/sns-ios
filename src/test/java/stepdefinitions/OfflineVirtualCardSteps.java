package stepdefinitions;

import hooks.*;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;

public class OfflineVirtualCardSteps {

    // Use PageManager from hooks
    private final OfflineVirtualCardPage offlineVirtualCard = Hooks.getPageManager().getOfflineVirtualCard();
    private final SSOMenuPage ssoMenuPage = Hooks.getPageManager().getSSOMenuPage();

    @When("the user turns off the connectivity")
    public void connectivityOff() {
        try {
            offlineVirtualCard.toggleAirplaneMode();

            System.out.println("✅ turned off the connectivity 🛜🚫");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }



    @When("the user turns on the connectivity")
    public void connectivityOn() {
        try {
            offlineVirtualCard.turnOnWifi();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("offline modal is displayed")
    public void offlineModalIsDisplayed() {
        try {
            Assert.assertTrue(offlineVirtualCard.isOfflinemodalVisible(),
                    "Offline modal is expected. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("offline modal is not displayed")
    public void offlineModalIsNotDisplayed() {
        try {
            Assert.assertTrue(offlineVirtualCard.waitUntilOfflineModalIsHidden(),
                    "Offline modal is NOT hidden. Assertion failed.");

            Assert.assertFalse(offlineVirtualCard.isOfflinemodalVisible(),
                    "Offline modal is NOT expected. Assertion failed.");

            System.out.println("✅ offline modal is not displayed");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Offline QR is displayed - {string}")
    public void offlineQRIsDisplayed(String tier) {
        try {
            Assert.assertTrue(offlineVirtualCard.isOfflineQRVisible_General(),
                    "Offline QR is expected. Assertion failed.");

            Assert.assertTrue(offlineVirtualCard.isLowerBannerVisiblePerTier(),
                    "Logged in account is NOT Start. Assertion failed.");

            System.out.println("✅ Offline QR is displayed");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Offline Barcode is displayed - {string}")
    public void offlineBCIsDisplayedStart(String tier) {
        try {
            String currentTier = offlineVirtualCard.getTier_BC();
            String expectedTier = tier;

            Assert.assertTrue(offlineVirtualCard.isOfflineBarcodeVisible(tier),
                    "Offline Barcode is expected. Assertion failed.");

            Assert.assertEquals(currentTier, expectedTier,
                    "Logged in account is NOT SMAC Start. Assertion failed.");

            System.out.println("✅ Offline Barcode is displayed - Start");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Offline QR is not displayed - Start")
    public void offlineQRIsNotDisplayedStart() {
        try {
            Assert.assertTrue(offlineVirtualCard.isOfflineQRVisible_General(),
                    "Offline QR is expected. Assertion failed.");

            Assert.assertTrue(offlineVirtualCard.isLowerBannerVisiblePerTier(),
                    "Logged in account is NOT Start. Assertion failed.");

            System.out.println("✅ Offline QR is not displayed - Start");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Offline - Refresh")
    public void clicksOnOfflineRefresh() {
        try {
            offlineVirtualCard.clickOffline_Refresh();

            System.out.println("✅ clicks on Offline - Refresh");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Offline toast is displayed")
    public void offlineToastIsDisplayed() {
        try {
            Assert.assertTrue(offlineVirtualCard.isOfflineToastVisible(),
                    "Offline toast is expected. Assertion failed");

            System.out.println("✅ Offline toast is displayed");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Back online toast is displayed")
    public void BackOnlineToastIsDisplayed() {
        try {
            Assert.assertTrue(offlineVirtualCard.isBckOnlineToastVisible(),
                    "Back online toast is expected. Assertion failed");

            System.out.println("✅ Back online toast is displayed");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks the Offline - View Virtual SMAC button")
    public void theUserClicksOnOfflineViewVirtualSMACButton() {
        try {
            offlineVirtualCard.clickOffline_ViewVirtualSMAC();

            System.out.println("✅ clicks on Offline - View Virtual SMAC button");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("View Virtual SMAC is {string}")
    public void virtualSMACModalShouldDisplay_noCache(String btnState) {
        try{
            if (btnState.equals("enabled")) {
                Assert.assertTrue(offlineVirtualCard.isViewVirtualCardEnabled(),
                        "View Virtual SMAC is expected to be enable. Assertion failed.");

                System.out.println("✅ View Virtual SMAC is enabled");
            } else if (btnState.equals("disabled")) {
                Assert.assertFalse(offlineVirtualCard.isViewVirtualCardEnabled(),
                        "View Virtual SMAC is expected to be disable. Assertion failed.");
                System.out.println("✅ View Virtual SMAC is disabled");
            }
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the View Virtual SMAC - No cache - Close")
    public void clicksOnViewVirtualSMACNoCacheClose() {
        try {
            ssoMenuPage.clickClose_VirtualSMACModal_NoCache();

            System.out.println("✅ the user clicks the View Virtual SMAC - No cache - Close");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("card number is not virtual - QR")
    public void cardNumberIsNotVirtual_QR() {
        try {
            String actualBIN = offlineVirtualCard.getCardBIN_QR();
            String expectedBIN = "8881";

            Assert.assertNotEquals(actualBIN, expectedBIN,
                    "Card number is not physical. Assertion failed.");

            System.out.println("✅ card number is not virtual");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("card number is virtual - QR")
    public void cardNumberIsVirtual_QR() {
        try {
            String actualBIN = offlineVirtualCard.getCardBIN_QR();
            String expectedBIN = "8881";

            Assert.assertEquals(expectedBIN, actualBIN,
                    "Account has linked card. Assertion failed.");

            System.out.println("✅ card number is virtual - QR");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("card number is virtual - Barcode")
    public void cardNumberIsVirtual_BC() {
        try {
            String actualBIN = offlineVirtualCard.getCardBIN_BC();
            String expectedBIN = "8881";

            Assert.assertEquals(actualBIN, expectedBIN,
                    "Account has linked card. Assertion failed.");

            System.out.println("✅ card number is virtual");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("card number is not virtual - Barcode")
    public void cardNumberIsNotVirtual_BC() {
        try {
            String actualBIN = offlineVirtualCard.getCardBIN_BC();
            String expectedBIN = "8881";

            Assert.assertNotEquals(actualBIN, expectedBIN,
                    "Account has NO linked card. Assertion failed.");

            System.out.println("✅ card number is not virtual");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user clicks the Offline Show barcode")
    public void clicksOnOfflineShowBarcode() {
        try {
            offlineVirtualCard.clickOffline_ShowBarcode();

            System.out.println("✅ clicks on Offline Show barcode");
        } catch (Exception e) {Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user clicks the Offline Show QR")
    public void clicksOnOfflineShowQR() {
        try {
            offlineVirtualCard.clickOffline_ShowQR();

            System.out.println("✅ clicks on Offline Show QR");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Show Barcode - Back")
    public void clicksOnShowBarcodeBack() {
        try {
            offlineVirtualCard.clickOffline_ShowBarcode_BackBtn();

            System.out.println("✅ clicks on Offline Show barcode - Back");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Show QR - Back")
    public void clicksOnShowqrBack() {
        try {
            offlineVirtualCard.clickOffline_ShowQR_BackBtn();

            System.out.println("✅ clicks on Offline Show QR - Back");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Virtual SMAC modal is not displayed")
    public void virtualSMACModalIsNotDisplayed() {
        try {
            Assert.assertFalse(
                    offlineVirtualCard.isVirtualSmacModalVisible_NoLoginHistory(),
                    "Virtual SMAC - No cache is NOT expected. Assertion failed."
            );
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
}
