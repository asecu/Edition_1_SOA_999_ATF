package com.endava.soa.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {
    @FindBy(xpath = "//a[contains(text(),'înregistrare')]")
    private WebElement inregistrareWebElement;
    @FindBy(xpath = "//a[contains(text(),'autentificare')]")
    private WebElement autentificareWebElement;
    @FindBy(xpath = "//input[@id='js-search-input']")
    private WebElement cautareInAnunturiForm;
    @FindBy(xpath = "//button[@class='header__search__button']")
    private WebElement cautaButton;
    @FindBy(xpath = "//div[contains(@class,'header_bar_nav')]//a[1]")
    private WebElement adaugaAnunt;
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

}
