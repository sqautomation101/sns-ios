@android
Feature: Offline Virtual Card
  Rule: No Cache
    Background:
      Given the user is on the SSO menu

        @medium
      Scenario: Virtual SMAC Modal is displayed upon clicking View Virtual SMAC without logged in account
        When the user clicks on View Virtual SMAC button
        Then Virtual SMAC modal is displayed -  No account logged yet

        @medium
      Scenario: Virtual SMAC modal is hidden upon clicking Close button - No cache/history of login
        And the user clicks on View Virtual SMAC button
        And Virtual SMAC modal is displayed -  No account logged yet
        When the user clicks the View Virtual SMAC - No cache - Close
        Then Virtual SMAC modal is not displayed
        And the user is on the SSO menu

        @high
      Scenario: No Internet Connection modal is displayed without connectivity - No cache/history of login
        And the user turns off the connectivity
        And offline modal is displayed
        When the user clicks the Offline - Refresh
        Then Offline toast is displayed
        And View Virtual SMAC is "disabled"

        @high
      Scenario: Clicking Refresh without connectivity still displayed No Internet Connection modal
        And the user turns off the connectivity
        And offline modal is displayed
        And the user clicks the Offline - Refresh
        Then offline modal is displayed
        And Offline toast is displayed

        @high
      Scenario: No Internet Connection modal does not dismiss after clicking persistently the Refresh button without connectivity
        And the user turns off the connectivity
        And offline modal is displayed
        And the user clicks the Offline - Refresh
        Then offline modal is displayed
        And Offline toast is displayed
        And the user clicks the Offline - Refresh
        Then offline modal is displayed
        And Offline toast is displayed

        @high
      Scenario: Guest Homepage is displayed upon clicking on Refresh - No cache
        Given the user is on the SSO menu
        And the user turns off the connectivity
        And offline modal is displayed
        When the user turns on the connectivity
        And the user clicks the Offline - Refresh
        And Back online toast is displayed
        And the user is on the guest homepage


  Rule: No linked card - Dee Lan
    Background:
      Given the user is on the SSO menu
      And the user clicks on SSO Login button
      And the user logs in using valid mobile number and password - Not linked
      And the user is on the Homepage
      And the user turns off the connectivity

        @high
      Scenario: Homepage is displayed upon clicking on Refresh - Have Cache
        And offline modal is displayed
        When the user turns on the connectivity
        And the user clicks the Offline - Refresh
        And Back online toast is displayed
        And the user is on the Homepage

        @low
      Scenario: Offline Virtual card is displayed upon clicking View Virtual SMAC - No linked card
        And offline modal is displayed
        When the user clicks the Offline - View Virtual SMAC button
        Then Offline QR is displayed - "SMAC Start"

        @low
      Scenario: Offline Barcode is displayed upon clicking Show Barcode - No linked card
        And offline modal is displayed
        And the user clicks the Offline - View Virtual SMAC button
        And Offline QR is displayed - "SMAC Start"
        When the user clicks the Offline Show barcode
        Then Offline Barcode is displayed - "SMAC Start"
        And card number is virtual - Barcode


  Rule: Start account - Olivia Rodrigo
    Background:
      Given the user logs in - SMAC Start
      And the user is on the Homepage
      And the user turns off the connectivity

        @high
      Scenario: No Internet Connection modal is displayed without connectivity - Have cache/history of login
        Then offline modal is displayed
        And View Virtual SMAC is "enabled"

        @critical @failed
      Scenario: Offline Virtual card is displayed upon clicking View Virtual SMAC - Have cache
        And offline modal is displayed
        When the user clicks the Offline - View Virtual SMAC button
        Then Offline QR is displayed - "SMAC Start"
        And card number is not virtual - QR
#        And the user clicks tdisplayedhe Offline Show barcode
#        And Offline Barcode is displayed - Start
#        When the user clicks the Offline Show QR
#        Then Offline QR is displayed - Start

        @high
      Scenario: Offline QR is displayed upon clicking Show QR - Start
        And offline modal is displayed
        And the user clicks the Offline - View Virtual SMAC button
        And the user clicks the Offline Show barcode
        And Offline Barcode is displayed - "SMAC Start"
        When the user clicks the Offline Show QR
        Then Offline QR is displayed - "SMAC Start"
        And card number is not virtual - QR

        @high
      Scenario: Offline Barcode is displayed upon clicking Show Barcode - Start
        And offline modal is displayed
        When the user clicks the Offline - View Virtual SMAC button
        Then the user clicks the Offline Show barcode
        And Offline Barcode is displayed - "SMAC Start"
        And card number is not virtual - Barcode

        @high
      Scenario: No Internet Connection modal is displayed upon clicking Back button of Offline Barcode
        And offline modal is displayed
        And the user clicks the Offline - View Virtual SMAC button
        And the user clicks the Offline Show barcode
        And Offline Barcode is displayed - "SMAC Start"
        When the user clicks the Show Barcode - Back
        Then offline modal is displayed

        @high
      Scenario: No Internet Connection modal is displayed upon clicking Back button of Offline QR
        And offline modal is displayed
        And the user clicks the Offline - View Virtual SMAC button
        And Offline QR is displayed - "SMAC Start"
        When the user clicks the Show QR - Back
        Then offline modal is displayed


  Rule: SMAC account - Sabrina Carpenter
    Background:
      Given the user logs in - SMAC
      And the user is on the Homepage
      And the user turns off the connectivity

        @high
      Scenario: Offline QR is displayed upon clicking Show QR - SMAC
        And offline modal is displayed
        And the user clicks the Offline - View Virtual SMAC button
        And the user clicks the Offline Show barcode
        And Offline Barcode is displayed - "SMAC Blue"
        When the user clicks the Offline Show QR
        Then Offline QR is displayed - "SMAC Blue"
        And card number is not virtual - QR

        @high
      Scenario: Offline Barcode is displayed upon clicking Show Barcode - SMAC
        And offline modal is displayed
        When the user clicks the Offline - View Virtual SMAC button
        Then the user clicks the Offline Show barcode
        And Offline Barcode is displayed - "SMAC Blue"
        And card number is not virtual - Barcode


  Rule: Prestige account - Maddy Perez
    Background:
      Given the user logs in - Prestige
      And the user is on the Homepage
      And the user turns off the connectivity

        @high
      Scenario: Offline QR is displayed upon clicking Show QR - Prestige
        And offline modal is displayed
        And the user clicks the Offline - View Virtual SMAC button
        And the user clicks the Offline Show barcode
        And Offline Barcode is displayed - "SMAC Prestige"
        When the user clicks the Offline Show QR
        Then Offline QR is displayed - "SMAC Prestige"
          And card number is not virtual - QR

        @high
      Scenario: Offline Barcode is displayed upon clicking Show Barcode - Prestige
        And offline modal is displayed
        When the user clicks the Offline - View Virtual SMAC button
        Then the user clicks the Offline Show barcode
        And Offline Barcode is displayed - "SMAC Prestige"
        And card number is not virtual - Barcode