package com.endava.soa.pageObject;

import com.endava.soa.constant.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'user/login')]")
    private WebElement authentificationOption;
    @FindBy(xpath = "//input[@id='js-search-input']")
    private WebElement searchInputField;
    @FindBy(xpath = "//button[@class='header__search__button']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[contains(@href,'/add')]")
    private WebElement addAnouncement;
    @FindBy(xpath = "//a[contains(@href,'category/transport')]")
    private WebElement transportCathegory;
    @FindBy(xpath = "//a[contains(@href,'category/real-estate')]")
    private WebElement realEstateCathegory;
    @FindBy(xpath = "//a[contains(@href,'category/phone-and-communication')]")
    private WebElement phoneAndCommunicationCathegory;
    @FindBy(xpath = "//button[contains(@class,'user-item-btn-settings')]")
    private WebElement settingsButton;
    @FindBy(xpath = "//a[@data-autotest='login']")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@name='login']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(id = "topbar-panel")
    private WebElement topPanelFrame;
    @FindBy(xpath = "//div[@data-autotest='cabinet']")
    private WebElement personalCabinet;
    @FindBy(xpath = "//a[contains(@href,'cabinet/favorites')]")
    private WebElement favoritesButton;
    @FindBy(xpath = "//a[contains(@href, '/cabinet/items')]")
    private WebElement myAnnouncementOption;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getFavoritesButton() {
        return favoritesButton;
    }

    public WebElement cabinetPersonal() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='m__user_panel']/div")));
    }


    public WebElement getAuthentificationOption() {
        return authentificationOption;
    }

    public WebElement getSearchInputField() {
        return searchInputField;
    }

    public WebElement getAddAnouncement() {
        return addAnouncement;
    }


    public void login(User user) {
        loginButton.click();
        usernameField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void accessSettingsTab() {
        driver.switchTo().frame(topPanelFrame);
        settingsButton.click();
        driver.switchTo().defaultContent();
    }

    public WebElement getPersonalCabinet() {
        return personalCabinet;
    }
}
