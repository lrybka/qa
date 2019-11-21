package com.jsystems.qa.qagui;

import com.jsystems.qa.qagui.page.LoginPage;
import com.jsystems.qa.qagui.page.MainWordpressPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

@Tag("FrontTest")
public class ActionTest extends ConfigFrontend{

    MainWordpressPage mainPage;

    @Test
    public void actionTest() {

        driver.get(Configuration.BASE_URL);
        mainPage = new MainWordpressPage(driver);
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

//    @Test
//    public void actionNextTest() {
//
//        driver.get(baseUrl);
//        mainPage = new MainPage(driver);
//        mainPage.logIn.click();
//        loginPage = new LoginPage(driver);
//
//        // akcje możemy budować wielo-etapowe
//        Actions action = new Actions(driver);
//        action.moveToElement(loginPage.usernameInput)
//                .sendKeys(TestDataStatic.login)
//                .moveToElement(loginPage.buttonContinue)
//                // jak po . klikniecie Ctrl + space to rozwinie wam się lista dostępnych metod z klasy Actions
//                .click()
//                .build().perform();
//
//        passwordPage = new PasswordPage(driver);
//        passwordPage.waitForVisibilityOfElement(passwordPage.passwordInput, 15);
//        passwordPage.isContentPresent();
//    }
//
//
//    @Test
//    public void testBasicRInteraction() {
//        Actions do42 = new Actions(driver);
//        do42.sendKeys(Keys.chord(Keys.CONTROL, "l"));
//        do42.sendKeys(Keys.ESCAPE);
//        do42.sendKeys("41 + 1");
//        do42.sendKeys(Keys.ENTER);
//        do42.perform();
//    }
}
