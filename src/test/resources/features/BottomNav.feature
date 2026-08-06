@android
Feature: Bottom Navigation
  Rule: Start account - Olivia Rodrigo
    Background:
      Given the user logs in - SMAC Start
      And the user is on the Homepage
      And bottom navigation is displayed

        @high
      Scenario: Vouchers page is displayed upon clicking Vouchers navigation
        When the user clicks the vouchers navigation
        Then the user is on the vouchers page

        @high @failed
        Scenario: QR page is displayed upon clicking QR navigation
        When the user clicks the QR - Start
        Then the user is on the QAS - QR Page - Start

        @medium @failed
      Scenario: SMAC Start as highest tier is displayed on QR and Scan page
        Then the QR button is reflected as "Start" tier
        When the user clicks the QR - Start
        Then the user is on the QAS - QR Page - Start

        @high
      Scenario: Account page is displayed upon clicking Account navigation
        When the user clicks the Account navigation
        Then the user is on the Account Page

#        @high @DEFERRED
#      Scenario: Shop page is displayed upon clicking on Shop navigation
#        When the user clicks the shop navigation
#        Then the user is on the Shop page

        @high
      Scenario: Homepage screen is displayed upon clicking Home navigation
        And the user clicks the Account navigation
        When the user clicks the Home navigation
        Then the user is on the Homepage


  Rule: SMAC account - Sabrina Carpenter
    Background:
      Given the user logs in - SMAC
      And the user is on the Homepage
      And bottom navigation is displayed

        @medium
      Scenario: SMAC as highest tier is displayed on QR and Scan page
        Then the QR button is reflected as "SMAC" tier
        When the user clicks on QR - SMAC icon
        Then the user is on QAS - QR page - SMAC

          @high
      Scenario: Inbox is displayed upon clicking Inbox navigation
        When the user clicks the inbox navigation
        Then the user is on the inbox page

  Rule: Prestige account - Maddy Perez
    Background:
      Given the user logs in - Prestige
      And the user is on the Homepage
      And bottom navigation is displayed

        @medium
      Scenario: SMAC Prestige as highest tier is displayed on QR and Scan page
        Then the QR button is reflected as "Prestige" tier
        When the user clicks on QR - Prestige icon
        Then the user is on QAS - QR page - Prestige