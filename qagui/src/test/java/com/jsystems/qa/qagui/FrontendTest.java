package com.jsystems.qa.qagui;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.common.truth.Truth.assertThat;



public class FrontendTest extends ConfigFrontend {


    @Test
    public void frontTest() {

        driver.get("https://www.wordpress.com/");

        WebElement loginIcon = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(loginIcon));

        loginIcon.click();

        String usernameOrEmailSelector = "usernameOrEmail";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameOrEmailSelector)));

        WebElement usernameInput = driver.findElement(By.id(usernameOrEmailSelector));

        usernameInput.clear();
        usernameInput.sendKeys("lukaszrybka1983@gmail.com");

        String primaryButtonSelector = ".button.form-button.is-primary";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        WebElement usernameButton = driver.findElement(By.cssSelector(primaryButtonSelector));
        usernameButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        WebElement inputPassword = driver.findElement(By.id("password"));

        inputPassword.clear();
        inputPassword.sendKeys("7ujmKO)(");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        WebElement buttonPassword = driver.findElement(By.cssSelector(primaryButtonSelector));
        usernameButton.click();

        String userAvatarSelector = ".masterbar__item.masterbar__item-me";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(userAvatarSelector)));

        WebElement userAvatar = driver.findElement(By.cssSelector(userAvatarSelector));
        userAvatar.click();

        String userDisplayNameSelector = ".profile-gravatar__user-display-name";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userDisplayNameSelector)));

        WebElement userDisplayName = driver.findElement(By.cssSelector(userDisplayNameSelector));
        String userDisplayNameText = userDisplayName.getText();

        assertThat(userDisplayNameText).isEqualTo("lrybka");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(primaryButtonSelector)));
        WebElement saveUserDetailsButton = driver.findElement(By.cssSelector(primaryButtonSelector));
        assertThat(!saveUserDetailsButton.isDisplayed());
    }
}

