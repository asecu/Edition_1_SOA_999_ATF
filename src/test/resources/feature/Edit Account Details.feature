Feature: Edit Account Details
@Gabriela @ignore
Scenario: Edit general details
  Given user TEST_USER is logged in
  When user access 'userName' option from settings
#    And user fills in the following fields with data:
#      | newE-mail         | password   |
#      | testmail@mail.com | 1234567890 |
#    Then the confirmation message is displayed