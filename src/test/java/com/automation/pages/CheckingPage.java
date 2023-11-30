package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckingPage extends BasePage {

    @FindBy(id = "Standard Checking")
    WebElement checkingtype;

    @FindBy(id = "Individual")
    WebElement accountownership;

    @FindBy(id = "name")
    WebElement accountNameInput;

    @FindBy(id = "openingBalance")
    WebElement amountInput;

    @FindBy(id = "newCheckingSubmit")
    WebElement submitbtn;

    @FindBy(id = "page-title")
    WebElement checkingpage;

    public void verifyCheckingPage() {
        Assert.assertTrue(accountNameInput.isDisplayed());
    }

    public void checkingDetails() {
        checkingtype.click();
        accountownership.click();
        ConfigReader.setProperty("account.type", "Checking");
        ConfigReader.setProperty("account.ownership", "Individual");

        String accountName = "TestAccount" + getRandomNumber();
        accountNameInput.sendKeys(accountName);
        ConfigReader.setProperty("account.name", accountName);

        int amount = getRandomNumber();
        amountInput.sendKeys(amount + "");
        ConfigReader.setProperty("transaction.amount", amount + "");
    }

    public void clickSubmitbtn() {
        submitbtn.click();
    }


}
