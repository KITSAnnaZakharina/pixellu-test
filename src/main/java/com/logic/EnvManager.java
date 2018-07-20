package com.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.logging.Logger;

public class EnvManager {
    private static final String DRIVER_PATH = "src/main/resources/drivers/";
    private static WebDriver driver;

    public static void initWebDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            throw new RuntimeException("Webdriver is not initialized");
        }
        return driver;
    }

    public static void shutDownDriver() {
        driver.quit();
    }


}
