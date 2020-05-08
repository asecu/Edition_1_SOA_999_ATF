
@Iuri

Feature: Searched history success deleting


Scenario: User is deleting searched in history
    Given home page is displayed
    And user TEST_USER is logged in
    And User open My Announcement page
    And User navigates history page
    When User clicks at Delete searched history button
    Then Previous Searches link is not showing

