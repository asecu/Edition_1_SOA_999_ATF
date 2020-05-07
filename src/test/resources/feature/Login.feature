@Daniel @ignore
Feature: User successfully login
Description: The purpose of this feature is to test that user is able to login using valid credentials

  Scenario: User is able to login
    Given main page is opened
    When user click authentication button
    Then user is redirected to login page
    When user inputs "user03" in username field
    And user input "user03" in password field
    And user click on login button
    Then user is redirected to main page
    And user is logged in