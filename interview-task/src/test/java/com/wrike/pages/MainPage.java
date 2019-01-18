package com.wrike.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Page {

    //locators
    private static final By GET_STARTED_FOR_FREE_BUTTON_LOCATOR = By.xpath("//div[@class='r']//em[contains(text(),'for free')]");
    private static final By INPUT_EMAIL_FIELD_LOCATOR = By.xpath("//label[@class='modal-form-trial__label']//input[@placeholder='Enter your business email']");
    private static final By CREATE_ACCOUNT_BUTTON_LOCATOR = By.xpath("//button[contains(text(),'Create my Wrike account')]");
    private static final By GOOGLE_IFRAME_LOCATOR = By.cssSelector("[id ^= I0_]");
    private static final String SURVEY_PAGE_URL = "https://www.wrike.com/resend/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void getStarted() {
        seleniumHelper.click(GET_STARTED_FOR_FREE_BUTTON_LOCATOR);
    }

    @Step
    public void inputEmail(String email) {
        seleniumHelper.type(INPUT_EMAIL_FIELD_LOCATOR, email);
    }

    @Step
    public void createAccount() {
        seleniumHelper.click(CREATE_ACCOUNT_BUTTON_LOCATOR);
    }

    @Step
    public void checkUserIsOnSurveyPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GOOGLE_IFRAME_LOCATOR));
        Assert.assertEquals(SURVEY_PAGE_URL, seleniumHelper.currentUrl());
    }

}
