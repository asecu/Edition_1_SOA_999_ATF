package com.endava.soa.hook;

import com.endava.soa.constant.ScenarioKey;
import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

import static com.endava.soa.constant.ScenarioKey.DRIVER;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;

public class AfterHook {
ScenarioContext scenarioContext = getScenarioInstance();

    @After
    public void afterHook() {
        WebDriver driver = (WebDriver)scenarioContext.getData(DRIVER);
        driver.close();
    }
}
