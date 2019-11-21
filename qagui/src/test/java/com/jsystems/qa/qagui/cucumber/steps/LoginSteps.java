package com.jsystems.qa.qagui.cucumber.steps;

import com.jsystems.qa.qagui.cucumber.ConfigStepCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(ConfigStepCucumber configStepCucumber){
        driver = configStepCucumber.setUp();
    }

    @Given("^User starts on main page$")
    public void userStartsOnMainPage(){

    }

    @When("User logs to the user panel")
    public void userLogsToTheUserPanel() {
    }

    @Then("User can modify user profile")
    public void userCanModifyUserProfile() {
    }
}
