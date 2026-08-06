@android
Feature: Card Linking
  Rule: Empty state
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      And the user logs in using valid mobile number and password - Card Link - "Charlene Joie"
      And the user is on the Homepage
      When the user clicks on Homepage Link Card
      And the user is on the card linking page

#      @done @deferred
#      Scenario: Card linking screen displays activation instructions text below card images
#        Then View activation instructions button is visible
#
#        @done1 @deferred
#      Scenario: User is on Card Activation Instructions
#        When the user clicks on info icon View Activation Instructions
#        Then Activation instructions modal is "visible"
#
#      @done1 @deferred
#      Scenario: Clicking on Close via Card Activation Instructions closes the modal
#        And the user clicks on info icon View Activation Instructions
#        When the user clicks on Activation Instructions - Close
#        And the user is on the card linking page

  @done1 @critical
        Scenario: Card linking is possible from empty state screen
          And the user enters a "AR" "SMAC" "878" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Link voucher modal is displayed
          And the user clicks on Link Card Voucher modal - Close
          And Card Linking Success screen is displayed - "SMAC"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          And SMAC default virtual card is visible
          And bottom navigation is displayed
          And Bottom nav - QR is "SMAC"
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And user reads main card number
          Then the newly-"linked" card is displayed

  @done1 @critical
        Scenario: User can link SMAC Start card
          And the user enters a "BA" "Start" "822" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "Start"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed

  @done1 @critical
      Scenario: User can link SMAC card
        And the user enters a "BA" "SMAC" "877" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "SMAC"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        And SMAC default virtual card is visible
        And bottom navigation is displayed
        And Bottom nav - QR is "SMAC"
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        #And the user swipes to newly-"linked" card #for-debugging-only
        And user reads main card number
        Then the newly-"linked" card is displayed

  @done1 @critical
        Scenario: User can link SMAC Prestige card
          And the user enters a "BA" "Prestige" "001" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "Prestige"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          And SMAC Prestige default virtual card is visible
          And bottom navigation is displayed
          And Bottom nav - QR is "Prestige"
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          #And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed

  @done1 @critical
        Scenario: User can link ACE card
          And the user enters a "AR" "ACE" "505" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "ACE"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed

    @done1 @critical
      Scenario: User can link MOM
      When the user enters a "AR" "MOM" "352" card number
      And a text container is visible
      And Link your Card button is "enabled"
      And the user clicks on Link Your Card
      And the user is redirected to OTP Verification
      And the user enters the correct OTP
      And Card linking splash screen is displayed
      And the user is on the MOM Registration Form - "Subsequent Link" - "MOM"
      And the user clicks Back navigation
      And the Incomplete MOM Form submission modal is visible
      And the user clicks on Leave Page
      And the user is on the Manage card Page
      And the user swipes to newly-"linked" card
      And user reads main card number
      Then the newly-"linked" card is displayed

  @done1 @critical
      Scenario: User can link LYBC card
        And the user enters a "BA" "LYBC" "404" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "LYBC"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed

  @done1 @critical
      Scenario: User can link TK card
        And the user enters a "BA" "TK" "188" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "TK"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed

  @done1 @medium
      Scenario: Successful Card linking screen is displayed
        And the user enters a "AR" "Start" "822" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "Start"

  @done1 @medium
      Scenario: Homepage is visible upon clicking on Back to Home
        And the user enters a "AR" "Start" "822" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "Start"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage


    # Linking prevention scenarios
      @done @medium
      Scenario: Prevent linking of Blocked
        When the user enters a "Blocked" card
        Then an error message will "appear" - "Blocked"
        And Link your Card button is "disabled"

  @done @low
      Scenario: Prevent linking of Lost Card (BBL)
        When the user enters a "BBL" card
        Then an error message will "appear" - "Blocked"
        And Link your Card button is "disabled"

      @done @low
      Scenario: Prevent linking of an already linked card
        When the user enters a "already linked" card
        Then an error message will "appear" - "Card already associated"
        And Link your Card button is "disabled"

      @done @low @toUpdate
      Scenario: Prevent linking of a card with BPR status
        When the user enters a "BPR" "Start" "822" card number
        Then an error message will "appear" - "Card not Activated"
        And Link your Card button is "disabled"

      @done @low
      Scenario: Prevent linking Nonexistent card
        When the user enters a "nonexistent" card
        Then an error message will "appear" - "nonexistent"
        And Link your Card button is "disabled"

      @done @low
      Scenario:Prevent linking card with BA/AR status without mobile number
        When the user enters a "BA or AR SMAC card without mobile" card
        #And the user clicks on Link Your Card
        Then an error message will "appear" - "Mobile number associated"
        And Link your Card button is "disabled"

      @done @low
      Scenario:Prevent linking card with BA/AR status with a mobile number update still pending approval
        When the user enters a "BA or AR with updated card number (pending approval) SMAC" card
        #And the user clicks on Link Your Card
        Then an error message will "appear" - "Mobile number associated"
        And Link your Card button is "disabled"

      @done @low
      Scenario: Prevent linking SMAC with pending points-related OLS transaction
        When the user enters a "SMAC with pending points-related transaction" card
        And the user clicks on Link Your Card
        Then an error message will "appear" - "Unable to link"
        And Link your Card button is "disabled"

      @done @low
      Scenario: Prevent linking expired SMAC Prestige (IIP)
        When the user enters a "IIP with more than 90 days expiry Prestige" card
        Then an error message will "appear" - "Expired"
        And Link your Card button is "disabled"

      @done @low
      Scenario: Prevent linking a card with bin type that is unlinkable
        When the user enters a "Primo" "100" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @low
      Scenario: Prevent linking a card with registered invalid mobile number
        When the user enters a "registered invalid mobile number" card
        And the user clicks on Link Your Card
        Then an error message will "appear" - "Mobile number associated"

      @done @medium
      Scenario: Prevent linking a Primo 100 card
        When the user enters a "Primo" "100" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a Primo 200 card
        When the user enters a "Primo" "200" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a SMAC 999 card
        When the user enters a "SMAC" "999" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a Supplies Station 300 card
        When the user enters a "Supplies Station" "300" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a Crate and Barrel 630 card
        When the user enters a "Crate and Barrel" "630" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a SM Hotels 710 card
        When the user enters a "SM Hotels" "710" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a Miniso Wink Rewards 879 card
        When the user enters a "Miniso Wink Rewards" "879" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a BDOR Emerald 512 card
        When the user enters a "BDOR Emerald" "512" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a BDOR Ruby 512 card
        When the user enters a "BDOR Ruby" "512" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a BDOR Sapphire 512 card
        When the user enters a "BDOR Sapphire" "512" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done @medium
      Scenario: Prevent linking a BDOR Diamond 512 card
        When the user enters a "BDOR Diamond" "512" card
        Then an error message will "appear" - "Not eligible"
        And Link your Card button is "disabled"

      @done1 @high
      Scenario: Incorrect OTP is rejected for SMAC Start cards with BA/APE/AR/IIP/IIPS status
        When the user enters a "BA" "Start" "822" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters an incorrect OTP
        Then an error message will "appear" - "Incorrect OTP"

      @done1 @high
      Scenario: Incorrect OTP is rejected for SMAC cards with BA/APE/AR/IIP/IIPS status
        When the user enters a "AR" "SMAC" "878" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters an incorrect OTP
        Then an error message will "appear" - "Incorrect OTP"

      @done1 @high
      Scenario: Incorrect OTP is rejected for SMAC Prestige cards with BA/APE/AR/IIP/IIPS status
        When the user enters a "AR" "Prestige" "002" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters an incorrect OTP
        Then an error message will "appear" - "Incorrect OTP"

      @high @done1
      Scenario: Incorrect OTP is rejected for TK with BA/APE/AR/IIP/IIPS status
        When the user enters a "BA" "TK" "188" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters an incorrect OTP
        Then an error message will "appear" - "Incorrect OTP"

      @high @done1
      Scenario: Incorrect OTP is rejected for ACE with BA/APE/AR/IIP/IIPS status
        When the user enters a "BA" "ACE" "505" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters an incorrect OTP
        Then an error message will "appear" - "Incorrect OTP"

      @high @done1
      Scenario: Incorrect OTP is rejected for LYBC with BA/APE/AR/IIP/IIPS status
        When the user enters a "BA" "LYBC" "404" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters an incorrect OTP
        Then an error message will "appear" - "Incorrect OTP"


      Scenario: Incorrect OTP is rejected for MOM with BA/APE/AR/IIP/IIPS status
        When the user enters a "BA" "MOM" "352" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters an incorrect OTP
        Then an error message will "appear" - "Incorrect OTP"

        @high @done1
      Scenario: SMAC Start (product code 822) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "Start" "822" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "Start"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC Start"
        And the card type is "SMAC Start"

          @high @done1
      Scenario: SMAC (product code 513) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "SMAC" "513" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "SMAC"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC"
        And the card type is "SMAC"

      @high @done1
      Scenario: SMAC (product code 877) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "SMAC" "877" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "SMAC"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC"
        And the card type is "SMAC"

        @high @done1
      Scenario: SMAC (product code 878) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "SMAC" "878" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "SMAC"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC"
        And the card type is "SMAC"

      Scenario: SMAC (product code 888) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "SMAC" "888" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "SMAC"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC"
        And the card type is "SMAC"

        @high @done1
      Scenario: SMAC Prestige (product code 001) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "Prestige" "001" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "Prestige"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC Prestige"
        And the card type is "SMAC Prestige"

      @high @done1
      Scenario: SMAC Prestige (product code 002) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "Prestige" "002" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "Prestige"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC Prestige"
        And the card type is "SMAC Prestige"

      @high @done1
      Scenario: SMAC Prestige (product code 003) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "Prestige" "003" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "Prestige"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC Prestige"
        And the card type is "SMAC Prestige"

      @high @done1
      Scenario: SMAC Prestige (product code 004) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "Prestige" "004" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "Prestige"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC Prestige"
        And the card type is "SMAC Prestige"

      @high @done1
      Scenario: Toy Kingdom (product code 188) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "TK" "188" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "TK"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "Toy Kingdom Amazing"
        And the card type is "Toy Kingdom Amazing"

      @high @done1
      Scenario: MOM (product code 352) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "MOM" "352" card number
        And a text container is visible
        And Link your Card button is "enabled"
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And the user is on the MOM Registration Form - "Subsequent Link" - "MOM"
        And the user clicks Back navigation
        And the Incomplete MOM Form submission modal is visible
        And the user clicks on Leave Page
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "MOM"
        And the card type is "MOM"

      @high @done1
      Scenario: LYBC (product code 404) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "LYBC" "404" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "LYBC"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "Love Your Body Card"
        And the card type is "Love Your Body Card"

        @high @done1
      Scenario: ACE (product code 505) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "ACE" "505" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "ACE"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "ACE Rewards"
        And the card type is "ACE Rewards"

      @high @done1
      Scenario: SM Pride (product code 880) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "SM Pride" "880" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "SM Pride"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC"
        And the card type is "SMAC"

      @high @done1
      Scenario: SM Pride (product code 881) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "SM Pride" "881" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "SM Pride"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC Prestige"
        And the card type is "SMAC Prestige"

      @high @done1
      Scenario: SMAC BDO MC (product code 512) is linkable, with the correct Card Name and Image Display
        When the user enters a "AR" "BDO MC" "512" card number
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And Card Linking Success screen is displayed - "BDO MC"
        And the user clicks on Card Linking Success screen - Back to Home
        And the user is on the Homepage
        When the user clicks the Manage card widget
        And the user is on the Manage card Page
        And the user swipes to newly-"linked" card
        And user reads main card number
        Then the newly-"linked" card is displayed
        And the card logo is "SMAC"
        And the card type is "SMAC"

          @high @done1
        Scenario: Child card inherits the cardholder name from the parent card - SMAC Start
          When the user enters a "BA" "SMAC Start" "822" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "Start - Inherit Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "inherits" the name "from the parent card"

        @high @done1
        Scenario: Child card inherits the cardholder name from the parent card - SMAC
          When the user enters a "BA" "SMAC Regular" "877" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "SMAC - Inherit Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "inherits" the name "from the parent card"

        @high @done1
        Scenario: Child card inherits the cardholder name from the parent card - SMAC Prestige
          When the user enters a "BA" "SMAC Prestige" "002" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "SMAC Prestige - Inherit Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "inherits" the name "from the parent card"

        @high @done1
        Scenario: Child card inherits the cardholder name from the parent card - ACE Rewards
          When the user enters a "BA" "ACE Rewards" "505" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "ACE Rewards - Inherit Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "inherits" the name "from the parent card"


        @high @done1
        Scenario: Child card inherits the cardholder name from the parent card - LYBC
          When the user enters a "BA" "Love Your Body Card" "404" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "LYBC Express - Inherit Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "inherits" the name "from the parent card"

        @high @done1
        Scenario: Child card inherits the cardholder name from the parent card - TK
          When the user enters a "BA" "Toy Kingdom" "188" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "TK - Inherit Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "inherits" the name "from the parent card"

        @high @done1
        Scenario: Child card inherits the cardholder name from the parent card - MOM
          When the user enters a "BA" "MOM card" "352" card number
          And a text container is visible
          And Link your Card button is "enabled"
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "MOM - Inherit Name"
          And the user is on the MOM Registration Form - "Subsequent Link" - "MOM card"
          And the user clicks Back navigation
          And the Incomplete MOM Form submission modal is visible
          And the user clicks on Leave Page
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "inherits" the name "from the parent card"


        @high @done1
        Scenario: Child card retains the cardholder name - SMAC Start
          When the user enters a "AR" "SMAC Start" "822" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "Start - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @high @done1
        Scenario: Child card retains the cardholder name - SMAC
          When the user enters a "AR" "SMAC Regular" "877" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "SMAC - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @high @done1
        Scenario: Child card retains the cardholder name - SMAC Prestige
          When the user enters a "AR" "SMAC Prestige" "002" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "SMAC Prestige - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @high @done1
        Scenario: Child card retains the cardholder name - ACE Rewards
          When the user enters a "AR" "ACE Rewards" "505" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "ACE Rewards - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @high @done1
        Scenario: Child card retains the cardholder name - MOM
          When the user enters a "AR" "MOM card" "352" card number
          And a text container is visible
          And Link your Card button is "enabled"
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "MOM - Retain Name"
          And the user is on the MOM Registration Form - "Subsequent Link" - "MOM card"
          And the user clicks Back navigation
          And the Incomplete MOM Form submission modal is visible
          And the user clicks on Leave Page
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @high @done1
        Scenario: Child card retains the cardholder name - LYBC
          When the user enters a "AR" "Love Your Body Card" "404" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "LYBC Express - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @high @done1
        Scenario: Child card retains the cardholder name - TK
          When the user enters a "AR" "Toy Kingdom" "188" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "TK - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @done1 @medium
        Scenario: Successfully link an expired (IIPS) card (expired within 90 days) while retaining the cardholder's name - SMAC
          When the user enters a "IIPS" "SMAC Regular" "877" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "SMAC - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @done1 @medium
        Scenario: Successfully link an expired (IIP) card (expired within 90 days) while retaining the cardholder's name - Prestige
          When the user enters a "IIP" "SMAC Prestige" "002" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "SMAC Prestige - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @done1 @medium
        Scenario: Successfully link an expired (IIPS) card (expired within 90 days) while retaining the cardholder's name - ACE
          When the user enters a "IIPS" "ACE Rewards" "505" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "ACE Rewards - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @done1
        Scenario: Successfully link an expired (IIPS) card (expired within 90 days) while retaining the cardholder's name - LYBC Express
          When the user enters a "IIPS" "Love Your Body Card" "404" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "LYBC Express - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @done1
        Scenario: Successfully link an expired (IIPS) card (expired within 90 days) while retaining the cardholder's name - TK
          When the user enters a "IIPS" "Toy Kingdom" "188" card number
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "TK - Retain Name"
          And the user clicks on Card Linking Success screen - Back to Home
          And the user is on the Homepage
          When the user clicks the Manage card widget
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @done1
        Scenario: Successfully link an expired (IIPS) card (expired within 90 days) while retaining the cardholder's name - MOM
          When the user enters a "IIPS" "MOM card" "352" card number
          And a text container is visible
          And Link your Card button is "enabled"
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And Card Linking Success screen is displayed - "MOM - Retain Name"
          And the user is on the MOM Registration Form - "Subsequent Link" - "MOM card"
          And the user clicks Back navigation
          And the Incomplete MOM Form submission modal is visible
          And the user clicks on Leave Page
          And the user is on the Manage card Page
          And the user swipes to newly-"linked" card
          And user reads main card number
          Then the newly-"linked" card is displayed
          And the cardholder name "retains" the name "on card"

        @done @medium
        Scenario: Prevent linking a SMAC Card that is expired beyond 90 days from grace period
          When the user enters a "IIPS with more than 90 days expiry SMAC" card
          Then an error message will "appear" - "Expired"
          And Link your Card button is "disabled"

        @done @medium
        Scenario: Prevent linking a Prestige Card that is expired beyond 90 days from grace period
          When the user enters a "IIP with more than 90 days expiry Prestige" card
          Then an error message will "appear" - "Expired"
          And Link your Card button is "disabled"

        Scenario: Prevent linking a MOM Card that is expired beyond 90 days from grace period
          When the user enters a "IIP with more than 90 days expiry MOM" card
          Then an error message will "appear" - "Expired"
          And Link your Card button is "disabled"

        Scenario: Prevent linking a TK Card that is expired beyond 90 days from grace period
          When the user enters a "IIP with more than 90 days expiry TK" card
          Then an error message will "appear" - "Expired"
          And Link your Card button is "disabled"

        Scenario: Prevent linking an ACE Card that is expired beyond 90 days from grace period
          When the user enters a "IIP with more than 90 days expiry ACE" card
          Then an error message will "appear" - "Expired"
          And Link your Card button is "disabled"

        Scenario: Prevent linking a LYBC Card that is expired beyond 90 days from grace period
          When the user enters a "IIP with more than 90 days expiry LYBC" card
          Then an error message will "appear" - "Expired"
          And Link your Card button is "disabled"