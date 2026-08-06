@ios
Feature: SSO Menu

    @low
  Scenario: SSO Menu is displayed
    Then the user is on the SSO menu

  Rule: Redirections
    Background:
      Given the user is on the SSO menu

        @critical
      Scenario: Login page is displayed upon clicking Login
        When the user clicks on SSO Login button
        Then the user is on the Login page

        @critical
      Scenario: Sign up page is displayed upon clicking Sign Up
        When the user clicks on Sign up button
        Then Sign Up Menu is visible

        @high
      Scenario: Guest homepage is visible upon clicking Continue as Guest
        When the user clicks the Continue as Guest button
        Then the user is on the guest homepage

    @critical
      Scenario: Forgot Password page is displayed upon clicking Forgot
        And the user clicks on SSO Login button
        And the user is on the Login page
        When the user clicks the Forgot? button
        Then the user is on the Forgot Password page