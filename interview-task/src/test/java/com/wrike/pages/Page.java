package com.wrike.pages;

import com.wrike.appmanager.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SeleniumHelper seleniumHelper;

    public Page(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        seleniumHelper = new SeleniumHelper(driver);
    }

}
