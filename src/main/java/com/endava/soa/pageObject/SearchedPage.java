package com.endava.soa.pageObject;

import com.endava.soa.utils.ScenarioContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.endava.soa.constant.ScenarioKey.SELECTED_ITEM;

public class SearchedPage {

  private WebDriverWait wait;

  @FindBy(xpath = "//aside//a")
  private WebElement saveSubscriptionOption;

  @FindBy(xpath = "//aside//a[@class='is-disabled']")
  private WebElement savedSubscriptionOption;

  @FindBy(xpath = "//header[@class='page-header items__header']//h1")
  private WebElement searchPageTitle;

  @FindBy(xpath = "//div[@class='empty__search__title']")
  private WebElement noItemDisplayMessage;

  @FindBy(xpath = "//div[contains(@class,'ads-list-photo-item-title')]//a")
  private List<WebElement> searchResultsList;

  @FindBy(xpath = "//div[@class='header_menu_nav__dropdown-wrapper']")
  private WebElement personalCabinetDropDownWrapper;

  @FindBy(xpath = "//ul//a[@href='/cabinet/subscriptions']")
  private WebElement subscriptionOption;

  ScenarioContext scenarioContext = ScenarioContext.getScenarioInstance();

  public SearchedPage(WebDriver driver) {
    wait = new WebDriverWait(driver, 10);
    PageFactory.initElements(driver, this);
  }

  public void selectElementFromSearchResultsById(int elementId) {
    scenarioContext.saveData(SELECTED_ITEM, searchResultsList.get(elementId).getText());
    searchResultsList.get(elementId).click();
  }

  public String getSearchedElement() {
    wait.until(ExpectedConditions.visibilityOf(searchPageTitle));
    return searchPageTitle.getText();
  }

  public WebElement getNoItemDisplayMessage() {
    return noItemDisplayMessage;
  }

  public void checkSaveSubscriptionOption() throws Exception {
    if (saveSubscriptionOption.isEnabled()) {
      saveSubscriptionOption.click();
    } else {
      throw new Exception("Element not displayed");
    }
  }

  public WebElement checkSaveSubscriptionOptionIsDisabled() {
    return saveSubscriptionOption;
  }

  public void chooseSubscriptionOption() {
    personalCabinetDropDownWrapper.click();
    wait.until(ExpectedConditions.visibilityOf(subscriptionOption));
    subscriptionOption.click();
  }
}
