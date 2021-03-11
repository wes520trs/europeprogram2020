package com.unitedcoder.regression.uitest.testngframework;

import com.unitedcoder.cubecartautomation.TestBase;
import com.unitedcoder.regression.uitest.pageobjectmodel.DashboardPage;
import com.unitedcoder.regression.uitest.pageobjectmodel.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo extends TestBase {

    @BeforeClass
    public void setup(){
        initialization();
    }

    @Test(dataProvider = "loginInfo")
    public void roleBasedSevurityTest(String username, String password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginUser(username, password);
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.logout();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @DataProvider
    public Object[][] loginInfo(){           //it can be more dimention than two
        Object[][] testDate=new  Object[][]{
                {"testautomation","automation123!"},
//                {"testautomation1","automation123!"},
                {"testautomation2","automation123!"}
        };
        return testDate;
    }
}
