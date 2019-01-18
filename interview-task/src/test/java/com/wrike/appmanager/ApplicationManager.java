package com.wrike.appmanager;

import com.wrike.pages.MainPage;
import com.wrike.pages.SurveyPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public StringBuffer verificationErrors = new StringBuffer();
    private WebDriver driver;
    private MainPage mainPage;
    private SurveyPage surveyPage;

    public ApplicationManager() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
        surveyPage = new SurveyPage(driver);

    }

    public MainPage mainPage() {
        return mainPage;
    }

    public SurveyPage qnaEmailPage() {
        return surveyPage;
    }

    public void goToMainPage() {
        driver.get("https://www.wrike.com/");
    }

    public void quit() {
        driver.quit();
    }
}
