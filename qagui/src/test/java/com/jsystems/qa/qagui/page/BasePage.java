package com.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    private WebDriverWait wait  = new WebDriverWait(driver, 30);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeClicable(By by, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElementToBeClicable(By by) {
        waitForElementToBeClicable(by, 30);
    }
    public void waitForElementToBeVisibility(By by, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElementToBeVisibility(By by) {
        waitForElementToBeVisibility(by, 30);
    }

}
