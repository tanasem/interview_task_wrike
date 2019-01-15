package com.wrike.tests;

import com.wrike.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.fail;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() throws Exception {
        app.init();
    }

    @After
    public void tearDown() throws Exception {
        app.stop();
        String verificationErrorString = app.verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public ApplicationManager getApp() {
        return app;
    }
}
