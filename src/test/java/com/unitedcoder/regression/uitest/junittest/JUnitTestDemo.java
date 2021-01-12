package com.unitedcoder.regression.uitest.junittest;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JUnitTestDemo {
    @BeforeClass
    public static void setup(){
        System.out.println("Before Class runs only once");
    }

    @Rule
    public TestName name=new TestName();


    @Before
    public void testBegin(){
        System.out.println("Before annotation will execute before every test");
        System.out.println(name.getMethodName()+" started");
    }


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
        Assert.assertEquals(10,10);
    }

    @After
    public void testEnd(){
        System.out.println("After annotation will execute after every test");
    }

    @AfterClass
    public static void teardown(){
        System.out.println("After class will execute once after class");
    }
}
