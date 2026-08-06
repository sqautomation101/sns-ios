package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class CardLinkingLocators {

    private CardLinkingLocators() {
    }

    //LOCATORS
    public static final By test = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"otp_pin_field_input\"]");
    public static final By MOM_CONTINUE_BTN = AppiumBy.xpath("//android.view.View[@content-desc=\"manage_cards_mom_registration_button, Ready to continue your Mom Card registration? Complete the form now and receive exclusive vouchers!\n" +
            "Continue\"]");//.accessibilityId("manage_cards_mom_registration_button");
    public static final By CARD_LINKING_HDR = AppiumBy.accessibilityId("card_linking_title");
    public static final By CARD_LINKING_IMG = AppiumBy.accessibilityId("card_linking_partner_cards_image");
    public static final By CARD_LINKING_DESC = AppiumBy.accessibilityId("card_linking_activation_reminder_text");
    public static final By CARD_NUM_FIELD = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"card_linking_card_number_field\"]");
    public static final By LINK_BTN = AppiumBy.accessibilityId("card_linking_link_card_button");
    public static final By CARD_LINKING_BACK = AppiumBy.accessibilityId("card_linking_back_button");
    public static final By MOM_TERMS_OF_SERVICE = AppiumBy.accessibilityId("Terms of Service");
    public static final By MOM_PRIVACY = AppiumBy.accessibilityId("Privacy Policy");

    //OTP
    public static final By OTP_HDR = AppiumBy.accessibilityId("Verification");
    public static final By OTP_ICON = AppiumBy.accessibilityId("Verification");
    public static final By OTP_FIELD = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"otp_pin_field\")");
    //xpath("//android.widget.EditText[@resource-id=\"otp_pin_field\"]");
    public static final By OTP_DID_NOT_RECEIVE = AppiumBy.accessibilityId("Verification");
    public static final By OTP_RESEND = AppiumBy.accessibilityId("Resend OTP");
    public static final By ERR_INCORRECT_OTP = AppiumBy.accessibilityId("Wrong Verification Code");
    public static final By SNACKBAR_INCORRECT_OTP = AppiumBy.accessibilityId("card_linking_otp_snackbar, Wrong verification code. Try entering again.");

    //Loading screen
    public static final By LOADING_ICN = AppiumBy.accessibilityId("card_linking_processing_loader");
    public static final By LOADING_TXT = AppiumBy.accessibilityId("card_linking_processing_status_text, Linking your card...");

    //Successful card link landing
    public static final By SUCCESS_HDR = AppiumBy.accessibilityId("card_linking_status_title, Other Information");
    public static final By SUCCESS_TNX = AppiumBy.accessibilityId("Thank You!");
    public static final By SUCCESS_SUBTXT = AppiumBy.accessibilityId("You're all set to start earning points and enjoying rewards!");
    public static final By SUCCESS_SUBTXT2 = AppiumBy.accessibilityId("It can take a bit of time for your total spend to reflect after linking your card.");
    public static final By SUCCESS_BACK_TO_HOME = AppiumBy.xpath("//*[contains(@content-desc,'back_to_home')]");

    //  ERROR MSG
    public static final By ERR_INVALID_CARD = AppiumBy.accessibilityId("Sorry, we're unable to link Invalid card number. Please enter the correct card number.");
    public static final By ERR_CARD_ALREADY_ASSOC = AppiumBy.accessibilityId("This membership number is already associated with a log in account. Please contact SMAC Assist.");
    public static final By ERR_CARD_NOT_ACTIVATED = AppiumBy.accessibilityId("Card not activated. Text SMAC ACT [card number] to 225600 to activate before linking.");
    public static final By ERR_MOB_NUM_ISSUE = AppiumBy.accessibilityId("We are unable to link this card, there's an issue with the mobile number associated to the card being linked. Please contact SMAC Assist.");
    public static final By ERR_NOT_ELIGIBLE = AppiumBy.accessibilityId("This card is not eligible to be linked to your account. Please use a different card number.");
    public static final By ERR_BLOCKED_CARD = AppiumBy.accessibilityId("Sorry, we're unable to link because your card is blocked. Please contact SMAC Assist.");
    //("Sorry, we're unable to link. This card is blocked. Please contact SMAC Assist.");
    public static final By ERR_EXPIRED_MORE_THAN_90_DAYS = AppiumBy.accessibilityId("Sorry, we're unable to link because your card is expired for more than 90 days.");
    public static final By ERR_PRESTIGE_UPGRADE = AppiumBy.accessibilityId("Sorry, we're unable to link. You have qualified for a SMAC Prestige upgrade, please claim your card at the Customer Service Counter of any SM Store to be able to proceed with linking.");

    public static final By FORM_PROCEED_BTN = AppiumBy.accessibilityId("Proceed");


    public static final By ACTIVATION_INSTRUCTIONS_BTN = AppiumBy.accessibilityId("card_linking_view_activation_instructions_button");
    public static final By ACTIVATION_INSTRUCTIONS_CLOSE_BTN = AppiumBy.accessibilityId("Close");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_HDR = AppiumBy.accessibilityId("activation_instructions_header");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_SMAC_HDR = AppiumBy.accessibilityId("activations_instructions_SMAC");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_SMAC_DESC = AppiumBy.accessibilityId("activations_instructions_SMAC_text");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_HDR = AppiumBy.accessibilityId("activations_instructions_non-SMAC");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_MOM_HDR = AppiumBy.accessibilityId("activation_instructions_MOM");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_MOM_DESC = AppiumBy.accessibilityId("activation_instructions_MOM_text");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_ACE_HDR = AppiumBy.accessibilityId("activation_instructions_ACE");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_ACE_DESC = AppiumBy.accessibilityId("activation_instructions_ACE_text");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_TK_HDR = AppiumBy.accessibilityId("activation_instructions_TK");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_TK_DESC = AppiumBy.accessibilityId("activation_instructions_TK_text");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_LYBC_HDR = AppiumBy.accessibilityId("activation_instructions_LYBC");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_NONSMAC_LYBC_DESC = AppiumBy.accessibilityId("activation_instructions_LYBC_text");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_SEND_TO = AppiumBy.accessibilityId("activation_instructions_send_to");
    public static final By ACTIVATION_INSTRUCTIONS_MODAL_INST_CLOSE = AppiumBy.xpath("//android.widget.Button[@content-desc=\"close_button\"]/android.widget.Button");

    //Link voucher modal
    public static final By VOUCHER_CONGRATS_HDR = AppiumBy.accessibilityId("congratulations_popup_title");
    public static final By VOUCHER_CONGRATS_DESC = AppiumBy.accessibilityId("congratulations_popup_message");
    public static final By VOUCHER_PROCEED_BTN = AppiumBy.accessibilityId("congratulations_popup_proceed_button, Proceed");
    public static final By VOUCHER_CLOSE_BTN = AppiumBy.accessibilityId("congratulations_popup_close_button");
    public static final By MOM_TY_TEXT_1 = AppiumBy.accessibilityId("Thank you for sharing your details!!");
    public static final By MOM_TY_TEXT_2 = AppiumBy.accessibilityId("We’re happy to have you as part of our Mom Card family!");
    public static final By MOM_TY_TEXT_3 = AppiumBy.xpath("//android.view.View[@content-desc=\"\n" +
            "\n" +
            "Your exclusive vouchers are now ready! Enjoy a rewarding shopping spree!\"]");
    public static final By MOM_TY_VIEW_VOUCHER = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]");

    //Thank you - Non-voucher MOM
    public static final By hdr_Thank_You_NV = AppiumBy.accessibilityId("Thank you for sharing your details!!");
    public static final By desc_Thank_You_NV = AppiumBy.accessibilityId("We’re happy to have you as part of our Mom Card family!");
    public static final By Thank_You_NV_Back_To_Home = AppiumBy.accessibilityId("back_to_home_button");

    //MOM form
    public static final By MOM_FORM_BANNER = AppiumBy.accessibilityId("mom_card_form_banner");
    public static final By MOM_FORM_OTHER_INFO = AppiumBy.accessibilityId("Other Information");
    public static final By MOM_FORM_ADDR_HDR = AppiumBy.accessibilityId("Address");
    public static final By MOM_FORM_ADDR_DESCHDR = AppiumBy.accessibilityId("Block, Lot, Street, Building or Village Name");
    public static final By form_MOM_LINKED_HDR = AppiumBy.accessibilityId("Your Mom Card is now linked!");
    public static final By MOM_FORM_ADDR_HOUSE_NUM = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
    public static final By ENTERED_HN = AppiumBy.xpath("//android.widget.EditText[@text=\"Purok 3\"]"); //CHANGE THIS AND USE houseNum Attr
    public static final By MOM_FORM_ADDR_PROVINCE = AppiumBy.accessibilityId("Select Province");
    public static final By PROVINCE_ALBAY = AppiumBy.accessibilityId("ALBAY");
    public static final By MOM_FORM_ADDR_CITY = AppiumBy.accessibilityId("Select City");
    public static final By CITY_DARAGA = AppiumBy.accessibilityId("DARAGA (LOCSIN)");
    public static final By MOM_FORM_ADDR_BRGY = AppiumBy.accessibilityId("Select Barangay");
    public static final By BRGY_ALCALA = AppiumBy.accessibilityId("ALCALA");
    public static final By MOM_FORM_ADDR_POSTAL_CODE = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"mom_card_form_postal_code_field\"]");
    public static final By ENTERED_POSTAL_CODE = AppiumBy.xpath("//android.widget.EditText[@text=\"2110\"]");

    public static final By MOM_FORM_PREG_DET_HDR = AppiumBy.accessibilityId("Pregnancy Details");
    public static final By MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_YES = AppiumBy.accessibilityId("Yes");
    public static final By MOM_FORM_PREG_DET_HDR_CURRENTLYPREG_NO = AppiumBy.accessibilityId("No");
    public static final By MOM_FORM_PREG_DET_KID_COUNT = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"mom_card_form_num_kids_field\"]");
    public static final By MOM_FORM_PREG_DET_PREG_STAGE = AppiumBy.accessibilityId("Select pregnancy stage");
    public static final By PREG_STAGE_2ND_TRI = AppiumBy.accessibilityId("2nd Trimester");
    public static final By MOM_FORM_PREG_DET_KIDS_AGE = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"mom_card_form_kids_ages_field\"]");
    public static final By AGE = AppiumBy.xpath("//android.widget.EditText[@text=\"15\"]");
    public static final By AGES = AppiumBy.xpath("//android.widget.EditText[@text=\"15,3\"]");

    //unfinish MOM Form
    public static final By MOM_FORM_INCOMPLETE_HDR = AppiumBy.accessibilityId("Hold on! Your vouchers are still waiting!");
    public static final By MOM_FORM_INCOMPLETE_DESC = AppiumBy.xpath("//android.view.View[@content-desc=\"Just a few more questions left to unlock your exclusive vouchers! Click Continue to finish the form.\n" +
            "\n" +
            "Prefer to come back later? Tap Leave Page and we’ll save your progress. You can return anytime to complete it and get your rewards.\"]");
    public static final By MOM_FORM_INCOMPLETE_CONTINUE_BTN = AppiumBy.accessibilityId("Continue");
    public static final By MOM_FORM_INCOMPLETE_LEAVE_PAGE_BTN = AppiumBy.accessibilityId("mom_form_incomplete_leave_page_button");
}