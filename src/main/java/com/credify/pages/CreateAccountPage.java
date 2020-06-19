package com.credify.pages;

import com.credify.base.TestUtilities;
import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePageObject {
    private By emailElement = By.name("username");
    private By passwordElement = By.name("password");
    private By checkBox=By.className("sc-fzqKxP");
    private By checkRateBtn= By.xpath("//button[@type='submit']");


    public CreateAccountPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void enterEmail(String email) {
        log.info("Entering Email");
        type(email, emailElement);
    }

    public void enterPassword(String pwd) {
        log.info("Entering Password");
        type(pwd, passwordElement);
    }

    public void clickCheckBox(){
            click(checkBox);
    }

    public OfferPage clickCheckRateBtn(){
        click(checkRateBtn);
        return new OfferPage(driver,log);
    }


}
