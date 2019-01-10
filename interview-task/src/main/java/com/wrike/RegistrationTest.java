package com.wrike;

import org.junit.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {
        login("abcdef+wpt@wriketask.qaa");
        gotoQnaSection();
        checkTwitterLink();
    }

}