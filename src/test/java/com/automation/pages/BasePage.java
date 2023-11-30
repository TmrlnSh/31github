package com.automation.pages;

import com.automation.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public abstract class BasePage {
    WebDriver driver;

    BasePage() {
        driver = DriverUtils.getDriver();
        PageFactory.initElements(driver, this);
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100000);
    }

}
