package stepdefinitions;

import hooks.*;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;
import util.*;

public class ManageCardSteps {

    // Use PageManager from hooks
    private final ManageCardsPage manageCards= Hooks.getPageManager().getManageCardsPage();
    private TestContext testContext;


    private String cleanCNFromMainCard;
    private Integer cardCount;
    private String cardNumWithDelimiter;

    public ManageCardSteps(TestContext testContext) {
        this.testContext = testContext;
    }


    @And("user reads main card number")
    public void readMainCard() {
        cleanCNFromMainCard = manageCards.cleanCardNumber(" ");

    }

    @When("the user clicks the Manage card - Back")
    public void clicksOnTheManageCardBack() {
        try {
            manageCards.clickManageCardBackButton();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Manage card - Transfer points")
    public void clicksOnTheTransferPointsButton() {
        try {
            manageCards.clickTransferPtsButton();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Manage card - Link card")
    public void clicksOnTheManageCardLinkCard() {
        try {
            manageCards.clickLinkCardBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Manage card - Block card")
    public void clicksOnBlockCard() {
        try {
            manageCards.clickBlockCardBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Block card is disabled")
    public void blockCardIsDisabled() {
        try {
            Assert.assertFalse(manageCards.isBlockCardEnabled(),
                    "Block card should be disabled. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Block card is enabled - Linked")
    public void blockCardIeEnabledLinked() {
        try {
            Assert.assertTrue(manageCards.isBlockCardEnabled(),
                    "Block card should be enabled. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Show card is enabled")
    public void showCardIsEnabled() {
        try {
            Assert.assertTrue(manageCards.isShowCardEnabled(),
                    "Show card should be enabled. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Show card is disabled")
    public void showCardIsDisabled() {
        try {
            Assert.assertFalse(manageCards.isShowCardEnabled(),
                    "Show card should be disabled. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on the transfer points page")
    public void redirectedToTransferPointsPage() {
        try {
            Assert.assertTrue(manageCards.isPtsTransferVisible_General(),
                    "Points transfer page is expected. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Manage card - Show Card")
    public void clicksOnManageCardShowCard() {
        try {
            manageCards.clickShowCard();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Show Card - QR is displayed - Start")
    public void showCardQRIsDisplayedStart() {
        try {
            Assert.assertTrue(manageCards.isShowCard_QR_Visible(),
                    "Show Card - QR is NOT visible. Assertion failed");

            Assert.assertTrue(manageCards.isShowCard_QR_selected(),
                    "QR tab is expected to be selected. Assertion failed");

            Assert.assertFalse(manageCards.isShowCard_Barcode_selected(),
                    "Barcode tab is NOT expected to be selected. Assertion failed");

            String currentStatus = manageCards.verifyIfCardVirtual_QRBC();
            String virtual = "8881";

            Assert.assertTrue(manageCards.showCard_verifyContentPerTier_QR(),
                    "Show card - QR SMAC Start is expected. Assertion failed");

            Assert.assertNotEquals(currentStatus, virtual,
                    "Logged in account is Virtual. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Show Card - QR is displayed - SMAC")
    public void showCardQRIsDisplayed() {
        try {
            Assert.assertTrue(manageCards.isShowCard_QR_Visible(),
                    "Show Card - QR is NOT visible. Assertion failed");

            Assert.assertTrue(manageCards.isShowCard_QR_selected(),
                    "QR tab is expected to be selected. Assertion failed");

            Assert.assertFalse(manageCards.isShowCard_Barcode_selected(),
                    "Barcode tab is NOT expected to be selected. Assertion failed");

            String currentStatus = manageCards.verifyIfCardVirtual_QRBC();
            String virtual = "8881";

            Assert.assertTrue(manageCards.showCard_verifyContentPerTier_QR(),
                    "Show card - QR SMAC Blue is expected. Assertion failed");

            Assert.assertNotEquals(currentStatus, virtual,
                    "Logged in account is Virtual. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Show Card - QR is visible - Prestige")
    public void showCardQRIsDisplayed_Prestige() {
        try {
            Assert.assertTrue(manageCards.isShowCard_QR_Visible(),
                    "Show Card - QR is NOT visible. Assertion failed");

            Assert.assertTrue(manageCards.isShowCard_QR_selected(),
                    "QR tab is expected to be selected. Assertion failed");

            Assert.assertFalse(manageCards.isShowCard_Barcode_selected(),
                    "Barcode tab is NOT expected to be selected. Assertion failed");

            String currentStatus = manageCards.verifyIfCardVirtual_QRBC();
            String virtual = "8881";

            Assert.assertTrue(manageCards.showCard_verifyContentPerTier_QR(),
                    "Show card - QR SMAC Prestige is expected. Assertion failed");

            Assert.assertNotEquals(currentStatus, virtual,
                    "Logged in account is Virtual. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the Link card button")
    public void theUserClicksOnTheGotAnExistingSMACButton() {
        try {
            manageCards.clickLinkCardBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks on Show card - Barcode")
    public void clicksOnShowCardBarcode() {
        try {
            manageCards.clickShowCard_Barcode();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Show Card - Barcode is visible")
    public void showCardBarcodeIsDisplayedNotLinked() {
        try {
            Assert.assertTrue(manageCards.showCard_verifyContentPerTier_BC("SMAC Prestige"),
                    "Show card - BC Prestige is expected. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the Linked cards counter is accurate")
    public void verifyTheLinkedCardsCounterIsAccurate() {
        try {
            cardCount = manageCards.countVisibleCards();

            Assert.assertTrue(manageCards.linkedCardCount(),
                    "Card count does not matched with card link. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the card number from QR screen matches with the linked physical card")
    public void theCardNumberFromQRScreenMatchesWithTheLinkedPhysicalCardPrestige() {
        try {
            if(manageCards.isShowCard_QR_Visible()){
                String cnFromShowCard = manageCards.cleanCardNumber_ShowCard_QR();

                Assert.assertEquals(cleanCNFromMainCard, cnFromShowCard,
                        "Cards numbers NOT matched. Assertion failed");

            } else {
                Assert.fail("Show card QR is not visible. Unable to perform ");
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to Promoted prestige card")
    public void swipedToPromotedPrestigeCard() {
        try {
            String cleanCN = TestDataManager.getCardNumberFromAccount("Maddy Perez", "TBCPrestige");
            String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cleanCN, " ");

            manageCards.swipeUntilCardVisible(CNwithDelimiter);

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("swiped to BBL prestige card")
    public void swipedToBBLPrestigeCard() {
        try {
            manageCards.swipeUntilCardVisible("8880 0029 6125 7367");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to expired card")
    public void swipedToExpiredCard() {
        try {
            String cleanCN = TestDataManager.getCardNumberFromAccount("Olivia Rodrigo", "Expired");
            String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cleanCN, " ");
            System.out.println(CNwithDelimiter);
            manageCards.swipeUntilCardVisible(CNwithDelimiter);
            //manageCards.swipeUntilCardVisible("8880 0029 6125 7428");

            Assert.assertTrue(manageCards.isCardExpired(),
                    "This card is NOT an expired prestige. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to blocked card")
    public void swipedToBlockedCard() {
        try {
            String cleanCN = TestDataManager.getCardNumberFromAccount("Sabrina Carpenter", "Blocked");
            String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cleanCN, " ");
            manageCards.swipeUntilCardVisible(CNwithDelimiter);

            Assert.assertTrue(manageCards.isCardExpired(),
                    "This card is NOT blocked. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to {string}")
    public void swipedToPrestigeCardWithAStatus(String cardType) {
        try {
            String cleanCN = TestDataManager.getCardNumberFromAccount("Sabrina Carpenter", cardType);
            String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cleanCN, " ");

            manageCards.swipeUntilCardVisible(CNwithDelimiter);

            System.out.println("✅ swiped to " + cardType);
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to LYBC card")
    public void swipedToLYBCCard() {
        try {
            String cleanCN = TestDataManager.getCardNumberFromAccount("Sabrina Carpenter", "LYBC");
            String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cleanCN, " ");

            manageCards.swipeUntilCardVisible(CNwithDelimiter);

            Thread.sleep(2000);
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to TK card")
    public void swipedToTKCard() {
        try {
            manageCards.swipeUntilCardVisible("8880 1888 3267 7873");

            Assert.assertTrue(manageCards.isCardExpired(),
                    "This card is NOT TK. Assertion failed");

            Thread.sleep(2000);
            System.out.println("✅ swiped to expired prestige card");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to {string} card")
    public void swipedToCard(String cardType) {
        try {
            switch (cardType) {
                case "MOM":
                    String cleanCN = TestDataManager.getCardNumberFromAccount("Olivia Rodrigo", "MOM");
                    String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cleanCN, " ");
                    manageCards.swipeUntilCardVisible(CNwithDelimiter);
                    break;

                case "Start":
                    manageCards.swipeUntilCardVisible("SMAC Start");

                    String cn = manageCards.extractMC_CN();
                    testContext.setCardNum(cn);

                    break;

            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to ACE card")
    public void swipedToACECard() {
        try {
            String cleanCN = TestDataManager.getCardNumberFromAccount("Maddy Perez", "ACE");
            String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cleanCN, " ");
            manageCards.swipeUntilCardVisible(CNwithDelimiter);

            Assert.assertTrue(manageCards.isCardExpired(),
                    "This card is NOT ACE. Assertion failed");

            Thread.sleep(2000);
            System.out.println("✅ swiped to expired prestige card");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to BDO MC card")
    public void swipedToBDOMCCard() {
        try {
            String cleanCN = TestDataManager.getCardNumberFromAccount("Sabrina Carpenter", "BDOMC");
            String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cleanCN, " ");
            manageCards.swipeUntilCardVisible(CNwithDelimiter);
            //manageCards.swipeUntilCardVisible("8880 5125 3589 7551");

            Assert.assertTrue(manageCards.isCardExpired(),
                    "This card is NOT BDO MC. Assertion failed");

            Thread.sleep(2000);
            System.out.println("✅ swiped to expired prestige card");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Claim Prestige button overlay is visible")
    public void claimPrestigeButtonOverlayIsDisplayed() {
        try {
            Assert.assertTrue(manageCards.isClaimPrestigeOverlayDisplayed(),
                    "Claim Prestige button overlay is not displayed. Assertion failed");

            System.out.println("✅ Claim Prestige button overlay is displayed");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Claim Prestige button overlay is not visible")
    public void claimPrestigeButtonOverlayIsNotDisplayed() {
        try {
            Assert.assertFalse(manageCards.isClaimPrestigeOverlayDisplayed(),
                    "Claim Prestige button overlay is displayed. Assertion failed");

            System.out.println("✅ Claim Prestige button overlay is not displayed");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user clicks the Claim Prestige button")
    public void ClicksOnClaimPrestigeButton() {
        try {
            manageCards.clickClaimPrestige();

            System.out.println("✅ clicks on Claim Prestige button");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("clicks on Prestige Unlock - Back button")
    public void ClicksOnPrestigeUnlockBackBtn() {
        try {
            manageCards.clickPrestigeUnlock_Back();

            System.out.println("✅ clicks on Claim Prestige button");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Prestige Unlocked popup modal is visible")
    public void prestigeUnlockedPopupModalIsVisible() {
        try {
            Assert.assertTrue(manageCards.isClaimPrestigeModalVisible(),
                    "Prestige Unlocked modal is NOT displayed. Assertion failed");

            System.out.println("✅ Prestige Unlocked popup modal is visible");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Prestige Unlocked popup modal is not visible")
    public void prestigeUnlockedPopupModalIsNotVisible() {
        try {
            Assert.assertFalse(manageCards.isClaimPrestigeModalVisible(),
                    "Prestige Unlocked modal is displayed. Assertion failed");

            System.out.println("✅ Prestige Unlocked popup modal is visible");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("block card button is changed to Your card is blocked")
    public void blockCardButtonIsChangedToYourCardIsBlocked() {
        try {
            String actualPlaceholder = manageCards.verifyBlockButtonChangedPlaceholder();
            String expectedPlaceholder = "Your card is blocked";
            System.out.println("Expected value: " + expectedPlaceholder);

            Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                    "\"Your card is blocked\" is NOT displayed. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes down")
    public void swipedDown() {
        try {
            manageCards.scrollDown();

            System.out.println("✅ swiped down");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Show card - QR is hidden")
    public void showCardQRIsHidden() {
        try {
            Assert.assertFalse(manageCards.isShowCard_QR_Visible(),
                    "Show Card - QR is still visible. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks outside the modal")
    public void clicksOutsideTheModal() {
        try {
            manageCards.clickOutsideTheModal();

            System.out.println("✅ clicks outside the modal");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("clicks on the info icon")
    public void theUserClicksOnTheInfoIcon() {
        try {
            manageCards.clickInfoIcon();

            System.out.println("✅ clicks on the info icon");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("{string} card is displayed")
    public void cardIsDisplayed(String tier) {
        try {
            manageCards.clickInfoIcon();

            System.out.println("✅ clicks on the info icon");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the card logo is {string}")
    public void theCardLogoIs(String cardType) {
        try{
            String extractedCard = manageCards.getCardTypeImage();

            Assert.assertEquals(extractedCard, cardType, "The card logo is NOT " + cardType);

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the card type is {string}")
    public void theCardTypeIs(String cardType) {
        try {
            String extractedCard = manageCards.getCardType();

            Assert.assertEquals(extractedCard, cardType, "The card type is NOT " + cardType);
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the card is displayed")
    public void theCardIsDisplayed() {
        try {
           Assert.assertTrue(manageCards.isCardContentVisible(),
                   "The card is NOT displayed. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
}