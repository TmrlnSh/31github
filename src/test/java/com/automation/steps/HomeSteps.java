package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("verify user is navigated to homepage")
    public void verify_user_is_navigated_to_homepage() {
        homePage.verifyHomePage();
    }

    @When("user click on checking tab")
    public void userClickOnCheckingTab() {
        homePage.clickOnCheckingTab();
    }

    @And("click on New Checking button")
    public void clickOnNewCheckingButton() {
        homePage.clickOnNewCheckingBtn();
    }
}
