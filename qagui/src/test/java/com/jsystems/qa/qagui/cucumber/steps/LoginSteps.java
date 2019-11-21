package com.jsystems.qa.qagui.cucumber.steps;

import com.jsystems.qa.qagui.Configuration;
import com.jsystems.qa.qagui.classic.page.LoginPage;
import com.jsystems.qa.qagui.classic.page.MainWordpressPage;
import com.jsystems.qa.qagui.classic.page.UserPage;
import com.jsystems.qa.qagui.cucumber.ConfigStepCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.google.common.truth.Truth.assertThat;
import static com.jsystems.qa.qagui.classic.page.LoginPage.*;
import static com.jsystems.qa.qagui.classic.page.MainWordpressPage.loginIconSelector;
import static com.jsystems.qa.qagui.classic.page.UserPage.userAvatarSelector;
import static com.jsystems.qa.qagui.classic.page.UserPage.userDisplayNameSelector;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(ConfigStepCucumber configStepCucumber){
        driver = configStepCucumber.setUp();
    }

    MainWordpressPage mainWordpressPage;
    LoginPage loginPage;
    UserPage userPage;

    @Given("^User starts on main page$")     //    ^ (musi zaczynac sie od tego)    $ (musi konczyc sie na tym)
    public void userStartsOnMainPage(){
        driver.navigate().to(Configuration.BASE_URL);
        mainWordpressPage = new MainWordpressPage(driver);
    }

    @When("^User logs to the user panel$")
    public void userLogsToTheUserPanel() {
        mainWordpressPage.waitForElementToBeVisibility(By.cssSelector(loginIconSelector));
        mainWordpressPage.waitForElementToBeClickable(mainWordpressPage.loginIcon);
        mainWordpressPage.loginIcon.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForElementToBeVisibility(By.id(usernameOrEmailSelector));
        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(Configuration.LOGIN);
        loginPage.waitForElementToBeClickable(By.cssSelector(primaryButtonSelector));
        loginPage.usernameButton.click();
        loginPage.waitForElementToBeClickable(By.id(passwordInputSelector));
        loginPage.inputPassword.clear();
        loginPage.inputPassword.sendKeys(Configuration.PASSWORD);
        loginPage.waitForElementToBeClickable(By.cssSelector(primaryButtonSelector));
        loginPage.usernameButton.click();
        UserPage userPage = new UserPage(driver);
    }

    @Then("^User can modify user profile$")
    public void userCanModifyUserProfile() {
        userPage.waitForElementToBeClickable(By.cssSelector(userAvatarSelector));
        userPage.userAvatar.click();
        userPage.waitForElementToBeClickable(By.cssSelector(userDisplayNameSelector));
        String userDisplayNameText = userPage.userDisplayName.getText();
        assertThat(userDisplayNameText).isEqualTo("lrybka");
        userPage.waitForElementToBeVisibility(By.cssSelector(UserPage.primaryButtonSelector));
        assertTrue(userPage.saveUserDetailsButton.isDisplayed());
        assertFalse(userPage.saveUserDetailsButton.isEnabled());
    }
}
