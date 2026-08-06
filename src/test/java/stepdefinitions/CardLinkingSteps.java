package stepdefinitions;

import hooks.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;
import util.*;
import java.util.Map;

public class CardLinkingSteps {

    private final CardLinkingPage cardLink = Hooks.getPageManager().getCardLinkingPage();
    private final ManageCardsPage manageCardsPage = Hooks.getPageManager().getManageCardsPage();
    private TestContext testContext;

    public CardLinkingSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    String HouseNum = "Purok 3";
    String prov = "ALBAY";
    String city = "DARAGA (LOCSIN)";
    String brgy = "ALCALA";
    String postalCode = "2110";
    Map<String, String> cardNumber;
    String cnString;
    String cleanCNFromMainCard;
    String cardNumberTD;
    String correctOTP = "000000";
    String incorrectOTP = "123456";

    @Then("the user is on the card linking page")
    public void theUserIsOnTheCardLinkingPage() {
        try {
            Assert.assertTrue(cardLink.isCardLinkingVisible(),
                    "Card Linking screen is expected. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("Link your Card button is {string}")
    public void linkYourCardButtonAttr(String state) {
        try {
            switch (state) {
                case "enabled":
                    Assert.assertTrue(cardLink.isLinkYourCardBtnEnabled2(),
                            "Loyalty Card button is expected to be enabled. Assertion failed");
                    break;

                case "disabled":
                    Assert.assertFalse(cardLink.isLinkYourCardBtnEnabled(),
                            "Loyalty Card button is expected to be disabled. Assertion failed");
                    break;

                default:
                    Assert.fail("❌ Unknown state: " + state);
            }
        } catch (Exception e) {
            Assert.fail("❌Test failed due to exception.", e);
        }
    }

    @Then("a text container is visible")
    public void aTextContainerIsVisible() {
        try {
            Assert.assertTrue(cardLink.isMOMTextAttributeVisible(),
                    "MOM Text Attribute is expected to be visible. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

//    @When("the user enters a valid BA MOM card number")
//    public void theUserEntersALinkableMOM() {
//        try {
//            Map<String, String> cardNumber = TestDataManager.MOM_getUnusedCardNumber("AR", "", "false", false);
//            String cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv
//
//            cardLink.enterCardNumber(cardNumberTD);
//        } catch (Exception e) {
//            Assert.fail("❌ Test failed due to exception.", e);
//        }
//    }

//    @When("the user is redirected to card linking page")
//    public void theUserIsRedirectedToCardLinkingPage() {
//        try {
//            ssoPage.clickSSOLoginBtn();
//            loginPage.SuccessfulLogin("09244418164", "Temp1234!!");
//            homePage.isHomepageDisplayed();
//            homePage.clickManageCards();
//            manageCardsPage.isManageCardPageVisible_General();
////            manageCardsPage.clickLinkAnExistingSmacButton();
////            theUserIsOnTheCardLinkingPage();
//
//        } catch (Exception e) {
//            Assert.fail("❌ Test failed due to exception.", e);
//        }
//    }

    @And("the user clicks on Link Your Card")
    public void theUserClicksOnLinkYourCard() {
        try {
            cardLink.clickLinkYourCardBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters the correct OTP")
    public void theUserEntersTheCorrectOTP() {
        try {
            cardLink.enterOTP(correctOTP);

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters an incorrect OTP")
    public void theUserEntersAnIncorrectOTP() {
        try {
            cardLink.enterOTP(incorrectOTP);

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user is redirected to OTP Verification")
    public void theUserIsRedirectedToOTPVerification() {
        try {
            Assert.assertTrue(cardLink.isOTPVerificationVisible(),
                    "OTP Verification is expected to be visible. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("OTP Verification is not Displayed")
    public void OTPVerificationIsNotDisplayed() {
        try {
            Assert.assertFalse(cardLink.isOTPVerificationVisible(),
                    "OTP Verification is expected to be visible. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on the MOM Registration Form - {string} - {string}")
    public void momRegistrationFormIsDisplayedProperly(String link, String sce) {
        try {
            switch (sce) {
                case "MOM card":
                    TestDataManager.writeBack(cardNumberTD, sce, "false", true);
                    testContext.setNOC(cardNumberTD);
                    break;

                case "MOM":
                    TestDataManager.writeBack(cardNumberTD, sce, "false", true);
                    testContext.setNOC(cardNumberTD);
                    break;

                default:
                    Assert.fail("❌ Unknown sce" + sce);

            }

            switch (link) {
                case "Initial link":
                    Assert.assertTrue(cardLink.isMOMFormDisplayed(),
                            "MOM Registration Form is expected to be displayed. Assertion failed");

                    Assert.assertTrue(cardLink.isAddressSectionVisible(),
                            "Address Section is expected to be displayed. Assertion failed");

                    Assert.assertTrue(cardLink.isPregnancyDetailsSectionVisible(),
                            "Pregnancy Details Section is expected to be displayed. Assertion failed");

                    Assert.assertTrue(cardLink.isProceedButtonVisible(),
                            "Proceed Button is expected to be displayed. Assertion failed");

                    break;

                case "Subsequent link":
                    Assert.assertTrue(cardLink.isMOMFormDisplayed(),
                            "MOM Registration Form is expected to be displayed. Assertion failed");
                    break;

                default:
                    Assert.fail("❌ Unknown link: " + link);
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks the MOM - Continue button")
    public void theUserClicksOnMOMContinueButton() {
        try {
            cardLink.clickMOMContinueButton();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("MOM Registration - Address section is displayed properly")
    public void momRegistrationAddressSectionIsDisplayedProperly() {
        try {
            Assert.assertTrue(cardLink.isAddressSectionVisible(),
                    "Address Section is expected to be visible. Assertion failed");

//            cardLink.select_Addr_Province();
//
//            Assert.assertTrue(cardLink.isCityVisible(),
//                    "City is expected to be visible. Assertion failed");
//
//            cardLink.select_Addr_City();
//
//            Assert.assertTrue(cardLink.isBrgyVisible(),
//                    "Brgy is expected to be visible. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters an alphanumeric house number")
    public void theUserEntersAnAlphanumericHouseNumber() {
        try {
            cardLink.Enter_Addr_HouseNumber(HouseNum);

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the House number input is accepted")
    public void theHouseNumberInputIsAccepted() {
        try {
            String expectedHouseNum = cardLink.getHouseNum();
            testContext.setHouseNum(expectedHouseNum);

            Assert.assertEquals(HouseNum, expectedHouseNum,
                    "Input is not equal to expected value. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user selects a Province from the dropdown")
    public void theUserSelectsAProvinceFromTheDropdown() {
        try {
            cardLink.select_Addr_Province();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the selected Province is displayed")
    public void theSelectedProvinceIsDisplayed() {
        try {
            String actualProvince = cardLink.getProvince();

            Assert.assertEquals(actualProvince, prov,
                    "Input is not equal to expected value. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user selects a City from the dropdown")
    public void theUserSelectsACityFromTheDropdown() {
        try {
            cardLink.select_Addr_City();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the selected City is displayed")
    public void theSelectedCityIsDisplayed() {
        try {
            String actualCity = cardLink.getCity();

            Assert.assertEquals(actualCity, city,
                    "Input is not equal to expected value. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user selects a Barangay from the dropdown")
    public void theUserSelectsABarangayFromTheDropdown() {
        try {
            cardLink.select_Addr_Brgy();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the selected Barangay is displayed")
    public void theSelectedBarangayIsDisplayed() {
        try {
            String actualBrgy = cardLink.getBrgy();

            Assert.assertEquals(actualBrgy, brgy,
                    "Input is not equal to expected value. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters a numeric input via Postal code")
    public void theUserEntersANumericInputViaPostalCode() {
        try {
            cardLink.Enter_Addr_PostalCode(postalCode);

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the Postal code input is accepted")
    public void thePostalCodeInputIsAccepted() {
        try {
            String actualPostalCode = cardLink.getPostalCode();
            Assert.assertEquals(actualPostalCode, postalCode,
                    "Input is not equal to expected value. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user scroll to Attribute section")
    public void theUserScrollToAttributeSection() {
        try {
            cardLink.scrollToProceedButton();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("MOM Registration - Attribute section is displayed properly")
    public void momRegistrationAttributeSectionIsDisplayedProperly() {
        try {
            cardLink.click_PregDet_Yes();

            Assert.assertTrue(cardLink.isPregnancyStageVisible(),
                    "Element is expected to be displayed. Assertion failed");

            cardLink.select_PregnancyStage();

            cardLink.enterKidsCount("2");

            cardLink.clickOuterScreen();

            Assert.assertTrue(cardLink.isChildrenAgeVisible(),
                    "Children age field is expected to be displayed. Assertion failed");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks on Yes button")
    public void theUserClicksOnYesButton() {
        try {
            cardLink.click_PregDet_Yes();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks on No button")
    public void theUserClicksOnNoButton() {
        try {
            cardLink.click_PregDet_No();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Pregnancy stage dropdown is {string}")
    public void pregnancyStageDropdownIsHidden(String status) {
        try {
            if(status.equals("hidden")) {
                Assert.assertFalse(cardLink.isPregnancyStageVisible(),
                        "Element is NOT expected. Assertion failed");
            } else if(status.equals("shown")) {
                Assert.assertTrue(cardLink.isPregnancyStageVisible(),
                        "Element is expected to be visible. Assertion failed");
            } else {
                Assert.fail("❌ Test failed due to exception.");
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

//    @Then("Pregnancy stage dropdown is shown")
//    public void pregnancyStageDropdownIsShown() {
//        try {
//
//
//        } catch (Exception e) {
//            Assert.fail("❌ Test failed due to exception.", e);
//        }
//    }

    @When("the user selects a pregnancy stage from the dropdown")
    public void theUserSelectsAPregnancyStageFromTheDropdown() {
        try {
            cardLink.select_PregnancyStage();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the selected pregnancy stage is displayed")
    public void theSelectedPregnancyStageIsDisplayed() {
        try {
            String actualPregStage = cardLink.getPregStage_2ndTri();

            Assert.assertEquals(actualPregStage, "2nd Trimester");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Children ages field is {string}")
    public void childrenAgesFieldIsHidden(String status) {
        try {
            if(status.equals("hidden")) {
                Assert.assertFalse(cardLink.isChildrenAgeVisible(),
                        "Element is NOT expected. Assertion failed");
            } else if(status.equals("shown")) {
                Assert.assertTrue(cardLink.isChildrenAgeVisible(),
                        "Element is expected to be visible. Assertion failed");
            } else {
                Assert.fail("❌ Test failed due to exception.");
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters {string} on Number of kids field")
    public void theUserEntersOnNumberOfKidsField(String value) {
        try {
            cardLink.enterKidsCount(value);

            cardLink.clickOuterScreen();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters {string} on Children ages field")
    public void theUserEntersOnChildrenAgesField(String value) {
        try {
            cardLink.enterKidsAge(value);

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the entered children {string} is displayed")
    public void theEnteredkidAgeIsDisplayed(String age) {
        try {
            if(age.equals("age")) {
                String actualAge = cardLink.getAge();

                Assert.assertEquals(actualAge, "15");
            } else if(age.equals("ages")) {
                String actualAges = cardLink.getAges();

                Assert.assertEquals(actualAges, "15,3");
            } else {
                Assert.fail("❌ Test failed due to exception.");
            }
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the entered children age is displayed")
    public void theEnteredChildrenAgeIsDisplayed() {
        try {
            String actualAges = cardLink.getAges();

            Assert.assertEquals(actualAges, "15,3");
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters a valid input for Address section")
    public void theUserEntersAValidInputForAddressSection() {
        try {
            cardLink.Valid_fillInAddressSection();
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user scrolls to Proceed button")
    public void theUserScrollsToProceedButton() {
        try {
            cardLink.scrollToProceedButton();
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user enters a valid input for Attributes section")
    public void theUserEntersAValidInputForAttributesSection() {
        try {
            cardLink.Valid_fillInPregDetSection();
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("View activation instructions button is visible")
    public void viewActivationInstructionsButtonIsVisible() {
        try {
            Assert.assertTrue(cardLink.isActivationInstructionsBtnVisible(),
                    "Activation Instructions button is expected. Assertion failed.");
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks on info icon View Activation Instructions")
    public void theUserClicksOnInfoIconViewActivationInstructions() {
        try {
            cardLink.clickActivationInstructionsBtn();
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user clicks on Activation Instructions - Close")
    public void theUserClicksOnActivationInstructionsClose() {
        try {
            cardLink.clickActivationInstructionsCloseBtn();
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters any {string} {string} with {string} 90 days expiry")
    public void theUserEntersAnyWithDaysExpiry(String cardStatus, String cardType, String conditionals) {
        switch (conditionals) {
            case "more than":
                switch (cardStatus) {
                    case "IIPS":
                        switch (cardType) {
                            case "SLP":
                                try {
                                    Map<String, String> cardNumber = TestDataManager.TK_getUnusedCardNumber("IIPS", ">90", "false", false);
                                    String cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                                    cardLink.enterCardNumber(cardNumberTD);
                                } catch (Exception e) {
                                    Assert.fail("❌ Test failed due to exception.", e);
                                }

                            case "SMAC":
                                try {
                                    Map<String, String> cardNumber = TestDataManager.SMAC_Reg_getUnusedCardNumber("IIPS", ">90", "false", false);
                                    String cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                                    cardLink.enterCardNumber(cardNumberTD);
                                } catch (Exception e) {
                                    Assert.fail("❌ Test failed due to exception.", e);
                                }

                            case "SMAC Prestige":
                                try {
                                    Map<String, String> cardNumber = TestDataManager.SMAC_Prestige_getUnusedCardNumber("IIP", ">90", "false", false);
                                    String cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                                    cardLink.enterCardNumber(cardNumberTD);
                                } catch (Exception e) {
                                    Assert.fail("❌ Test failed due to exception.", e);
                                }
                        default:
                            Assert.fail("❌ Unknown card type: " + cardType);}
                default:
                    Assert.fail("❌ Unknown card status: " + cardStatus);
                }
        default:
            Assert.fail("❌ Unknown conditionals: " + conditionals);
        }
    }

//    @When("the user is on OTP screen")
//    public void theUserIsOnOTPScreen() {
//        try {
//            cardLink.isOTPVerificationVisible();
//        } catch (Exception e) {
//            Assert.fail("❌ Test failed. See above logs." + e.getMessage());
//        }
//    }

    @Then("Card linking splash screen is displayed")
    public void cardLinkingSplashScreenIsDisplayed() {
        try {
            Assert.assertTrue(cardLink.isCardLinkingLoaderVisible(),
                    "Card linking splash screen is NOT displayed. Assertion failed.");
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("Card Linking Success screen is displayed - {string}")
    public void cardLinkingSuccessScreenIsDisplayed(String cardType) {
        try {
            switch (cardType) {
                case "MOM - Retain Name":
                case "MOM - Inherit Name":
                    break;

                case "Start":
                case "SMAC":
                case "Prestige":
                case "ACE":
                case "LYBC":
                case "TK":
                case "Start - Inherit Name":
                case "Start - Retain Name":
                case "SMAC - Inherit Name":
                case "SMAC - Retain Name":
                case "SMAC Prestige - Inherit Name":
                case "SMAC Prestige - Retain Name":
                case "ACE Rewards - Inherit Name":
                case "ACE Rewards - Retain Name":
                case "LYBC Express -  Inherit Name":
                case "LYBC Express - Retain Name":
                case "TK - Inherit Name":
                case "TK - Retain Name":

                    Assert.assertTrue(cardLink.isSuccessCardLinkVisible(),
                            "Successful Card linking screen is NOT displayed. Assertion failed.");

                    TestDataManager.writeBack(cardNumberTD, cardType, "false", true);
                    testContext.setNOC(cardNumberTD);
                    break;

                    default:
                        Assert.fail("Unknown card type: " + cardType);
            }
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user enters a {string} {string} {string} card number")
    public void theUserEntersACardNumber(String cardStatus, String cardType, String code) {
        try {
            switch (cardType) {
                case "Start":
                    cardNumber = TestDataManager.Start_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv
                    testContext.setNOC(cardNumberTD);

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "SMAC Start":
                case "SMAC Regular":
                case "SMAC Prestige":
                case "ACE Rewards":
                case "Love Your Body Card":
                case "Toy Kingdom":
                case "MOM card":

                        cardNumber = TestDataManager.TC_With_Names_getUnusedCardNumber(cardStatus, cardType, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "SMAC":
                    cardNumber = TestDataManager.SMAC_Reg_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "Prestige":
                    cardNumber = TestDataManager.SMAC_Prestige_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "BDO MC":
                    cardNumber = TestDataManager.SMAC_Reg_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                    //SLP
                case "ACE":
                    cardNumber = TestDataManager.ACE_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "LYBC":
                    cardNumber = TestDataManager.LYBC_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "MOM":
                    cardNumber = TestDataManager.MOM_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "TK":
                    cardNumber = TestDataManager.TK_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "SM Pride":
                    cardNumber = TestDataManager.SMPride_getUnusedCardNumber(cardStatus, code, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                default:
                    Assert.fail("❌ Unknown card type: " + cardType);

            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to newly-{string} card")
    public void TheUserSwipesToNewlyLinkedCard(String sce) {
        try {
            switch (sce){
                case "linked":
                case "blocked":
                    String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cardNumberTD, " ");

                    manageCardsPage.swipeUntilCardVisible(CNwithDelimiter);

                    System.out.println("✅ swiped to " + CNwithDelimiter);
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user swipes to newly-{string} {string} card")
    public void TheUserSwipesToNewlyLinkedSpecificCard(String sce, String cardType) {
        try {
            String cn = testContext.getCardNum();

            switch (sce){
                case "linked":
                case "blocked":

                    String CNwithDelimiter = CardComponent.addDelimiterToCardNumber(cn, " ");

                    manageCardsPage.swipeUntilCardVisible(CNwithDelimiter);

                    System.out.println("✅ swiped to " + CNwithDelimiter);
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the newly-{string} card is displayed")
    public void theNewlyCardIsDisplayed(String sce) {
        try {
            switch (sce){
                case "linked":
                case "blocked":

                    cleanCNFromMainCard = manageCardsPage.cleanCardNumber(" ");

                    Assert.assertEquals(cleanCNFromMainCard, cardNumberTD,
                            "Cards numbers NOT matched. Assertion failed");

                    System.out.println("Clean cn (Main Card): " +  cleanCNFromMainCard + "\nLinked card: " + cardNumberTD);
                    break;

                default:
                    Assert.fail("❌ Unknown scenario: " + sce);
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("Link voucher modal is displayed")
    public void linkVoucherModalIsDisplayed() {
        try {
            Assert.assertTrue(cardLink.isLinkVoucherModalVisible(),
                    "Link voucher modal is NOT displayed. Assertion failed.");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks on Link Card Voucher modal - Close")
    public void theUserClicksOnLinkCardVoucherModalClose() {
        try {
            cardLink.clickLinkCardVoucherCloseBtn();
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks on Card Linking Success screen - Back to Home")
    public void theUserClicksOnCardLinkingSuccessScreenBackToHome() {
        try {
            cardLink.clickCardLinkingSuccessBackToHome();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters a {string} card")
    public void theUserEntersACard(String note) {
        try {
            switch (note) {
                case "Blocked":
                case "BBL":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("BBL", "888", "lostCardSMAC", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "already linked": //SMAC Reg
                    cardNumber = TestDataManager.SMAC_Reg_getUnusedCardNumber("BA", "877", "true", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "BA or AR SMAC card without mobile":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("AR", "888", "withoutMobNum", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "nonexistent":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("", "", "nonexistent", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber");  //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "BA or AR with updated card number (pending approval) SMAC":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("AR", "888", "pendingInOLS", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "IIP with more than 90 days expiry Prestige":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("IIP", "004", "expiredPrestige>90", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "IIPS with more than 90 days expiry SMAC":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("IIPS", "878", "GT90daysExpirySMACReg", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "IIP with more than 90 days expiry MOM":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("IIPS", "352", "expiredMOM>90", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "IIP with more than 90 days expiry TK":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("IIPS", "188", "expiredTK>90", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "IIP with more than 90 days expiry ACE":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("IIPS", "505", "expiredACE>90", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "IIP with more than 90 days expiry LYBC":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("IIPS", "404", "expiredLYBC>90", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "registered invalid mobile number":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("AR", "888", "invalidMobNum", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                case "SMAC with pending points-related transaction":
                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("AR", "888", "pendingPointsInOLS", "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

                default:
                    Assert.fail("❌ Unknown scenario: " + note);
            }
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("an error message will {string} - {string}")
    public void anErrorMessageWillAppear(String visibility, String errorType){
        try {
            if (visibility.equals("appear")) {
                switch (errorType) {
                    case "Incorrect OTP":
                        Assert.assertTrue(cardLink.isOTPCorrect(),
                                "Error message - Incorrect OTP is expected. Assertion failed.");
                        break;

                    case "Blocked":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_blockedCard(),
                                "Error message - Blocked card is expected. Assertion failed.");
                        break;

                    case "Card already associated":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_CardAlreadyAssoc(),
                                "Error message - Card already associated is expected. Assertion failed.");
                        break;

                    case "Card not Activated":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_CardNotActivated(),
                                "Error message - Card Not Activated is expected. Assertion failed.");
                        break;

                    case "nonexistent":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_InvalidCardNumber(),
                                "Error message - Invalid card is expected. Assertion failed.");
                        break;

                    case "Expired":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_expiredCardMoreThan90Days(),
                                "Error message - Expired card is expected. Assertion failed.");
                        break;

                    case "Not eligible":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_NotEligible(),
                                "Error message - Not eligible is expected. Assertion failed.");
                        break;

                    case "Mobile number associated":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_MobNumIssue(),
                                "Error message - Mobile number issue is expected. Assertion failed.");
                        break;

                    case "Unable to link":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_MobNumIssue(),
                                "Error message - Mobile number issue is expected. Assertion failed.");
                        break;

                    case "SMAC Prestige upgrade":
                        Assert.assertTrue(cardLink.isVisible_ErrMsg_PrestigeUpgrade());
                        break;

                    default:
                        Assert.fail("❌ Unknown error type: " + errorType);
                }
            } else if (visibility.equals("not appear")) {
                switch (errorType) {
                    case "Incorrect OTP":
                        Assert.assertFalse(cardLink.isOTPCorrect(),
                                "Error message - Incorrect OTP is expected. Assertion failed.");
                        break;

                    case "Blocked":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_blockedCard(),
                                "Error message - Blocked card is expected. Assertion failed.");
                        break;

                    case "Card already associated":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_CardAlreadyAssoc(),
                                "Error message - Card already associated is expected. Assertion failed.");
                        break;

                    case "Card not Activated":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_CardNotActivated(),
                                "Error message - Card Not Activated is expected. Assertion failed.");
                        break;

                    case "nonexistent":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_InvalidCardNumber(),
                                "Error message - Invalid card is expected. Assertion failed.");
                        break;

                    case "Expired":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_expiredCardMoreThan90Days(),
                                "Error message - Expired card is expected. Assertion failed.");
                        break;

                    case "Not eligible":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_NotEligible(),
                                "Error message - Not eligible is expected. Assertion failed.");
                        break;

                    case "Mobile number associated":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_MobNumIssue(),
                                "Error message - Mobile number issue is expected. Assertion failed.");
                        break;

                    case "Unable to link":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_MobNumIssue(),
                                "Error message - Mobile number issue is expected. Assertion failed.");
                        break;

                    case "SMAC Prestige upgrade":
                        Assert.assertFalse(cardLink.isVisible_ErrMsg_PrestigeUpgrade());
                        break;

                    default:
                        Assert.fail("❌ Unknown error type: " + errorType);
                }
            } else {
                Assert.fail("Unknown visibility: " + visibility);
            }
            

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters a {string} {string} card")
    public void theUserEntersACard(String notes, String code) {
        try{
            switch (notes){
                case "Primo":
                case "SMAC":
                case "Crate and Barrel":
                case "Supplies Station":
                case "Miniso Wink Rewards":
                case "SM Hotels":
                case "BDOR Emerald":
                case "BDOR Ruby":
                case "BDOR Sapphire":
                case "BDOR Diamond":
                        cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("AR", code, notes, "false", false);
                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv

                    cardLink.enterCardNumber(cardNumberTD);
                    break;

//                case "SMAC":
//                    cardNumber = TestDataManager.Unlinkables_getUnusedCardNumber("AR", code, notes, "false", false);
//                    cardNumberTD = cardNumber.get("CardNumber"); //get from CardNumber column of csv
//
//                    cardLink.enterCardNumber(cardNumberTD);
//                    break;

                default:
                   Assert.fail("❌ Unknown note: " + notes);
            }
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the cardholder name {string} the name {string}")
    public void theCardholderNameInheritsTheNameFromTheParentCard(String behaviour, String where) {
        try{
            String actualNameOnCard = manageCardsPage.getActualNameOnCard();
            String ChildNameOnCard = cardLink.getNameOnCard(cardNumberTD);
            String accountName = testContext.getAccountName();

            System.out.println("Actual NOC: " + actualNameOnCard +
                    "\nChild NOC: " + ChildNameOnCard +
                    "\nAccount Name: " + accountName);

            switch (behaviour) {
                case "inherits":
                    System.out.println("Behaviour: "+ behaviour +"\nDisplay Name: " + actualNameOnCard + "\nExpected: " + accountName);
                    Assert.assertNotEquals(ChildNameOnCard, actualNameOnCard,
                            "Name on the linked card should match the logged-in account's name. Assertion failed.");

                    Assert.assertEquals(accountName, actualNameOnCard,
                            "Name on card is not matched with logged-in account's name. Assertion failed.");
                    break;

                case "retains":
                    System.out.println("Behaviour: "+ behaviour +"\nDisplay Name: " + actualNameOnCard + "\nExpected: " + ChildNameOnCard);
                    Assert.assertEquals(ChildNameOnCard, actualNameOnCard,
                            "Name on the linked card should match the card's name. Assertion failed.");

                    Assert.assertNotEquals(accountName, actualNameOnCard,
                            "Name on card is should not matched with logged-in account's name. Assertion failed.");
                    break;
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("Activation instructions modal is {string}")
    public void activationInstructionsModalIsVisible(String visibility) {
        try{
            if(visibility.equals("visible")) {
                Assert.assertTrue(cardLink.isActivationInstructionsModalVisible(),
                        "Activation instructions modal is not visible. Assertion failed.");
            } else if(visibility.equals("not visible")) {
                Assert.assertFalse(cardLink.isActivationInstructionsModalVisible(),
                        "Activation instructions modal should not be visible. Assertion failed.");
            } else {
                Assert.fail("Incorrect visibility: " + visibility);
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the Proceed button is {string}")
    public void theProceedButtonIs(String state) {
        try{
            switch (state) {
                case "enabled":
                    Assert.assertTrue(cardLink.isProceedBtnEnabled_MOM(),
                            "Proceed button is not enabled. Assertion failed.");
                    break;

                case "disabled":
                    Assert.assertFalse(cardLink.isProceedBtnEnabled_MOM(),
                            "Proceed button is not disabled. Assertion failed.");
                    break;

                default:
                    Assert.fail("Unknown state: " + state);
            }
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks on Proceed button")
    public void theUserClicksOnProceedButton() {
        try{
            cardLink.clickProceedBtn_MOM();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("MOM - Thank You page is displayed")
    public void momThankYouPageIsDisplayed() {
        try{
            if(cardLink.isThankYouPageVisible_MOM()){
                Assert.assertTrue(cardLink.isThankYouPageVisible_MOM(),
                        "MOM - Thank You page - Voucher is not displayed. Assertion failed.");
            } else if(cardLink.isThankYouPageVisible_MOM_NonVoucher()) {
                Assert.assertTrue(cardLink.isThankYouPageVisible_MOM(),
                        "MOM - Thank You page - Non-voucher is not displayed. Assertion failed.");
            } else {
                Assert.fail("MOM - Thank You page is not displayed.");
            }

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks the MOM - View Voucher")
    public void theUserClicksTheMOMViewVoucher() {
        try{
            cardLink.clickMOM_View_Voucher();
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("MOM Continue button is {string}")
    public void momContinueButtonIs(String sce) {
        try{
            switch (sce) {
                case "not visible":
                    Assert.assertFalse(cardLink.isMOMContinueBtnVisible(),
                            "MOM Continue button is visible. Assertion failed.");
                    break;

                case "visible":
                    Assert.assertTrue(cardLink.isMOMContinueBtnVisible(),
                            "MOM Continue button is NOT visible. Assertion failed.");
                    break;

                default:
                    Assert.fail("Unknown scenario: " + sce);
            }
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks Back navigation")
    public void theUserClicksBackNavigation() {
        try{
            cardLink.navigateBack();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the Incomplete MOM Form submission modal is visible")
    public void theIncompeleteMOMFormSubmissionModalIsVisible() {
        try{
            Assert.assertTrue(cardLink.isMOMFormIncompleteModalVisible(),
                    "Incomplete MOM Form submission modal is not visible. Assertion failed.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the user clicks on Leave Page")
    public void theUserClicksOnLeavePage() {
        try{
            cardLink.clickMOM_inc_Leave_Page();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
}
