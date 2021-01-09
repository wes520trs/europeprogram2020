package com.unitedcoder.regression.uitest.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(linkText = "Products")
    WebElement productsLink;
    @FindBy(linkText = "Categories")
    WebElement categoriesLink;
    @FindBy(css="i.fa.fa-sign-out")
    WebElement logoutButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    public boolean verifyLogin(){
        utility.waitForElementPresent(logoutButton);
        return logoutButton.isDisplayed();
    }
    public void clickOnCustomersLink(){
        utility.waitForElementPresent(customerListLink);
        customerListLink.click();
    }
    public void clickOnProductsLink(){
        utility.waitForElementPresent(productsLink);
        productsLink.click();
    }
    public void clickOnCategoryLink(){
        utility.waitForElementPresent(categoriesLink);
        categoriesLink.click();
    }
    public void logout(){
        utility.waitForElementPresent(logoutButton);
        logoutButton.click();
    }
}
