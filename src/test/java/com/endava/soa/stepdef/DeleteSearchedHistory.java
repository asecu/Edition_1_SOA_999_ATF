package com.endava.soa.stepdef;

import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;

import com.endava.soa.pageObject.HomePage;
import com.endava.soa.pageObject.LoginPage;
import com.endava.soa.pageObject.MyAnnouncements;
import com.endava.soa.pageObject.MyHistory;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static com.endava.soa.constant.ScenarioKey.DRIVER;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoSuchElementException;
import java.lang.Thread;

public class DeleteSearchedHistory {
    WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;
    private MyHistory myHistoryPage;
    private MyAnnouncements myAnnouncementsPage;

    ScenarioContext scenarioContext = getScenarioInstance();

    public DeleteSearchedHistory() {
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


    @When("User clicks at Delete searched history button")
    public void userClickDeleteButton() {
        myHistoryPage.getDeleteSearchedAnnouncementsButton().click();
    }

    @Then("Previous Searches link is not showing")
    public void checkSearchedItemsIsDeleted() throws InterruptedException{
        Thread.sleep(3000);
        Boolean isElementPresent = true;
        try {
            myHistoryPage.getSearchedHistoryFirstItemLink().isDisplayed();
        }
        catch (NoSuchElementException | StaleElementReferenceException e) {
            isElementPresent = false;
        }
        System.out.println(isElementPresent);
        Assert.assertFalse(isElementPresent);
    }

}

