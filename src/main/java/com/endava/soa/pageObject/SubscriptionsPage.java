package com.endava.soa.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SubscriptionsPage {
  @FindBy(xpath = "//div[contains(@class,'subscriptions-list__item__title')]//a")
  private List<WebElement> subscriptionList;

  public SubscriptionsPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void getElementFromSubscriptionList(String string) {
    for (WebElement elem : this.subscriptionList) {
      if (elem.getText().contains(string)) {
        assertTrue(elem.getText().contains(string));
      }
    }
  }
}
