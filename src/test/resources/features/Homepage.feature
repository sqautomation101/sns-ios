@android
Feature: Homepage

    Rule: Start account - Olivia Rodrigo
      Background:
        Given the user is on the SSO menu
        And the user clicks the Login button - SSO
        And the user is on the Login page
        And the user logs in using valid mobile number and password - SMAC Start

          @low
        Scenario: Homepage is displayed
          Then the user is on the Homepage

          @low
        Scenario: Main card widget is displayed
          And the user is on the Homepage
          Then the Main card widget is visible

          @low
        Scenario: Virtual/loyalty card number is masked upon login
          When the user is on the Homepage
          Then the virtual card number is masked

          @low
        Scenario: Virtual/loyalty card number is unmasked upon clicking on virtual card number
          And the user is on the Homepage
          Given the virtual card number is masked
          When the user clicks the virtual card number
          Then the virtual card number is unmasked

          @low
        Scenario: Virtual/loyalty card number can be masked again by clicking the virtual card number
          And the user is on the Homepage
          Given the virtual card number is masked
          And the user clicks the virtual card number
          And the virtual card number is unmasked
          When the user clicks the virtual card number
          Then the virtual card number is masked

          @low
        Scenario: Virtual card number remains unmasked after clicking the card number and navigating to another page
            And the user is on the Homepage
            Given the virtual card number is masked
            And the user clicks the virtual card number
            And the virtual card number is unmasked
            When the user clicks the Account navigation
            And the user is on the Account Page
            And the user clicks the Home navigation
            Then the virtual card number is unmasked

          @low
        Scenario: Masked virtual card number is retained upon navigating to another page
          And the user is on the Homepage
          Given the virtual card number is masked
          When the user clicks the Account navigation
          And the user is on the Account Page
          And the user clicks the Home navigation
          Then the virtual card number is masked

          @low @failed
        Scenario: Masked behaviour is retained upon logging out and logging back in via virtual card number
          And the user is on the Homepage
          Given the virtual card number is masked
          And the user clicks the virtual card number
          And the virtual card number is unmasked
          And the user clicks the Account navigation
          And the user is on the Account Page
          And the user clicks the Logout
          And the user is on the SSO menu
          And the user clicks the Login button - SSO
          And the user is on the Login page
          When the user logs in using valid mobile number and password - SMAC Start
          Then the user is on the Homepage
          And the virtual card number is masked

          @low
        Scenario: Go Shopping Header is displayed
          And the user is on the Homepage
          Then Go shopping header is visible

          @high
        Scenario: Shop universal search screen is displayed
          And the user is on the Homepage
          When the user clicks the search a product button
          Then the user will redirects to shop's universal search screen

          @high
        Scenario: Manage Card page is displayed upon clicking Manage Card widget
          And the user is on the Homepage
          When the user clicks the Manage card widget
          Then the user is on the Manage card Page

          @high
        Scenario: Highest-tier SMAC card (SMAC Start) is displayed on the Homepage
          And the user is on the Homepage
          #And the homepage greeting widget is displayed properly - SMAC Start
          Given the Main card widget is visible
          Then SMAC Start default virtual card is visible

          @high @failed-rtp
        Scenario: Card Benefits page is visible upon clicking RTP progress bar for SMAC Start account
          And the user is on the Homepage
          Given SMAC Start default virtual card is visible
          When the user clicks the Prestige bar
          Then the user is on the Card benefits page - Start tab
    #End of Start account

    Rule: SMAC account - Sabrina Carpenter
      Background:
        Given the user is on the SSO menu
        And the user clicks the Login button - SSO
        And the user is on the Login page
        And the user logs in using valid mobile number and password - SMAC

          @high
        Scenario: Points history page is displayed upon clicking Points History widget
          And the user is on the Homepage
          When the user clicks the Points history widget
          Then the user is on the Points History page

          @medium
        Scenario: Highest-tier SMAC card (SMAC) is displayed on the Homepage
          And the user is on the Homepage
          #And the homepage greeting widget is visible - SMAC
          Given the Main card widget is visible
          Then SMAC default virtual card is visible

          @high @failed-rtp
        Scenario: Card Benefits page is displayed upon clicking RTP progress bar for SMAC account
          And the user is on the Homepage
          When the user clicks the Prestige bar
          Then the user will redirects to Card benefits page - SMAC tab
    #End of SMAC account

    Rule: Prestige account - Maddy Perez
      Background:
        Given the user is on the SSO menu
        And the user clicks the Login button - SSO
        And the user is on the Login page
        And the user logs in using valid mobile number and password - Prestige

          @medium
        Scenario: Highest-tier SMAC card (SMAC Prestige) is displayed on the Homepage
          And the user is on the Homepage
          #And the homepage greeting widget is visible - SMAC Prestige
          Given the Main card widget is visible
          Then SMAC Prestige default virtual card is visible

          @high @failed-rtp
        Scenario: Card Benefits page is displayed upon clicking RTP progress bar for SMAC Prestige
          And the user is on the Homepage
          When the user clicks the Prestige bar
          Then the user is on the Card benefits page - SMAC Prestige tab
    #End of Prestige account


  #          @low @DEFFERED
#        Scenario: Homepage greeting widget is displayed correctly
#          And the user is on the Homepage
#          Then the homepage greeting widget is displayed properly - SMAC Start
#
#          @high @DEFFERED
#        Scenario: Inbox button is displayed
#          And the user is on the Homepage
#          Then the inbox button is visible