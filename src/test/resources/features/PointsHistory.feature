@android
Feature: Points History

  Rule: Start account - Olivia Rodrigo
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      And the user logs in using valid mobile number and password - SMAC Start
      And the user is on the Homepage
      When the user clicks the Points history widget

    @high
      Scenario: Transaction Details for transfers (member as Receiver) is displayed
        And the user is on the Points History page
        When the user clicks the Points Transaction item ("Point transfer as Receiver")
        Then the Transaction details for "transfers - Receiver" page is displayed

    @low
      Scenario: Points history page is visible upon clicking on Transaction details' Back button
        And the user is on the Points History page
        And the user clicks the Points Transaction item ("Point transfer as Receiver")
        And the Transaction details for "transfers - Receiver" page is displayed
        When the user clicks the Transaction Details back button
        Then the user is on the Points History page

    @low
      Scenario: Homepage is visible upon clicking on Point history's Back button
        And the user is on the Points History page
        When the user clicks the Points history back button
        Then the user is on the Homepage

    @low
      Scenario: SLP-account awarding transaction - LYBC label and points is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "awd-LYBC"
        Then the user reads the "positive" transaction points - "awd-LYBC"
        And the Points History item title "THE BODY SHOP: Marquee Mall" is displayed

    @low
      Scenario: SLP-account awarding transaction - LYBC label and points is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the "positive" transaction points - "awd-LYBC"
        And the user reads the transaction title - "awd-LYBC"
        And the user reads the transaction date - "awd-LYBC"
        When the user clicks the Points Transaction item ("awd-LYBC")
        Then Item title is matched in Transaction Details - "awd-LYBC"
        And Item points is matched in Transaction Details - "awd-LYBC"
        And Item date is matched in Transaction Details - "awd-LYBC"

    @low
      Scenario: SLP-account awarding transaction - MOM label and points is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "awd-MOM"
        Then the user reads the "positive" transaction points - "awd-MOM"
        And the Points History item title "BABY COMPANY: SM Fairview" is displayed

    @low
      Scenario: SLP-account awarding transaction - MOM label and points is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the "positive" transaction points - "awd-MOM"
        And the user reads the transaction title - "awd-MOM"
        And the user reads the transaction date - "awd-MOM"
        When the user clicks the Points Transaction item ("awd-MOM")
        Then Item title is matched in Transaction Details - "awd-MOM"
        And Item points is matched in Transaction Details - "awd-MOM"
        And Item date is matched in Transaction Details - "awd-MOM"

    @low
      Scenario: SLP-account awarding transaction - TK label and points is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "awd-TK"
        Then the user reads the "positive" transaction points - "awd-TK"
        And the Points History item title "DS: Batangas 123" is displayed

    @low @failed
      Scenario: SLP-account awarding transaction - TK label and points is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the "positive" transaction points - "awd-TK"
        And the user reads the transaction title - "awd-TK"
        And the user reads the transaction date - "awd-TK"
        When the user clicks the Points Transaction item ("awd-TK")
        Then Item title is matched in Transaction Details - "awd-TK"
        And Item points is matched in Transaction Details - "awd-TK"
        And Item date is matched in Transaction Details - "awd-TK"
  #End of Start account


  Rule: SMAC account - Sabrina Carpenter
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      And the user logs in using valid mobile number and password - SMAC
      And the user is on the Homepage
      When the user clicks the Points history widget

    @high
      Scenario: Points History page displayed
        Then the user is on the Points History page

      Scenario: Points History screen text adjustment is displayed
        Then Points history text adjustment is visible
    @high
      Scenario: Transaction Details for transfers (member as sender) is displayed
        And the user is on the Points History page
        When the user clicks the Points Transaction item ("Point transfer as Sender")
        Then the Transaction details for "transfers - Sender" page is displayed

      Scenario: Transaction Details for Redemption is displayed
        And the user is on the Points History page
        When the user clicks the Points Transaction item ("Redemption")
        Then the Transaction details for "Redemption" page is displayed

      Scenario: Points History item title is displayed correctly in RED transaction
        And the user is on the Points History page
        And the user reads the transaction title - "Redemption"
        When the user clicks the Points Transaction item ("Redemption")
        Then Item title is matched in Transaction Details - "Redemption"

    @low
      Scenario: SLP-account redemption transaction - ACE label and points is displayed correctly in Points History list
        And the user is on the Points History page
        Then the user reads the "negative" transaction points - "red-ACE"
        And the user reads the transaction title - "red-ACE"
        And the Points History item title "ACE HARDWARE: SM Cubao" is displayed

    @low @failed #should have negative points
      Scenario: SLP-account redemption transaction - ACE label and points is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the "negative" transaction points - "red-ACE"
        And the user reads the transaction title - "red-ACE"
        And the user reads the transaction date - "red-ACE"
        When the user clicks the Points Transaction item ("red-ACE")
        Then Item title is matched in Transaction Details - "red-ACE"
        And Item points is matched in Transaction Details - "red-ACE"
        And Item date is matched in Transaction Details - "red-ACE"

    @low
      Scenario: SLP-account redemption transaction - LYBC label and points is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "red-LYBC"
        Then the user reads the "negative" transaction points - "red-LYBC"
        And the Points History item title "THE BODY SHOP: Rockwell" is displayed

    @low @failed #should have negative points
      Scenario: SLP-account redemption transaction - LYBC label and points is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the "negative" transaction points - "red-LYBC"
        And the user reads the transaction title - "red-LYBC"
        And the user reads the transaction date - "red-LYBC"
        When the user clicks the Points Transaction item ("red-LYBC")
        Then Item title is matched in Transaction Details - "red-LYBC"
        And Item points is matched in Transaction Details - "red-LYBC"
        And Item date is matched in Transaction Details - "red-LYBC"

    @low
      Scenario: SLP-account redemption transaction - TK label and points is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "red-TK"
        Then the user reads the "negative" transaction points - "red-TK"
        And the Points History item title "TOY KINGDOM: SM CDO Downtown" is displayed

    @low @failed #should have negative points
      Scenario: SLP-account redemption transaction - TK label and points is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the "negative" transaction points - "red-TK"
        And the user reads the transaction title - "red-TK"
        And the user reads the transaction date - "red-TK"
        When the user clicks the Points Transaction item ("red-TK")
        Then Item title is matched in Transaction Details - "red-TK"
        And Item points is matched in Transaction Details - "red-TK"
        And Item date is matched in Transaction Details - "red-TK"

    @low
      Scenario: SLP-account redemption transaction - MOM label and points is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "red-MOM"
        Then the user reads the "negative" transaction points - "red-MOM"
        And the Points History item title "BABY COMPANY: Head Office" is displayed

    @low @failed #should have negative points
      Scenario: SLP-account redemption transaction - MOM label and points is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the "negative" transaction points - "red-MOM"
        And the user reads the transaction title - "red-MOM"
        And the user reads the transaction date - "red-MOM"
        When the user clicks the Points Transaction item ("red-MOM")
        Then Item title is matched in Transaction Details - "red-MOM"
        And Item points is matched in Transaction Details - "red-MOM"
        And Item date is matched in Transaction Details - "red-MOM"
  #End of SMAC account


  Rule: Prestige account - Maddy Perez
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      And the user logs in using valid mobile number and password - Prestige
      And the user is on the Homepage
      When the user clicks the Points history widget

      Scenario: Transaction Details for Awarding is displayed
        And the user is on the Points History page
        When the user clicks the Points Transaction item ("Awarding")
        Then the Transaction details for "Awarding" page is displayed

      Scenario: Points History item title is displayed correctly in AWD transaction
        And the user is on the Points History page
        And the user reads the transaction title - "Awarding"
        When the user clicks the Points Transaction item ("Awarding")
        Then Item title is matched in Transaction Details - "Awarding"

    @low
      Scenario: SLP-account awarding transaction - ACE label and points is displayed correctly in Points History list
        And the user is on the Points History page
        Then the user reads the "positive" transaction points - "awd-ACE"
        And the user reads the transaction title - "awd-ACE"
        And the Points History item title "ACE HARDWARE: SM Tarlac" is displayed

    @low
      Scenario: SLP-account awarding transaction - ACE label and points is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user scrolls down
        And the user reads the "positive" transaction points - "awd-ACE"
        And the user reads the transaction title - "awd-ACE"
        And the user reads the transaction date - "awd-ACE"
        When the user clicks the Points Transaction item ("awd-ACE")
        Then Item title is matched in Transaction Details - "awd-ACE"
        And Item points is matched in Transaction Details - "awd-ACE"
        And Item date is matched in Transaction Details - "awd-ACE"

    @low
      Scenario: BDOR to SMAC conversion label is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "BDOR to SMAC"
        Then the Points History item title "Points converted: BDO" is displayed

    @low
      Scenario: BDOR to SMAC conversion label is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the transaction title - "BDOR to SMAC"
        When the user clicks the Points Transaction item ("BDOR to SMAC")
        Then the Transaction item title "Points converted: BDO" is displayed

    @low
      Scenario: PAL to SMAC conversion label is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "PAL to SMAC"
        Then the Points History item title "Points converted: PAL Mabuhay Miles" is displayed

    @low
      Scenario: PAL to SMAC conversion label is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the transaction title - "PAL to SMAC"
        When the user clicks the Points Transaction item ("PAL to SMAC")
        Then the Transaction item title "Points converted: PAL Mabuhay Miles" is displayed

    @low
      Scenario: AIR ASIA to SMAC conversion label is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "AIR ASIA to SMAC"
        Then the Points History item title "Points converted: Air Asia Points" is displayed

    @low
      Scenario: AIR ASIA to SMAC conversion label is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the transaction title - "AIR ASIA to SMAC"
        When the user clicks the Points Transaction item ("AIR ASIA to SMAC")
        Then the Transaction item title "Points converted: Air Asia Points" is displayed

    @low
      Scenario: SMAC to PAL conversion label is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "SMAC to PAL"
        Then the Points History item title "Points converted: SMAC to PAL Mabuhay Miles" is displayed

    @low
      Scenario: SMAC to PAL conversion label is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the transaction title - "SMAC to PAL"
        When the user clicks the Points Transaction item ("SMAC to PAL")
        Then the Transaction item title "Points converted: SMAC to PAL Mabuhay Miles" is displayed

    @low
      Scenario: SMAC to AIR ASIA conversion label is displayed correctly in Points History list
        And the user is on the Points History page
        And the user reads the transaction title - "SMAC to AIR ASIA"
        Then the Points History item title "Points converted: SMAC to Air Asia Points" is displayed

        @low
      Scenario: SMAC to AIR ASIA conversion label is displayed correctly in Transaction Details
        And the user is on the Points History page
        And the user reads the transaction title - "SMAC to AIR ASIA"
        When the user clicks the Points Transaction item ("SMAC to AIR ASIA")
        Then the Transaction item title "Points converted: SMAC to Air Asia Points" is displayed
  #End of Prestige account