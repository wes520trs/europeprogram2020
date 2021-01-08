package com.unitedcoder.regression.uitest.pageobjectmodel;

import com.unitedcoder.cubecartautomation.TestBase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRunner extends TestBase {
    static TestUtility utility;
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    ProductsPage productsPage;
    CategoriesPage categoriesPage;

    @BeforeClass
    public static void setup(){
        initialzation();
        loginPage=new LoginPage(driver);
        utility=new TestUtility(driver);
        dashboardPage=new DashboardPage(driver);
        loginPage.login();
    }

    @Test
    public void addProduct(){
        dashboardPage.clickOnProductsLink();
        productsPage=new ProductsPage(driver);
        Assert.assertTrue(productsPage.addProduct());
    }

    @Test
    public void deleteCategories(){
        dashboardPage.clickOnCategoryLink();
        categoriesPage =new CategoriesPage(driver);
        Assert.assertTrue(categoriesPage.deleteCategory());
    }
    @AfterClass
    public static void tearDown(){
        dashboardPage.logout();
        driver.close();
        driver.quit();
    }
}
