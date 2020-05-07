package com.endava.soa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {
    private WebDriver driver;

    @FindBy(id = "topbar-settings")
    private WebElement settingsFrame;
    @FindBy(xpath = "//a[contains(@class,'has-icon--general')]")
    private WebElement generalOption;
    @FindBy(xpath = "//a[contains(@class,'has-icon--contacts')]")
    private WebElement contactsOption;
    @FindBy(xpath = "//a[contains(@class,'has-icon--userpic')]")
    private WebElement photoOption;
    @FindBy(xpath = "//a[contains(@class,'has-icon--username')]")
    private WebElement userNameOption;
    @FindBy(xpath = "//a[contains(@class,'has-icon--email')]")
    private WebElement emailOption;
    //General Fields
    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//select[@name='birthdate_day']")
    private WebElement birthDayDropdown;
    @FindBy(xpath = "//select[@name='birthdate_month']")
    private WebElement birthMonthDropdown;
    @FindBy(xpath = "//select[@name='birthdate_year']")
    private WebElement birthYearDropdown;
    @FindBy(xpath = "//select[@name='sex']")
    private WebElement genderDropdown;
    @FindBy(xpath = "//button[@class='simpalsid-modal-content-form-submit-btn']")
    private WebElement submitButton;
    //Contacts Fields
    @FindBy(xpath = "//select[@name='country_code']")
    private WebElement countryDropdown;
    @FindBy(xpath = "//input[@name='number']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//button[@class='simpalsid-modal-content-form-submit-btn is-small']")
    private WebElement addButton;
    //Photo Options
    @FindBy(xpath = "//input[@id='simpalsid-user-settings-userpic-file']")
    private WebElement addPhotoButton;
    @FindBy(xpath = "//img[@id='simpalsid-user-settings-userpic-img']")
    private WebElement photoPlaceholder;
    //email Option
    @FindBy(xpath = "//input[@name='email']")
    private WebElement newEmailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@class='simpalsid-modal-content-form-submit-btn']")
    private WebElement saveEmailButton;
    @FindBy(id = "simpalsid-settings-tab-success")
    private WebElement successMessage;
    @FindBy(xpath = "//*[@id='simpalsid-settings-tab']//li")
    private WebElement errorMessage;


    public EditAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToSettingsFrame() {
        driver.switchTo().frame(settingsFrame);
    }

    public void exitFrame() {
        driver.switchTo().defaultContent();
    }

    public void selectOption(String option) {
        switch (option.toLowerCase()) {
            case "general":
                generalOption.click();
                break;
            case "e-mail":
                emailOption.click();
                break;
            case "photo":
                photoOption.click();
                break;
            case "username":
                userNameOption.click();
                break;
            default:
                throw new RuntimeException("Invalid Option");
        }
    }
}
