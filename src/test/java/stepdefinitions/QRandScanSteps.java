package stepdefinitions;

import hooks.*;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;

public class QRandScanSteps {

    private final QRandScanPage qrAndScan = Hooks.getPageManager().getQrAndscanPage();



    @Then("the user is on QAS - QR Page - No linked card")
    public void qrPageIsDisplayedNoLinkedCard() {
        try {
            String actualBIN = qrAndScan.getCardBIN_QAS();
            String expectedBIN = "8881";

            Assert.assertEquals(actualBIN, expectedBIN,
                    "❌Card number is NOT virtual. Assertion failed");

            Assert.assertTrue(qrAndScan.isQRPageDisplayed_General(),
                    "❌ QAS - QR is not displayed. Assertion failed");

            Assert.assertTrue(qrAndScan.isLowerBannerVisiblePerTier_QAS(),
                    "Logged in account has linked card. Assertion failed.");
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on the QAS - QR Page - Start")
    public void qrPageIsDisplayedStart() {
        try {
            String actualBIN = qrAndScan.getCardBIN_QAS();
            String expectedBIN = "8881";

            Assert.assertNotEquals(actualBIN, expectedBIN,
                    "❌Physical card number should be displayed. Assertion failed");

            Assert.assertTrue(qrAndScan.isQRPageDisplayed_General(),
                    "❌ QAS - QR is not displayed Assertion failed");

            Assert.assertTrue(qrAndScan.isLowerBannerVisiblePerTier_QAS(),
                    "Logged in account is not Start. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on QAS - QR page - SMAC")
    public void qrPageIsDisplayedSMAC() {
        try {
            String actualBIN = qrAndScan.getCardBIN_QAS();
            String expectedBIN = "8881";

            Assert.assertNotEquals(actualBIN, expectedBIN,
                    "❌Physical card number should be displayed. Assertion failed");

            Assert.assertTrue(qrAndScan.isQRPageDisplayed_General(),
                    "❌ QAS - QR is not displayed Assertion failed");

            Assert.assertTrue(qrAndScan.isLowerBannerVisiblePerTier_QAS(),
                    "Logged in account is not SMAC. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on QAS - QR page - Prestige")
    public void qrPageIsDisplayedPrestige() {
        try {
            String actualBIN = qrAndScan.getCardBIN_QAS();
            String expectedBIN = "8881";

            Assert.assertNotEquals(actualBIN, expectedBIN,
                    "❌Physical card number should be displayed. Assertion failed");

            Assert.assertTrue(qrAndScan.isQRPageDisplayed_General(),
                    "❌ QAS - QR is not displayed Assertion failed");

            Assert.assertTrue(qrAndScan.isLowerBannerVisiblePerTier_QAS(),
                    "Logged in account is not Prestige. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on QAS - Barcode page - Start")
    public void bcPageIsDisplayedStart() {
        try {
            String actualBIN = qrAndScan.getCardBIN_QAS();
            String expectedBIN = "8881";

            Assert.assertNotEquals(actualBIN, expectedBIN,
                    "❌Account has linked card. Assertion failed");

            Assert.assertTrue(qrAndScan.isBCPageDisplayed_General(),
                    "❌ QAS - Barcode is not displayed Assertion failed");

            Assert.assertTrue(qrAndScan.isLowerBannerVisiblePerTier_QAS(),
                    "Logged in account is not Start. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on QAS - Barcode page - SMAC")
    public void bcPageIsDisplayedSMAC() {
        try {
            String actualBIN = qrAndScan.getCardBIN_QAS();
            String expectedBIN = "8881";

            Assert.assertNotEquals(actualBIN, expectedBIN,
                    "❌Account has NO linked card. Assertion failed");

            Assert.assertTrue(qrAndScan.isBCPageDisplayed_General(),
                    "❌ QAS - Barcdoe is not displayed Assertion failed");

            Assert.assertTrue(qrAndScan.isLowerBannerVisiblePerTier_QAS(),
                    "Logged in account is not SMAC. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on QAS - Barcode page - Prestige")
    public void bcPageIsDisplayedPrestige() {
        try {
            String actualBIN = qrAndScan.getCardBIN_QAS();
            String expectedBIN = "8881";

            Assert.assertNotEquals(actualBIN, expectedBIN,
                    "❌Account has NO linked card. Assertion failed");

            Assert.assertTrue(qrAndScan.isBCPageDisplayed_General(),
                    "❌ QAS - Barcode is not displayed Assertion failed");

            Assert.assertTrue(qrAndScan.isLowerBannerVisiblePerTier_QAS(),
                    "Logged in account is not Prestige. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks on Show barcode - QAS")
    public void clicksOnShowBarcode() {
        try {
            qrAndScan.clickShowBarcode();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks on Show QR - QAS")
    public void clicksOnShowQR() {
        try {
            qrAndScan.clickShowQR();

            System.out.println("✅ the user clicks on Show QR - QAS");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks on Pay with Points - QAS")
    public void clicksOnPayWithPoints() {
        try {
            qrAndScan.clickPayWithPoints();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on Scanner page - QAS")
    public void scannerPageIsDisplayedQAS() {
        try {
            Assert.assertTrue(qrAndScan.isPayWithPointsPageVisible(),
                    "❌ Pay with points is expected. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
}
