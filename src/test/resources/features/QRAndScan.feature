@android
Feature: QR and Scan
  Background:
    Given the user is on the SSO menu
    And the user clicks the Login button - SSO
    And the user is on the Login page

  Scenario: QR screen is the default landing upon clicking on QR navigation for account without linked card
    And the user logs in using valid mobile number and password - Not linked
    And the user is on the Homepage
    And bottom navigation is displayed
    When the user clicks the QR - Start
    Then the user is on QAS - QR Page - No linked card

  Scenario: QR screen is displayed correctly for SMAC Start members
    And the user logs in using valid mobile number and password - SMAC Start
    And the user is on the Homepage
    And bottom navigation is displayed
    When the user clicks the QR - Start
    Then the user is on the QAS - QR Page - Start

  Scenario: QR screen is displayed correctly for SMAC members
    And the user logs in using valid mobile number and password - SMAC
    And the user is on the Homepage
    And bottom navigation is displayed
    When the user clicks on QR - SMAC icon
    Then the user is on QAS - QR page - SMAC

  Scenario: QR screen is displayed correctly for Prestige members
    And the user logs in using valid mobile number and password - Prestige
    And the user is on the Homepage
    And bottom navigation is displayed
    When the user clicks on QR - Prestige icon
    Then the user is on QAS - QR page - Prestige

  Scenario: Barcode screen is displayed correctly for SMAC Start members
    And the user logs in using valid mobile number and password - SMAC Start
    And the user is on the Homepage
    And bottom navigation is displayed
    And the user clicks the QR - Start
    And the user is on the QAS - QR Page - Start
    And the user clicks the QR - Start
    When the user clicks on Show barcode - QAS
    Then the user is on QAS - Barcode page - Start

  Scenario: Barcode screen is displayed correctly for SMAC member
    And the user logs in using valid mobile number and password - SMAC
    And the user is on the Homepage
    And bottom navigation is displayed
    And the user clicks on QR - SMAC icon
    And the user is on QAS - QR page - SMAC
    When the user clicks on Show barcode - QAS
    Then the user is on QAS - Barcode page - SMAC

  Scenario: Barcode screen is displayed correctly for Prestige members
    And the user logs in using valid mobile number and password - Prestige
    And the user is on the Homepage
    And bottom navigation is displayed
    And the user clicks on QR - Prestige icon
    And the user is on QAS - QR page - Prestige
    When the user clicks on Show barcode - QAS
    Then the user is on QAS - Barcode page - Prestige

  Scenario: QR screen is displayed
    And the user logs in using valid mobile number and password - Prestige
    And the user is on the Homepage
    And bottom navigation is displayed
    And the user clicks on QR - Prestige icon
    And the user is on QAS - QR page - Prestige
    And the user clicks on Show barcode - QAS
    And the user is on QAS - Barcode page - Prestige
    When the user clicks on Show QR - QAS
    Then the user is on QAS - QR page - Prestige

  Scenario: Barcode screen is displayed
    And the user logs in using valid mobile number and password - Prestige
    And the user is on the Homepage
    And bottom navigation is displayed
    And the user clicks on QR - Prestige icon
    And the user is on QAS - QR page - Prestige
    When the user clicks on Show barcode - QAS
    Then the user is on QAS - Barcode page - Prestige

  Scenario: Pay with points is displayed
    And the user logs in using valid mobile number and password - Prestige
    And the user is on the Homepage
    And bottom navigation is displayed
    And the user clicks on QR - Prestige icon
    And the user is on QAS - QR page - Prestige
    When the user clicks on Pay with Points - QAS
    Then the user is on Scanner page - QAS

  Scenario: Last tab open will be displayed upon clicking on QR and Scan nav
    And the user logs in using valid mobile number and password - Prestige
    And the user is on the Homepage
    And bottom navigation is displayed
    And the user clicks on QR - Prestige icon
    And the user is on QAS - QR page - Prestige
    And the user clicks on Show barcode - QAS
    And the user is on QAS - Barcode page - Prestige
    And the user clicks the Home navigation
    When the user clicks on QR - Prestige icon
    Then the user is on QAS - Barcode page - Prestige