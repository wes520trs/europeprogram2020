package com.unitedcoder.regression.uitest.pageobjectmodel;

import com.unitedcoder.cubecartautomation.TestBase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestRunner extends TestBase {
    static TestUtility utility;
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    ProductsPage productsPage;
    CategoryPage categoryPage;
    @BeforeClass
    public static void setup(){
        initialzation();
        loginPage=new LoginPage(driver);
        utility=new TestUtility(driver);
        dashboardPage=new DashboardPage(driver);
    }

    @Test
    public void addProduct(){
        dashboardPage.clickOnProductssLink();
        productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.addProduct());
    }

    @AfterClass
    public static void tearDown(){

    }
}
