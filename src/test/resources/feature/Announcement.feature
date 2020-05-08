@All
Feature: Editing Announcement 999.md

  Background: User place an announcement of a mobile phone
    Given "https://999.md/ro/" page is displayed
    And "user02" user is logged in
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
    And user checks Agree checkbox
    And user clicks Add announcement
    Then user is redirected to publish success page
    And an informative message is displayed that user already has placed an announcement in this category

  Scenario: Edit Announcement
    Given My announcements page is accessed
    When Edit Announcement button is clicked
    Then Edit Announcement page is opened
    When the title and description fields are updated with new following values:
      | Vind Iphone 10 | Super Telephone |
    And the following location, mark and model are reselected:
      | 12898 | Google | 22461 |
    And Save button is clicked
    Then user is redirected to the announcement pay page
    When user goes back to the announcement edit page
    Then page is updated correspondingly

  Scenario: Delete Announcement
    Given My announcements page is accessed
    When Delete button is clicked
    Then Delete confirmation pop up is displayed
    When Confirm deletion button is clicked
    Then Announcement is deleted


  Scenario: Delete all announcements
    Given My announcements page is accessed
    When Select all announcements checkbox is clicked
    Then All announcements are selected
    When Delete all announcements button is clicked
    Then Confirm deletion alert is displayed
    When Alert is confirmed
    Then All announcements are deleted




