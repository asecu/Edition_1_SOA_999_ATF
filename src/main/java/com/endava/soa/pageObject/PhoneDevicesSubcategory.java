package com.endava.soa.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhoneDevicesSubcategory {
    private WebDriver driver;


    @FindBy(xpath = "//a[contains(@href,'/add?category=phone-and-communication&subcategory=phone-and-communication/mobile-phones')]")
    private WebElement mobilePhones;

    public PhoneDevicesSubcategory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getmobilePhonesWhenLoaded() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'/add?category=phone-and-communication&subcategory=phone-and-communication/mobile-phones')]")));

    }
}
