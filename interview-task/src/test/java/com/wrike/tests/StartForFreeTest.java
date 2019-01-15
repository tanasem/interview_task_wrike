package com.wrike.tests;

import org.junit.Test;

public class StartForFreeTest extends TestBase {

    @Test
    public void testCase() throws Exception {
        app.login(System.currentTimeMillis() + "+wpt@wriketask.qaa");
        app.gotoQnaSection();
        app.ResendEmail();
        app.checkTwitterLink();
    }

}