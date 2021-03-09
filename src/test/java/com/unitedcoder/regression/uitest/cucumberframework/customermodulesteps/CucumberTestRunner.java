package com.unitedcoder.regression.uitest.cucumberframework.customermodulesteps;

import com.unitedcoder.cubecartautomation.TestBase;
import com.unitedcoder.regression.uitest.pageobjectmodel.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cubecart-cucumber"},
        features = {"src/test/resources"},
        tags = "@CustomerModuleIntegration",
        monochrome = true
)


public class CucumberTestRunner extends TestBase {

    @BeforeClass
    public static void setup(){
        initialzation();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
