package com.wrike.appmanager;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.wrike.com/");
    }

    public void login(String email) {
        driver.findElement(By.xpath("//div[@class='r']//em[contains(text(),'for free')]")).click();
        driver.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[1]/input")).sendKeys(email);
        driver.findElement(By.xpath("//button[contains(text(),'Create my Wrike account')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("[id ^= I0_]"))));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.wrike.com/resend/", currentUrl);

    }

    public void gotoQnaSection() {
        driver.switchTo().frame(1);
        driver.findElement(By.xpath(".//span[text()='YES']")).click();
        driver.switchTo().defaultContent();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("[id ^= I0_]"), 0));

        driver.findElement(By.xpath("//form/div[1]/label[1]/button")).click();
        driver.findElement(By.xpath("//form/div[2]/label[1]/button")).click();
        driver.findElement(By.xpath("//form/div[3]/label[1]/button")).click();
        driver.findElement(By.xpath("//form[@name='survey-form']//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("[class ^= survey-success]"))));
        Assert.assertFalse(driver.findElement(By.xpath("//form[@name='survey-form']//button[@type='submit']")).isDisplayed());

    }

    public void ResendEmail() {
       driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(".//span[text()='again.']"))));

        Assert.assertTrue(driver.findElement(By.xpath(".//span[text()='again.']")).isDisplayed());
    }

    public void checkTwitterLink() {
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='https://twitter.com/wrike']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(".//*[name()='svg'][id='twitter')]")).isDisplayed());

    }


    public void stop() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
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

}
