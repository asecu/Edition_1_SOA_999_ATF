package com.endava.soa.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AnouncePlacingMobilePhonePage {
    private WebDriver driver;


    @FindBy(xpath = "//input[@id='control_12']")
    private WebElement anounceTitleTextBox;
    @FindBy(xpath = "//textarea[@id='control_13']")
    private WebElement anounceTextTextBox;
    @FindBy(xpath = "//select[@id='control_7']")
    private WebElement regionDropdown;
    @FindBy(xpath = "//input[@id='control_2']")
    private WebElement priceTextBox;
    @FindBy(xpath = "//select[@id='control_589']")
    private WebElement brandDropdown;
    @FindBy(xpath = "//select[@id='control_590']")
    private WebElement modelDropdown;
    @FindBy(xpath = "//select[@id='control_593']")
    private WebElement conditionDropdown;
    @FindBy(xpath = "//select[@id='control_592']")
    private WebElement designDropdown;
    @FindBy(xpath = "//select[@id='control_591']")
    private WebElement OSDropdown;
    @FindBy(xpath = "//select[@id='control_1265']")
    private WebElement ROMDropdown;
    @FindBy(xpath = "//select[@id='control_1266']")
    private WebElement RAMDropdown;
    @FindBy(xpath = "//select[@id='control_1322']")
    private WebElement displaySizeDropdown;
    @FindBy(xpath = "//select[@id='control_1323']")
    private WebElement displayResolutionDropdown;
    @FindBy(xpath = "//select[@id='control_1324']")
    private WebElement displayTypeDropdown;
    @FindBy(xpath = "//select[@id='control_1325']")
    private WebElement cameraDropdown;
    @FindBy(xpath = "//input[@name='1328']")
    private WebElement fingerprintCheckbox;
    @FindBy(xpath = "//input[@name='1329']")
    private WebElement faceunlockCheckbox;
    @FindBy(xpath = "//input[@name='1327']")
    private WebElement nfcCheckbox;
    @FindBy(xpath = "//input[@name='1326']")
    private WebElement usbTypeCheckbox;
    @FindBy(xpath = "//input[@name='597']")
    private WebElement dualSimCheckbox;
    @FindBy(xpath = "//input[@name='594']")
    private WebElement touchscreenCheckbox;
    @FindBy(xpath = "//input[@name='601']")
    private WebElement forgCheckbox;
    @FindBy(xpath = "//input[@name='600']")
    private WebElement threegCheckbox;
    @FindBy(xpath = "//input[@name='596']")
    private WebElement wifiCheckbox;
    @FindBy(xpath = "//input[@name='598']")
    private WebElement extendableROMCheckbox;
    @FindBy(xpath = "//input[@name='602']")
    private WebElement gpsCheckbox;
    @FindBy(xpath = "//input[@name='595']")
    private WebElement incorporatedCameraCheckbox;
    @FindBy(xpath = "//*[@id='fileupload-file-input']")
    private WebElement uploadPhoto;
    @FindBy(xpath = "//button[contains(@class,'button button--giant')]")
    private WebElement addAnouncementButton;
    @FindBy(xpath = "//*[@id='js-pjax-container']/div/div[1]/div/div")
    private WebElement alreadyHaveAnouncement;
    @FindBy(xpath = "//input[@id='agree']")
    private WebElement agreeCheckbox;

    public WebElement getAlreadyHaveAnouncement() {
        return alreadyHaveAnouncement;
    }

    public AnouncePlacingMobilePhonePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getAddAnouncementButton() {
        return addAnouncementButton;
    }

    public WebElement getUploadPhoto() {
        return uploadPhoto;
    }


    public WebElement getAnounceTitleTextBoxWhenLoaded() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='control_12']")));

    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getAnounceTitleTextBox() {
        return anounceTitleTextBox;
    }

    public WebElement getAnounceTextTextBox() {
        return anounceTextTextBox;
    }

    public Select getRegionDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_7']")));
    }

    public WebElement getPriceTextBox() {
        return priceTextBox;
    }

    public Select getBrandDropdown() {

        return new Select(driver.findElement(By.xpath("//select[@id='control_589']")));

    }

    public Select getModelDropdown() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='control_590']")));
        return new Select(driver.findElement(By.xpath("//select[@id='control_590']")));
    }

    public Select getConditionDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_593']")));
    }

    public Select getDesignDropdown() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='control_592']")));
        return new Select(driver.findElement(By.xpath("//select[@id='control_592']")));
    }

    public Select getOSDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_591']")));
    }

    public Select getROMDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_1265']")));
    }

    public Select getRAMDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_1266']")));
    }

    public Select getDisplaySizeDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_1322']")));
    }

    public Select getDisplayResolutionDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_1323']")));
    }

    public Select getDisplayTypeDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_1324']")));
    }

    public Select getCameraDropdown() {
        return new Select(driver.findElement(By.xpath("//select[@id='control_1325']")));
    }

    public WebElement getFingerprintCheckbox() {
        return fingerprintCheckbox;
    }

    public WebElement getFaceunlockCheckbox() {
        return faceunlockCheckbox;
    }

    public WebElement getNfcCheckbox() {
        return nfcCheckbox;
    }

    public WebElement getUsbTypeCheckbox() {
        return usbTypeCheckbox;
    }

    public WebElement getDualSimCheckbox() {
        return dualSimCheckbox;
    }

    public WebElement getTouchscreenCheckbox() {
        return touchscreenCheckbox;
    }

    public WebElement getForgCheckbox() {
        return forgCheckbox;
    }

    public WebElement getThreegCheckbox() {
        return threegCheckbox;
    }

    public WebElement getWifiCheckbox() {
        return wifiCheckbox;
    }

    public WebElement getExtendableROMCheckbox() {
        return extendableROMCheckbox;
    }

    public WebElement getGpsCheckbox() {
        return gpsCheckbox;
    }

    public WebElement getIncorporatedCameraCheckbox() {
        return incorporatedCameraCheckbox;
    }

    public WebElement getAgreeCheckbox() {
        return agreeCheckbox;
    }
}
