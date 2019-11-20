package com.jsystems.qa.qagui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage {
    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String userAvatarSelector = ".masterbar__item.masterbar__item-me";
    @FindBy(css = userAvatarSelector)
    public WebElement userAvatar;
//    public WebElement userAvatar = driver.findElement(By.cssSelector(userAvatarSelector));

    public static final String userDisplayNameSelector = ".profile-gravatar__user-display-name";
    @FindBy(css = userDisplayNameSelector)
    public WebElement userDisplayName;
//    public WebElement userDisplayName = driver.findElement(By.cssSelector(userDisplayNameSelector));

    public static final String primaryButtonSelector = ".button.form-button.is-primary";
    @FindBy(css = primaryButtonSelector)
    public WebElement saveUserDetailsButton;
//    WebElement saveUserDetailsButton = driver.findElement(By.cssSelector(primaryButtonSelector));
}