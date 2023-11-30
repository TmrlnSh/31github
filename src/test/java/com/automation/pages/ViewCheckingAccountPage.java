package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCheckingAccountPage extends BasePage {

    @FindBy(id = "new-account-msg")
    WebElement confirmationMessage;

    @FindBy(xpath = "//div[@id='firstRow']/div[last()]//small[contains(text(),'Account Number:')]")
    WebElement accountNumberValue;

    public void verifycheckingAccountPageisDisplayed() {
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    public void successMessage() {
        Assert.assertTrue(confirmationMessage.isDisplayed());
        ConfigReader.setProperty("account.number", accountNumberValue.getText().replaceAll("[^0-9]",""));
    }


}
