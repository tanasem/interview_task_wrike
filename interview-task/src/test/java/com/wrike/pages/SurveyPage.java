package com.wrike.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SurveyPage extends Page {

    //locators
    private static final By CLOSE_GOOGLE_IFRAME_BUTTON_LOCATOR = By.xpath(".//span[text()='YES']");
    private static final By GOOGLE_IFRAME_LOCATOR = By.cssSelector("[id ^= I0_]");
    private static final By ANSWER_FIRST_QUESTION_LOCATOR = By.xpath("//form/div[1]/label[1]/button");
    private static final By ANSWER_SECOND_QUESTION_LOCATOR = By.xpath("//form/div[2]/label[1]/button");
    private static final By ANSWER_THIRD_QUESTION_LOCATOR = By.xpath("//form/div[3]/label[1]/button");
    private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//form[@name='survey-form']//button[@type='submit']");
    private static final By SURVEY_SUCESS_FORM_LOCATOR = By.cssSelector("[class ^= survey-success]");
    private static final By RESEND_EMAIL_BUTTON_LOCATOR = By.xpath("//button[contains(@class, 'hollow button')]");
    private static final By RESEND_EMAIL_FLAG_LOCATOR = By.xpath(".//span[text()='again.']");
    private static final By TWITTER_BUTTON_LOCATOR = By.xpath("//ul[@class='wg-footer__social-list']//a[@href='https://twitter.com/wrike']//*[local-name()='svg']/*[local-name()='use' and contains (@*, 'twitter')]");

    public SurveyPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void closeGoogleIframe() {
        driver.switchTo().frame(1);
        seleniumHelper.click(CLOSE_GOOGLE_IFRAME_BUTTON_LOCATOR);

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.numberOfElementsToBe(GOOGLE_IFRAME_LOCATOR, 0));
    }

    @Step
    public void fillQNASection() {
        seleniumHelper.click(ANSWER_FIRST_QUESTION_LOCATOR);
        seleniumHelper.click(ANSWER_SECOND_QUESTION_LOCATOR);
        seleniumHelper.click(ANSWER_THIRD_QUESTION_LOCATOR);
        seleniumHelper.click(SUBMIT_BUTTON_LOCATOR);
    }

    @Step
    public void checkAnswersAreSubmitted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SURVEY_SUCESS_FORM_LOCATOR));
        Assert.assertFalse(driver.findElement(SUBMIT_BUTTON_LOCATOR).isDisplayed());
    }

    @Step
    public void resendEmail() {
        seleniumHelper.click(RESEND_EMAIL_BUTTON_LOCATOR);
    }

    @Step
    public void checkResendEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RESEND_EMAIL_FLAG_LOCATOR));
        Assert.assertTrue(driver.findElement(RESEND_EMAIL_FLAG_LOCATOR).isDisplayed());
    }

    @Step
    public void checkTwitterButton() {
        Assert.assertTrue(driver.findElement(TWITTER_BUTTON_LOCATOR).isDisplayed());
    }

}
