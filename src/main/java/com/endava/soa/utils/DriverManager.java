package com.endava.soa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.endava.soa.utils.PropertyLoader.getBrowserProperty;
import static com.endava.soa.utils.PropertyLoader.getDriverPathProperty;
import static java.lang.System.setProperty;

public class DriverManager {
    private static final String CHROME_DRIVER = "chromedriver.exe";
    private static final String FIREFOX_DRIVER = "geckodriver.exe";
    private static WebDriver driver = null;

    private static WebDriver getFirefox() {
        setProperty("webdriver.gecko.driver", getDriverPathProperty() + FIREFOX_DRIVER);
        if (driver == null)
            driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver getChrome() {
        setProperty("webdriver.chrome.driver", getDriverPathProperty() + CHROME_DRIVER);
        if (driver == null)
            driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getAtfBrowser() throws AtfException {
        String browserName = getBrowserProperty().toLowerCase();
        switch (browserName){
            case "chrome":
                return getChrome();
            case "firefox":
                return getFirefox();
            default:
                throw new AtfException("Unsupported browser type");
        }
    }
}
