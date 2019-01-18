package com.wrike.tests;

import com.wrike.appmanager.ApplicationManager;
import org.junit.After;

import static org.junit.Assert.fail;


public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @After
    public void tearDown() {
        app.quit();
        String verificationErrorString = app.verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
