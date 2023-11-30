package com.automation.steps;

import com.automation.pages.SavingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SavingsSteps {
SavingPage savingPage=new SavingPage();
    @When("user click on savings tab")
    public void user_click_on_savings_tab() {
       savingPage.clickOnSavingsbtn();
        
    }

    @When("click on New Savings button")
    public void click_on_new_savings_button() {
        savingPage.clickOnNewSavingsBtn();
    }

    @Then("verify new savings account page is displayed")
    public void verify_new_savings_account_page_is_displayed() {
       savingPage.verifySavingsPageIsDisplayed();
    }

    @When("user enters new savings account details")
    public void user_enters_new_savings_account_details() {
       savingPage.userEnterSavingsDetails();
    }

    @When("click on Submit button")
    public void click_on_submit_button() {
       savingPage.clickOnSubmit();
    }

    @Then("verify view savings account page is displayed")
    public void verify_view_savingsaccount_page_is_displayed() {
       savingPage.verifySavingAccountisDisplayed();
    }

}
