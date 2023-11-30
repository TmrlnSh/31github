package com.automation.steps;

import com.automation.pages.ViewCheckingAccountPage;
import io.cucumber.java.en.Then;

public class ViewCheckingAccountSteps {

    ViewCheckingAccountPage viewCheckingAccountPage = new ViewCheckingAccountPage();

    @Then("verify view checking account page is displayed")
    public void verify_view_checking_account_page_is_displayed() {
        viewCheckingAccountPage.verifycheckingAccountPageisDisplayed();
    }

    @Then("verify account creation success message is displayed")
    public void verify_account_creation_success_message_is_displayed() {
        viewCheckingAccountPage.successMessage();
    }
}
