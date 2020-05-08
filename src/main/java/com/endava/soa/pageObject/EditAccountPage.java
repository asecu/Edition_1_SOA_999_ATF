package com.endava.soa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class EditAccountPage {
    private WebDriver driver;
    WebDriverWait wait;
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
    @FindBy(xpath = "//*[@id='simpalsid-settings-tab']//div[5]/button")
    private WebElement saveGeneralButton;
    @FindBy(id = "simpalsid-settings-tab-success")
    private WebElement generalSuccessMessage;
    //Contacts Fields
    @FindBy(xpath = "//select[@name='country_code']")
    private WebElement countryDropdown;
    @FindBy(xpath = "//input[@name='number']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//button[@class='simpalsid-modal-content-form-submit-btn is-small']")
    private WebElement addPhoneButton;
    @FindBys({
            @FindBy(xpath = "//*[@id='simpalsid-settings-tab']//h3"),
            @FindBy(xpath = "//*[@id='simpalsid-settings-tab']//p")
    })
    private WebElement conctactErrorMessage;
    //Photo Options
    @FindBy(xpath = "//input[@id='simpalsid-user-settings-userpic-file']")
    private WebElement addPhotoButton;
    @FindBy(id = "simpalsid-user-settings-userpic-img")
    private WebElement photoPlaceholder;
    @FindBy(id = "simpalsid-user-settings-userpic-remove")
    private WebElement deletePhotoButton;
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
    private WebElement emailErrorMessage;


    public EditAccountPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
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
                wait.until(elementToBeClickable(generalOption));
                generalOption.click();
                break;
            case "e-mail":
                wait.until(elementToBeClickable(emailOption));
                emailOption.click();
                break;
            case "contact":
                wait.until(elementToBeClickable(contactsOption));
                contactsOption.click();
                break;
            case "photo":
                wait.until(elementToBeClickable(photoOption));
                photoOption.click();
                break;
            default:
                throw new RuntimeException("Invalid Option" + option);
        }
    }

    public void updateOptionDetails(String option, Map<String, String> parameters) {
        switch (option.toLowerCase()) {
            case "general":
                updateGeneral(parameters);
                break;
            case "e-mail":
                updateEmail(parameters);
                break;
            case "contact":
                updateContacts(parameters);
                break;
        }
    }

    public String getOptionMessage(String option) {
        String message = null;
        switch (option.toLowerCase()) {
            case "general":
                message = getGeneralSuccessMessage();
                break;
            case "e-mail":
                message = getEmailErrorMessage();
                break;
            case "contact":
                message = getContactsErrorMessage();
                break;
        }
        return message;
    }

    private void updateGeneral(Map<String, String> parameters) {
        String randomNumber = String.valueOf(new Random().nextInt(999)) + "";
        firstNameField.clear();
        firstNameField.sendKeys(parameters.get("firstName") + randomNumber);
        lastNameField.clear();
        lastNameField.sendKeys(parameters.get("lastName") + randomNumber);
        birthDayDropdown.sendKeys(parameters.get("birthDay"));
        birthYearDropdown.sendKeys(parameters.get("birthYear"));
        saveGeneralButton.click();
    }

    private String getGeneralSuccessMessage() {
        wait.until(visibilityOf(generalSuccessMessage));
        return generalSuccessMessage.getText();
    }

    private void updateEmail(Map<String, String> parameters) {
        wait.until(visibilityOf(newEmailField));
        newEmailField.sendKeys(parameters.get("newEmail"));
        passwordField.sendKeys(parameters.get("password"));
        saveEmailButton.click();
    }

    private void updateContacts(Map<String, String> parameters) {
        wait.until(visibilityOf(countryDropdown));
        countryDropdown.sendKeys(parameters.get("country"));
        phoneNumberField.sendKeys(parameters.get("phoneNumber"));
        addPhoneButton.click();
    }

    public void uploadPhoto(String photoName) {
        String photoPath = System.getProperty("user.dir") + "\\src\\test\\resources\\img\\";
        addPhotoButton.sendKeys(photoPath + photoName);
    }

    public String getPhotoSource() {
        return photoPlaceholder.getAttribute("src");
    }

    public void deletePhoto() {
        wait.until(elementToBeClickable(deletePhotoButton));
        deletePhotoButton.click();
    }

    private String getEmailErrorMessage() {
        wait.until(visibilityOf(emailErrorMessage));
        return emailErrorMessage.getText();
    }

    private String getContactsErrorMessage() {
        wait.until(visibilityOf(conctactErrorMessage));
        return conctactErrorMessage.getText();
    }
}