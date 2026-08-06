package pages;

import base.*;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardComponent extends BasePage {


    public CardComponent(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Extracts the full content-desc for a card element.
     * @param toBeExtracted The By locator of the card element
     * @return Full content-desc as String
     */
    public String extractFromContentDesc(String elementName, By toBeExtracted, String delimiter, Integer index) {
        WebElement cardElement = waitForVisibility(elementName, toBeExtracted, 15);
        String contentDesc = cardElement.getAttribute("content-desc");
        //debug contentdesc
        //System.out.println("Full content-desc: " + contentDesc);
        String cardNumber = contentDesc.split(delimiter)[index].trim();

        System.out.println("Extracted value from content desc: " + cardNumber);
        return cardNumber;
    }


    public String extractCardNumber(By cardNumberLocator, Integer indexCardNo) {
        WebElement cardElement = waitForVisibility("Card number", cardNumberLocator, 30);

        String contentDesc = cardElement.getAttribute("content-desc");

        String[] parts = contentDesc.split("_");
        String cn = parts[indexCardNo].trim();

        System.out.println("💳 Extracted card number: " + cn);

        return cn;
    }


    public String extractAndNormaliseCardNumber_(By cardNumberLocator) {
        WebElement cardElement = waitForVisibility("Card number", cardNumberLocator, 30);

        String contentDesc = cardElement.getAttribute("content-desc");

        if (contentDesc == null) return "";

        // remove all spaces
        String normalized = contentDesc.replaceAll("\\s+", "");

        return normalized;
    }


    /**
     * Extracts a specific part from the card content.
     * @param cardNumberLocator The By locator of the card element
     * @param delimiterContentDesc Delimiter used to split content-desc (e.g., ",")
     * @param delimiterCN Delimiter used to split content-desc (e.g., ",")
     * @param indexCN Part index to extract (0-based)
     * @return The extracted part as String
     */
    public String extractCardPart(By cardNumberLocator, String delimiterContentDesc, String delimiterCN, int indexCN) {
        String cn = extractFromContentDesc("Card number", cardNumberLocator, delimiterContentDesc, 1);

        // fallback if delimiter not present
        String[] parts = cn.contains(delimiterCN)
                ? cn.split(delimiterCN)
                : new String[]{cn};

        if (indexCN < 0 || indexCN >= parts.length) {
            throw new IndexOutOfBoundsException(
                    "Requested index " + indexCN + " is out of bounds for content-desc parts: " + cn
            );
        }

        String cardPart = parts[indexCN].trim();
        System.out.println("💳 Extracted BIN [" + indexCN + "]: " + cardPart);
        return cardPart;
    }


    /**
     * Determines the tier based on the card number (usually the second part)
     * @param cardNumberLocator The By locator of the card element
     * @param delimiterContentDesc Delimiter used to split content-desc
     * @param delimiterCN Delimiter used to split content-desc
     * @return Tier name as String
     */
    public String verifyTier(By cardNumberLocator, String delimiterContentDesc, String delimiterCN) {
        // Extract the raw card number string
        String uncleanCardNumber = extractCardPart(cardNumberLocator, delimiterContentDesc, delimiterCN, 1);

        // Split into parts
        String[] parts = uncleanCardNumber.split(delimiterCN);

        // Safely get the second part
        String indexPart = parts[0];
        if (indexPart.length() < 4) {
            throw new IllegalArgumentException(
                    "Card number part too short to determine status: " + indexPart
            );
        }

        // First 3 characters determine the CARD TYPE
        String tierKey = indexPart.substring(0, 3);

        // Map the tier key to the actual tier name
        switch (tierKey) {
            case "822":
                System.out.println("🥉 Logged in account is SMAC Start\n");
                return "SMAC Start";
            case "877":
            case "878":
            case "888":
            case "999":
            case "512": //BDO MC
                System.out.println("🥈 Logged in account is SMAC\n");
                return "SMAC Blue";
            case "001":
            case "002":
            case "003":
                System.out.println("🥇 Logged in account is Prestige\n");
                return "SMAC Prestige";
            case "404":
                System.out.println("Logged in account has LYBC\n");
                return "LYBC";
            case "188":
                System.out.println("Logged in account has TK\n");
                return "TK";
            case "505":
                System.out.println("Logged in account has ACE\n");
                return "ACE";
            case "352":
                System.out.println("Logged in account has MOM\n");
                return "MOM";
            default: return "Unknown Tier";
        }
    }


    public String verifyStatus(By cardNumberLocator, String delimiterContentDesc, String delimiterCN) {
        // Extract the raw card number string
        String uncleanCardNumber = extractCardPart(cardNumberLocator, delimiterContentDesc, delimiterCN, 0);

        // Split into parts
        String[] parts = uncleanCardNumber.split(delimiterCN);

        // Safely get the second part
        String indexPart = parts[0];
        if (indexPart.length() < 4) {
            throw new IllegalArgumentException(
                    "Card number part too short to determine status: " + indexPart
            );
        }

        // First 4 characters determine the status
        String tierKey = indexPart.substring(0, 4);

        switch (tierKey) {
            case "8881":
                System.out.println("*** Virtual card ***\n");
                return "8881";
            case "8880":
                System.out.println("*** Physical card ***\n");
                return "8880";
            default: return "Unknown Status";
        }
    }


    public String cleanCardNumber(String elementName, By cardNumLocator, String delimiter){
        String rawCard = extractFromContentDesc(elementName, cardNumLocator, ",", 1);
        String cleanCN = rawCard.replace(delimiter, "");
        System.out.println("Clean card number: " + cleanCN);
        return cleanCN;
    }


    public static String addDelimiterToCardNumber(String card, String delimiter) {
        return card/*.replaceAll("\\D", "") */ //replace all non-digit chars of space
                .replaceAll("(.{4})", "$1" + delimiter) //group by {4} then add delimiter at the end (incl the last group)
                .replaceAll(delimiter + "$", ""); //remove the delimiter from the last group
    }

    public String extractContentDesc_2(By locator, String delimiterCD, Integer index){
        String contentDesc = driver.findElement(locator).getAttribute("content-desc");

        String secondValue = contentDesc.substring(contentDesc.indexOf(delimiterCD) + index).trim();

        return secondValue;
    }

//    public String getBIN(){
//
//    }
}
