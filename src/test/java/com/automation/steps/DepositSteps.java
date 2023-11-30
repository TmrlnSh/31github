package com.automation.steps;

import com.automation.pages.DepositPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DepositSteps {
    DepositPage depositPage=new DepositPage();
    @When("user click on Deposit tab")
    public void user_click_on_deposit_tab() {
        depositPage.clickOnDepositTab();
        
    }

    @Then("verify deposit into account page is displayed")
    public void verify_deposit_into_account_page_is_displayed() {
        depositPage.verifyDepositAccountPageIsDisplayed();
        
    }

    @When("user select account from the dropdown")
    public void user_select_account_from_the_dropdown() {
        depositPage.selectAccountFromDropdown();
        
    }

    @When("enter the deposit amount")
    public void enter_the_deposit_amount() {
        depositPage.depositAmount();
        
    }

    @When("click on submit Button")
    public void click_on_submit_button() {
        depositPage.clickOnSubmit();
        
    }



    @Then("verify deposit entry is displayed in the transaction history")
    public void verify_deposit_entry_is_displayed_in_the_transaction_history() {
        depositPage.transactionHistory();
    }


    @Then("verify view checking and savings account page is displayed")
    public void verifyViewCheckingAndSavingsAccountPageIsDisplayed() {
        depositPage.verifyViewCheckingAndSavingsIsDisplayed();
    }
}
