package com.wrike.tests;

import org.junit.Test;

/*
1) Open url: wrike.com;
2) Click "Get started for free" button near "Login" button;
3) Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
4) Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;
5) Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted;
6) Click on "Resend email" + check it with assertion;
7)   Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url and has the correct icon.
(you may close all needless tooltips on your way)
*/


public class GetStartedForFreeTest extends TestBase {

    @Test
    public void testCase() {

        //Step 1
        app.goToMainPage();

        //Step 2
        app.mainPage().getStarted();

        //Step 3
        app.mainPage().inputEmail(System.currentTimeMillis() + "+wpt@wriketask.qaa");

        //Step 4

        app.mainPage().createAccount();
        app.mainPage().checkUserIsOnSurveyPage();

        //Step 5
        app.qnaEmailPage().closeGoogleIframe();
        app.qnaEmailPage().fillQNASection();
        app.qnaEmailPage().checkAnswersAreSubmitted();

        //Step 6
        app.qnaEmailPage().resendEmail();
        app.qnaEmailPage().checkResendEmail();

        //Step 7
        app.qnaEmailPage().checkTwitterButton();
    }

}