@android
Feature: Road to Prestige
  Rule: Start account - Olivia Rodrigo
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      When the user logs in using valid mobile number and password - SMAC Start
      And the user is on the Homepage

      Scenario: Current membership identifier - Start is displayed
        And the user clicks the Prestige bar
        When the user is on the Card benefits page - Start tab

      Scenario: Cards Benefit page - SMAC Start tab is displayed
        And the user clicks the Prestige bar
        Then the user is on the Card benefits page - Start tab
        And RTP Widget is visible

      Scenario: Homepage is displayed upon clicking back button on RTP page
        And the user clicks the Prestige bar
        When the user is on the Card benefits page - Start tab
        And the user clicks the back button - RTP
        Then the user is on the Homepage

      Scenario: RTP Widget is displayed to Cards benefit page only to the user's current tier - Start
        And the user clicks the Prestige bar
        When the user is on the Card benefits page - Start tab
        Then RTP Widget is visible
        When the user clicks the Cards benefits - SMAC
        Then RTP Widget is not visible
        When the user clicks the Cards benefits - SMAC Prestige
        Then RTP Widget is not visible

      Scenario: User can navigate through the Card Benefits upon clicking on Tier tabs
        And the user clicks the Prestige bar
        When the user is on the Card benefits page - Start tab
        Then RTP Widget is visible
        When the user clicks the Cards benefits - SMAC
        Then RTP Widget is not visible
        When the user clicks the Cards benefits - SMAC Prestige
        Then RTP Widget is not visible

  Rule: SMAC account - Sabrina Carpenter
    Background:
      Given the user is on the SSO menu
      And the user clicks the Login button - SSO
      And the user is on the Login page
      When the user logs in using valid mobile number and password - SMAC
      And the user is on the Homepage

      Scenario: Current membership identifier - SMAC is displayed
        And the user clicks the Prestige bar
        When the user will redirects to Card benefits page - SMAC tab

      Scenario: Cards Benefit page - SMAC tab is displayed
        And the user clicks the Prestige bar
        Then the user will redirects to Card benefits page - SMAC tab
        And RTP Widget is visible

      Scenario: RTP Widget is displayed to Cards benefit page only to the user's current tier - SMAC
        And the user clicks the Prestige bar
        When the user will redirects to Card benefits page - SMAC tab
        Then RTP Widget is visible
        When the user clicks the Cards benefits - SMAC Start
        Then RTP Widget is not visible
        When the user clicks the Cards benefits - SMAC Prestige
        Then RTP Widget is not visible

    Rule: Prestige account - Maddy Perez
      Background:
        Given the user is on the SSO menu
        And the user clicks the Login button - SSO
        And the user is on the Login page
        When the user logs in using valid mobile number and password - Prestige
        And the user is on the Homepage
        And the user clicks the Manage card widget
        And the user is on the Manage card Page

      Scenario: Current membership identifier - Prestige is displayed
        And the user clicks the Prestige bar
        When the user is on the Card benefits page - SMAC Prestige tab

        Scenario: Cards Benefit page - SMAC Prestige tab is displayed
          And the user clicks the Prestige bar
          Then the user is on the Card benefits page - SMAC Prestige tab
          And RTP Widget is visible - Prestige

        Scenario: RTP Widget is displayed to Cards benefit page only to the user's current tier - Prestige
          And the user clicks the Prestige bar
          When the user is on the Card benefits page - SMAC Prestige tab
          Then RTP Widget is visible - Prestige
          When the user clicks the Cards benefits - SMAC
          Then RTP Widget is not visible
          When the user clicks the Cards benefits - SMAC Start
          Then RTP Widget is not visible

        Scenario: Claim Prestige Button Overlay is visible on BPR
          When the user swipes to Promoted prestige card
          Then Claim Prestige button overlay is visible

        Scenario: Claim Prestige Button Overlay is NOT visible on Expired Prestige
          When the user swipes to expired prestige card
          Then Claim Prestige button overlay is not visible

        Scenario: Claim Prestige Button Overlay is NOT visible on Active Prestige
          And the user is on the Manage card Page
          Then Claim Prestige button overlay is not visible

        Scenario: Claim Prestige Button Overlay is NOT visible on BA Prestige
          And the user is on the Manage card Page
          When the user swipes to "Prestige card - BA"
          Then Claim Prestige button overlay is not visible

        Scenario: Claim Prestige Button Overlay is NOT visible on BBL Prestige
          When the user swipes to "Prestige card - BBL"
          Then Claim Prestige button overlay is not visible

        Scenario: Prestige Unlocked popup modal is displayed
          When the user swipes to Promoted prestige card
          Then Claim Prestige button overlay is visible
          When the user clicks the Claim Prestige button
          Then Prestige Unlocked popup modal is visible

        Scenario: Prestige Unlocked popup modal will be hidden upon clicking on Close icon
          And the user swipes to Promoted prestige card
          And Claim Prestige button overlay is visible
          And the user clicks the Claim Prestige button
          And Prestige Unlocked popup modal is visible
          When clicks on Prestige Unlock - Back button
          Then Prestige Unlocked popup modal is not visible
