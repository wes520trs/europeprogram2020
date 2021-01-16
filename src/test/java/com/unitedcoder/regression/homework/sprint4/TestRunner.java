package com.unitedcoder.regression.homework.sprint4;

import com.unitedcoder.cubecartautomation.TestBase;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

    @Test
    public void deleteProduct(){
        productsPage=new ProductsPage(driver);
        productsPage.deleteProduct();
    }

}
