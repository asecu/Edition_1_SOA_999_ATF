package com.endava.soa.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static Properties properties = new Properties();

    private static void loadProperties() {
        try (FileReader reader = new FileReader("src/main/resources/application.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowserProperty() {
        loadProperties();
        return properties.getProperty("browser");
    }

    public static String getDriverPathProperty() {
        loadProperties();
        return properties.getProperty("driver.path");
    }

    public static String getHomeURLProperty() {
        loadProperties();
        return properties.getProperty("homeURL");
    }

    public static String getUsernameProperty(String userType) {
        loadProperties();
        return properties.getProperty(userType + ".username");
    }

    public static String getPasswordProperty(String userType) {
        loadProperties();
        return properties.getProperty(userType + ".password");
    }
}
