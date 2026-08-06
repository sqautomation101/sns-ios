package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.*;
import org.testng.Assert;

public class InboxSteps {

    private final HomePage home = Hooks.getPageManager().getHomePage();
    private final InboxPage inboxPage = Hooks.getPageManager().getInboxPage();

    public String inboxTitle;
    public String inboxBody;

    @And("the user clicks the inbox navigation")
    public void userClicksOnTheInboxIcon() {
        home.clickBotNav_Inbox();
    }

    @Then("the user is on the inbox page")
    public void theUserIsOnTheInboxPage() {
        try{

            Assert.assertTrue(
                    inboxPage.isInboxPageDisplayed(),
                    "❌ Inbox Page is not visible. Assertion failed."
            );
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @Then("the user is on the inbox page - empty state")
    public void theUserIsOnTheInboxPageEmptyState() {
        try {
            Assert.assertTrue(
                    inboxPage.isInboxPageDisplayedEmptyState(),
                    "❌ Inbox Page is not visible. Assertion failed."
            );
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the user clicks the message")
    public void theUserClicksOnAMessage() {
            inboxPage.clickFirstInboxNotification();
    }


    @Then("the user is redirected to inbox inner page")
    public void theUserIsRedirectedToInboxInnerPage() {
        try{
            Assert.assertTrue(
                    inboxPage.isInboxInnerPageDisplayed(),
                    "❌ Inbox Inner Page is not visible. Assertion failed."
            );
            
        } catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the user clicks the back button - inner inbox")
    public void theUserClicksOnTheBackButton() {
        inboxPage.clickInboxBackBtn();
    }

    @And("user reads the inbox title")
    public void userReadsTheInboxTitle() {
        try{
            inboxTitle = inboxPage.getInboxTitle();
        }catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("user reads the inbox body")
    public void userReadsTheInboxBody() {
        try{
            inboxBody = inboxPage.getInboxBody();
        }catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }

    @And("the inbox title matches from outer inbox screen")
    public void theInboxTitleMatchesFromOuterInboxScreen() {
        try{
            String title_inner = inboxPage.getInboxTitle_inner();

            Assert.assertEquals(title_inner,inboxTitle,
                    "Inbox Title is NOT matched. Assertion failed");

            System.out.println("Actual: " + title_inner + "\nExpected: " + inboxTitle);

        }catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }


    @And("the inbox body matches from outer inbox screen")
    public void theInboxBodyMatchesFromOuterInboxScreen() {
        try{
            String body_inner = inboxPage.getInboxBody_inner();

            Assert.assertEquals(body_inner, inboxBody,
                    "Inbox Body is NOT matched. Assertion failed");

            System.out.println("Actual: " + body_inner + "\nExpected: " +  inboxBody);

        }catch (Exception e) {
            Assert.fail("❌ Test failed due to exception.", e);
        }
    }
}
