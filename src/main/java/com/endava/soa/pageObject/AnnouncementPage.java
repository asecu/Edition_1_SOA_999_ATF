package com.endava.soa.pageObject;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AnnouncementPage {

    @FindBy(xpath = "//div[contains(@class, 'header_menu_nav__dropdown-wrapper')]")
    private WebElement personalCabinetDropdown;
    @FindBy(xpath = "//a[contains(@href, '/cabinet/items')]")
    private WebElement myAnnouncementOption;
    @FindBy(xpath = "//i[@class='figure figure--ad_remove']")
    private WebElement deleteAnnouncementButton;
    @FindBy(xpath = "//button[contains(@class,'button button--small')]")
    private WebElement confirmDeleteAnnouncementButton;
    @FindBy(xpath = "//input[@id='js-cabinet-items-select-all']")
    private WebElement selectAllAnnouncementCheckbox;
    @FindBy(xpath = "//i[contains(@class,'figure figure--small figure--ad_remove')]")
    private WebElement deleteAllAnnouncementButton;
    @FindBy(xpath = "//td[contains(@class,'cabinet__user-ads__check')]/input")
    private WebElement announcementSelectCheckbox;
    @FindBy(xpath = "//i[@class='figure figure--ad_edit']")
    private WebElement editAnnouncementButton;
    @FindBy(css = ".cabinet__user-ads__header__filters  li:nth-child(1) .is-counter")
    private WebElement announcementsNumber;
    @FindBy(xpath = "//div[contains(@class, 'grid_9')]/button")
    private WebElement saveButton;
    @FindBy(xpath = "//input[@id='control_12']")
    private WebElement title;
    @FindBy(xpath = "//textarea[@id='control_13']")
    private WebElement description;
    @FindBy(xpath = "//select[@id='control_7']")
    private WebElement location;
    @FindBy(xpath = "//select[@id='control_589']")
    private WebElement mark;
    @FindBy(xpath = "//select[@id='control_590']")
    private WebElement model;
    @FindBy(xpath = "//ul[@class = 'product-payment__info']")
    private WebElement productPaymentInfoContainer;


    private WebDriver driver;
    private Select select;
    WebDriverWait wait;

    public AnnouncementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isUserOnPayPage() {
        wait.until(elementToBeClickable(productPaymentInfoContainer));
        try {
            productPaymentInfoContainer.click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void openAnnouncementsPage() throws InterruptedException {
        Thread.sleep(3000);
        personalCabinetDropdown.click();
        myAnnouncementOption.click();
    }

    public void pressDeleteAnnouncementButton() {
        deleteAnnouncementButton.click();
    }

    public void pressConfirmButton() {
        confirmDeleteAnnouncementButton.click();
    }

    public void selectAllAnnouncements() {
        selectAllAnnouncementCheckbox.click();
    }

    public void deleteAllAnnouncements() {
        deleteAllAnnouncementButton.click();
    }

    public boolean isPopUpDisplayed() {
        wait.until(elementToBeClickable(confirmDeleteAnnouncementButton));
        return confirmDeleteAnnouncementButton.isDisplayed();
    }

    public boolean isAnnouncementDisplayed() {
        try {
            deleteAnnouncementButton.click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAnnouncementSelected() {
        return announcementSelectCheckbox.isDisplayed();
    }

    public void pressEditAnnouncementButton() {
        editAnnouncementButton.click();
    }

    public boolean isSaveButtonDisplayed() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return saveButton.isDisplayed();
    }

    public String getTitle() {
        return title.getAttribute("value");
    }

    public String getDescription() {
        return description.getAttribute("value");
    }

    public String getLocation() {
        select = new Select(location);
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public String getMark() {
        select = new Select(mark);
        return select.getFirstSelectedOption().getText();
    }

    public String getModel() {
        select = new Select(model);
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public void save() {
        saveButton.click();
    }

    public void setTitle(String title) {
        this.title.clear();
        this.title.sendKeys(title);
    }

    public void setDescription(String description) {
        this.description.clear();
        this.description.sendKeys(description);
    }

    public void setLocation(String location) {
        select = new Select(this.location);
        select.selectByValue(location);
    }

    public void setMark(String mark) {
        select = new Select(this.mark);
        select.selectByVisibleText(mark);
    }

    public void setModel(String model) {
        wait.until(elementToBeClickable(this.model));
        select = new Select(this.model);
        select.selectByValue(model);
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
    }

    public int getAnnouncementNumber() {
        return Integer.parseInt(announcementsNumber.getText().replaceAll("\\D+", ""));
    }

}
