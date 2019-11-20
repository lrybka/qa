package com.jsystems.qa.qagui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public static final String usernameOrEmailSelector = "usernameOrEmail";
    @FindBy(id = usernameOrEmailSelector)
    public WebElement usernameInput;

    public static final String primaryButtonSelector = ".button.form-button.is-primary";
    @FindBy(css = primaryButtonSelector)
    public  WebElement usernameButton;

}
