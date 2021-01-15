package com.unitedcoder.regression.uitest.testngframework;

import org.testng.Assert;
import org.testng.annotations.*;
import static java.lang.Math.*; //static import method, you don't have to write Math, in viewCustomer method

public class TestNGDemo1 {

    @BeforeSuite
    public void beforeSuitTest(){
        System.out.println("Before suit will run first");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test will run after Suite");
    }

    @BeforeClass
    public void setup(){
        System.out.println("before Class will run once");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method will run before every test method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method will run after every test method");
    }

    @Test(priority = 2, description = "Admin user should be able to add product.",
            groups = {"smoke test","regression test"})
    public void addProductTest(){
        System.out.println("This for adding new product");
        Assert.assertTrue("add product".contains("product"));
    }

    @Test(priority = 3, enabled = false, groups = "regression test")
    public void deleteProduct(){
        System.out.println("This test is for deleting product");
        Assert.assertEquals(10,10);
    }

    @Test(priority = 1, groups = "smoke test")
    public void viewCustomer(){
        System.out.println("This test is for view customers");
        Assert.assertEquals(max(15,25),25);
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class will run once");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test will run after class");
    }

    @AfterSuite
    public void afterSiutTest(){
        System.out.println("After suit will run after all tests");
    }
}
