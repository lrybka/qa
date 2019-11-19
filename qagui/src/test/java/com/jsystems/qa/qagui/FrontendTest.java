package com.jsystems.qa.qagui;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;


public class FrontendTest extends ConfigFrontend {


    @Test
    public void frontTest() {

        driver.get("https://www.wordpress.com/");
        WebElement textElement_1 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(1)"));
        String text1 = textElement_1.getText();
        assertTrue(text1.equals("WordPress powers"));

        WebElement textElement_2 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(2)"));
        String text2 = textElement_2.getText();
        assertTrue(text2.contains("% of the internet."));
        assertThat(text2).matches("\\d+(% of the internet.)");


        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() {
        driver.get("https://www.wordpress.com/");

        //WebElement login = driver.findElement(By.cssSelector(".x-menu-grid.x-menu-grid--logged-out a[title=\"Log In\"]"));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"lpc-header-nav\"]/div/div/div[1]/header/nav/ul[2]/li[1]/a"));
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(login.isDisplayed());
        login.click();
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        WebElement login2 = driver.findElement(By.id("usernameOrEmail"));
        WebElement button = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div[1]/div/form/div[1]/div[2]/button"));

        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login2.sendKeys("lukaszrybka1983@gmail.com");
        button.click();
    }
}

