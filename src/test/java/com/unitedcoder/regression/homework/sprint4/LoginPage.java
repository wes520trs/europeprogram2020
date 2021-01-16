package com.unitedcoder.regression.homework.sprint4;

import com.unitedcoder.configutility.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    String confingFile="config.properties";
    TestUtility testUtility;
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
        testUtility=new TestUtility(driver);
    }

    public void typeUsername(String username){
        testUtility.waitForElementPresent(usernameField);
        usernameField.sendKeys(username);
    }

    public void typePassword(String password){
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        testUtility.waitForElementPresent(loginButton);
        loginButton.click();
    }

    public void login(){
        typeUsername(ApplicationConfig.readConfigProperties(confingFile,"username"));
        typePassword(ApplicationConfig.readConfigProperties(confingFile,"password"));
        clickLoginButton();
    }

    public void loginByUsernameAndPassword(String username, String password){
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
    }
}
