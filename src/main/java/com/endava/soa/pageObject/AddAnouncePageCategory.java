package com.endava.soa.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAnouncePageCategory {
    private WebDriver driver;

    public AddAnouncePageCategory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'/add?category=phone-and-communication')]")
    private WebElement phoneDevices;

    public WebElement getPhoneDevices() {
        return phoneDevices;
    }

    public WebElement getPhoneDevicesWhenLoaded() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'/add?category=phone-and-communication')]")));

    }
}
