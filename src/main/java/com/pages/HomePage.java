package com.pages;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public static final String BASE_URL = "https://pixellu.com/";

    @FindBy(css = "li.has-menu>span")
    WebElement loginMenu;

    @FindBy(css = "li>a[title*='Log in to SmartSlides']")
    WebElement smartSlidesLoginLink;

    public HomePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.has-menu>span")));
    }

    public void loginSmartSlides() {
        loginMenu.click();
        smartSlidesLoginLink.click();
    }


}
