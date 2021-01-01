package com.unitedcoder.regression.uitest.junittest;

import org.junit.Assert;
import org.junit.Test;

public class JUnitTestDemo {
    @Test
    public void test1(){
        System.out.println("square root test");
        Assert.assertTrue(Math.sqrt(64)==8);
    }

    @Test
    public void test2(){
        System.out.println("compare two string");
        String s1="Selenium";
        String s2="selenium";
        Assert.assertFalse(s1.equals(s2));
    }

    @Test
    public void test3(){
        Assert.assertEquals(10,20);
    }
}
