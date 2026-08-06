@android
Feature: Card Blocking
  Background:
    Given the user is on the SSO menu
    And the user clicks the Login button - SSO
    And the user is on the Login page
    When the user logs in using valid mobile number and password - Card Link - "Charlene Joie"
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
#    And the user clicks on Homepage Link Card
#    And the user is on the card linking page

    @done1 @high
  Scenario: Verify that user can block SMAC Start card
#    And the user enters a "BA" "Start" "822" card number
#    And the user clicks on Link Your Card
#    And the user is redirected to OTP Verification
#    And the user enters the correct OTP
#    And Card linking splash screen is displayed
#    And Card Linking Success screen is displayed - "Start"
#    And the user clicks on Card Linking Success screen - Back to Home
#    And the user is on the Homepage
#    And the user clicks the Manage card widget
#    And the user is on the Manage card Page
    When the user swipes to "Start" card
    And user reads main card number
    When the user clicks the Manage card - Block card
    And the user is on the Block Card page
    And the block tier image is "822"
    And the user clicks the Block - Block card
    Then the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Blocking success screen is displayed
    And the user clicks on Back to Loyalty
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"blocked" "Start" card
    And user reads main card number
    And the newly-"blocked" card is displayed
    And Show card is disabled
    And block card button is changed to Your card is blocked

@done1 @high
  Scenario: Verify that user can block SMAC card
    And the user enters a "AR" "SMAC" "878" card number
    And the user clicks on Link Your Card
    And the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Card linking splash screen is displayed
    And Card Linking Success screen is displayed - "SMAC"
    And the user clicks on Card Linking Success screen - Back to Home
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"linked" card
    And user reads main card number
    And the newly-"linked" card is displayed
    When the user clicks the Manage card - Block card
    And the user is on the Block Card page
    And the block tier image is "878"
    And the user clicks the Block - Block card
    And the user enters the correct OTP
    And Blocking success screen is displayed
    And the user clicks on Back to Loyalty
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"blocked" card
    And user reads main card number
    And the newly-"blocked" card is displayed
    And Show card is disabled
    And block card button is changed to Your card is blocked

  @done1 @high
  Scenario: Verify that user can block SMAC Prestige card
    And the user enters a "AR" "Prestige" "002" card number
    And the user clicks on Link Your Card
    And the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Card linking splash screen is displayed
    And Card Linking Success screen is displayed - "Prestige"
    And the user clicks on Card Linking Success screen - Back to Home
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"linked" card
    And user reads main card number
    And the newly-"linked" card is displayed
    When the user clicks the Manage card - Block card
    And the user is on the Block Card page
    And the block tier image is "002"
    And the user clicks the Block - Block card
    Then the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Blocking success screen is displayed
    And the user clicks on Back to Loyalty
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"blocked" card
    And user reads main card number
    And the newly-"blocked" card is displayed
    And Show card is disabled
    And block card button is changed to Your card is blocked

  @done1 @high
  Scenario: Verify that user can block TK card
    And the user enters a "BA" "TK" "188" card number
    And the user clicks on Link Your Card
    And the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Card linking splash screen is displayed
    And Card Linking Success screen is displayed - "TK"
    And the user clicks on Card Linking Success screen - Back to Home
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"linked" card
    And user reads main card number
    And the newly-"linked" card is displayed
    When the user clicks the Manage card - Block card
    And the user is on the Block Card page
    And the block tier image is "188"
    And the user clicks the Block - Block card
    Then the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Blocking success screen is displayed
    And the user clicks on Back to Loyalty
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"blocked" card
    And user reads main card number
    And the newly-"blocked" card is displayed
    And Show card is disabled
    And block card button is changed to Your card is blocked

    @failed @redirectedbackttoMCinsteadofHP
  Scenario: Verify that user can block MOM card
    When the user enters a "AR" "MOM" "352" card number
    And a text container is visible
    And Link your Card button is "enabled"
    And the user clicks on Link Your Card
    And the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Card linking splash screen is displayed
    And the user is on the MOM Registration Form - "Subsequent link" - "MOM"
    And the user clicks Back navigation
    And the Incomplete MOM Form submission modal is visible
    And the user clicks on Leave Page
    And the user is on the Manage card Page
    And the user swipes to newly-"linked" card
    And user reads main card number
    And the newly-"linked" card is displayed
    When the user clicks the Manage card - Block card
    And the user is on the Block Card page
    And the block tier image is "352"
    And the user clicks the Block - Block card
    Then the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Blocking success screen is displayed
    And the user clicks on Back to Loyalty
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"blocked" card
    And user reads main card number
    And the newly-"blocked" card is displayed
    And Show card is disabled
    And block card button is changed to Your card is blocked


  @done1 @high
  Scenario: Verify that user can block LYBC card
    And the user enters a "BA" "LYBC" "404" card number
    And the user clicks on Link Your Card
    And the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Card linking splash screen is displayed
    And Card Linking Success screen is displayed - "LYBC"
    And the user clicks on Card Linking Success screen - Back to Home
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"linked" card
    And user reads main card number
    And the newly-"linked" card is displayed
    When the user clicks the Manage card - Block card
    And the user is on the Block Card page
    And the block tier image is "404"
    And the user clicks the Block - Block card
    Then the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Blocking success screen is displayed
    And the user clicks on Back to Loyalty
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"blocked" card
    And user reads main card number
    And the newly-"blocked" card is displayed
    And Show card is disabled
    And block card button is changed to Your card is blocked

  @done1 @high
  Scenario: Verify that user can block ACE card
    And the user enters a "AR" "ACE" "505" card number
    And the user clicks on Link Your Card
    And the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Card linking splash screen is displayed
    And Card Linking Success screen is displayed - "ACE"
    And the user clicks on Card Linking Success screen - Back to Home
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"linked" card
    And user reads main card number
    And the newly-"linked" card is displayed
    When the user clicks the Manage card - Block card
    And the user is on the Block Card page
    And the block tier image is "505"
    And the user clicks the Block - Block card
    Then the user is redirected to OTP Verification
    And the user enters the correct OTP
    And Blocking success screen is displayed
    And the user clicks on Back to Loyalty
    And the user is on the Homepage
    And the user clicks the Manage card widget
    And the user is on the Manage card Page
    And the user swipes to newly-"blocked" card
    And user reads main card number
    And the newly-"blocked" card is displayed
    And Show card is disabled
    And block card button is changed to Your card is blocked