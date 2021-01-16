package com.unitedcoder.regression.uitest.testngframework;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionDemo {
    SoftAssert softAssert=new SoftAssert(); //Assert is hard assert
    @Test
    public void dummyTest(){
        System.out.println("Open browser");
        Assert.assertEquals(10,10);
        System.out.println("Log in");
        Assert.assertEquals(10,10);
        System.out.println("Add product");
//        Assert.assertEquals(10,20);
        softAssert.assertEquals(10,20);
        System.out.println("Add customer");
        System.out.println("Add review");
        softAssert.assertAll();
    }
}
