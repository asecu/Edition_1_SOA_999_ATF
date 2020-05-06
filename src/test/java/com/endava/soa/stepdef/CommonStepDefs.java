package com.endava.soa.stepdef;

import com.endava.soa.pageObject.HomePage;
import com.endava.soa.pageObject.LoginPage;
import com.endava.soa.utils.AtfException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.endava.soa.utils.DriverManager.getAtfDriver;
import static com.endava.soa.utils.PropertyLoader.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonStepDefs {
    WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;

    public CommonStepDefs() throws AtfException {
        driver = getAtfDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);

    }


    @Given("{string} page is displayed")
    public void pageIsDisplayed(String pageName) {
        assertTrue(driver.getCurrentUrl().contains(pageName));
    }

    @And("{string} user is logged in")
    public void userIsLoggedIn(String userType) {
        Assert.assertTrue(homePage.getAuthentificationOption().isDisplayed());
        homePage.getAuthentificationOption().click();
        assertTrue(loginPage.getUsernameFieldWhenLoaded().isDisplayed());
        loginPage.getUsernameFieldWhenLoaded().sendKeys(getUsernameProperty(userType));
        loginPage.getPasswordField().sendKeys(getPasswordProperty(userType));
        loginPage.getLoginButton().click();
        String URL = driver.getCurrentUrl();
        assertEquals(URL, getHomeURLProperty() + "/");
        assertTrue(homePage.getFavoritesButton().isDisplayed());
    }

}
