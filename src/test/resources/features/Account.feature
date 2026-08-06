@android
Feature: Account
  Background:
    Given the user is on the SSO menu
    And the user clicks the Login button - SSO
    And the user is on the Login page
    And the user logs in using valid mobile number and password - Prestige
    And the user is on the Homepage
    When the user clicks the Account navigation

      @high
    Scenario: Account page is displayed
      Then the user is on the Account Page

      @high
    Scenario: Help and information page is displayed
      And the user is on the Account Page
      When the user clicks the Help and information
      Then the user is on the Help and Information Page

      @high
    Scenario: Manage cards page is displayed upon clicking Manage Cards from Account page
      And the user is on the Account Page
      When the user clicks the Account - Manage cards
      Then the user is on the Manage card Page

      @high
    Scenario: Points History page is displayed upon clicking Points History from Account page
      And the user is on the Account Page
      When the user clicks the Points history from Account page
      Then the user is on the Points History page