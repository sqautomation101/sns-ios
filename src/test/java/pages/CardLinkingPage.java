package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;

import util.*;
import base.*;
import locators.CardLinkingLocators;

public class CardLinkingPage extends BasePage {

    public static int timeout = 5;

    // Constructor
    public CardLinkingPage(AppiumDriver driver) {
        super(driver);
    }


    public boolean isCardLinkingVisible(){
        waitUniqueElement(CardLinkingLocators.LINK_BTN, 60);

        boolean CL_Link = isElementVisible("Loyalty card Link - Link btn", CardLinkingLocators.LINK_BTN, 10);
        //boolean CL_Hdr = isElementVisible("Loyalty card Link - Header", CardLinkingLocators.CARD_LINKING_HDR, 10);
        boolean CL_Img = isElementVisible("Loyalty card Link - Image", CardLinkingLocators.CARD_LINKING_IMG, 10);
        //boolean CL_Desc = isElementVisible("Loyalty card Link - Desc", CardLinkingLocators.CARD_LINKING_DESC, 10);
        boolean CL_CardNumber = isElementVisible("Loyalty card Link - Card number field", CardLinkingLocators.CARD_NUM_FIELD, 10);
        boolean CL_BackBtn = isElementVisible("Loyalty card Link - Back btn", CardLinkingLocators.CARD_LINKING_BACK, 10);

        logStatus("Loyalty card Link - Link btn", CL_Link);
        //logStatus("Loyalty card Link - Header", CL_Hdr);
        logStatus("Loyalty card Link - Image", CL_Img);
        //logStatus("Loyalty card Link - Desc", CL_Desc);
        //logStatus("Loyalty card Link - Instructions", CL_Instruction);
        logStatus("Loyalty card Link - Card number field", CL_CardNumber);
        logStatus("Loyalty card Link - Back btn", CL_BackBtn);

        return CL_Link && CL_Img  /* CL_Hdr && CL_Desc && CL_Instruction*/ && CL_CardNumber && CL_BackBtn;
    }


    public boolean isMOMTextAttributeVisible(){
        waitUniqueElement(CardLinkingLocators.MOM_TERMS_OF_SERVICE, 15);

        return isElementVisible("MOM - Terms", CardLinkingLocators.MOM_TERMS_OF_SERVICE, 10);
    }


    public boolean isLinkYourCardBtnEnabled(){
        return isElementEnabled("Link your card btn", CardLinkingLocators.LINK_BTN);
    }

    public boolean isLinkYourCardBtnEnabled2(){
        return isEnabled("Link you card btn",  CardLinkingLocators.LINK_BTN, 10);
    }


    public void enterCardNumber(String cardNumberTD) throws Exception {
        tap("Card number field", CardLinkingLocators.CARD_NUM_FIELD, 5);
        type("Card number field", CardLinkingLocators.CARD_NUM_FIELD, 5, cardNumberTD);
        Thread.sleep(1000);
    }


    public void clickMOMContinueButton() throws InterruptedException {
        waitUniqueElement(CardLinkingLocators.MOM_CONTINUE_BTN, 30);

        boolean isEnabled = isElementEnabled("Continue", CardLinkingLocators.MOM_CONTINUE_BTN);

        if (isEnabled){
            tap("Continue", CardLinkingLocators.MOM_CONTINUE_BTN, timeout);
        }
    }


    public boolean isMOMContinueBtnVisible(){
        return isElementVisible("Continue", CardLinkingLocators.MOM_CONTINUE_BTN, timeout);
    }


    public boolean isLinkYourCardEnabled(){
        return isElementEnabled("Link your card btn", CardLinkingLocators.LINK_BTN);
    }


    public void clickLinkYourCardBtn() {


        clickWhenEnabled("Link your card", CardLinkingLocators.LINK_BTN, 15);
//        boolean hidden = !(isVisible_ErrMsg_blockedCard() && isVisible_ErrMsg_CardAlreadyAssoc() && isVisible_ErrMsg_MobNumIssue() && isVisible_ErrMsg_CardNotActivated() && isVisible_ErrMsg_NotEligible() && isVisible_ErrMsg_InvalidCardNumber() && isVisible_ErrMsg_expiredCardMoreThan90Days());

//        if (hidden){
//            if(isEnabled){
//                tap("Link your card btn", loyaltyCardLinkBtn, timeout);
//            } else {
//                System.out.println("Link your card btn is not enabled. Unable to click link btn.");
//            }
//        }
    }


    public boolean isOTPVerificationVisible(){
        waitUniqueElement(CardLinkingLocators.OTP_DID_NOT_RECEIVE, 60);

        boolean otp_hdr = isElementVisible("OTP - HDR", CardLinkingLocators.OTP_HDR, timeout);
        boolean otp_icon = isElementVisible("OTP - Icon", CardLinkingLocators.OTP_ICON, timeout);
        boolean otp_field = isElementPresent("OTP - Field", CardLinkingLocators.OTP_FIELD, timeout);
        boolean otp_DidntRecieve = isElementVisible("OTP - Didn't recieve", CardLinkingLocators.OTP_DID_NOT_RECEIVE, timeout);
        boolean otp_ResendBtn = isElementVisible("OTP - Resend OTP", CardLinkingLocators.OTP_RESEND, timeout);

        logStatus("OTP - HDR", otp_hdr);
        logStatus("OTP - Icon", otp_icon);
        logStatus("OTP - Field", otp_field);
        logStatus("OTP - Didn't recieve", otp_DidntRecieve);
        logStatus("OTP - Resend OTP", otp_ResendBtn);

        return otp_hdr && otp_icon && otp_field && otp_DidntRecieve || otp_ResendBtn;
    }


    public void enterOTP(String otp) {
        WebElement activeInput = driver.findElement(
                AppiumBy.xpath("//android.widget.EditText[@focused='true']"));

        System.out.println(activeInput.getAttribute("focused"));

        AndroidDriver androidDriver = (AndroidDriver) driver;


        for (char digit : otp.toCharArray()) {
            androidDriver.pressKey(
                    new KeyEvent(AndroidKey.valueOf("DIGIT_" + digit))
            );
        }
    }


    public boolean isAddressSectionVisible(){
        waitUniqueElement(CardLinkingLocators.MOM_FORM_ADDR_POSTAL_CODE, 60);

        boolean frm_Addr_Section = isElementVisible("Address section", CardLinkingLocators.MOM_FORM_ADDR_HDR, timeout);
        boolean frm_Addr_HouseNumber = isElementVisible("Address - House number", CardLinkingLocators.MOM_FORM_ADDR_HOUSE_NUM, timeout);
        boolean frm_Addr_Brgy = isElementVisible("Address - Street", CardLinkingLocators.MOM_FORM_ADDR_BRGY, timeout);
        boolean frm_Addr_Province = isElementVisible("Address - Province", CardLinkingLocators.MOM_FORM_ADDR_PROVINCE, timeout);
        boolean frm_Addr_City = isElementVisible("Address - City", CardLinkingLocators.MOM_FORM_ADDR_CITY, timeout);
        boolean frm_Addr_Postal = isElementVisible("Postal code", CardLinkingLocators.MOM_FORM_ADDR_POSTAL_CODE, timeout);

        logStatus("Address - Section", frm_Addr_Section);
        logStatus("Address - House-Number", frm_Addr_HouseNumber);
        logStatus("Address - Brgy", frm_Addr_Brgy);
        logStatus("Address - Province", frm_Addr_Province);
        logStatus("Address - City", frm_Addr_City);
        logStatus("Address - Postal", frm_Addr_Postal);

        boolean frm_Addr_Prov_ols = isElementVisible("OLS - Province", CardLinkingLocators.PROVINCE_ALBAY, timeout);
        logStatus("OLS - Province", frm_Addr_Prov_ols);
        boolean frm_Addr_City_ols = isElementVisible("OLS - City", CardLinkingLocators.CITY_DARAGA, timeout);
        logStatus("OLS - City", frm_Addr_City_ols);
        boolean frm_Addr_Brgy_ols = isElementVisible("OLS - Province", CardLinkingLocators.BRGY_ALCALA, timeout);
        logStatus("OLS - Barangay", frm_Addr_Brgy_ols);

        return frm_Addr_Section && frm_Addr_Postal && frm_Addr_HouseNumber
                && (frm_Addr_Province || frm_Addr_Prov_ols)
                && (frm_Addr_City || frm_Addr_City_ols)
                && (frm_Addr_Brgy || frm_Addr_Brgy_ols);
    }


    public boolean isPregnancyDetailsSectionVisible() {
        scrollToProceedButton();

        waitUniqueElement(CardLinkingLocators.FORM_PROCEED_BTN, 60);

        boolean frm_PD_Section = isElementVisible("Pregnancy details - Section", CardLinkingLocators.MOM_FORM_PREG_DET_HDR, timeout);
        logStatus("Pregnancy details - Section", frm_PD_Section);

        boolean frm_PD_CurrPreg_Yes = isElementVisible("Currently pregnant - Yes",  CardLinkingLocators.MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_YES, timeout);
        logStatus("Pregnancy details - Curr preg - Yes", frm_PD_CurrPreg_Yes);

        boolean frm_PD_CurrPreg_No = isElementVisible("Currently pregnant - No",  CardLinkingLocators.MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_NO, timeout);
        logStatus("Pregnancy details - Curr preg - No", frm_PD_CurrPreg_No);

//        boolean frm_PD_PregnancyStage = isElementNotVisible("Pregnancy stage", CardLinkingLocators.MOM_FORM_PREG_DET_PREG_STAGE, timeout);
//        logStatus("Pregnancy details - Pregnancy stage", frm_PD_PregnancyStage);
//
//        boolean frm_PD_KidsAge = isElementNotVisible("Kids Age",  CardLinkingLocators.MOM_FORM_PREG_DET_KIDS_AGE, timeout);
//        logStatus("Pregnancy Details - Kids Age", frm_PD_KidsAge);
//
//        boolean frm_PD_KidCount = isElementVisible("Kids Count", CardLinkingLocators.MOM_FORM_PREG_DET_KID_COUNT, timeout);
//        logStatus("Pregnancy details - Kid count", frm_PD_KidCount);

        return frm_PD_Section && frm_PD_CurrPreg_Yes && frm_PD_CurrPreg_No /*&& frm_PD_PregnancyStage && frm_PD_KidsAge && frm_PD_KidCount*/;
    }


    public boolean isMOMFormDisplayed(){
        waitUniqueElement(CardLinkingLocators.MOM_FORM_OTHER_INFO, 20);

        boolean otherInfo = isElementVisible("Other information", CardLinkingLocators.MOM_FORM_OTHER_INFO, timeout);
        logStatus("Other information", otherInfo);

        boolean momBanner = isElementVisible("MOM - Banner", CardLinkingLocators.MOM_FORM_BANNER, timeout);
        logStatus("MOM - Banner", momBanner);

        return  otherInfo && momBanner;
    }


    public void scrollToProceedButton(){
        scrollHelper.swipeDown();
    }


    public boolean isProceedButtonVisible(){
        return isElementVisible("Proceed button", CardLinkingLocators.FORM_PROCEED_BTN, timeout);
    }


    public boolean isCityVisible(){
        return isElementVisible("Address - City", CardLinkingLocators.MOM_FORM_ADDR_CITY, timeout);
    }


    public boolean isBrgyVisible(){
        return isElementVisible("Address - Brgy", CardLinkingLocators.MOM_FORM_ADDR_BRGY, timeout);
    }


    public void Enter_Addr_HouseNumber(String houseNum){
        tap("Address - House num", CardLinkingLocators.MOM_FORM_ADDR_HOUSE_NUM, timeout);
        type("Address - House num", CardLinkingLocators.MOM_FORM_ADDR_HOUSE_NUM, timeout, houseNum);
    }


    //UPDATE ALL GETTERS
    public String getHouseNum(){
        return getText(CardLinkingLocators.ENTERED_HN);
    }


    public String getProvince(){
        return getContentDesc(CardLinkingLocators.PROVINCE_ALBAY);
    }


    public String getCity(){
        return getContentDesc(CardLinkingLocators.CITY_DARAGA);
    }


    public String getBrgy(){
        return getContentDesc(CardLinkingLocators.BRGY_ALCALA);
    }


    public String getPostalCode(){
        return getText(CardLinkingLocators.MOM_FORM_ADDR_POSTAL_CODE);
    }

    public String getKidCount(){
        return getText(CardLinkingLocators.MOM_FORM_PREG_DET_KID_COUNT);
    }

    public String getKidAGE(){
        return getText(CardLinkingLocators.MOM_FORM_PREG_DET_KIDS_AGE);
    }


    public void select_Addr_Province(){
        tap("Address - Province", CardLinkingLocators.MOM_FORM_ADDR_PROVINCE, 5);
        tap("Select Albay", CardLinkingLocators.PROVINCE_ALBAY, 5);
    }


    public void select_Addr_City(){
        tap("Address - City", CardLinkingLocators.MOM_FORM_ADDR_CITY, 5);
        tap("Select DARAGA (LOCSIN)", CardLinkingLocators.CITY_DARAGA, 5);
    }


    public void select_Addr_Brgy(){
        tap("Address - Brgy", CardLinkingLocators.MOM_FORM_ADDR_BRGY, 5);
        tap("Select ALCALA", CardLinkingLocators.BRGY_ALCALA, 5);
    }

    public void Enter_Addr_PostalCode(String postalCode){
        tap("Address - Postal", CardLinkingLocators.MOM_FORM_ADDR_POSTAL_CODE, 5);
        type("Address - Postal", CardLinkingLocators.MOM_FORM_ADDR_POSTAL_CODE, 10, postalCode);
    }


    public void Valid_fillInAddressSection() throws InterruptedException {
        Enter_Addr_HouseNumber("Suite 1");
        select_Addr_Province();
        select_Addr_City();
        select_Addr_Brgy();
        Enter_Addr_PostalCode("2110");

        clickOuterScreen();
    }


    public String getPregStage_2ndTri(){
        return getContentDesc(CardLinkingLocators.PREG_STAGE_2ND_TRI);
    }


    public String getAge(){
        return getText(CardLinkingLocators.AGE);
    }


    public String getAges(){
        return getText(CardLinkingLocators.AGES);
    }


    public void click_PregDet_Yes(){
        tap("Yes", CardLinkingLocators.MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_YES, timeout);
        scrollHelper.swipeDown();
    }


    public void click_PregDet_No(){
        tap("No", CardLinkingLocators.MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_NO, timeout);
        scrollHelper.swipeDown();
    }


    public boolean isPregnancyStageVisible(){
        return isElementVisible("Pregnancy Stage dropdown", CardLinkingLocators.MOM_FORM_PREG_DET_PREG_STAGE, timeout);
    }


    public boolean isChildrenAgeVisible(){
        return isElementVisible("Children Age", CardLinkingLocators.MOM_FORM_PREG_DET_KIDS_AGE, timeout);
    }


    public void select_PregnancyStage(){
        tap("Pregnancy Stage dropdown", CardLinkingLocators.MOM_FORM_PREG_DET_PREG_STAGE, timeout);
        tap("Pregnancy stage - 2nd Trimester", CardLinkingLocators.PREG_STAGE_2ND_TRI, timeout);
    }


    public void enterKidsCount(String kidsCount){
        tap("Kids count", CardLinkingLocators.MOM_FORM_PREG_DET_KID_COUNT, timeout);
        type("Kids count", CardLinkingLocators.MOM_FORM_PREG_DET_KID_COUNT, timeout, kidsCount);
        scrollHelper.swipeDown();
    }


    public void enterKidsAge(String kidsAge){
        tap("Kids Age", CardLinkingLocators.MOM_FORM_PREG_DET_KIDS_AGE, timeout);
        type("Kids Age", CardLinkingLocators.MOM_FORM_PREG_DET_KIDS_AGE, timeout, kidsAge);
    }


    public void Valid_fillInPregDetSection() throws InterruptedException {
        click_PregDet_Yes();
        select_PregnancyStage();
        enterKidsCount("2");
        clickOuterScreen();
        enterKidsAge("5,7");
        clickOuterScreen();
    }


    public boolean isActivationInstructionsBtnVisible(){
        return isElementVisible("Activation instruction button", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_BTN, timeout);
    }


    public void clickActivationInstructionsBtn(){
        tap("Activation instruction button", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_BTN, timeout);
    }


    public void clickActivationInstructionsCloseBtn(){
        tap("Activation instruction close button", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_CLOSE, timeout);
    }

    public boolean isActivationInstructionsModalVisible(){
        waitUniqueElement(CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_CLOSE, 10);

        boolean ai_close =  isElementVisible("Activation instruction button - Close", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_CLOSE, timeout);
        logStatus("Activation instructions modal - Close btn", ai_close);

        boolean ai_hdr =  isElementVisible("Activation instruction button - Header", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_HDR, timeout);
        logStatus("Activation instructions modal - Header", ai_hdr);

        boolean ai_SMAC_hdr =  isElementVisible("Activation instruction button - SMAC Hdr", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_SMAC_HDR, timeout);
        logStatus("Activation instructions modal - SMAC hdr", ai_SMAC_hdr);

        boolean ai_SMAC_desc =  isElementVisible("Activation instruction button - SMAC desc", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_SMAC_DESC, timeout);
        logStatus("Activation instructions modal - SMAC desc", ai_SMAC_desc);

        boolean ai_NONSMAC_hdr =  isElementVisible("Activation instruction button - NONSMAC Hdr", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_HDR, timeout);
        logStatus("Activation instructions modal - NONSMAC hdr", ai_NONSMAC_hdr);

        boolean ai_MOM_hdr =  isElementVisible("Activation instruction button - MOM Hdr", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_MOM_HDR, timeout);
        logStatus("Activation instructions modal - MOM hdr", ai_MOM_hdr);

        boolean ai_MOM_desc =  isElementVisible("Activation instruction button - MOM desc", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_MOM_DESC, timeout);
        logStatus("Activation instructions modal - NONSMAC desc", ai_MOM_desc);

        boolean ai_ACE_hdr =  isElementVisible("Activation instruction button - ACE Hdr", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_ACE_HDR, timeout);
        logStatus("Activation instructions modal - ACE hdr", ai_ACE_hdr);

        boolean ai_ACE_desc =  isElementVisible("Activation instruction button - ACE desc", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_ACE_DESC, timeout);
        logStatus("Activation instructions modal - ACE desc", ai_ACE_desc);

        boolean ai_LYBC_hdr =  isElementVisible("Activation instruction button - LYBC Hdr", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_LYBC_HDR, timeout);
        logStatus("Activation instructions modal - LYBC hdr", ai_LYBC_hdr);

        boolean ai_LYBC_desc =  isElementVisible("Activation instruction button - LYBC desc", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_LYBC_DESC, timeout);
        logStatus("Activation instructions modal - LYBC desc", ai_LYBC_desc);

        boolean ai_TK_hdr =  isElementVisible("Activation instruction button - TK Hdr", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_TK_HDR, timeout);
        logStatus("Activation instructions modal - TK hdr", ai_TK_hdr);

        boolean ai_TK_desc =  isElementVisible("Activation instruction button - TK desc", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_TK_DESC, timeout);
        logStatus("Activation instructions modal - TK desc", ai_TK_desc);

        boolean ai_Send_to =  isElementVisible("Activation instruction button - Send to", CardLinkingLocators.ACTIVATION_INSTRUCTIONS_MODAL_INST_SEND_TO, timeout);
        logStatus("Activation instructions modal - Send to", ai_Send_to);

        return ai_hdr && ai_close && ai_SMAC_hdr && ai_SMAC_desc && ai_NONSMAC_hdr && ai_MOM_hdr && ai_MOM_desc && ai_ACE_hdr && ai_ACE_desc &&
                ai_TK_hdr && ai_TK_desc && ai_LYBC_hdr && ai_LYBC_desc && ai_Send_to;
    }



    //  GENERAL CARD LINKING - ERROR MSG

    public boolean isVisible_ErrMsg_InvalidCardNumber(){
        waitUniqueElement(CardLinkingLocators.ERR_INVALID_CARD, 20);
        return isElementVisible("Error message - Invalid Card number", CardLinkingLocators.ERR_INVALID_CARD, 10);
    }


    public boolean isVisible_ErrMsg_CardAlreadyAssoc() {
        return isElementVisible("Error message - Card Already Associated", CardLinkingLocators.ERR_CARD_ALREADY_ASSOC, 10);
    }


    public boolean isVisible_ErrMsg_CardNotActivated() {
        return isElementVisible("Error message - Card Not Activated", CardLinkingLocators.ERR_CARD_NOT_ACTIVATED, 10);
    }


    public boolean isVisible_ErrMsg_MobNumIssue() {
        return isElementVisible("Error message - Mobile number issue", CardLinkingLocators.ERR_MOB_NUM_ISSUE, 10);
    }


    public boolean isVisible_ErrMsg_NotEligible() {
        return isElementVisible("Error message - Not eligible", CardLinkingLocators.ERR_NOT_ELIGIBLE, 10);
    }


    public boolean isVisible_ErrMsg_blockedCard() {
        return isElementVisible("Error message - Blocked card", CardLinkingLocators.ERR_BLOCKED_CARD, 10);
    }


    public boolean isVisible_ErrMsg_expiredCardMoreThan90Days() {
        return isElementVisible("Error message - Expired card more than 90 days", CardLinkingLocators.ERR_EXPIRED_MORE_THAN_90_DAYS, 20);
    }


    public boolean isVisible_ErrMsg_PrestigeUpgrade() {
        return isElementVisible("Error message - Prestige upgrade", CardLinkingLocators.ERR_PRESTIGE_UPGRADE, 20);
    }


    public boolean isOTPCorrect(){
        waitUniqueElement(CardLinkingLocators.ERR_INCORRECT_OTP, 10);

        boolean incorrectOTP_inline = isElementVisible("Wrong Verification code", CardLinkingLocators.ERR_INCORRECT_OTP, 10);
        logStatus("Incorrect OTP - Inline error", incorrectOTP_inline);

        boolean incorrectOTP_snackBar = isElementVisible("Incorrect OTP - Snackbar", CardLinkingLocators.SNACKBAR_INCORRECT_OTP, 10);
        logStatus("Incorrect OTP - Snackbar", incorrectOTP_snackBar);

        return incorrectOTP_inline && incorrectOTP_snackBar;
    }


    public boolean isCardLinkingLoaderVisible(){
        waitUniqueElement(CardLinkingLocators.LOADING_TXT, 60);

        boolean loadText = isElementVisible("Loading text", CardLinkingLocators.LOADING_TXT, timeout);
        logStatus("Loading text", loadText);

        boolean loadIcon = isElementVisible("Loading icon", CardLinkingLocators.LOADING_ICN, timeout);
        logStatus("Loading icon", loadIcon);

        return loadIcon && loadText;
    }


    public boolean isSuccessCardLinkVisible(){
        waitUniqueElement(CardLinkingLocators.SUCCESS_SUBTXT, 60);

        boolean scs_hdr = isElementVisible("Success card link - hdr", CardLinkingLocators.SUCCESS_HDR, 10);
        logStatus("Success card link - hdr", scs_hdr);

        boolean scs_ThankYou = isElementVisible("Success card link - Thank You", CardLinkingLocators.SUCCESS_TNX, 10);
        logStatus("Success card link - Thank you", scs_ThankYou);

        boolean scs_subTxt = isElementVisible("Success card link - Sub text", CardLinkingLocators.SUCCESS_SUBTXT, 10);
        logStatus("Success card link - Sub text", scs_subTxt);

        boolean scs_subTxt2 = isElementVisible("Success card link - Sub text 2", CardLinkingLocators.SUCCESS_SUBTXT2, 10);
        logStatus("Success card link - Sub text 2", scs_subTxt2);

        boolean scs_BackToHome = isElementVisible("Success card link - Back to Home", CardLinkingLocators.SUCCESS_BACK_TO_HOME, 10);
        logStatus("Success card link - Back to Home", scs_BackToHome);

        return scs_hdr && scs_ThankYou && scs_subTxt && scs_subTxt2 && scs_BackToHome;
    }

    public boolean isThankYouPageVisible_MOM_NonVoucher(){

        boolean nv_ty_hdr = isElementVisible("Non-voucher - TY -Header", CardLinkingLocators.hdr_Thank_You_NV, 60);
        logStatus("Non-voucher - TY -Header", nv_ty_hdr);

        boolean nv_ty_desc = isElementVisible("Non-voucher - TY - Description", CardLinkingLocators.desc_Thank_You_NV, 10);
        logStatus("Non-voucher - TY - Description", nv_ty_desc);

        boolean nv_ty_back_To_home = isElementVisible("Non-voucher - TY - Back to home", CardLinkingLocators.Thank_You_NV_Back_To_Home, 10);
        logStatus("Non-voucher - TY - Back to home", nv_ty_back_To_home);

        return nv_ty_hdr && nv_ty_desc && nv_ty_back_To_home;
    }


    public boolean isLinkVoucherModalVisible(){
        waitUniqueElement(CardLinkingLocators.VOUCHER_PROCEED_BTN, 60);

        boolean vou_Proceed = isElementVisible("Link Voucher modal - Prceed btn", CardLinkingLocators.VOUCHER_PROCEED_BTN, 10);
        logStatus("Link Voucher modal - Proceed btn", vou_Proceed);

        boolean vou_hdr = isElementVisible("Link Voucher modal - Hdr", CardLinkingLocators.VOUCHER_CONGRATS_HDR, 10);
        logStatus("Link Voucher modal - Hdr", vou_hdr);

        boolean vou_desc = isElementVisible("Link Voucher modal - Desc", CardLinkingLocators.VOUCHER_CONGRATS_DESC, 10);
        logStatus("Link Voucher modal - Desc", vou_desc);

        boolean vou_Close = isElementVisible("Link Voucher modal - Close", CardLinkingLocators.VOUCHER_CLOSE_BTN, 10);
        logStatus("Link Voucher modal - Close", vou_Close);

        return vou_hdr && vou_desc && vou_Close && vou_Proceed;

    }


    public void clickLinkCardVoucherCloseBtn() {
        tap("Link Card voucher modal - Close", CardLinkingLocators.VOUCHER_CLOSE_BTN, 10);
    }


    public void clickCardLinkingSuccessBackToHome(){
        tap("Card Linking Success - Back to Home", CardLinkingLocators.SUCCESS_BACK_TO_HOME, 10);
    }

    public String getNameOnCard(String cardNumber){
        return TestDataManager.getNameOnCard(cardNumber);
    }

    public void clickOuterScreen() throws InterruptedException {
        tap("",CardLinkingLocators.MOM_FORM_OTHER_INFO, 10);
        Thread.sleep(300);
    }

    public boolean isProceedBtnEnabled_MOM(){
        return isEnabled("MOM form - Proceed", CardLinkingLocators.FORM_PROCEED_BTN, 10);
    }

    public void clickProceedBtn_MOM(){
        tap("MOM - Proceed", CardLinkingLocators.FORM_PROCEED_BTN, 10);
    }

    public boolean isThankYouPageVisible_MOM(){
        //waitUniqueElement(CardLinkingLocators.MOM_TY_VIEW_VOUCHER, 20);

        boolean ty_text_1 = isElementVisible("MOM - TY - Txt 1", CardLinkingLocators.MOM_TY_TEXT_1, 5);
        logStatus("MOM - TY - Txt 1", ty_text_1);

        boolean ty_text_2 = isElementVisible("MOM - TY - Txt 2", CardLinkingLocators.MOM_TY_TEXT_2, 5);
        logStatus("MOM - TY - Txt 2", ty_text_2);

        boolean ty_text_3 = isElementVisible("MOM - TY - Txt 3", CardLinkingLocators.MOM_TY_TEXT_3, 20);
        logStatus("MOM - TY - Txt 3", ty_text_3);

        boolean ty_view_vou = isElementVisible("MOM - TY - View Voucher", CardLinkingLocators.MOM_TY_VIEW_VOUCHER, 5);
        logStatus("MOM - TY - View Voucher", ty_view_vou);

        return ty_text_1 && ty_text_2 && ty_text_3 && ty_view_vou;
    }


    public void clickMOM_View_Voucher(){
        tap("MOM - TY - View voucher", CardLinkingLocators.MOM_TY_VIEW_VOUCHER, 10);
    }

    public void navigateBack(){
        native_back();
    }

    public boolean isMOMFormIncompleteModalVisible(){
        waitUniqueElement(CardLinkingLocators.MOM_FORM_INCOMPLETE_CONTINUE_BTN, 30);

        boolean MOM_Form_inc_hdr = isElementVisible("MOM Form incomplete - Hdr", CardLinkingLocators.MOM_FORM_INCOMPLETE_HDR, 10);
        logStatus("MOM Form incomplete - Hdr", MOM_Form_inc_hdr);

        boolean MOM_Form_inc_desc = isElementVisible("MOM Form incomplete - desc", CardLinkingLocators.MOM_FORM_INCOMPLETE_DESC, 10);
        logStatus("MOM Form incomplete - Desc", MOM_Form_inc_desc);

        boolean MOM_Form_inc_continue = isElementVisible("MOM Form incomplete - Continue", CardLinkingLocators.MOM_FORM_INCOMPLETE_CONTINUE_BTN, 10);
        logStatus("MOM Form incomplete - Continue", MOM_Form_inc_continue);

        boolean MOM_Form_inc_Leave_Page = isElementVisible("MOM Form incomplete - Leave Page", CardLinkingLocators.MOM_FORM_INCOMPLETE_LEAVE_PAGE_BTN, 10);
        logStatus("MOM Form incomplete - Leave Page", MOM_Form_inc_Leave_Page);

        return MOM_Form_inc_hdr && MOM_Form_inc_desc && MOM_Form_inc_continue && MOM_Form_inc_Leave_Page;
    }

    public void clickMOM_inc_Leave_Page(){
        tap("MOM Form incomplete - Leave page", CardLinkingLocators.MOM_FORM_INCOMPLETE_LEAVE_PAGE_BTN, 10);
    }
}