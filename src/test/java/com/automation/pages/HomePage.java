package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
    WebElement userIcon;

    @FindBy(id = "checking-menu")
    WebElement checkingTab;

    @FindBy(id = "new-checking-menu-item")
    WebElement newCheckingTab;

    public void verifyHomePage() {
        Assert.assertTrue(userIcon.isDisplayed());
    }

    public void clickOnCheckingTab() {
        checkingTab.click();
    }

    public void clickOnNewCheckingBtn() {
        newCheckingTab.click();
    }
}

