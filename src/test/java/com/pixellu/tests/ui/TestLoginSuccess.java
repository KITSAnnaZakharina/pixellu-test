package com.pixellu.tests.ui;

import com.logic.EnvManager;
import com.pages.HomePage;
import com.pages.SmartSlidesLoginPage;
import com.pages.SmartSlidesHomePage;
import static org.testng.AssertJUnit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginSuccess {

    @BeforeClass
    public void startBrowser() {
        EnvManager.initWebDriver("chrome");
    }

    @Test
    public void loginSuccess() {
        //I didn't use page object pattern for google pages cause they are not a part of testable application
        EnvManager.getWebDriver().navigate().to("http://google.com/");
        EnvManager.getWebDriver().findElement(By.cssSelector("input[name='q']")).sendKeys("Pixellu" + Keys.ENTER);
        EnvManager.getWebDriver().findElement(By.xpath("//*[@id='rso']//h3/a")).click();
        assertEquals("Pixellu site is not on the top of google search", HomePage.BASE_URL, EnvManager.getWebDriver().getCurrentUrl());

        HomePage homePage = new HomePage(EnvManager.getWebDriver());
        homePage.loginSmartSlides();
        SmartSlidesLoginPage smartSlidesLoginPage = new SmartSlidesLoginPage(EnvManager.getWebDriver());
        smartSlidesLoginPage.loginSmartSlides("pixellu.at.task+5@gmail.com", "cxJ7YP2J");
        assertEquals(SmartSlidesLoginPage.BASE_URL, EnvManager.getWebDriver().getCurrentUrl());
    }

    @AfterClass
    public void tearDown() {
        new SmartSlidesHomePage(EnvManager.getWebDriver()).logOut();
        EnvManager.shutDownDriver();
     }
}
