package com.automation.pages;


import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    WebElement usernameElement;

    @FindBy(id = "password")
    WebElement passwordElement;

    @FindBy(id = "submit")
    WebElement submitBtn;

    public void openWebsite() {
        driver.get(ConfigReader.getProperty("application.url"));
    }

    public void doLogin(String username, String password) {
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        submitBtn.click();
    }
}
