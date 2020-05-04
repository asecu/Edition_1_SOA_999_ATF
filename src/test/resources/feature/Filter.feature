@All
@Constantin
Feature: Feature title

  Scenario:  Creating a filter using different controls
    Given User is on cars announcements page
    When "Cahul" is set as city
    And the following price range is set:
      | 500 | 1000 |
    And the following car condition and announcement type are set:
      | Schimb | Nou |
    Then Page is updated correspondingly

