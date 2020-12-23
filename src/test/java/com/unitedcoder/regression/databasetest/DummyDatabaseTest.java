package com.unitedcoder.regression.databasetest;

import org.junit.Assert;
import org.testng.annotations.Test;

public class DummyDatabaseTest {
    @Test
    public void exampleDatabaseTest()
    {
        Assert.assertTrue("Selenium".equalsIgnoreCase("selenium"));
    }
}
