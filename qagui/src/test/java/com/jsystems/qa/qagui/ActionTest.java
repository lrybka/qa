package com.jsystems.qa.qagui;

import com.jsystems.qa.qagui.page.LoginPage;
import com.jsystems.qa.qagui.page.MainWordpressPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

@Tag("FrontTest")
public class ActionTest extends ConfigFrontend {


    @Test
    public void actionTest() {

        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainPage = new MainWordpressPage(driver);
        mainPage.loginIcon.click();

        Actions action = new Actions(driver);
        action.moveToElement(
                mainPage.loginIcon,
                5, 5);
        action.clickAndHold();
        action.moveByOffset(5, 5);
        action.release();
        action.build().perform();
    }

    @Test
    public void actionNextTest() {

        driver.get(Configuration.BASE_URL);
        MainWordpressPage mainPage = new MainWordpressPage(driver);
        mainPage.loginIcon.click();
        LoginPage loginPage = new LoginPage(driver);

        // akcje możemy budować wielo-etapowe
        Actions action = new Actions(driver);
        action.moveToElement(loginPage.usernameInput)
                .sendKeys(Configuration.LOGIN)
                .moveToElement(loginPage.usernameButton)
                // jak po . klikniecie "Ctrl + space" to rozwinie wam się lista dostępnych metod z klasy Actions
                .click()
                .build().perform();

        loginPage.waitForElementToBeVisibility(loginPage.inputPassword, 15);
        assertTrue(loginPage.inputPassword.isDisplayed());

    }


    @Test
    public void testBasicRInteraction() {
        Actions do42 = new Actions(driver);
        do42.sendKeys(Keys.chord(Keys.CONTROL, "l"));  //wciśniecie i przytrzymanie klawiszy Ctrl oraz 1
        do42.sendKeys(Keys.ESCAPE);
        do42.sendKeys("41 + 1");
        do42.sendKeys(Keys.ENTER);
        do42.perform();
    }
}