package com.unitedcoder.regression.uitest.pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//*[@id=\"categories\"]/table/tbody/tr[1]/td[7]/a[4]/i")
    WebElement deleteIcon;
    @FindBy(xpath = "//div[@class='success']")
    WebElement successfullyDeleteMassage;

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    public boolean deleteCategory(){
        utility.waitForElementPresent(deleteIcon);
        deleteIcon.click();
        utility.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        return successfullyDeleteMassage.isDisplayed();
    }
}
