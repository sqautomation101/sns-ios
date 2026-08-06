@android
Feature: Inbox
  Rule: Start Account - Olivia Rodrigo
    Background:
      Given the user is on the SSO menu
      And the user clicks on SSO Login button
      And the user logs in using valid mobile number and password - Prestige
      And the user is on the Homepage

        @low
      Scenario: Empty inbox is displayed correctly
        When the user clicks the inbox navigation
        Then the user is on the inbox page - empty state


  Rule: SMAC Account - Sabrina Carpenter
    Background:
      Given the user is on the SSO menu
      And the user clicks on SSO Login button
      And the user logs in using valid mobile number and password - SMAC
      And the user is on the Homepage

        @medium
      Scenario: Account with inbox is displayed correctly
        When the user clicks the inbox navigation
        Then the user is on the inbox page

        @high
      Scenario: Inbox content is correctly displayed on inner inbox screen
        When the user clicks the inbox navigation
        And the user is on the inbox page
        And user reads the inbox title
        And user reads the inbox body
        And the user clicks the message
        Then the user is redirected to inbox inner page
        And the inbox title matches from outer inbox screen
        And the inbox body matches from outer inbox screen

        @low @failed
      Scenario: Outer Inbox is displayed upon clicking on Back button from Inner Inbox page
        And the user clicks the inbox navigation
        And the user is on the inbox page
        And user reads the inbox title
        And user reads the inbox body
        And the user clicks the message
        And the user is redirected to inbox inner page
        When the user clicks the back button - inner inbox
        Then the user is on the inbox page