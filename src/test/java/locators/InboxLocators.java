package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class InboxLocators {

    private InboxLocators() {}

    public static final By INBOX_HDR =  AppiumBy.accessibilityId("Inbox");
    public static final By INBOX_NOTIF_1_TITLE = AppiumBy.androidUIAutomator(
            "new UiSelector()" +
                    ".descriptionContains(\"inbox_notification_title_1\")"
    );
    public static final By INBOX_NOTIF_1_BODY =AppiumBy.androidUIAutomator(
            "new UiSelector()" +
                    ".descriptionContains(\"inbox_notification_body_1\")"
    );
    public static final By INBOX_NOMESSAGES = AppiumBy.accessibilityId ("inbox_no_messages_text");
    public static final By INBOX_BACK_BTN =  AppiumBy.accessibilityId("inbox_detail_back_button");
    public static final By INBOX_INNER_HDR = AppiumBy.androidUIAutomator(
            "new UiSelector()" +
                    ".descriptionContains(\"inbox_detail_title\")"
    );
    public static final By INBOX_INNER_BODY = AppiumBy.androidUIAutomator(
            "new UiSelector()" +
                    ".descriptionContains(\"inbox_detail_body\")"
    );
}