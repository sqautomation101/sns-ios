package stepdefinitions;

import hooks.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;

public class PointsHistorySteps {

    private final PointsHistoryPage ptsHistoryPage = Hooks.getPageManager().getPointsHistoryPage();
    public String transactionTitleFromPtsHx;
    public String transactionPtsFromPtsHx;
    public String transactionDateFromPtsHx;



    @When("the user clicks the Points history back button")
    public void userClicksOnPointsHistoryBackButton() {
        try {
            ptsHistoryPage.clickBackBtnPointsHistory();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }

    }

    @Then("the user is on the Points History page")
    public void userIsRedirectedToThePointsHistoryPage() {
        try {
            Assert.assertTrue(
                    ptsHistoryPage.isPointsHistoryPageVisible(),
                    "❌ Points History is not visible. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the user clicks the Transaction Details back button")
    public void userClicksOnTransactionDetailsBackButton() {
        try {
            ptsHistoryPage.clickTransDetailsBackBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Points history text adjustment is visible")
    public void pointsHistoryTextAdjustmentIsVisible() {
        try{
            Assert.assertTrue(ptsHistoryPage.isPtsHistoryTextAdjVisible(),
                    "Pts History text adj is not visible. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @When("the user clicks the Points Transaction item \\({string})")
    public void theUserClicksThePointsTransactionItem(String sce) {
        try{
            ptsHistoryPage.clickPtsHistoryTransaction(sce);

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @Then("the Transaction details for {string} page is displayed")
    public void theTransactionDetailsForPageIsDisplayed(String transactionType) {
        try{
            Assert.assertTrue(ptsHistoryPage.isPointsTransferInnerPageVisible_General(),
                    "Inner page - General is expected to be displayed. Assertion failed.");

            Assert.assertTrue(ptsHistoryPage.isPointsTransferInnerPageVisible_Specific(transactionType),
                    "Inner page - Specific is expected to be displayed. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @And("the user reads the transaction title - {string}")
    public void theUserReadsTheTransactionTitle(String tranType) {
        try{
            Assert.assertTrue(ptsHistoryPage.verifyItem_TransactionType(tranType),
                    "Item should be visible. Assertion failed.");

            transactionTitleFromPtsHx = ptsHistoryPage.getPtsHistoryTitle(tranType);

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @And("the user reads the transaction date - {string}")
    public void theUserReadsTheTransactionDate(String tranType) {
        try{
            Assert.assertTrue(ptsHistoryPage.verifyItem_TransactionType(tranType),
                    "Item should be visible. Assertion failed.");

            transactionDateFromPtsHx = ptsHistoryPage.getPtsHistoryDate(tranType);

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @Then("Item title is matched in Transaction Details - {string}")
    public void itemTitleIsMatchedInTransactionDetails(String tranType) {
        try{
            Assert.assertTrue(ptsHistoryPage.isPointsTransferInnerPageVisible_General(),
                    "Inner page - General is expected to be displayed. Assertion failed.");

            String inner = ptsHistoryPage.getPtsHistoryTitle_Inner();
            Assert.assertEquals(inner, transactionTitleFromPtsHx,
                    "Titles are not the same. Assertion failed.");
            System.out.println("From Pts Hx list: " + transactionTitleFromPtsHx + "\nFrom inner page: " + inner);

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @Then("Item points is matched in Transaction Details - {string}")
    public void itemPtsMatchedInTransactionDetails(String tranType) {
        try{
            Assert.assertTrue(ptsHistoryPage.isPointsTransferInnerPageVisible_General(),
                    "Inner page - General is expected to be displayed. Assertion failed.");

            String cleanedPts_PtsHx = ptsHistoryPage.cleanPositivePointsValue(transactionPtsFromPtsHx);
            String inner = ptsHistoryPage.getPtsHistoryPts_Inner();
            Assert.assertEquals(inner, cleanedPts_PtsHx,
                    "Pts are not the same. Assertion failed.");
            System.out.println("From Pts Hx list: " + transactionPtsFromPtsHx + "\nFrom inner page: " + inner);

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @Then("Item date is matched in Transaction Details - {string}")
    public void itemDatesMatchedInTransactionDetails(String tranType) {
        try{
            Assert.assertTrue(ptsHistoryPage.isPointsTransferInnerPageVisible_General(),
                    "Inner page - General is expected to be displayed. Assertion failed.");

            String inner = ptsHistoryPage.getPtsHistoryDate_Inner();
            Assert.assertEquals(inner, transactionDateFromPtsHx,
                    "Titles are not the same. Assertion failed.");
            System.out.println("From Pts Hx list: " + transactionDateFromPtsHx + "\nFrom inner page: " + inner);

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @Then("the Transaction item title {string} is displayed")
    public void theTransactionItemTitleIsDisplayed(String sce) {
        try{
            String inner = ptsHistoryPage.getPtsHistoryTitle_Inner();
            Assert.assertEquals(inner, sce,
                    "Assertion failed.");
            System.out.println("Expected: " + sce + "\nActual: " + inner);

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @Then("the Points History item title {string} is displayed")
    public void thePHItemTitleIsDisplayed(String sce) {
        try{
            Assert.assertEquals(transactionTitleFromPtsHx, sce,
                    "Not equal. Assertion failed.");
            System.out.println("Expected: " + sce + "\nActual: " + transactionTitleFromPtsHx + "\n");

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @And("the user reads the {string} transaction points - {string}")
    public void theUserReadsThePositiveTransactionPoints(String sign, String tranType) {
        try{
            transactionPtsFromPtsHx = ptsHistoryPage.getPointsValFromPointsHistoryList(tranType);

            if (sign.equalsIgnoreCase("positive")){
                Assert.assertTrue(ptsHistoryPage.isValuePositive(tranType),
                        "Value is not positive. Assertion failed");
            } else if (sign.equalsIgnoreCase("negative")){
                Assert.assertFalse(ptsHistoryPage.isValuePositive(tranType),
                        "Value is not negative. Assertion failed");
            }

        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }

    @And("the user scrolls down")
    public void theUserScrollsDown() {
        try{
            ptsHistoryPage.scrollDown_PH();
        } catch (Exception e) {
            Assert.fail("❌ Points history test failed due to exception.", e);
        }
    }
}
