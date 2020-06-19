package com.credify;

import com.credify.base.TestUtilities;
import com.credify.pages.LoginPage;
import com.credify.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class NegativeTests  extends TestUtilities {

    @Test
    public void validate_error_with_invalid_loan_amount(){
        log.info("Starting the Test");

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Enter loan amount as 2,000
        welcomePage.typeAmount("500");

        // select any purpose randomly
        Random rn = new Random();
        welcomePage.selectPurpose(rn.nextInt(6) + 1);

        // Click "Check your Rate"
        welcomePage.clickCheckRate();
        Assert.assertEquals(welcomePage.getErrorMessage(), "Please enter loan amount between $1,000 and $35,000.");
        log.info("Verified error is thrown if amount less than 1000 is entered is entered");
    }

    @Test
    public void validate_error_with_invalid_credentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.openPage();

        loginPage.enterEmail("seti@gmail.com");
        loginPage.enterPassword("password");
        loginPage.clickSignIn();
        loginPage.waitForErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(), "We're sorry, the credentials you've provided are incorrect. Please try again");
        log.info("Verified error is thrown with invalid user credentials");
    }

    @Test
    public void validate_error_with_invalid_email() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.openPage();

        loginPage.enterEmail("seti");
        loginPage.enterPassword("password");
        loginPage.clickSignIn();


        Assert.assertEquals(loginPage.getInvalidEmailMessage(), "Please include an '@' in the email address. 'seti' is missing an '@'.");
        log.info("Verified error is thrown with invalid user credentials");
    }


}
