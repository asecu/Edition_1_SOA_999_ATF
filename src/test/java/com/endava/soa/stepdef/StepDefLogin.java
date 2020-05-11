package com.endava.soa.stepdef;


import com.endava.soa.pageObject.HomePage;
import com.endava.soa.pageObject.LoginPage;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.endava.soa.constant.ScenarioKey.DRIVER;
import static com.endava.soa.utils.PropertyLoader.*;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StepDefLogin {
    static WebDriver driver;
    ScenarioContext scenarioContext = getScenarioInstance();

    private HomePage homePage;
    private LoginPage loginPage;

    public StepDefLogin() {
        driver = (WebDriver) scenarioContext.getData(DRIVER);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);

    }


    @Given("main page is opened")
    public void mainPageIsOpened() throws Exception {
        Assert.assertTrue(homePage.getAuthentificationOption().isDisplayed());
    }

    @When("user click authentication button")
    public void userClickButtonInTheRightTopCornerOfThePage() {
        homePage.getAuthentificationOption().click();

    }

    @Then("user is redirected to login page")
    public void userIsRedirectedToLoginPage() {
        assertTrue(loginPage.getUsernameFieldWhenLoaded().isDisplayed());
    }

    @When("user inputs {string} in username field")
    public void userInputsInUsernameField(String userType) {
        loginPage.getUsernameFieldWhenLoaded().sendKeys(getUsernameProperty(userType));

    }

    @And("user input {string} in password field")
    public void userInputInPasswordField(String userType) {
        loginPage.getPasswordField().sendKeys(getPasswordProperty(userType));
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        loginPage.getLoginButton().click();
    }

    @Then("user is redirected to main page")
    public void userIsRedirectedToMainPage() {
        String URL = driver.getCurrentUrl();
        assertEquals(URL, getHomeURLProperty() + "/");

    }

    @And("user is logged in")
    public void userIsLoggedIn() {
        assertTrue(homePage.getFavoritesButton().isDisplayed());
    }
}