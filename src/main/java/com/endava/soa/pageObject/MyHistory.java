package com.endava.soa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyHistory {
    private WebDriver driver;

    public MyHistory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[1]/header/a")
    private WebElement deleteSearchedAnnouncements;
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[1]/header/a")
    private WebElement deleteOpenedAnnouncements;
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[1]/div/ul/li[1]/a")
    private WebElement searchedHistoryFirstItemLink;
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/div/div/div[1]/div/div/a[2]")
    private WebElement openedHistoryFirstItemLink;



    public WebDriver getDriver() {
        return driver;
    }


    public WebElement getDeleteSearchedAnnouncementsButton() {
        return deleteSearchedAnnouncements;
    }
    public WebElement getDeleteOpenedAnnouncementsButton() {
        return deleteOpenedAnnouncements;
    }


    public WebElement getSearchedHistoryFirstItemLink() {
        return searchedHistoryFirstItemLink;
    }

    public WebElement getOpenedHistoryFirstItemLink() {
        return openedHistoryFirstItemLink;
    }

}

