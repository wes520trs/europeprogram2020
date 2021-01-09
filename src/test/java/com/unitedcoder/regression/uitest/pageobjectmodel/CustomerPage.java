package com.unitedcoder.regression.uitest.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerPage {
    WebDriver driver;
    TestUtility utility;
    @FindAll(
            @FindBy(xpath = "//div[@id='customer-list']/table/tbody/tr")
            //number of <tr></tr>, how many rows
    )
    List<WebElement> customerList;
    @FindBy(xpath = "//div[@id='customer-list']/table")
    WebElement customerTable;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    public boolean viewCustomers(){
        utility.waitForElementPresent(customerTable);
        return customerList.size()>=1;
    }
}
