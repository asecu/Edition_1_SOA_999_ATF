@All
Feature: Edit Account Details

  Scenario: Change general details
    Given user TEST_USER is logged in
    When user access 'general' option from settings
    And user fills in the following fields with data:
      | firstName | TestFirstName |
      | lastName  | TestLastName  |
      | birthDay  | 1             |
      | birthYear | 1930          |
    Then the SUCCESS_UPDATE message is displayed

  Scenario: Check edit email details error message
    Given user TEST_USER is logged in
    When user access 'e-mail' option from settings
    And user fills in the following fields with data:
      | newEmail | testmail@mail.com |
      | password | 1234567890        |
    Then the MAX_UPDATE_EMAIL_ERROR message is displayed

  Scenario Outline: Check edit contact details error message
    Given user TEST_USER is logged in
    When user access 'Contact' option from settings
    And user fills in the following fields with data:
      | country     | <country> |
      | phoneNumber | <number>  |
    Then the <error> message is displayed
    Examples:
      | country        | number        | error                              |
      | Moldova (+373) | 69869869      | UPDATE_EXISTING_PHONE_NUMBER_ERROR |
      | Moldova (+373) | 123           | UPDATE_WRONG_PHONE_NUMBER_ERROR    |
      | Moldova (+373) | 1231231231231 | UPDATE_WRONG_PHONE_NUMBER_ERROR    |

  Scenario: Change photo
    Given user TEST_USER is logged in
    When user access 'photo' option from settings
    Then user upload 'bug.jpg' image successfully
    And user returns to default photo options