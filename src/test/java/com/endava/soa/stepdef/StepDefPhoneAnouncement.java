package com.endava.soa.stepdef;

import com.endava.soa.pageObject.*;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.endava.soa.constant.ScenarioKey.DRIVER;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class StepDefPhoneAnouncement {
    ScenarioContext scenarioContext = getScenarioInstance();
    static WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private AddAnouncePageCategory addAnouncePageCategory;
    private AnouncePlacingMobilePhonePage anouncePlacingMobilePhonePage;
    private PhoneDevicesSubcategory phoneDevicesSubcategory;

    public StepDefPhoneAnouncement() {
        driver = (WebDriver) scenarioContext.getData(DRIVER);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        addAnouncePageCategory = new AddAnouncePageCategory(driver);
        anouncePlacingMobilePhonePage = new AnouncePlacingMobilePhonePage(driver);
        phoneDevicesSubcategory = new PhoneDevicesSubcategory(driver);
        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);
        PageFactory.initElements(driver, addAnouncePageCategory);
        PageFactory.initElements(driver, anouncePlacingMobilePhonePage);
        PageFactory.initElements(driver, phoneDevicesSubcategory);

    }

    @When("user clicks add announcement announcement")
    public void userClicksAddAnnouncementAnnouncement() {
        homePage.getAddAnouncement().click();
    }

    @Then("user is redirected to category page")
    public void userIsRedirectedToCategoryPage() {
        addAnouncePageCategory.getPhoneDevicesWhenLoaded().isDisplayed();
    }

    @When("user clicks phone and communication category")
    public void userClicksPhoneAndCommunicationCategory() {
        addAnouncePageCategory.getPhoneDevices().click();
    }

    @Then("user is redirected to subcategories page")
    public void userIsRedirectedToSubcategoriesPage() {
        phoneDevicesSubcategory.getmobilePhonesWhenLoaded().isDisplayed();
    }

    @When("user clicks mobile phones")
    public void userClicksMobilePhones() {
        phoneDevicesSubcategory.getmobilePhonesWhenLoaded().click();
    }

    @Then("user is redirected to complete add page")
    public void userIsRedirectedToCompleteAddPage() {
        anouncePlacingMobilePhonePage.getAnounceTitleTextBoxWhenLoaded().isDisplayed();
    }

    @When("user inputs data in announcement title field")
    public void userInputsDataInAnnouncementTitleField() {
        anouncePlacingMobilePhonePage.getAnounceTitleTextBox().sendKeys("Nokia");
    }

    @And("user inputs data in announcement text field")
    public void userInputsDataInAnnouncementTextField() {
        anouncePlacingMobilePhonePage.getAnounceTextTextBox().sendKeys("vind telefon nou");
    }

    @And("user selects region from region dropdown")
    public void userSelectsRegionFromRegionDropdown() {
        anouncePlacingMobilePhonePage.getRegionDropdown().selectByIndex(2);
    }

    @And("user inputs price in price field")
    public void userInputsPriceInPriceField() {
        anouncePlacingMobilePhonePage.getPriceTextBox().sendKeys("5000");
    }

    @And("user selects brand from brand dropdown")
    public void userSelectsBrandFromBrandDropdown() {
        anouncePlacingMobilePhonePage.getBrandDropdown().selectByValue("1913");

    }

    @And("user selects model from model dropdown")
    public void userSelectsModelFromModelDropdown() {
        anouncePlacingMobilePhonePage.getModelDropdown().selectByValue("2002");

    }

    @And("user selects condition from condition dropdown")
    public void userSelectsConditionFromConditionDropdown() {
        anouncePlacingMobilePhonePage.getConditionDropdown().selectByValue("6370");
    }

    @And("user selects design from design dropdown")
    public void userSelectsDesignFromDesignDropdown() {
        anouncePlacingMobilePhonePage.getDesignDropdown().selectByValue("6365");
    }

    @And("user selects OS from OS dropdown")
    public void userSelectsOSFromOSDropdown() {
        anouncePlacingMobilePhonePage.getOSDropdown().selectByValue("6359");
    }

    @And("user selects ROM from ROM dropdown")
    public void userSelectsROMFromROMDropdown() {
        anouncePlacingMobilePhonePage.getROMDropdown().selectByValue("23240");

    }

    @And("user selects RAM from RAM dropdown")
    public void userSelectsRAMFromRAMDropdown() {
        anouncePlacingMobilePhonePage.getRAMDropdown().selectByValue("22189");

    }

    @And("user selects display size from display size dropdown")
    public void userSelectsDisplaySizeFromDisplaySizeDropdown() {
        anouncePlacingMobilePhonePage.getDisplaySizeDropdown().selectByValue("23390");
    }

    @And("user selects display rezolution from display rezolution dropdown")
    public void userSelectsDisplayRezolutionFromDisplayRezolutionDropdown() {
        anouncePlacingMobilePhonePage.getDisplayResolutionDropdown().selectByValue("23399");
    }

    @And("user selects display type from display type dropdown")
    public void userSelectsDisplayTypeFromDisplayTypeDropdown() {
        anouncePlacingMobilePhonePage.getDisplayTypeDropdown().selectByValue("23406");

    }

    @And("user selects camera rezolution from camera rezolution dropdown")
    public void userSelectsCameraRezolutionFromCameraRezolutionDropdown() {
        anouncePlacingMobilePhonePage.getCameraDropdown().selectByValue("23407");
    }

    @And("user checks fingerprint checkbox")
    public void userChecksFingerprintCheckbox() {
        anouncePlacingMobilePhonePage.getFingerprintCheckbox().click();

    }

    @And("user checks facial unlock checkbox")
    public void userChecksFacialUnlockCheckbox() {
        anouncePlacingMobilePhonePage.getFaceunlockCheckbox().click();
    }

    @And("user checks NFC checkbox")
    public void userChecksNFCCheckbox() {
        anouncePlacingMobilePhonePage.getNfcCheckbox().click();
    }

    @And("user checks USB-typeC checkbox")
    public void userChecksUSBTypeCCheckbox() {
        anouncePlacingMobilePhonePage.getUsbTypeCheckbox().click();
    }

    @And("user checks Dual Sim checkbox")
    public void userChecksDualSimCheckbox() {
        anouncePlacingMobilePhonePage.getDualSimCheckbox().click();
    }

    @And("user checks Touch screen checkbox")
    public void userChecksTouchScreenCheckbox() {
        anouncePlacingMobilePhonePage.getTouchscreenCheckbox().click();
    }

    @And("user checks 4g checkbox")
    public void userChecks4gCheckbox() {
        anouncePlacingMobilePhonePage.getForgCheckbox().click();
    }

    @And("user checks 3g checkbox")
    public void userChecks3GCheckbox() {
        anouncePlacingMobilePhonePage.getThreegCheckbox().click();
    }

    @And("user checks wi-fi checkbox")
    public void userChecksWiFiCheckbox() {
        anouncePlacingMobilePhonePage.getWifiCheckbox().click();
    }

    @And("user checks extendable memory checkbox")
    public void userChecksExtendableMemoryCheckbox() {
        anouncePlacingMobilePhonePage.getExtendableROMCheckbox().click();
    }

    @And("user checks GPS checkbox")
    public void userChecksGPSCheckbox() {
        anouncePlacingMobilePhonePage.getGpsCheckbox().click();
    }

    @And("user checks Camera checkbox")
    public void userChecksCameraCheckbox() {
        anouncePlacingMobilePhonePage.getIncorporatedCameraCheckbox().click();
    }

    @And("user uploads a photo")
    public void userUploadsAPhoto() {
        anouncePlacingMobilePhonePage.getUploadPhoto().sendKeys("C:/test task/Edition_1_SOA_999_ATF/src/test/resources/img/phone1.jpg");
    }

    @And("user checks Agree checkbox")
    public void userChecksAgreeCheckbox() {
        anouncePlacingMobilePhonePage.getAgreeCheckbox().click();
    }

    @And("user clicks Add announcement")
    public void userClicksAddAnnouncement() throws InterruptedException {
        anouncePlacingMobilePhonePage.getAddAnouncementButton().click();
    }

    @Then("user is redirected to publish success page")
    public void userIsRedirectedToPublishSuccessPage() {
        String success = driver.getCurrentUrl();
        assertThat(success, containsString("publish_success"));
    }

    @And("an informative message is displayed that user already has placed an announcement in this category")
    public void anInformativeMessageIsDisplayedThatUserAlreadyHasPlacedAnAnnouncementInThisCategory() {
        anouncePlacingMobilePhonePage.getAlreadyHaveAnouncement().isDisplayed();
    }
}