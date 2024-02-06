Feature: Login Page Feature

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters the username "hyphen_admin@acmetest.com"
    And clicks user clicks on SEND ME A VERIFICATION CODE BUTTON
    Then user enters verification code "34067"
    And user clicks on LOG IN button
