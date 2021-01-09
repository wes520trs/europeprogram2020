package com.unitedcoder.regression.uitest.testngframework;

import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Math.max;

public class TestNGDemo2 {

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

    @Test(groups = {"smoke test","regression test"})
    public void addProductTest(){
        System.out.println("This for adding new product");
        Assert.assertTrue("add product".contains("Product"));
    }

    @Test(groups = "regression test")
    public void deleteProduct(){
        System.out.println("This test is for deleting product");
        Assert.assertEquals(10,10);
    }

    @Test(groups = "smoke test", dependsOnGroups = "regression test")
    public void viewCustomer(){
        System.out.println("This test is for view customers");
        Assert.assertEquals(max(15,25),25);
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class will run once");
    }


}
