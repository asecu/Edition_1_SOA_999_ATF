
@Iuri

Feature: Searched opened first recommendation


  Scenario: User is Checking viewed History on announcements
    Given home page is displayed
    And user TEST_USER is logged in
    And User clicks on first recommended announcement
    And User open My Announcement page
    And User navigates history page
    Then at page history is shown first recommended announcement

