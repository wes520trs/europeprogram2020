package com.unitedcoder.regression.uitest.testngframework;

import org.testng.Assert;
import org.testng.annotations.*;
import static java.lang.Math.*; //static import method, you don't have to write Math, in viewCustomer method

public class TestNGDemo1 {

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

    @Test
    public void addProductTest(){
        System.out.println("This for adding new product");
        Assert.assertTrue("add product".contains("product"));
    }

    @Test
    public void deleteproduct(){
        System.out.println("This test is for deleting product");
        Assert.assertEquals(10,20);
    }

    @Test
    public void viewCustomer(){
        System.out.println("This test is for view customers");
        Assert.assertEquals(max(15,25),20);
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class will run once");
    }


}
