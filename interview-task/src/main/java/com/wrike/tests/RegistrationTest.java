package com.wrike.tests;

import org.junit.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {
        app.login(System.currentTimeMillis()+"+wpt@wriketask.qaa");
        app.gotoQnaSection();
        app.checkTwitterLink();
    }

}