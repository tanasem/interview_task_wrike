package com.wrike.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QNAEmailPage extends Page {

    private static final By CLOSE_GOOGLE_IFRAME_BUTTON_LOCATOR = By.xpath(".//span[text()='YES']");
    private static final By GOOGLE_IFRAME_LOCATOR = By.cssSelector("[id ^= I0_]");
//    private static final By GET_STARTED_FOR_FREE_BUTTON_LOCATOR = By.xpath("//div[@class='r']//em[contains(text(),'for free')]");
//    private static final By GET_STARTED_FOR_FREE_BUTTON_LOCATOR = By.xpath("//div[@class='r']//em[contains(text(),'for free')]");


    public QNAEmailPage(WebDriver driver) {
        super(driver);
    }

    public void closeGoogleIframe() {
        driver.switchTo().frame(1);
        seleniumHelper.click(CLOSE_GOOGLE_IFRAME_BUTTON_LOCATOR);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.numberOfElementsToBe(GOOGLE_IFRAME_LOCATOR, 0));
    }

    public void fillQNASection() {
        seleniumHelper.click(By.xpath("//form/div[1]/label[1]/button"));
        seleniumHelper.click(By.xpath("//form/div[2]/label[1]/button"));
        seleniumHelper.click(By.xpath("//form/div[3]/label[1]/button"));
        seleniumHelper.click(By.xpath("//form[@name='survey-form']//button[@type='submit']"));
    }

    public void checkAnswersAreSubmitted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("[class ^= survey-success]"))));
        Assert.assertFalse(driver.findElement(By.xpath("//form[@name='survey-form']//button[@type='submit']")).isDisplayed());
    }

    public void resendEmail() {
        seleniumHelper.click(By.xpath("//button[contains(@class, 'hollow button')]"));
    }

    public void checkResendEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(".//span[text()='again.']"))));
        Assert.assertTrue(driver.findElement(By.xpath(".//span[text()='again.']")).isDisplayed());
    }

    public void checkTwitterLink() {
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='wg-footer__social-list']//a[@href='https://twitter.com/wrike']//*[local-name()='svg']/*[local-name()='use' and contains (@*, 'twitter')]")).isDisplayed());
    }

}
