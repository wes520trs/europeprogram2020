package com.unitedcoder.regression.uitest.cucumberframework;

import com.unitedcoder.cubecartautomation.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends TestBase {

    @Before
    public void setup(){
        initialzation();
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
