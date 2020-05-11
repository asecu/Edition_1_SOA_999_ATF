package com.endava.soa.stepdef;

import static com.endava.soa.utils.PropertyLoader.getHomeURLProperty;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;

import com.endava.soa.constant.User;
import com.endava.soa.pageObject.HomePage;
import com.endava.soa.pageObject.LoginPage;
import com.endava.soa.pageObject.MyAnnouncements;
import com.endava.soa.pageObject.MyHistory;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import static com.endava.soa.constant.ScenarioKey.DRIVER;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserCheckingOpenedAnnouncements {
    WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;
    private MyHistory myHistoryPage;
    private MyAnnouncements myAnnouncementsPage;
    private String firstRecommendationText;

    ScenarioContext scenarioContext = getScenarioInstance();

    public UserCheckingOpenedAnnouncements() {
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

//    @Given("home page is displayed")
//    public void userIsOnIndexPage () {
//        String URL = driver.getCurrentUrl();
//        assertEquals(URL, getHomeURLProperty() + "/");
//    }
//
//    @And("User {string} is logged in")
//   public void userSingsIns (User user) {
//        homePage.login(user);
//    }


    @And("User clicks on first recommended announcement")
    public void userClicksOnAnnouncement () {
        firstRecommendationText = homePage.getFirstRecommendation().getText();
        homePage.getFirstRecommendation().click();
        }


    @Then("at page history is shown first recommended announcement")

    public void CheckHistoryFirstItemLink() {
        System.out.println(firstRecommendationText);
       assertEquals(myHistoryPage.getOpenedHistoryFirstItemLink().getText(), firstRecommendationText);
    }

}

