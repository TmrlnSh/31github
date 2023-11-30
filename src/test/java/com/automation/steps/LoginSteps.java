package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user open the website")
    public void user_open_the_website() {
        loginPage.openWebsite();
    }

    @When("user enter the username {string} and password {string}")
    public void user_enter_the_username_and_password(String usernameKey, String passwordKey) {
        loginPage.doLogin(ConfigReader.getProperty(usernameKey), ConfigReader.getProperty(passwordKey));
    }


}
