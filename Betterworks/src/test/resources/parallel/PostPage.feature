Feature: Create Post Page Feature

  Background:
    Given user is already logged in to the application
    |username|password|
    |hyphen_admin@acmetest.com|34067|

    Scenario: Create Post Page Title
      Given user is on Create Post Page
      When user gets the title of the page
      Then page title should be "Betterworks Engage - Login"

    Scenario: Creating a Post
      Given user is on Create Post Page
      When user clicks on CREATE NEW POST BUTTON
      Then user should select the options
      And user should click the PUBLISH POST button
