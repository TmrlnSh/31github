package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends BasePage {
 @FindBy(id="deposit-menu-item")
    WebElement depositTab;

  @FindBy(xpath = "//div[@class='page-title']")
  WebElement depositPage1;


  @FindBy(id="selectedAccount")
  WebElement selectdropdown;


 @FindBy(xpath = "//option[text()='RM (Savings)']")
 WebElement dropdownChoice;

  @FindBy(id = "amount")
  WebElement depamount;

  @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
  WebElement submit;

  @FindBy(id="page-title")
  WebElement viewcheck;

  @FindBy(xpath = "//tr[@class='odd']/td")
      List <WebElement> history;


    public void clickOnDepositTab() {
      depositTab.click();
    }

    public void verifyDepositAccountPageIsDisplayed() {
        Assert.assertTrue(depositPage1.isDisplayed());
    }

    public void selectAccountFromDropdown() {
       selectdropdown.click();
       dropdownChoice.click();


    }

    public void depositAmount() {
        depamount.sendKeys("1500");
    }

    public void clickOnSubmit() {
        submit.click();
    }

    public void verifyViewCheckingAndSavingsIsDisplayed() {
        Assert.assertTrue(viewcheck.isDisplayed());
    }

    public void transactionHistory() {
       for(int i=0;i<history.size();i++){
           Assert.assertTrue(history.size()>1);
       }
    }
}
