package com.endava.soa.stepdef;


import com.endava.soa.pageObject.CarsPage;
import com.endava.soa.pageObject.HomePage;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.endava.soa.constant.ScenarioKey.DRIVER;
import static com.endava.soa.constant.ScenarioKey.ITEMS_NUMBER;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateFilterStepDef {
    WebDriver driver = (WebDriver) getScenarioInstance().getData(DRIVER);
    WebDriverWait wait = new WebDriverWait(driver, 3000);

    ScenarioContext scenarioContext = getScenarioInstance();
    CarsPage carsPage = new CarsPage((WebDriver) scenarioContext.getData(DRIVER));
    HomePage homePage = new HomePage((WebDriver) scenarioContext.getData(DRIVER));


    @Given("User is on cars announcements page")
    public void userIsOnCarsAnnouncementsPage() {
        homePage.openTransportsPage();
        carsPage.openCarsPage();
        scenarioContext.saveData(ITEMS_NUMBER, carsPage.getItemsNumber());
    }

    @When("{string} is set as city")
    public void followingExpandFieldsAreChosen(String city) throws InterruptedException {
        carsPage.expandCityFilters();
        carsPage.chooseOption(city);
    }

    @And("the following price range is set:")
    public void rangeControlsAreSet(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        carsPage.setPriceRangeMin(list.get(0));
        carsPage.setPriceRangeMax(list.get(1));
    }

    @And("the following car condition and announcement type are set:")
    public void checkboxesFromDDAreChosen(DataTable dataTable) throws InterruptedException {
        List<String> list = dataTable.asList(String.class);
        carsPage.chooseOption(list.get(0));
        carsPage.chooseOption(list.get(1));
    }

    @Then("Page is updated correspondingly")
    public void pageIsUpdatedCorrespondingly() {
        assertThat("There is the same announcement number", carsPage.getItemsNumber() < (int) scenarioContext.getData(ITEMS_NUMBER));
    }
}
