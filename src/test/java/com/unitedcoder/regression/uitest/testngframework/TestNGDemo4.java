package com.unitedcoder.regression.uitest.testngframework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo4 {
    @Test(timeOut = 5000)
    public void loginTest(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Login test passed.");
        Assert.assertEquals(10,10);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void test1(){
        String s="100A";
        System.out.println(Integer.parseInt(s));
    }
}
