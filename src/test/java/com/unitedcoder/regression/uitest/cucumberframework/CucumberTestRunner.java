package com.unitedcoder.regression.uitest.cucumberframework;

import com.unitedcoder.cubecartautomation.TestBase;
import com.unitedcoder.regression.uitest.pageobjectmodel.DashboardPage;
import com.unitedcoder.regression.uitest.pageobjectmodel.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( //customise cucumber test
        plugin = {"pretty", "html:target/cubecart-cucumber",
        "json:target/cucumber.json"},
        features = {"src/test/resources"},
        tags = "@ProductModule,@weatherApiTest,@DataBaseTest",
        monochrome = true
)


public class CucumberTestRunner extends TestBase {
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
