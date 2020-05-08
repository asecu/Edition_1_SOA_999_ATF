package com.endava.soa.stepdef;

import com.endava.soa.pageObject.AnnouncementPage;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.endava.soa.constant.ScenarioKey.*;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class MyAnnouncementStepDef {
    ScenarioContext scenarioContext = getScenarioInstance();
    WebDriver driver = (WebDriver) scenarioContext.getData(DRIVER);
    AnnouncementPage announcementPage = new AnnouncementPage((WebDriver) scenarioContext.getData(DRIVER));

    @Given("My announcements page is accessed")
    public void userAccessPage() throws InterruptedException {
        announcementPage.openAnnouncementsPage();
    }

    @When("Edit Announcement button is clicked")
    public void userClicksOnButton() {
        announcementPage.pressEditAnnouncementButton();
    }

    @Then("Edit Announcement page is opened")
    public void userIsRedirectedToEditAnnouncementPage() {
        assertThat("User is not on edit announcement page", announcementPage.isSaveButtonDisplayed());
    }

    @When("the title and description fields are updated with new following values:")
    public void theFollowingTextBoxesAreUpdatedWithNewText(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        announcementPage.setTitle(list.get(0));
        scenarioContext.saveData(TITLE, list.get(0));
        announcementPage.setDescription(list.get(1));
        scenarioContext.saveData(DESCRIPTION, list.get(1));
    }

    @And("the following location, mark and model are reselected:")
    public void theFollowingValuesAreReselectedForSingleSelectionDropDown(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        announcementPage.setLocation(list.get(0));
        scenarioContext.saveData(LOCATION, list.get(0));

        announcementPage.setMark(list.get(1));
        scenarioContext.saveData(MARK, list.get(1));

        announcementPage.setModel(list.get(2));
        scenarioContext.saveData(MODEL, list.get(2));
    }

    @And("Save button is clicked")
    public void theFollowingCheckboxIsUpdatedWith() {
        announcementPage.save();
    }

    @Then("user is redirected to the announcement pay page")
    public void userIsRedirected() throws InterruptedException {
        assertThat("User is not redirected", announcementPage.isUserOnPayPage());
    }

    @When("user goes back to the announcement edit page")
    public void userGoesBack() {
        driver.navigate().back();
    }

    @Then("page is updated correspondingly")
    public void pageIsUpdatedCorrespondingly() {
        assertThat("Title was not changed", announcementPage.getTitle().equals(scenarioContext.getData(TITLE)));
        assertThat("Description was not changed", announcementPage.getDescription().equals(scenarioContext.getData(DESCRIPTION)));
        assertThat("Location was not changed", announcementPage.getLocation().equals(scenarioContext.getData(LOCATION)));
        assertThat("Mark was not changed", announcementPage.getMark().equals(scenarioContext.getData(MARK)));
        assertThat("Model was not changed", announcementPage.getModel().equals(scenarioContext.getData(MODEL)));
    }

    @When("Delete button is clicked")
    public void deleteButtonIsClicked() {
        announcementPage.pressDeleteAnnouncementButton();
    }

    @Then("Delete confirmation pop up is displayed")
    public void deleteConfirmationPopUpIsDisplayed() {
        assertThat("Pop Up is not displayed", announcementPage.isPopUpDisplayed());
    }

    @When("Confirm deletion button is clicked")
    public void confirmDeletionButtonIsClicked() {
        announcementPage.pressConfirmButton();
    }

    @Then("Announcement is deleted")
    public void announcementIsDeleted() {
        assertThat("Pop Up is not displayed", not(announcementPage.isAnnouncementDisplayed()));
    }

    @When("Select all announcements checkbox is clicked")
    public void selectAllAnnouncementsCheckboxIsClicked() {
        announcementPage.selectAllAnnouncements();
    }

    @Then("All announcements are selected")
    public void allAnnouncementsAreSelected() {
        assertThat("All announcements are not selected ", announcementPage.isAnnouncementSelected());
    }

    @When("Delete all announcements button is clicked")
    public void deleteAllAnnouncementsButtonIsClicked() {
        announcementPage.deleteAllAnnouncements();
    }

    @Then("Confirm deletion alert is displayed")
    public void confirmDeletionAlertIsDisplayed() {
        assertThat("Alert is not present", announcementPage.isAlertPresent());
    }

    @When("Alert is confirmed")
    public void alertIsConfirmed() {
        announcementPage.confirmAlert();
    }

    @Then("All announcements are deleted")
    public void allAnnouncementsAreDeleted() {
        assertThat("Announcements are not deleted", announcementPage.getAnnouncementNumber() == 0);
    }
}
