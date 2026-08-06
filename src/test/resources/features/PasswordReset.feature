@android
Feature: Password Reset
  Scenario: Error message is displayed for invalid email format in Password Reset
  Scenario: Error message is displayed for invalid mobile number format in Password Reset
  Scenario: Error message is displayed for unregistered email format in Password Reset
  Scenario: Error message is displayed for unregistered mobile number format in Password Reset
  Scenario: Reset Password page is displayed for registered native account email
  Scenario: Reset Password page is displayed for registered native account mobile number
  Scenario: Forgot Password is displayed upon clicking the Back button of Password Reset page
  Scenario: Error message is displayed for blank Password field
  Scenario: Alphanumeric and special characters input is accepted on Password field
  Scenario: Error message is displayed for password with whitespace
  Scenario: Password is masked by default and Show Password icon is toggled off
  Scenario: Password is unmasked when user clicks the Show Password icon
  Scenario: Password is masked when user clicks the Hide Password icon
  Scenario: Error message is displayed for blank Confirm Password field
  Scenario: Alphanumeric and special characters input is accepted on Confirm Password field
  Scenario: Error message is displayed for password with whitespace for Confirm Password
  Scenario: Password is masked by default and Show Password icon is toggled off for Confirm Password
  Scenario: Password is unmasked when user clicks the Show Password icon on Confirm Password
  Scenario: Password is masked when user clicks the Hide Password icon on Confirm Password
  Scenario: Error message and Password criteria checkmark is greyed out when Password field requirement is not met
  Scenario: Error message and Confirm Password criteria checkmark is greyed out when Password field requirement is not met
  Scenario: Error message is displayed when Password and Confirm Password is not matched
  Scenario: Error message is not displayed when Password and Confirm Password is matched
  Scenario: Error message is displayed for reused password
  Scenario: Password is changed successfully and OTP screen is displayed

  Scenario: Login is successful using the new password reset via mobile number
  Scenario: Login is successful using the new password reset via email

  Rule: Reset password via Mobile Password
    Scenario: Resend OTP timer is not visible when the countdown is finished
    Scenario: Resend OTP button is disabled when the countdown is ongoing
    Scenario: Resend OTP button is enabled when the countdown is finished
    Scenario: Timer will restart again when the user clicks Resend OTP button
    Scenario: Error message is displayed when entered OTP is incorrect
    Scenario: Reset Password via mobile number is successful

  Rule: Reset password via Email Address
    Scenario: Resend OTP timer is not visible when the countdown is finished
    Scenario: Resend OTP button is disabled when the countdown is ongoing
    Scenario: Resend OTP button is enabled when the countdown is finished
    Scenario: Timer will restart again when the user clicks Resend OTP button
    Scenario: Error message is displayed when entered OTP is incorrect
    Scenario: Reset Password via email is successful

  Rule: Reset password via Google - Email
    Scenario: Reset Password via Google - Email is successful
    Scenario: Login using mobile number is successful using the new password reset via Google - email
    Scenario: Login using Email is successful using the new password reset via Google - email

  Rule: Reset password via Google - Mobile number
    Scenario: Reset Password via Google - Mobile number is successful
    Scenario: Login using mobile number is successful using the new password reset via Google - Mobile number
    Scenario: Login using Email is successful using the new password reset via Google - Mobile number

  Rule: Reset password via Apple account - Email
    Scenario: Reset Password via Apple account - Email is successful
    Scenario: Login using mobile number is successful using the new password reset via Apple - email
    Scenario: Login using Email is successful using the new password reset via Apple - email

  Rule: Reset password via Apple account - Mobile number
    Scenario: Reset Password via Apple account - Mobile number is successful
    Scenario: Login using mobile number is successful using the new password reset via Apple - Mobile number
    Scenario: Login using Email is successful using the new password reset via Apple - Mobile number

  Rule: Expired Password
    Scenario: Reset Password page is displayed when user logged in account with expired password
    Scenario: Password reset is successful for account with expired password
    Scenario: Login is successful using the new password reset of an account with expired password