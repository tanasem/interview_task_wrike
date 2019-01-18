package com.wrike.appmanager;

import com.wrike.pages.MainPage;
import com.wrike.pages.QNAEmailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    private MainPage mainPage;
    private QNAEmailPage qnaEmailPage;

    public StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
        qnaEmailPage = new QNAEmailPage(driver);

    }

    public MainPage mainPage() {
        return mainPage;
    }

    public QNAEmailPage qnaEmailPage() {
        return qnaEmailPage;
    }

    public void goToMainPage() {
        driver.get("https://www.wrike.com/");
    }

    public void quit() {
        driver.quit();
    }
}
