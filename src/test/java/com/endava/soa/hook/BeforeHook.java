package com.endava.soa.hook;


import com.endava.soa.utils.ScenarioContext;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static com.endava.soa.constant.ScenarioKey.DRIVER;
import static com.endava.soa.utils.DriverManager.getAtfDriver;
import static com.endava.soa.utils.PropertyLoader.getHomeURLProperty;
import static com.endava.soa.utils.ScenarioContext.getScenarioInstance;

public class BeforeHook {
    ScenarioContext scenarioContext = getScenarioInstance();

    @Before
    public void setUp() {
        WebDriver driver = getAtfDriver();
        driver.manage().window().maximize();
        driver.get(getHomeURLProperty());
        scenarioContext.save(DRIVER, driver);
    }
}