package com.endava.soa.stepdef;

import static com.endava.soa.utils.PropertyLoader.getHomeURLProperty;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;
import static org.junit.Assert.assertEquals;

import com.endava.soa.pageObject.HomePage;
import com.endava.soa.pageObject.LoginPage;
import com.endava.soa.pageObject.MyAnnouncements;
import com.endava.soa.pageObject.MyHistory;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import com.endava.soa.constant.User;
import static com.endava.soa.constant.ScenarioKey.DRIVER;
import org.openqa.selenium.support.PageFactory;

public class SearchedHistory {
    WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;
    private MyHistory myHistoryPage;
    private MyAnnouncements myAnnouncementsPage;

    ScenarioContext scenarioContext = getScenarioInstance();

    public SearchedHistory() {
        driver = (WebDriver) scenarioContext.getData(DRIVER);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myHistoryPage = new MyHistory(driver);
        myAnnouncementsPage = new MyAnnouncements(driver);
        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);
        PageFactory.initElements(driver, myHistoryPage);
        PageFactory.initElements(driver, myAnnouncementsPage);
    }

    @Given("home page is displayed")
    public void userIsOnIndexPage () {
        String URL = driver.getCurrentUrl();
        assertEquals(URL, getHomeURLProperty() + "/");
    }

    @And("User {string} is logged in")
    public void userSingsIns (User user) {
        homePage.login(user);
    }

    @When("User types {string} in search-form")
    public void typeTextInSearchForm (String inputText) {
        homePage.getSearchInputField().sendKeys(inputText);
    }

    @And("User click search button")
    public void userClicksSearchButton () {
        homePage.getSearchButton().click();
    }

    @And("User open My Announcement page")
    public void userOpenMyAnnouncementPage () {
        homePage.getPersonalCabinet().click();
        homePage.getMyAnnouncementOption().click();
    }

    @And("User navigates history page")
    public void userOpenHistoryPage() {
        myAnnouncementsPage.getHistoryLink().click();
    }

    @Then("at page history is shown {string}")
    public void checkIfTextIsShown (String text) {
        assertEquals(myHistoryPage.getSearchedHistoryFirstItemLink().getText(), text);
    }
}

