package com.pages;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SmartSlidesLoginPage extends BasePage {

    public static final String BASE_URL = "https://smartslides.com/login";

    @FindBy(css = "input[name='email']")
    WebElement emailInput;

    @FindBy(css = "input[name='password']")
    WebElement pwdInput;

    @FindBy( css = "button[type='submit']")
    WebElement loginButton;

    @FindBy( css = "div.error-container")
    WebElement error;

    public SmartSlidesLoginPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));
    }

     public void loginSmartSlides(String email, String password) {
        emailInput.sendKeys(email);
        pwdInput.sendKeys(password);
        loginButton.click();

    }

    public String readError(){
        //TODO create a custom expected condition: any text to be present in element
        //TODO wait.until(new textToBePresentInElement(error));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return error.getText();
    }

}
