package com.endava.soa.pageObject;

import com.endava.soa.constant.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),'înregistrare')]")
    private WebElement inregistrareWebElement;
    @FindBy(xpath = "//a[contains(@href,'user/login')]")
    private WebElement authentificationOption;
    @FindBy(xpath = "//input[@id='js-search-input']")
    private WebElement cautareInAnunturiForm;
    @FindBy(xpath = "//button[@class='header__search__button']")
    private WebElement cautaButton;
    @FindBy(xpath = "//a[contains(@href,'/add')]")
    private WebElement addAnouncement;
    @FindBy(xpath = "//a[contains(text(),'Transport')]")
    private WebElement transportTab;
    @FindBy(xpath = "//a[contains(text(),'Imobiliare')]")
    private WebElement imobiliareTab;
    @FindBy(xpath = "//a[contains(text(),'Aparate telefonice')]")
    private WebElement aparateTelefoniceTab;
    @FindBy(xpath = "//nav[contains(@class,'main-CatalogNavigation')]//ul")
    private List<WebElement> anunturiList;
    @FindBy(xpath = "//div[@id='js-recommended-container']")
    private WebElement recomandateContainer;
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

    public WebElement getInregistrareWebElement() {
        return inregistrareWebElement;
    }

    public WebElement getAuthentificationOption() {
        return authentificationOption;
    }

    public WebElement getCautareInAnunturiForm() {
        return cautareInAnunturiForm;
    }

    public WebElement getCautaButton() {
        return cautaButton;
    }

    public WebElement getAddAnouncement() {
        return addAnouncement;
    }

    public WebElement getTransportTab() {
        return transportTab;
    }

    public WebElement getImobiliareTab() {
        return imobiliareTab;
    }

    public WebElement getAparateTelefoniceTab() {
        return aparateTelefoniceTab;
    }

    public List<WebElement> getAnunturiList() {
        return anunturiList;
    }

    public WebElement getRecomandateContainer() {
        return recomandateContainer;
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
