@android
Feature: Guest user
  Background:
    Given the user is on the SSO menu
    And the user clicks the Continue as Guest button
  
      @high
    Scenario: Guest homepage is displayed
      Then the user is on the guest homepage

      @high
    Scenario: SSO Menu is displayed after clicking Login button on main card widget
      And the user is on the guest homepage
      When the user clicks the Login button in the main card widget
      Then the user is on the SSO menu

      @high
    Scenario: SSO Menu is displayed after clicking inbox navigation
      And the user is on the guest homepage
      When the guest user clicks the inbox icon
      Then the user is on the SSO menu

      @high
    Scenario: Shop universal screen is displayed upon clicking on Guest Search a product
      And the user is on the guest homepage
      When the user clicks the search a product button
      Then the user is on the Shop page

      @high
    Scenario: SSO Menu is displayed after clicking Vouchers navigation
      And the user is on the guest homepage
      When the guest user clicks the vouchers icon
      Then the user is on the SSO menu

      @high
    Scenario: SSO Menu is displayed after clicking QR navigation
      And the user is on the guest homepage
      When the guest user clicks the QR icon
      Then the user is on the SSO menu

      @high
    Scenario: SSO Menu is displayed after clicking Account navigation
      And the user is on the guest homepage
      When the guest user clicks the account icon
      Then the user is on the SSO menu

#      @high @deferred
#    Scenario: SSO Menu is displayed after clicking Shop navigation
#      And the user is on the guest homepage
#      When the guest user clicks the shop icon
#      Then the user is on the Shop page