package com.unitedcoder.regression.uitest.pageobjectmodel;

import com.unitedcoder.configutility.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    String configFile="config.properties";
    TestUtility utility;
    WebDriver driver;
    @FindBy(id="username")
    WebElement usernameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="login")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    public void enterUsername(String username){
        utility.waitForElementPresent(usernameField);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        utility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        utility.waitForElementPresent(loginButton);
        loginButton.click();
    }

    public void login(){
        enterUsername(ApplicationConfig.readConfigProperties(configFile,"username"));
        enterPassword(ApplicationConfig.readConfigProperties(configFile,"password"));
        clickLoginButton();
    }

    public void loginUser(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}
