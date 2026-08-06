package stepdefinitions;

import hooks.*;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;
import util.*;

public class LoginSteps {

    // Use PageManager from hooks
    private final LoginPage login = Hooks.getPageManager().getLoginPage();
    private final SSOMenuPage ssoMenu = Hooks.getPageManager().getSSOMenuPage();
    private TestContext testContext;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("the user clicks the Login button - SSO")
    public void theyClickedOnLoginButtonOnSSOMenu() {
        try {
            ssoMenu.clickSSOLoginBtn();
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the user is on the Login page")
    public void loginPageIsDisplayed() {
        try {
            Assert.assertTrue(
                    login.isSSOLoginVisible(),
                    "❌ Login page is not visible"
            );
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user logs in using valid mobile number and password - Not linked")
    public void theUserLogsInUsingValidMobileNumberAndPassword_NotLinked() {
        try{
            String uname = TestDataManager.getUsername("Dee Lan", "mobile");
            String pword = TestDataManager.getPassword("Dee Lan");
            String acctName = TestDataManager.getAccountName("Dee Lan");

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            testContext.setAccountName(acctName); //Store account name for future use

            System.out.println("✅ Logged in successfully: Dee Lan - No card linked");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user logs in using valid mobile number and password - SMAC Start")
    public void theUserLogsInUsingValidMobileNumberAndPassword_Start() {
        try{
            String uname = TestDataManager.getUsername("Olivia Rodrigo", "mobile");
            String pword = TestDataManager.getPassword("Olivia Rodrigo");

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            System.out.println("✅ Logged in successfully: Olivia Rodrigo - SMAC Start");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the user logs in using valid mobile number and password - SMAC")
    public void theUserLogsInUsingValidMobileNumberAndPasswordSMAC() {
        try{
            String uname = TestDataManager.getUsername("Sabrina Carpenter", "mobile");
            String pword = TestDataManager.getPassword("Sabrina Carpenter");
            String acctName = TestDataManager.getAccountName("Sabrina Carpenter");
            testContext.setAccountName(acctName);

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            System.out.println("✅ Logged in successfully: Sabrina Carpenter - SMAC");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user logs in using valid mobile number and password - Prestige")
    public void theUserLogsInUsingValidMobileNumberAndPasswordPrestige() {
        try{
            String uname = TestDataManager.getUsername("Maddy Perez", "mobile");
            String pword = TestDataManager.getPassword("Maddy Perez");

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            System.out.println("✅ Logged in successfully: Maddy Perez - Prestige");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user logs in using valid mobile number and password - Card Link - {string}")
    public void theUserLogsInUsingValidMobileNumberAndPasswordCardLink(String name) {
        try{
            String uname = TestDataManager.getUsername(name, "mobile");
            String pword = TestDataManager.getPassword(name);
            String acctName = TestDataManager.getAccountName(name);

            testContext.setAccountName(acctName);

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            System.out.println("✅ Logged in successfully: Card Link account - " + name);
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the user logs in using valid email address and password - SMAC")
    public void theUserLogsInUsingValidEmailAddressAndPasswordSMAC() {
        try{
            String uname = TestDataManager.getUsername("Sabrina Carpenter", "email");
            String pword = TestDataManager.getPassword("Sabrina Carpenter");

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            System.out.println("✅ Logged in successfully: Email - Sabrina Carpenter - SMAC");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Given("the user logs in - SMAC Start")
    public void theUserIsAlreadyLoggedIn_Start() {
        try{
            Assert.assertTrue(
                    ssoMenu.isSSOMenuVisible(),
                    "❌ SSO Menu is not visible"
            );

            ssoMenu.clickSSOLoginBtn();

            String uname = TestDataManager.getUsername("Olivia Rodrigo", "mobile");
            String pword = TestDataManager.getPassword("Olivia Rodrigo");

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            System.out.println("✅ Logged in successfully: Olivia Rodrigo - SMAC Start");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Given("the user logs in - SMAC")
    public void theUserIsAlreadyLoggedIn_SMAC() {
        try{
            Assert.assertTrue(
                    ssoMenu.isSSOMenuVisible(),
                    "❌ SSO Menu is not visible"
            );
            ssoMenu.clickSSOLoginBtn();

            String uname = TestDataManager.getUsername("Sabrina Carpenter", "mobile");
            String pword = TestDataManager.getPassword("Sabrina Carpenter");

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            System.out.println("✅ Logged in successfully: Sabrina Carpenter - SMAC");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Given("the user logs in - Prestige")
    public void theUserIsAlreadyLoggedIn_prestige() {
        try{
            Assert.assertTrue(
                    ssoMenu.isSSOMenuVisible(),
                    "❌ SSO Menu is not visible"
            );
            ssoMenu.clickSSOLoginBtn();

            String uname = TestDataManager.getUsername("Maddy Perez", "mobile");
            String pword = TestDataManager.getPassword("Maddy Perez");

            login.verifySuccessfulLogin_SSOLoginOnly(uname, pword);

            System.out.println("✅ Logged in successfully: Maddy Perez - Prestige");
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the username is blank")
    public void theUsernameIsBlank() {
        try{
            login.enterUsername("test");
            login.clearUnameField();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters an alphanumeric input on username")
    public void theUserEntersAnAlphanumericInputOnUsername() {
        try{
            login.enterUsername("apha123@yopmail.com");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("the username input is accepted")
    public void theUsernameInputShouldBeAccepted() {
        try{
            Assert.assertFalse(
                    login.isUsernameFieldInvalid(),
                    "❌ Error message not expected. Assertion failed."
            );

            Assert.assertFalse(
                    login.isUsernameFieldEmpty(),
                    "❌ Error message not expected. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the username field has an error message")
    public void anErrorMessageIsVisibleForTheUsername() {
        try {
            Assert.assertTrue(
                    login.isUsernameFieldEmpty(),
                    "❌ An error message for Username is expected. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters an email address with allowed special character given that the correct format is followed")
    public void enterUsernameWithAllowedSpecialCharacter() {
        try{
            login.enterUsername("test_QA@yopmail.com");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters a valid username")
    public void theUserEntersAValidUsername() {
        try{
            login.enterUsername("09663544751");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the password is blank")
    public void thePasswordIsBlank() {
        try{
            login.enterPassword("test");
            login.clearPwordField();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the password field has an error message")
    public void anErrorMessageIsVisibleForThePassword() {
        try {
            Assert.assertTrue(
                    login.isPasswordFieldEmpty(),
                    "❌ An error message for Password is expected. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @When("the user enters an alphanumeric input on password")
    public void theUserEntersAnAlphanumericInputOnPassword() {
        try{
            login.enterPassword("Temp1234!!");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the password input is accepted")
    public void thePasswordInputShouldBeAccepted() {
        try{
            Assert.assertFalse(
                    login.isPasswordFieldInvalid(),
                    "❌ Error message not expected. Assertion failed."
            );

            Assert.assertFalse(
                    login.isPasswordFieldEmpty(),
                    "❌ Error message not expected. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters a password with special characters")
    public void theUserEntersAPasswordWithSpecialCharacters() {
        try{
            login.enterPassword("check@This_password!");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters an unregistered email address")
    public void theUserEntersAnUnregisteredEmailAddress() {
        try{
            login.enterUsername("unregistered@yopmail.com");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the user enters a password")
    public void entersAPassword() {
        try{
            login.enterPassword("Temp1234@@");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks the Login button")
    public void clicksOnLoginButton() {
        try{
            login.clickOnFinalLoginButton();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("New Account Registration modal is visible")
    public void newAccountRegistrationModalShouldBeVisible() {
        try{
            Assert.assertTrue(
                    login.isNewAcctRegModalVisible(),
                    "New Account Modal is  not visible. Assertion failed"
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters an email address with invalid format")
    public void theUserEntersAnEmailAddressWithInvalidFormat() {
        try{
            login.enterUsername("this Invalid@yopmailcom.");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("an error message for username appears with invalid format")
    public void anErrorMessageForUsernameShouldAppearWithInvalidFormatErrorMessage() {
        try{
            Assert.assertTrue(
                    login.isUsernameFieldInvalid(),
                    "Username entered is valid. Assertion failed."
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters a registered {string}")
    public void theUserEntersARegisteredEmail(String unameType) {
        try{
            String uname = TestDataManager.getUsername("Sabrina Carpenter", unameType);
            login.enterUsername(uname);

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the user enters an incorrect password")
    public void enterAnIncorrectPassword() {
        try{
            login.enterPassword("Qwerty1234");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("an error message appears for incorrect login credentials")
    public void anErrorMessageShouldAppearForIncorrectLoginCredentials() {
        try{
            Assert.assertTrue(
                    login.isLoginCredentialsIncorrect(),
                    "Login credentials entered is valid. Assertion failed"
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters an unregistered mobile number")
    public void theUserEntersAnUnregisteredMobileNumber() {
        try{
            login.enterUsername("09663555555");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user enters a mobile number with invalid format")
    public void theUserEntersAMobileNumberWithInvalidFormat() {
        try{
            login.enterUsername("639663544751");

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @When("the user clicks the Forgot? button")
    public void theUserClicksOnForgotButton() {
        try{
            login.clickForgotBtn();

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("the user is on the Forgot Password page")
    public void shouldBeRedirectedToForgotPasswordPage() {
        try {
            Assert.assertTrue(
                    login.isForgotPasswordPageVisible(),
                    "Forgot Password should be visible. Assertion failed"
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @Then("login button is disabled")
    public void loginButtonShouldBeDisabled() {
        try {
            Assert.assertFalse(
                    login.isFinalLoginBtnEnable(5),
                    "Login button is expected to be disabled. Assertion failed"
            );

        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

}
