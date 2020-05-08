
@Iuri

Feature: Searched history success save


Scenario: User is checking searched history
        Given home page is displayed
        And user TEST_USER is logged in
        When User types "Iphone" in search-form
        And User click search button
        And User open My Announcement page
        And User navigates history page
        Then at page history is shown "Iphone"

