package com.endava.soa.pageObject;

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

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
    @FindBy(xpath = "//a[contains(@href,'cabinet/favorites')]")
    private WebElement favoritesButton;

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
}
