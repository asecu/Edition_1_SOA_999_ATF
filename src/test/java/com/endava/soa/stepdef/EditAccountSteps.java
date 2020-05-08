package com.endava.soa.stepdef;

import com.endava.soa.constant.Messages;
import com.endava.soa.constant.ScenarioKey;
import com.endava.soa.constant.User;
import com.endava.soa.pageObject.EditAccountPage;
import com.endava.soa.pageObject.HomePage;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static com.endava.soa.constant.ScenarioKey.ACTUAL_PAGE;
import static com.endava.soa.constant.ScenarioKey.DEFAULT_PHOTO;
import static com.endava.soa.constant.ScenarioKey.OPTION;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class EditAccountSteps {
    ScenarioContext scenarioContext = getScenarioInstance();
    WebDriver driver = (WebDriver) scenarioContext.getData(ScenarioKey.DRIVER);

    @Given("user {} is logged in")
    public void userIsLoggedIn(User user) {
        HomePage homePage = new HomePage(driver);
        homePage.login(user);
        scenarioContext.saveData(ACTUAL_PAGE, homePage);
        assertTrue("[Cabinet Personal] is displayed", homePage.getPersonalCabinet().isDisplayed());
    }

    @When("user access {string} option from settings")
    public void userAccessEMailOptionFromSettings(String option) {
        HomePage homePage = (HomePage) scenarioContext.getData(ACTUAL_PAGE);
        homePage.accessSettingsTab();
        EditAccountPage accountPage = new EditAccountPage(driver);
        accountPage.switchToSettingsFrame();
        accountPage.selectOption(option);
        scenarioContext.saveData(ACTUAL_PAGE, accountPage);
        scenarioContext.saveData(OPTION, option);
    }

    @And("user fills in the following fields with data:")
    public void userFillsInTheFollowingFieldsWithData(Map<String, String> parameters) {
        EditAccountPage editAccountPage = (EditAccountPage) scenarioContext.getData(ACTUAL_PAGE);
        String option = (String) scenarioContext.getData(OPTION);
        editAccountPage.updateOptionDetails(option, parameters);
    }

    @Then("the {} message is displayed")
    public void messageIsDisplayed(Messages errorMessage) {
        EditAccountPage editAccountPage = (EditAccountPage) scenarioContext.getData(ACTUAL_PAGE);
        String option = (String) scenarioContext.getData(OPTION);
        assertThat("expected messege is displayed", errorMessage.getMessage(), equalTo(editAccountPage.getOptionMessage(option)));
    }

    @Then("user upload {string} image successfully")
    public void userUploadImageSuccessfully(String photoName) {
        EditAccountPage editAccountPage = (EditAccountPage) scenarioContext.getData(ACTUAL_PAGE);
        String photoNameBeforeUpload = editAccountPage.getPhotoSource();
        editAccountPage.uploadPhoto(photoName);
        String photoNameAfterUpload = editAccountPage.getPhotoSource();
        assertNotEquals("Photo was upload successfully", photoNameBeforeUpload, photoNameAfterUpload);
        scenarioContext.saveData(DEFAULT_PHOTO, photoNameBeforeUpload);
    }

    @And("user returns to default photo options")
    public void userReturnsToDefaultPhotoOptions() {
        String expectedPhotoName = (String) scenarioContext.getData(DEFAULT_PHOTO);
        EditAccountPage editAccountPage = (EditAccountPage) scenarioContext.getData(ACTUAL_PAGE);
        editAccountPage.deletePhoto();
        String actualPhotoName = editAccountPage.getPhotoSource();
        assertThat("Photo was deleted", expectedPhotoName, equalTo(actualPhotoName));
    }
}
