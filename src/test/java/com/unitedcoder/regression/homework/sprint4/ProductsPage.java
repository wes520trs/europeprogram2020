package com.unitedcoder.regression.homework.sprint4;

import com.unitedcoder.configutility.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    String configFile="config.properties";
    WebDriver driver;
    TestUtility testUtility;
    private String myKeyWord="TRS";

    @FindBy(linkText = "Products")
    WebElement productsPage;
    @FindBy(linkText = "Add Product")
    WebElement addProductTab;
    @FindBy(id="name")
    WebElement productNameField;
    @FindBy(xpath="//*[contains(@rel,\"code_auto\")]")
    WebElement autoProductCode;
    @FindBy(xpath = "//*[@id=\"tab_category\"]/a")
    WebElement categoriesTab;
    @FindBy(xpath = "//tbody/tr[td//text()[contains(.,'TRS')]]//descendant::input") //key word is "TRS"
    WebElement myCategory;
    @FindBy(xpath = "//input[@value=\"Save\"]")
    WebElement saveButton;
    @FindBy(xpath = "//div[@class=\"success\"]")
    WebElement successfulMessage;
    @FindBy(xpath = "//*[td//text()[contains(.,'book')]]//i[@class='fa fa-trash']")
    WebElement deleteIcon;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void addProducts(int numberOfProduct){
        testUtility.waitForElementPresent(productsPage);
        productsPage.click();
        for (int i=1; i<=numberOfProduct; i++) {
            testUtility.waitForElementPresent(addProductTab);
            addProductTab.click();
            testUtility.waitForElementPresent(productNameField);
            productNameField.sendKeys(ApplicationConfig.readConfigProperties(configFile, "productName" + i));
            testUtility.waitForElementPresent(autoProductCode);
            autoProductCode.click();
            testUtility.waitForElementPresent(categoriesTab);
            categoriesTab.click();
            testUtility.waitForElementPresent(myCategory);
            myCategory.click();
            testUtility.sleep(3);
            testUtility.waitForElementPresent(saveButton);
            saveButton.click();
            testUtility.waitForElementPresent(successfulMessage);
            if(successfulMessage.isDisplayed()){
                System.out.println(i+" product added successfully.");
            }
        }
    }

    public void deleteProduct() {
        testUtility.sleep(2);
        testUtility.waitForElementPresent(productsPage);
        productsPage.click();
        testUtility.sleep(2);
        boolean b = true;
        try {
        while (b) {
            if (deleteIcon.isDisplayed()) {
                testUtility.waitForElementPresent(deleteIcon);
                deleteIcon.click();
                driver.switchTo().alert().accept();
                if (successfulMessage.isDisplayed()) {
                    System.out.println("Product deleted successfully.");
                }else {
                    System.out.println("Product cannot deleted.");
                }
            }
        }
    }catch (Exception e){
            System.out.println("Products no longer exist.");
//            e.printStackTrace();
        }
    }


}
