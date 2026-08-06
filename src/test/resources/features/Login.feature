@android
Feature: Login
  Background:
    Given the user is on the SSO menu
    When the user clicks the Login button - SSO
    And the user is on the Login page

      @high 
    Scenario: Error message is displayed and Login button is disabled when username field is blank
      When the username is blank
      And the user enters a password
      Then login button is disabled
      And the username field has an error message

      @high 
    Scenario: Error message is displayed and Login button is disabled when password field is blank
      When the user enters a valid username
      And the password is blank
      Then login button is disabled
      And the password field has an error message

      @medium 
    Scenario: Alphanumeric input is allowed in the username field
      When the user enters an alphanumeric input on username
      Then the username input is accepted

      @medium
    Scenario: Alphanumeric input is allowed in the password field
      When the user enters an alphanumeric input on password
      Then the password input is accepted

      @medium 
    Scenario: Specific special characters are allowed in the username field for Email input (- _ @ .)
      When the user enters an email address with allowed special character given that the correct format is followed
      Then the username input is accepted

      @medium 
    Scenario: Special characters are allowed in the password field
      When the user enters a password with special characters
      Then the password input is accepted

      @high 
    Scenario: New Account Registration modal is displayed upon logging in unregistered email
      When the user enters an unregistered email address
      And the user enters a password
      And the user clicks the Login button
      Then New Account Registration modal is visible

      @high 
    Scenario: New Account Registration modal is displayed upon logging in unregistered mobile number
      When the user enters an unregistered mobile number
      And the user enters a password
      And the user clicks the Login button
      Then New Account Registration modal is visible

      @high 
    Scenario: Error message is displayed for invalid email format during login
      When the user enters an email address with invalid format
      Then an error message for username appears with invalid format

      @high 
    Scenario: Error message is displayed for logging in registered email and incorrect password
      When the user enters a registered "email"
      And the user enters an incorrect password
      And the user clicks the Login button
      Then an error message appears for incorrect login credentials

      @high 
    Scenario: Error message is displayed for logging in registered mobile number and incorrect password
      When the user enters a registered "mobile"
      And the user enters an incorrect password
      And the user clicks the Login button
      Then an error message appears for incorrect login credentials

      @high 
    Scenario: Error message is displayed for invalid mobile number format during login
      When the user enters a mobile number with invalid format
      Then an error message for username appears with invalid format

      @critical 
    Scenario: Successful login via mobile number
      When the user logs in using valid mobile number and password - SMAC
      Then the user is on the Homepage

      @critical 
    Scenario: Successful login via email address
      When the user logs in using valid email address and password - SMAC
      Then the user is on the Homepage

      @critical 
    Scenario: User logs out successfully
      When the user logs in using valid email address and password - SMAC
      Then the user is on the Homepage
      And the user clicks the Account navigation
      And the user is on the Account Page
      And the user clicks the Logout
      Then the user is on the SSO menu