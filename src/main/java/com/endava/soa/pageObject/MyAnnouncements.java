package com.endava.soa.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAnnouncements {
    private WebDriver driver;

    public MyAnnouncements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul//a[@href='/cabinet/user-history']")
    private WebElement historyLink;

    public WebElement getHistoryLink() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul//a[@href='/cabinet/user-history']")));
    }
}
//        return (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'/cabinet/items')]")));