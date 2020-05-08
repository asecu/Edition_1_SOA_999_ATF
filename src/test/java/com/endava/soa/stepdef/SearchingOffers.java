package com.endava.soa.stepdef;

import com.endava.soa.pageObject.HomePage;
import com.endava.soa.pageObject.ProductPage;
import com.endava.soa.pageObject.SearchedPage;
import com.endava.soa.pageObject.SubscriptionsPage;
import com.endava.soa.utils.DriverManager;
import com.endava.soa.utils.PropertyLoader;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.endava.soa.constant.ScenarioKey.*;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchingOffers {
  ScenarioContext scenarioContext = getScenarioInstance();
  WebDriver driver = (WebDriver) scenarioContext.getData(DRIVER);
  HomePage homePage = new HomePage(driver);
  SearchedPage searchedPage = new SearchedPage(driver);
  ProductPage productPage = new ProductPage(driver);
  SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
  DriverManager driverManager = new DriverManager();

  @Given("home page is displayed")
  public void pageIsDisplayed() throws RuntimeException {
    String actualResult = PropertyLoader.getHomeURLProperty().toLowerCase();
    String expectedResult = driver.getCurrentUrl().toLowerCase();
    assertTrue(expectedResult.contains(actualResult));
  }

  @When("user searches for {string}")
  public void userSearchesFor(String data) {
    homePage.searchAdds(data);
    scenarioContext.saveData(SEARCHED_VALUE, data);
  }

  @Then("the searching result page is displayed")
  public void theSearchingResultPageIsDisplayed() {
    String expectedSearchedValueOnSearchPage = (String) scenarioContext.getData(SEARCHED_VALUE);
    assertEquals(
            expectedSearchedValueOnSearchPage.toLowerCase(),
            searchedPage.getSearchedElement().toLowerCase());
  }

  @When("item with id '(.*?)' from the list is selected")
  public void anItemFromTheListIsClicked(int itemId) {
    searchedPage.selectElementFromSearchResultsById(itemId);
    System.out.println("------------> ELEMENT WITH ID " + itemId + " IS SELECTED!");
  }

  @Then("item page is displayed")
  public void itemPageIsDisplayed() {
    String expectedSelectedItemName = (String) scenarioContext.getData(SELECTED_ITEM);
    assertTrue(
            productPage.getProductNameOnProductPage().getText().contains(expectedSelectedItemName));
  }

  @And("item body contains the searched value")
  public void itemBodyContainsTheSearchedValue() {
    String expectedSelectedItemName = (String) scenarioContext.getData(SELECTED_ITEM);
    assertTrue(
            productPage.getProductNameOnProductPage().getText().contains(expectedSelectedItemName));
  }

  @Then("informative message is displayed")
  public void informativeMessageIsDisplayed() {
    String expectedInformativeMessage = "Din păcate, nu sunt rezultate pentru căutarea Dvs.";
    assertEquals(expectedInformativeMessage, searchedPage.getNoItemDisplayMessage().getText());
  }

  @When("save search option is clicked")
  public void saveSearchOptionIsClicked() throws Exception {
    searchedPage.checkSaveSubscriptionOption();
  }

  @Then("save search option is disabled")
  public void saveSearchOptionIsDisabled() {
    assertTrue(searchedPage.checkSaveSubscriptionOptionIsDisabled().isDisplayed());
  }

  @When("user accesses subscription option from personal Cabinet")
  public void userAccessesSubscriptionOptionFromPersonalCabinet() {
    searchedPage.chooseSubscriptionOption();
  }

  @Then("list of subscriptions containing {string} is displayed")
  public void listOfSubscriptionsContainingDataIsDisplayed(String data) throws Exception {
    subscriptionsPage.getElementFromSubscriptionList(data);
  }
}
