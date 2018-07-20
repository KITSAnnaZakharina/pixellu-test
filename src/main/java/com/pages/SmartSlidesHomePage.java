package com.pages;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SmartSlidesHomePage extends BasePage {

    public static final String BASE_URL = "https://smartslides.com/";
    private static final String LOGOUT_XPATH = "//span[text()='Log out']/..";

    @FindBy(css = "div.user-button")
    WebElement userButton;

    public SmartSlidesHomePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.user-button")));
    }

    public void logOut(){
        Actions actions = new Actions(driver);
        actions.moveToElement(userButton).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGOUT_XPATH)));
        driver.findElement(By.xpath(LOGOUT_XPATH)).click();
    }
}
