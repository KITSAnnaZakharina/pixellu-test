package com.pixellu.tests.ui;

import com.logic.EnvManager;
import com.pages.HomePage;
import com.pages.SmartSlidesLoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;


public class TestLoginFailed {

    @BeforeClass
    public void startBrowser() {
        EnvManager.initWebDriver("chrome");
    }

    @Test
    public void loginWrongCredentials() {
        EnvManager.getWebDriver().navigate().to(HomePage.BASE_URL);
        HomePage homePage = new HomePage(EnvManager.getWebDriver());
        homePage.loginSmartSlides();
        SmartSlidesLoginPage smartSlidesLoginPage = new SmartSlidesLoginPage(EnvManager.getWebDriver());
        smartSlidesLoginPage.loginSmartSlides("bla-bla@gmail.com", "bla-bla");
        assertEquals("Incorrect email or password", smartSlidesLoginPage.readError());
    }

    @AfterClass
    public void tearDown() {
        EnvManager.shutDownDriver();
    }
}
