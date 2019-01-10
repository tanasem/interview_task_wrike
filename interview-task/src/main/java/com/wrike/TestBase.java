package com.wrike;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
    protected WebDriver wd;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        init();
    }

    private void init() {
        wd = new FirefoxDriver();
        baseUrl = "https://www.wrike.com/";
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("https://www.wrike.com/");
    }

    protected void gotoQnaSection() {
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Help us provide you the best possible experience:'])[1]/following::button[1]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Just looking'])[1]/following::button[1]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Just looking'])[1]/following::button[6]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No'])[1]/following::button[1]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Just looking'])[1]/following::button[6]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Other'])[1]/following::button[1]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='contact us'])[2]/following::button[1]")).click();
    }

    protected void login(String email) {
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[2]/following::button[1]")).click();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[4]/following::input[1]")).clear();
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[4]/following::input[1]")).sendKeys(email);
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[4]/following::button[1]")).click();
    }

    @After
    public void tearDown() throws Exception {
        wd.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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

    protected void checkTwitterLink() {
        wd.findElement(By.cssSelector("svg.wg-footer__social-icon > use")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        wd.close();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
    }
}
