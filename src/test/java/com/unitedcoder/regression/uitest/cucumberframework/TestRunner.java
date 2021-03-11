package com.unitedcoder.regression.uitest.cucumberframework;

import com.unitedcoder.cubecartautomation.TestBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( //customise cucumber test
        plugin = {"pretty", "html:target/cubecart-cucumber"},
        features = {"src/test/resources"},
        tags = "@weatherApiTest",
        monochrome = true
)


public class TestRunner extends TestBase {
//        @BeforeClass
//    public static void setUp(){
//        initialization();
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.login();
//    }
//    @AfterClass
//    public static void tearDown(){
//        DashboardPage dashboardPage=new DashboardPage(driver);
//        dashboardPage.logout();
//        driver.close();
//        driver.quit();
//    }
}
