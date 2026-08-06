@android
Feature: Manage Cards

    Rule: No card account
      Background:
        Given the user is on the SSO menu
        And the user clicks on SSO Login button
        And the user logs in using valid mobile number and password - Not linked
        And the user is on the Homepage
        And the user clicks the Manage card widget
        And the user is on the Manage card Page

          @medium
        Scenario: Block card button is disabled when account has no cards
          Then Block card is disabled

          @high @locator-unableToClick 
        Scenario: Card linking page is visible upon clicking Link card button - Not linked
          When the user clicks the Manage card - Link card
          Then the user is on the card linking page

          @low 
        Scenario: Empty state of Manage card is displayed
          And the user is on the Manage card Page
  #End of NL account


      Rule: Start account - Olivia Rodrigo
        Background:
          Given the user is on the SSO menu
          And the user clicks on SSO Login button
          And the user logs in using valid mobile number and password - SMAC Start
          And the user is on the Homepage
          And the user clicks the Manage card widget
          And the user is on the Manage card Page


            @medium 
          Scenario: SMAC Start as highest-tier is displayed on Manage Card
            #And the card is displayed
            When user reads main card number
            Then "Start" card is displayed

            @high 
          Scenario: QR Code - Card number matches with the linked physical card - Start
            #And the card is displayed
            And user reads main card number
            And the user clicks the Manage card - Show Card
            And Show Card - QR is displayed - Start
            Then the card number from QR screen matches with the linked physical card

            @high 
          Scenario: QR Code - Card number matches with the linked physical card - MOM
            When the user swipes to "MOM" card
            #And the card is displayed
            And user reads main card number
            When the user clicks the Manage card - Show Card
            Then the card number from QR screen matches with the linked physical card

          @low
          Scenario: Block card button is disabled when card is expired
            When the user swipes to expired card
            #And the card is displayed
            Then Block card is disabled

          @low
          Scenario: Show card is disabled when card is expired
            And the user swipes to expired card
            #And the card is displayed
            Then Show card is disabled
  #End of Start account

    Rule: SMAC account - Sabrina Carpenter
      Background:
        Given the user is on the SSO menu
        And the user clicks on SSO Login button
        And the user logs in using valid mobile number and password - SMAC
        And the user is on the Homepage
        And the user clicks the Manage card widget
        And the user is on the Manage card Page

          @medium 
        Scenario: SMAC as highest-tier is displayed on Manage Card
          When user reads main card number
          #And the card is displayed
          Then "SMAC" card is displayed

          @low 
        Scenario: Block card button is disabled and changed to "Your card is blocked" when card is blocked
          When the user swipes to blocked card
          And the card is displayed
          Then Block card is disabled
          And block card button is changed to Your card is blocked

          @low 
        Scenario: Block card button is enabled when account has active linked card/s
          #And the card is displayed
          Then Block card is enabled - Linked

          @high 
        Scenario: QR Code - Card number matches with the linked physical card - SMAC
          #And the card is displayed
          And user reads main card number
          And the user clicks the Manage card - Show Card
          And Show Card - QR is displayed - SMAC
          Then the card number from QR screen matches with the linked physical card

          @low 
        Scenario: Show card is disabled when card is blocked
          And the user swipes to blocked card
          #And the card is displayed
          Then Show card is disabled

          @high 
        Scenario: QR Code - Card number matches with the linked physical card - BDO MC
          When the user swipes to BDO MC card
          #And the card is displayed
          And user reads main card number
          When the user clicks the Manage card - Show Card
          Then the card number from QR screen matches with the linked physical card

          @high 
        Scenario: QR Code - Card number matches with the linked physical card - LYBC
          And the user swipes to LYBC card
          #And the card is displayed
          And user reads main card number
          When the user clicks the Manage card - Show Card
          Then the card number from QR screen matches with the linked physical card
  #End of SMAC account

    Rule: Prestige account - Maddy Perez
      Background:
        Given the user is on the SSO menu
        And the user clicks on SSO Login button
        And the user logs in using valid mobile number and password - Prestige
        And the user is on the Homepage
        And the user clicks the Manage card widget
        And the user is on the Manage card Page

          @medium 
        Scenario: SMAC Prestige as highest-tier is displayed on Manage Card
          #And the card is displayed
          When user reads main card number
          Then "Prestige" card is displayed

          @high 
        Scenario: Homepage is displayed upon clicking Back button from Manage Card page
          When the user clicks the Manage card - Back
          Then the user is on the Homepage

          @high 
        Scenario: Transfer points page is displayed upon clicking transfer points button
          When the user clicks the Manage card - Transfer points
          Then the user is on the transfer points page

          @high 
        Scenario: Block card page is displayed upon clicking Block card button
          When the user clicks the Manage card - Block card
          Then the user is on the Block Card page

          @low 
        Scenario: Show card is enabled when card is active
          #And the card is displayed
          Then Show card is enabled

          @high 
        Scenario: Card linking page is displayed upon clicking on Link card - With linked card
          When the user clicks the Link card button
          Then the user is on the card linking page

          @high 
        Scenario: Show Card default landing is QR
          When the user clicks the Manage card - Show Card
          Then Show Card - QR is visible - Prestige

          @high 
        Scenario: Swiping down hides the QR/Barcode card display
          And the user clicks the Manage card - Show Card
          And Show Card - QR is visible - Prestige
          When the user swipes down
          Then Show card - QR is hidden

          @medium 
        Scenario: Tapping outside the card display hides the QR/Barcode image
            And the user clicks the Manage card - Show Card
            And Show Card - QR is visible - Prestige
            When the user clicks outside the modal
            Then Show card - QR is hidden

          @high 
        Scenario: Show Card - Barcode is displayed
            When the user clicks the Manage card - Show Card
            And Show Card - QR is visible - Prestige
            And the user clicks on Show card - Barcode
            Then Show Card - Barcode is visible

          @high 
        Scenario: Linked card counter is accurate
          Then the Linked cards counter is accurate

          @high 
        Scenario: Clicking on QR and Barcode toggles accordingly
          When the user clicks the Manage card - Show Card
          Then Show Card - QR is visible - Prestige
          When the user clicks on Show card - Barcode
          Then Show Card - Barcode is visible

          @high 
        Scenario: QR Code - Card number matches with the linked physical card - Prestige
          #And the card is displayed
          And user reads main card number
          When the user clicks the Manage card - Show Card
          And Show Card - QR is visible - Prestige
          Then the card number from QR screen matches with the linked physical card

          @high 
        Scenario: QR Code - Card number matches with the linked physical card - TK
          And the user swipes to TK card
          #And the card is displayed
          And user reads main card number
          When the user clicks the Manage card - Show Card
          Then the card number from QR screen matches with the linked physical card

          @high 
        Scenario: QR Code - Card number matches with the linked physical card - ACE
          When the user swipes to ACE card
          #And the card is displayed
          And user reads main card number
          When the user clicks the Manage card - Show Card
          Then the card number from QR screen matches with the linked physical card
  #End of Prestige account