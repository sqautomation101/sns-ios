@android
Feature: MOM Card Attribute
  Rule: Initial MOM card link
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      And the user logs in using valid mobile number and password - Card Link - "Charlene Kiyuwey"
      And the user is on the Homepage
      And the user clicks on Homepage Link Card
      And the user is on the card linking page

      @high
      Scenario: MOM Card Registration Form Layout is displayed
        When the user enters a "AR" "MOM" "352" card number
        And a text container is visible
        And Link your Card button is "enabled"
        And the user clicks on Link Your Card
        And the user is redirected to OTP Verification
        And the user enters the correct OTP
        And Card linking splash screen is displayed
        And the user is on the MOM Registration Form - "Initial link" - "MOM"

        @high
        Scenario: MOM Card Registration Form - Address section layout is displayed
          When the user enters a "AR" "MOM" "352" card number
          And a text container is visible
          And Link your Card button is "enabled"
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And the user is on the MOM Registration Form - "Subsequent link" - "MOM"
          Then MOM Registration - Address section is displayed properly

          @low
        Scenario: MOM Card Registration Form - Address section - House number field accepts alphanumeric input
            And the user enters a "AR" "MOM" "352" card number
            And a text container is visible
            And Link your Card button is "enabled"
            And the user clicks on Link Your Card
            And the user is redirected to OTP Verification
            And the user enters the correct OTP
            And Card linking splash screen is displayed
            And the user is on the MOM Registration Form - "Subsequent link" - "MOM"
            And MOM Registration - Address section is displayed properly
            When the user enters an alphanumeric house number
            Then the House number input is accepted

        @low
        Scenario: MOM Card Registration Form - Address section - Province is reflected after selection
          And the user enters a "AR" "MOM" "352" card number
          And a text container is visible
          And Link your Card button is "enabled"
          And the user clicks on Link Your Card
          And the user is redirected to OTP Verification
          And the user enters the correct OTP
          And Card linking splash screen is displayed
          And the user is on the MOM Registration Form - "Subsequent link" - "MOM"
          And MOM Registration - Address section is displayed properly
          When the user selects a Province from the dropdown
          Then the selected Province is displayed
#End of rule

  Rule: Initial MOM card link
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      And the user logs in using valid mobile number and password - Card Link - "Charlene Kiyuwey"
      And the user is on the Homepage
      And the user clicks the Manage card widget
      And the user is on the Manage card Page

      @low
      Scenario: MOM Card Registration Form - Address section - City is reflected after selection
        And the user selects a Province from the dropdown
        When the user selects a City from the dropdown
        Then the selected City is displayed

      @low
      Scenario: MOM Card Registration Form - Address section - Barangay is reflected after selection
        And the user selects a Province from the dropdown
        And the user selects a City from the dropdown
        When the user selects a Barangay from the dropdown
        Then the selected Barangay is displayed

      @low
      Scenario: MOM Card Registration Form - Address section - Postal code accepts numeric input
        When the user enters a numeric input via Postal code
        Then the Postal code input is accepted

      @low
      Scenario: MOM Card Registration Form - Attributes section Layout
        When the user scroll to Attribute section
        Then MOM Registration - Attribute section is displayed properly

      @medium
      Scenario: MOM Card Registration Form - Attribute section - Clicking on No button will hide the Pregnancy stage dropdown
        And the user scroll to Attribute section
        When the user clicks on No button
        Then Pregnancy stage dropdown is "hidden"
        #And No button is highlighted -->NEED TO EXPOSE ATTR

      @medium
      Scenario: MOM Card Registration Form - Attribute section - Clicking on Yes button will show the Pregnancy stage dropdown
        And the user scroll to Attribute section
        When the user clicks on Yes button
        Then Pregnancy stage dropdown is "shown"
        #And Yes button is highlighted -->NEED TO EXPOSE ATTR

      @low
      Scenario: MOM Card Registration Form - Attribute section - Pregnancy stage is reflected after selection
        And the user scroll to Attribute section
        When the user clicks on Yes button
        When the user selects a pregnancy stage from the dropdown
        Then the selected pregnancy stage is displayed

      @medium
      Scenario: MOM Card Registration Form - Address section - Entering 0 to Number of Kids field hides Children Ages field
        And the user scroll to Attribute section
        When the user enters "0" on Number of kids field
        Then Children ages field is "hidden"

      @medium
      Scenario: MOM Card Registration Form - Address section - Entering >= 1 to Number of Kids field shows Children Ages field
        And the user scroll to Attribute section
        When the user enters "1" on Number of kids field
        Then Children ages field is "shown"

      @low
      Scenario:  MOM Card Registration Form - Address section - Non-comma input is accepted to Children ages field
        And the user scroll to Attribute section
        And the user clicks on Yes button
        And the user selects a pregnancy stage from the dropdown
        And the user enters "1" on Number of kids field
        When the user enters "15" on Children ages field
        Then the entered children "age" is displayed

      @low
      Scenario: MOM Card Registration Form - Address section - With comma input is accepted to Children ages field
        And the user scroll to Attribute section
        And the user clicks on Yes button
        And the user selects a pregnancy stage from the dropdown
        And the user enters "2" on Number of kids field
        When the user enters "15,3" on Children ages field
        Then the entered children "ages" is displayed

        @high
      Scenario: Proceed button is disabled when a field is left blank
        When the user enters a valid input for Address section
        And the user scrolls to Proceed button
        Then the Proceed button is "disabled"

      @critical
      Scenario: Clicking on Proceed will be redirected to Thank You screen
        When the user enters a valid input for Address section
        And the user scroll to Attribute section
        And the user enters a valid input for Attributes section
        And the user scrolls to Proceed button
        And the Proceed button is "enabled"
        And the user clicks on Proceed button
        Then MOM - Thank You page is displayed

  Scenario:  MOM - Continue layout



  Scenario:  that clicking on Continue button will


  Scenario:  that the Continue button is displayed in Manage Cards page if Form submission is uncontinued


  Rule: MOM Card linking
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      And the user logs in using valid mobile number and password - Card Link - "Charlene Joie"
      And the user is on the Homepage
      And the user clicks on Homepage Link Card
      And the user is on the card linking page

      @critical
      Scenario:  Card Linking -  MOM card - Text Container
        When the user enters a "AR" "MOM" "352" card number
        Then a text container is visible
        And Link your Card button is "enabled"

    Scenario:  Continue button is NOT displayed in Manage Cards page upon successful
      When the user enters a "AR" "MOM" "352" card number
      And a text container is visible
      And Link your Card button is "enabled"
      And the user clicks on Link Your Card
      And the user is redirected to OTP Verification
      And the user enters the correct OTP
      And Card linking splash screen is displayed
      And the user is on the MOM Registration Form - "Initial link" - "MOM"
      And the user enters a valid input for Address section
      And the user scroll to Attribute section
      And the user enters a valid input for Attributes section
      And the user scrolls to Proceed button
      And the user clicks on Proceed button
      And MOM - Thank You page is displayed
      And the user clicks on Card Linking Success screen - Back to Home
      And the user is on the Homepage
      And the user clicks the Manage card widget
      And the user is on the Manage card Page
      Then MOM Continue button is "not displayed"


    Scenario:  Continue button is displayed in Manage Cards page if Form submission is uncontinued
      When the user enters a "AR" "MOM" "352" card number
      And a text container is visible
      And Link your Card button is "enabled"
      And the user clicks on Link Your Card
      And the user is redirected to OTP Verification
      And the user enters the correct OTP
      And Card linking splash screen is displayed
      And the user is on the MOM Registration Form - "Initial link" - "MOM"
      And the user clicks Back navigation
      And the Incomplete MOM Form submission modal is visible
      And the user clicks on Leave Page
      And the user is on the Manage card Page
      Then MOM Continue button is "displayed"

      Scenario: MOM form is displayed upon clicking Continue button

      Scenario: Continue button is NOT displayed upon resubmitting of MOM form

      Scenario: Continue button is NOT displayed if Form submission is not continued for the second MOM card linking

      Scenario: User can update the form for the second MOM card linking