package pages;

import base.*;
import locators.*;
import io.appium.java_client.AppiumDriver;

public class InboxPage extends BasePage {


    // Constructor
    public InboxPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickInboxBackBtn() { tap("Inbox - Back btn", InboxLocators.INBOX_BACK_BTN, 15); }

    public boolean isInboxPageDisplayedEmptyState() {
        waitUniqueElement(InboxLocators.INBOX_NOMESSAGES, 30);

        boolean inboxHdr = isElementVisible("Inbox header", InboxLocators.INBOX_HDR, 10);
        logStatus("Inbox - Header", inboxHdr);

        boolean inboxNoMsg = isElementVisible("Inbox NoMessages", InboxLocators.INBOX_NOMESSAGES, 10);
        logStatus("Inbox - No Messages", inboxNoMsg);

        return inboxHdr & inboxNoMsg;
    }


    public boolean isInboxPageDisplayed() {
        waitUniqueElement(InboxLocators.INBOX_NOTIF_1_TITLE, 15);

        boolean inbox_outer_hdr = isElementVisible("Inbox header", InboxLocators.INBOX_HDR, 10);
        logStatus("Inbox - Header", inbox_outer_hdr);

        boolean inbox_outer_title = isElementVisible("Inbox - Title", InboxLocators.INBOX_NOTIF_1_TITLE, 10);
        logStatus("Inbox - Title", inbox_outer_title);

        boolean inbox_outer_body = isElementVisible("Inbox - Body", InboxLocators.INBOX_NOTIF_1_BODY, 10);
        logStatus("Inbox - Body", inbox_outer_body);

        return inbox_outer_hdr & inbox_outer_title & inbox_outer_body;
    }


    public void clickFirstInboxNotification() {
        tap("Inbox notification", InboxLocators.INBOX_NOTIF_1_TITLE, 10);
    }

    public String getInboxTitle() {
        waitUniqueElement(InboxLocators.INBOX_NOTIF_1_TITLE, 15);

        String rawContentDesc = getContentDesc(InboxLocators.INBOX_NOTIF_1_TITLE);

        int start = rawContentDesc.indexOf(",") + 1;
        String inboxTitle = rawContentDesc.substring(start).trim();

        System.out.println("Extracted title: " + inboxTitle);

        return inboxTitle;
    }


    public String getInboxBody() {
        waitUniqueElement(InboxLocators.INBOX_NOTIF_1_BODY, 15);

        String rawContentDesc = getContentDesc(InboxLocators.INBOX_NOTIF_1_BODY);

        int start = rawContentDesc.indexOf(",") + 1;
        String inboxBody = rawContentDesc.substring(start).trim();

        System.out.println("Extracted body: " + inboxBody);

        return inboxBody;
    }


    public String getInboxTitle_inner() {
        waitUniqueElement(InboxLocators.INBOX_INNER_HDR, 15);

        String rawContentDesc = getContentDesc(InboxLocators.INBOX_INNER_HDR);

        int start = rawContentDesc.indexOf(",") + 1;
        String inboxTitle = rawContentDesc.substring(start).trim();

        System.out.println("Extracted text: " + inboxTitle);

        return inboxTitle;
    }


    public String getInboxBody_inner() {
        waitUniqueElement(InboxLocators.INBOX_INNER_BODY, 15);

        String rawContentDesc = getContentDesc(InboxLocators.INBOX_INNER_BODY);

        int start = rawContentDesc.indexOf(",") + 1;
        String inboxBody = rawContentDesc.substring(start).trim();

        System.out.println("Extracted text: " + inboxBody);

        return inboxBody;
    }


    public boolean isInboxInnerPageDisplayed() {
        waitUniqueElement(InboxLocators.INBOX_BACK_BTN, 15);

        boolean inbox_Back = isElementVisible("Inbox - Back btn", InboxLocators.INBOX_BACK_BTN, 10);
        logStatus("Inbox - Back btn", inbox_Back);

        boolean inbox_inner_hdr = isElementVisible("Inbox - inner header" ,InboxLocators.INBOX_INNER_HDR, 10);
        logStatus("Inbox - inner header", inbox_inner_hdr);

        boolean inbox_innerBody = isElementVisible("Inbox - inner body", InboxLocators.INBOX_INNER_BODY, 10);
        logStatus("Inbox - inner body", inbox_innerBody);

        return inbox_Back & inbox_inner_hdr & inbox_innerBody;
    }
}
