package com.endava.soa.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@name,'login')]")
    private WebElement usernameField;
    @FindBy(xpath = "//input[contains(@name,'password')]")
    private WebElement passwordField;
    @FindBy(xpath = "//button[contains(@class,'login__form__footer__submit')]")
    private WebElement loginButton;


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameFieldWhenLoaded() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'login')]")));

    }


    public WebElement getPasswordField() {
        return passwordField;
    }


    public WebElement getLoginButton() {
        return loginButton;
    }


}
