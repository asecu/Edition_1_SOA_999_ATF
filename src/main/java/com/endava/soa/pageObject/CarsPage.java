package com.endava.soa.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class CarsPage {
    private WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[contains(@href,'category/transport')]")
    private WebElement transportTab;
    @FindBy(xpath = "//li[contains(@class,'category__subCategories-collection')]//a[contains(@href,'list/transport/cars')]")
    private WebElement carsTab;
    @FindBy(xpath = "//label[@for='filter-290']")
    private WebElement cityDropdown;
    @FindBy(xpath = "//input[@id='option-778']")
    private WebElement changeCheckbox;
    @FindBy(xpath = "//input[contains(@name, 'r_6_2_from')]")
    private WebElement minPriceField;
    @FindBy(xpath = "//input[contains(@name, 'r_6_2_to')]")
    private WebElement maxPriceField;
    @FindBy(css = ".items__header__total")
    private WebElement itemsNumber;

    public CarsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public int getItemsNumber() {
        WebElement element = wait.until(elementToBeClickable(By.cssSelector(".items__header__total")));
        return Integer.parseInt(itemsNumber.getText().replaceAll("\\D+", ""));
    }

    public void openCarsPage() {
        carsTab.click();
    }


    public void expandCityFilters() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cityDropdown.click();
    }

    public void chooseOption(String option) throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//label[contains(@for, 'option')]/span[contains(text(), '" + option + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    public void setPriceRangeMin(String price) {
        WebElement element = wait.until(
                elementToBeClickable(By.xpath("//input[contains(@name, 'r_6_2_from')]")));
        minPriceField.sendKeys(price);
    }

    public void setPriceRangeMax(String price) {
        WebElement element = wait.until(
                elementToBeClickable(By.xpath("//input[contains(@name, 'r_6_2_to')]")));
        maxPriceField.sendKeys(price);
    }
}
