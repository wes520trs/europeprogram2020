package com.unitedcoder.regression.homework.sprint4;

import com.unitedcoder.cubecartautomation.TestBase;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRunner extends TestBase {
    static TestUtility testUtility;
    static LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public static void setup(){
        initialzation();
        loginPage=new LoginPage(driver);
        loginPage.login();
    }

    @Test
    public void addProduct(){
        productsPage=new ProductsPage(driver);
        productsPage.addProducts(2);
    }

}
