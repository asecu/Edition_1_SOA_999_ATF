@All
Feature: Searching offers

  Scenario Outline: Search for an existing product
    Given home page is displayed
    When user searches for '<data>'
    Then the searching result page is displayed
    When item with id '<itemID>' from the list is selected
    Then item page is displayed
    And item body contains the searched value
    Examples:
      | data         | itemID |
      | Audi         | 3      |
      | Apartamente  | 4      |
      | Xiaomi Redmi | 6      |


  Scenario: Search for a non-existing product
    Given home page is displayed
    When user searches for 'qpwoeiruty'
    Then the searching result page is displayed
    And informative message is displayed


  Scenario Outline: Subscribe to search
    Given home page is displayed
    And user TEST_USER is logged in
    When user searches for '<data>'
    Then the searching result page is displayed
    When save search option is clicked
    Then save search option is disabled
    When user accesses subscription option from personal Cabinet
    Then list of subscriptions containing '<data>' is displayed
    Examples:
      | data                    |
      | Audi                    |
      | Apartamente in Chisinau |
      | Samsung                 |

