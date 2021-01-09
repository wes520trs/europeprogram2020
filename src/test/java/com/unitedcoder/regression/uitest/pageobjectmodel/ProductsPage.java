package com.unitedcoder.regression.uitest.pageobjectmodel;

import com.unitedcoder.configutility.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;
    TestUtility utility;
    String configFile="config.properties";
    @FindBy(linkText = "Add Product")
    WebElement addProductTab;
    @FindBy(xpath = "//img[@rel=\"#product_status\"]")
    WebElement productStatusCheckBox;
    @FindBy(id="name")
    WebElement productNameField;
    @FindBy(xpath = "//input[@value=\"Save\"]")
    WebElement saveButton;
    @FindBy(xpath = "//div[@class=\"success\"]")
    WebElement successfulMessage;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    public boolean addProduct(){
        utility.waitForElementPresent(addProductTab);
        addProductTab.click();
        utility.waitForElementPresent(productStatusCheckBox);
        productStatusCheckBox.click();
        utility.waitForElementPresent(productNameField);
        productNameField.sendKeys(ApplicationConfig.readConfigProperties(configFile,"productName"));
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        utility.waitForElementPresent(successfulMessage);
        return successfulMessage.isDisplayed();
    }

}
