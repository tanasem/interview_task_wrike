package com.wrike.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;
    public StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("https://www.wrike.com/");
    }

    public void gotoQnaSection() {
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Help us provide you the best possible experience:'])[1]/following::button[1]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Just looking'])[1]/following::button[1]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Just looking'])[1]/following::button[6]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Other'])[1]/following::button[1]")).click();
    }

    public void login(String email) {
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[2]/following::button[1]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[4]/following::input[1]")).clear();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[4]/following::input[1]")).sendKeys(email);
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[4]/following::button[1]")).click();
    }

    public void stop() {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void checkTwitterLink() {
//        wd.findElement(By.cssSelector("svg.wg-footer__social-icon > use")).click();
    }
}
