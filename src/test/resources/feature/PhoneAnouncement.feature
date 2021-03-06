@All
Feature: User place an announcement
  Description: User place an announcement in mobile phone category on first case.
  User verify that an informative message is displayed when trying to place an announcement in the same category.


  Background: User logs in and is located on home page
    Given "Home" page is displayed
    And "user03" user is logged in

  Scenario: User place an announcement of a mobile phone
    When user clicks add announcement announcement
    Then user is redirected to category page
    When user clicks phone and communication category
    Then user is redirected to subcategories page
    When user clicks mobile phones
    Then user is redirected to complete add page
    When user inputs data in announcement title field
    And user inputs data in announcement text field
    And user selects region from region dropdown
    And user inputs price in price field
    And user selects brand from brand dropdown
    And user selects model from model dropdown
    And user selects condition from condition dropdown
    And user selects design from design dropdown
    And user selects OS from OS dropdown
    And user selects ROM from ROM dropdown
    And user selects RAM from RAM dropdown
    And user selects display size from display size dropdown
    And user selects display rezolution from display rezolution dropdown
    And user selects display type from display type dropdown
    And user selects camera rezolution from camera rezolution dropdown
    And user checks fingerprint checkbox
    And user checks facial unlock checkbox
    And user checks NFC checkbox
    And user checks USB-typeC checkbox
    And user checks Dual Sim checkbox
    And user checks Touch screen checkbox
    And user checks 4g checkbox
    And user checks 3g checkbox
    And user checks wi-fi checkbox
    And user checks extendable memory checkbox
    And user checks GPS checkbox
    And user checks Camera checkbox
    And user uploads a photo
    And user checks Agree checkbox
    And user clicks Add announcement
    Then user is redirected to publish success page

  Scenario: User place an announcement in the same category,negative case
    When user clicks add announcement announcement
    Then user is redirected to category page
    When user clicks phone and communication category
    Then user is redirected to subcategories page
    When user clicks mobile phones
    Then user is redirected to complete add page
    And an informative message is displayed that user already has placed an announcement in this category