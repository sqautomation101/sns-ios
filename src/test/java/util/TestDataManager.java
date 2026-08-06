package util;

import java.util.List;
import java.util.Map;

public class TestDataManager {


    // Global CSV data
    public static List<Map<String, String>> Login_TestCards;
    public static List<Map<String, String>> MOM_TestCards;
    public static List<Map<String, String>> TK_TestCards;
    public static List<Map<String, String>> LYBC_TestCards;
    public static List<Map<String, String>> ACE_TestCards;
    public static List<Map<String, String>> Start_TestCards;
    public static List<Map<String, String>> SMAC_Reg_TestCards;
    public static List<Map<String, String>> SMAC_Prestige_TestCards;
    public static List<Map<String, String>> Unlinkables_TestCards;
    public static List<Map<String, String>> CardLinks_TD;
    public static List<Map<String, String>> Password_TD;
    public static List<Map<String, String>> SM_Pride_TestCards;
    public static List<Map<String, String>> Test_Cards_With_Name_TD;



    // CSV paths
    private static final String LOGIN_CARDS_CSV_PATH = "src/test/resources/testdata/Login_TD.csv";
    private static final String MOM_CARDS_CSV_PATH = "src/test/resources/testdata/MOM_TestCards.csv";
    private static final String TK_CARDS_CSV_PATH = "src/test/resources/testdata/TK_TestCards.csv";
    private static final String LYBC_CARDS_CSV_PATH = "src/test/resources/testdata/LYBC_TestCards.csv";
    private static final String ACE_CARDS_CSV_PATH = "src/test/resources/testdata/ACE_TestCards.csv";
    private static final String START_CARDS_CSV_PATH = "src/test/resources/testdata/SMAC_Start_TestCards.csv";
    private static final String SMAC_REG_CARDS_CSV_PATH = "src/test/resources/testdata/SMAC_Reg_TestCards.csv";
    private static final String SMAC_PRESTIGE_CARDS_CSV_PATH = "src/test/resources/testdata/SMAC_Prestige_TestCards.csv";
    private static final String UNLINKABLE_CARDS_CSV_PATH = "src/test/resources/testdata/Unlinkable_TestCards.csv";
    private static final String CARDLINKS_TD_CSV_PATH = "src/test/resources/testdata/CardLinks_TD.csv";
    public static final String PASSWORD_TD_CSV_PATH = "src/test/resources/testdata/passwords_TD.csv";
    public static final String SM_PRIDE_TD_CSV_PATH = "src/test/resources/testdata/SM_Pride_TestCards.csv";
    public static final String TEST_CARDS_WITH_NAME_CSV_PATH = "src/test/resources/testdata/TestCardsWithName.csv";


    // -------------------- LOAD METHODS --------------------

    public static void loadLoginCardsData() throws Exception {
        System.out.println("Loading Creds CSV...");
        Login_TestCards = CSVDataReader.readCsvWithHeader(LOGIN_CARDS_CSV_PATH);
    }
    
    public static void loadMOMCardsData() throws Exception {
        System.out.println("Loading MOM Cards CSV...");
        MOM_TestCards = CSVDataReader.readCsvWithHeader(MOM_CARDS_CSV_PATH);
    }

    public static void loadTKCardsData() throws Exception {
        System.out.println("Loading TK Cards CSV...");
        TK_TestCards = CSVDataReader.readCsvWithHeader(TK_CARDS_CSV_PATH);
    }

    public static void loadLYBCCardsData() throws Exception {
        System.out.println("Loading LYBC Cards CSV...");
        LYBC_TestCards = CSVDataReader.readCsvWithHeader(LYBC_CARDS_CSV_PATH);
    }

    public static void loadACE_CardsData() throws Exception {
        System.out.println("Loading ACE Cards CSV...");
        ACE_TestCards = CSVDataReader.readCsvWithHeader(ACE_CARDS_CSV_PATH);
    }

    public static void loadStartCardsData() throws Exception {
        System.out.println("Loading SMAC Start Cards CSV...");
        Start_TestCards = CSVDataReader.readCsvWithHeader(START_CARDS_CSV_PATH);
    }

    public static void loadSMACRegCardsData() throws Exception {
        System.out.println("Loading SMAC Reg Cards CSV...");
        SMAC_Reg_TestCards = CSVDataReader.readCsvWithHeader(SMAC_REG_CARDS_CSV_PATH);
    }

    public static void loadSMACPrestigeCardsData() throws Exception {
        System.out.println("Loading SMAC Prestige Cards CSV...");
        SMAC_Prestige_TestCards = CSVDataReader.readCsvWithHeader(SMAC_PRESTIGE_CARDS_CSV_PATH);
    }

    public static void loadUnlinkableCardsData() throws Exception {
        System.out.println("Loading Unlinkable Cards CSV...");
        Unlinkables_TestCards = CSVDataReader.readCsvWithHeader(UNLINKABLE_CARDS_CSV_PATH);
    }

    public static void loadCardLinksTD() throws Exception {
        System.out.println("Loading Card Links TD...");
        CardLinks_TD = CSVDataReader.readCsvWithHeader(CARDLINKS_TD_CSV_PATH);
    }

    public static void loadPasswordTD() throws Exception {
        System.out.println("Loading Password TD...");
        Password_TD = CSVDataReader.readCsvWithHeader(PASSWORD_TD_CSV_PATH);
    }

    public static void loadSMPrideTD() throws Exception {
        System.out.println("Loading SM Pride TD...");
        SM_Pride_TestCards = CSVDataReader.readCsvWithHeader(SM_PRIDE_TD_CSV_PATH);
    }

    public static void loadTestCardsWithNameTD() throws Exception {
        System.out.println("Loading Test Cards with Name TD...");
        Test_Cards_With_Name_TD = CSVDataReader.readCsvWithHeader(TEST_CARDS_WITH_NAME_CSV_PATH);
    }


    // Load all CSVs at once
    public static void loadAllData() throws Exception {
        if (Login_TestCards ==  null) loadLoginCardsData();
        if (MOM_TestCards == null) loadMOMCardsData();
        if (TK_TestCards == null) loadTKCardsData();
        if (LYBC_TestCards == null) loadLYBCCardsData();
        if (ACE_TestCards == null) loadACE_CardsData();
        if (Start_TestCards == null) loadStartCardsData();
        if (SMAC_Reg_TestCards == null) loadSMACRegCardsData();
        if (SMAC_Prestige_TestCards == null) loadSMACPrestigeCardsData();
        if (Unlinkables_TestCards == null) loadUnlinkableCardsData();
        if (CardLinks_TD == null) loadCardLinksTD();
        if (Password_TD == null) loadPasswordTD();
        if (SM_Pride_TestCards == null) loadSMPrideTD();
        if (Test_Cards_With_Name_TD == null) loadTestCardsWithNameTD();
    }

    // -------------------- GET UNUSED DATA --------------------

    public static String getUsername(String name, String unameType) {

        for (Map<String, String> row : Login_TestCards) {
            if (name.equalsIgnoreCase(row.get("Name"))) {

                switch (unameType.toLowerCase()) {
                    case "email":
                        return row.get("Email");

                    case "mobile":
                        return row.get("MobileNumber");

                    default:
                        throw new IllegalArgumentException("Invalid username type");
                }
            }
        }
        throw new RuntimeException("No matching username found");
    }

    public static String getPassword(String name) {

        for (Map<String, String> row : Login_TestCards) {
            if (name.equalsIgnoreCase(row.get("Name"))) {
                return row.get("Password");
                }
            }
        throw new RuntimeException("No matching password found");
    }

    public static String getGreetingName(String name) {

        for (Map<String, String> row : Login_TestCards) {
            if (name.equalsIgnoreCase(row.get("Name"))) {
                return row.get("Greeting");
            }
        }
        throw new RuntimeException("No matching record found");
    }

    public static String getMaskedVirtualCard(String name) {

        for (Map<String, String> row : CardLinks_TD) {
            if (name.equalsIgnoreCase(row.get("Name"))) {
                return row.get("Greeting");
            }
        }
        throw new RuntimeException("No matching record found");
    }



    public static Map<String, String> Start_getUnusedCardNumber(
            String cardStatus,
            String code,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : Start_TestCards) {
//            debug
//            System.out.println(
//                    "status=" + row.get("CardStatus") +
//                    ", note=" + row.get("Notes") +
//                    ", used=" + row.get("Used")
//            );

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &
                            code.equalsIgnoreCase(row.get("Code")) &
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");

                    CSVWriterUtil.writeCsvWithHeader(
                            START_CARDS_CSV_PATH,
                            Start_TestCards);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> SMAC_Reg_getUnusedCardNumber(
            String cardStatus,
            String code,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : SMAC_Reg_TestCards) {
//            debug
//            System.out.println(
//                    "status=" + row.get("CardStatus") +
//                    ", note=" + row.get("Notes") +
//                    ", used=" + row.get("Used")
//            );

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &
                            code.equalsIgnoreCase(row.get("Code")) &
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");

                    CSVWriterUtil.writeCsvWithHeader(
                            SMAC_REG_CARDS_CSV_PATH,
                            SMAC_Reg_TestCards);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> SMAC_Prestige_getUnusedCardNumber(
            String cardStatus,
            String code,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : SMAC_Prestige_TestCards) {
//            debug
//            System.out.println(
//                    "status=" + row.get("CardStatus") +
//                    ", note=" + row.get("Notes") +
//                    ", used=" + row.get("Used")
//            );

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &
                            code.equalsIgnoreCase(row.get("Code")) &
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");

                    CSVWriterUtil.writeCsvWithHeader(
                            SMAC_PRESTIGE_CARDS_CSV_PATH,
                            SMAC_Prestige_TestCards);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> MOM_getUnusedCardNumber(
            String cardStatus,
            String code,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : MOM_TestCards) {
//            debug
//            System.out.println(
//                    "status=" + row.get("CardStatus") +
//                    ", note=" + row.get("Notes") +
//                    ", used=" + row.get("Used")
//            );

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &&
                            code.equalsIgnoreCase(row.get("Notes")) &&
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");

                    CSVWriterUtil.writeCsvWithHeader(
                            TK_CARDS_CSV_PATH,
                            TK_TestCards);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> TK_getUnusedCardNumber(
            String cardStatus,
            String code,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : TK_TestCards) {

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &
                            code.equalsIgnoreCase(row.get("Code")) &
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");

                    CSVWriterUtil.writeCsvWithHeader(
                            TK_CARDS_CSV_PATH,
                            TK_TestCards);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> LYBC_getUnusedCardNumber(
            String cardStatus,
            String code,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : LYBC_TestCards) {
//            debug
//            System.out.println(
//                    "status=" + row.get("CardStatus") +
//                    ", note=" + row.get("Notes") +
//                    ", used=" + row.get("Used")
//            );

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &
                            code.equalsIgnoreCase(row.get("Code")) &
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");

                    CSVWriterUtil.writeCsvWithHeader(
                            LYBC_CARDS_CSV_PATH,
                            LYBC_TestCards);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> ACE_getUnusedCardNumber(
            String cardStatus,
            String code,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : ACE_TestCards) {
//            debug
//            System.out.println(
//                    "status=" + row.get("CardStatus") +
//                    ", note=" + row.get("Notes") +
//                    ", used=" + row.get("Used")
//            );

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &
                            code.equalsIgnoreCase(row.get("Code")) &
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");

                    CSVWriterUtil.writeCsvWithHeader(
                            ACE_CARDS_CSV_PATH,
                            ACE_TestCards);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> Unlinkables_getUnusedCardNumber(
            String cardStatus,
            String code,
            String note,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : Unlinkables_TestCards) {
//            debug
//            System.out.println(
//                    "status=" + row.get("CardStatus") +
//                    ", note=" + row.get("Notes") +
//                    ", used=" + row.get("Used")
//            );

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &&
                            note.equalsIgnoreCase(row.get("Notes")) &&
                            code.equalsIgnoreCase(row.get("Code")) &&
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static String getCardNumberFromAccount(String name, String cardType) {

        for (Map<String, String> row : CardLinks_TD) {
            if (name.equalsIgnoreCase(row.get("Name"))) {

                switch (cardType) {
                    case "Virtual":
                        return row.get("Virtual");

                    case "maskedVirtual":
                        return row.get("maskedVirtual");

                    case "Start":
                        return row.get("Start");

                    case "Regular":
                        return row.get("Regular");

                    case "Prestige":
                        return row.get("Prestige");

                    case "TBCPrestige":
                        return row.get("TBCPrestige");

                    case "Blocked":
                        return row.get("Blocked");

                    case "Expired":
                        return row.get("Expired");

                    case "LYBC":
                        return row.get("LYBC");

                    case "ACE":
                        return row.get("ACE");

                    case "TK":
                        return row.get("TK");

                    case "MOM":
                        return row.get("MOM");

                    case "Prestige card - BA":
                        return row.get("PrestigeBA");

                    case "Prestige card - BBL":
                        return row.get("PrestigeBBL");

                    case "BDOMC":
                        return row.get("BDOMC");

                    default:
                        throw new IllegalArgumentException("Invalid card type");
                }
            }
        }
        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> getUnusedPassword(
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : Password_TD) {

            boolean matches = usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");
                }

                System.out.println("password used: " + row.get("Password"));
                return row;
            }
        }
        throw new RuntimeException("Error");
    }

    public static Map<String, String> SMPride_getUnusedCardNumber(
            String cardStatus,
            String code,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : SM_Pride_TestCards) {

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &
                            code.equalsIgnoreCase(row.get("Code")) &
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "true");

                    CSVWriterUtil.writeCsvWithHeader(
                            SM_PRIDE_TD_CSV_PATH,
                            SM_Pride_TestCards);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static Map<String, String> TC_With_Names_getUnusedCardNumber(
            String cardStatus,
            String code,
            String note,
            String usedFlag,
            boolean writeBack) {

        for (Map<String, String> row : Test_Cards_With_Name_TD) {

            boolean matches =
                    cardStatus.equalsIgnoreCase(row.get("CardStatus")) &&
                            code.equalsIgnoreCase(row.get("Code")) &&
                            note.equalsIgnoreCase(row.get("Notes")) &&
                            usedFlag.equalsIgnoreCase(row.get("Used"));

            if (matches) {
                if (writeBack) {
                    row.put("Used", "TRUE");

                    CSVWriterUtil.writeCsvWithHeader_With_Name(
                            TEST_CARDS_WITH_NAME_CSV_PATH,
                            Test_Cards_With_Name_TD);
                }

                System.out.println("Card number: " + row.get("CardNumber"));
                return row;
            }
        }

        throw new RuntimeException("No matching card found");
    }

    public static String getNameOnCard(String cardNumber) {

        for (Map<String, String> row : Test_Cards_With_Name_TD) {
            if (cardNumber.equalsIgnoreCase(row.get("CardNumber"))) {
                return row.get("NameOnCard");
            }
        }
        throw new RuntimeException("No matching record found");
    }

    public static String getAccountName(String name) {

        for (Map<String, String> row : Login_TestCards) {
            if (name.equalsIgnoreCase(row.get("Name"))) {
                return row.get("Name");
            }
        }
        throw new RuntimeException("No matching record found");
    }

    public static Map<String, String> writeBack(
            String cardNumber,
            String cardType,
            String usedFlag,
            boolean writeBack
    ) {
        switch (cardType) {
            case "Start":
                for (Map<String, String> row : Start_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    START_CARDS_CSV_PATH,
                                    Start_TestCards);
                        }

                        System.out.println("=====\nUpdated " + row.get("CardNumber") + " flag to "  + row.get("Used") + "\n=====");
                        return row;
                    }
                }
                break;

            case "Start - Inherit Name":
            case "SMAC - Inherit Name":
            case "SMAC Prestige - Inherit Name":
            case "ACE Rewards - Inherit Name":
            case "LYBC Express - Inherit Name":
            case "TK - Inherit Name":
            case "MOM - Inherit Name":
            case "Start - Retain Name":
            case "SMAC - Retain Name":
            case "SMAC Prestige - Retain Name":
            case "ACE Rewards - Retain Name":
            case "LYBC Express - Retain Name":
            case "TK - Retain Name":
            case "MOM card":


                for (Map<String, String> row : Test_Cards_With_Name_TD) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader_With_Name(
                                    TEST_CARDS_WITH_NAME_CSV_PATH,
                                    Test_Cards_With_Name_TD);
                        }

                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;
                
            case "SMAC":
                for (Map<String, String> row : SMAC_Reg_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    SMAC_REG_CARDS_CSV_PATH,
                                    SMAC_Reg_TestCards);
                        }

                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;

            case "Prestige":
                for (Map<String, String> row : SMAC_Prestige_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    SMAC_PRESTIGE_CARDS_CSV_PATH,
                                    SMAC_Prestige_TestCards);
                        }

                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;

            case "BDO MC":
                for (Map<String, String> row : SMAC_Reg_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    SMAC_REG_CARDS_CSV_PATH,
                                    SMAC_Reg_TestCards);
                        }

                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;
                
                //SLP
            case "ACE":
                for (Map<String, String> row : ACE_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    ACE_CARDS_CSV_PATH,
                                    ACE_TestCards);
                        }

//                        System.out.println("Card number: " + row.get("CardNumber"));
                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;

            case "LYBC":
                for (Map<String, String> row : LYBC_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    LYBC_CARDS_CSV_PATH,
                                    LYBC_TestCards);
                        }

//                        System.out.println("Card number: " + row.get("CardNumber"));
                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;

            case "MOM":
                for (Map<String, String> row : MOM_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    MOM_CARDS_CSV_PATH,
                                    MOM_TestCards);
                        }

//                        System.out.println("Card number: " + row.get("CardNumber"));
                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;

            case "TK":
                for (Map<String, String> row : TK_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    TK_CARDS_CSV_PATH,
                                    TK_TestCards);
                        }

//                        System.out.println("Card number: " + row.get("CardNumber"));
                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;

            case "SM Pride":
                for (Map<String, String> row : SM_Pride_TestCards) {
                    boolean matches =
                            cardNumber.equalsIgnoreCase(row.get("CardNumber")) &
                                    usedFlag.equalsIgnoreCase(row.get("Used"));

                    if (matches) {
                        if (writeBack) {
                            row.put("Used", "TRUE");

                            CSVWriterUtil.writeCsvWithHeader(
                                    SM_PRIDE_TD_CSV_PATH,
                                    SM_Pride_TestCards);
                        }

//                        System.out.println("Card number: " + row.get("CardNumber"));
                        System.out.println("Updated " + row.get("CardNumber") + " flag to "  + row.get("Used"));
                        return row;
                    }
                }
                break;

        }
        throw new RuntimeException("Error");
    }
}