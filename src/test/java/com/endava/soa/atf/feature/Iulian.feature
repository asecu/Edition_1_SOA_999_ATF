@Iulian-feature
Feature: Searching offers

  Scenario Outline: Search for an existing product
    Given home page is displayed
    When user populates the search input field with <data>
    And user  clicks "Search" button
    Then the "searching result" page is displayed
    And number of adds is displayed
    Examples:
      | data                    |
      | Audi                    |
      | Apartamente in Chisinau |
      | Xiaomi Redmi 5          |


  Scenario: Search for a non-existing product
    Given home page is displayed
    When the search input field is populated with "qpwoeiruty"
    Then the "searching result" page is displayed
    And number of adds "0" is displayed
    And "informative" message is displayed


  Scenario Outline: Subscribe to search
    Given user "test1" is logged in
    When the search input field is populated with <data>
    And "Search" button is clicked
    Then the search page is displayed
    When "salveaza cautarea" button is clicked
    Then name of button is changed to "Cautarea salvata"
    And "Cautarea salvata" button is disabled
    When user accesses "abonari" option from "Cabinetul personal"
    Then "subscription" page is displayed
    And list of saved searched <data> is displayed
    Examples:
      | data                    |
      | Audi                    |
      | Apartamente in Chisinau |
      | Xiaomi Redmi 5          |


  Scenario: Unsubscribe from search
    Given subscription page is displayed
    And the user has valid search subscriptions
    When the "remove" icon button is clicked for "Audi" saved search field
    And the user confirms deletion on pop-up window
    Then "Audi" search field is deleted from the list of saved searches