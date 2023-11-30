package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavingPage extends BasePage{
    @FindBy(id = "savings-menu")
    WebElement savings;

    @FindBy(id="new-savings-menu-item")
    WebElement newSavings;

    @FindBy(xpath = "//strong[@class='card-title text-white']")
    WebElement savingsAccounttitle;

    @FindBy(id = "Savings")
    WebElement SavingType;
    @FindBy(id = "Individual")
    WebElement ownership;

    @FindBy(id = "name")
    WebElement accountName;

    @FindBy(id="openingBalance")
    WebElement initialdeposit;

    @FindBy(id = "newSavingsSubmit")
    WebElement newsavingsubmit;

    @FindBy(id = "transactionTable_length")
    WebElement savingAccount;

    @FindBy(id="new-account-msg")
    WebElement confirmationmsg;

    public void clickOnSavingsbtn() {
savings.click();
    }

    public void clickOnNewSavingsBtn() {
  newSavings.click();
    }

    public void verifySavingsPageIsDisplayed() {
        Assert.assertTrue(savingsAccounttitle.isDisplayed());
    }

    public void userEnterSavingsDetails() {
    SavingType.click();
    ownership.click();
    accountName.sendKeys("RM");
    initialdeposit.sendKeys("2000");


    }

    public void clickOnSubmit() {
        newsavingsubmit.click();
    }

    public void verifySavingAccountisDisplayed() {
        Assert.assertTrue(savingAccount.isDisplayed());
    }

    public void successMsg() {
    Assert.assertTrue(confirmationmsg.isDisplayed());
    }
}
