package com.endava.soa.stepdef;

import com.endava.soa.constant.ScenarioKey;
import com.endava.soa.constant.User;
import com.endava.soa.pageObject.EditAccountPage;
import com.endava.soa.pageObject.HomePage;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;
import static org.junit.Assert.assertTrue;

public class EditAccountSteps {
    ScenarioContext scenarioContext = getScenarioInstance();
    WebDriver driver = (WebDriver) scenarioContext.getData(ScenarioKey.DRIVER);

    @Given("user {} is logged in")
    public void userIsLoggedIn(User user) {
        HomePage homePage = new HomePage(driver);
        homePage.login(user);
        assertTrue("[Cabinet Personal] is displayed", homePage.getPersonalCabinet().isDisplayed());
    }

    @When("user access {string} option from settings")
    public void userAccessEMailOptionFromSettings(String option) {
        HomePage homePage = new HomePage(driver);
        homePage.accessSettingsTab();
        EditAccountPage accountPage = new EditAccountPage(driver);
        accountPage.switchToSettingsFrame();
        accountPage.selectOption(option);
    }

    @And("user fills in the following fields with data:")
    public void userFillsInTheFollowingFieldsWithData(DataTable parameters) {

    }
}
