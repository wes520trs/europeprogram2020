package com.unitedcoder.regression.uitest.cucumberframework;

import com.unitedcoder.cubecartautomation.TestBase;
import com.unitedcoder.regression.uitest.pageobjectmodel.CustomerPage;
import com.unitedcoder.regression.uitest.pageobjectmodel.DashboardPage;
import com.unitedcoder.regression.uitest.pageobjectmodel.LoginPage;
import com.unitedcoder.regression.uitest.pageobjectmodel.TestUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends TestBase {

    TestUtility utility;
    CustomerPage customerPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    @Given("User on login page")
    public void userOnLoginPage() {
        initialzation();
    }

    @When("User enter username and password click on login button")
    public void userEnterUsernameAndPasswordClickOnLoginButton() {
        loginPage=new LoginPage(driver);
        loginPage.login();
    }

    @Then("User successfully login to the system")
    public void userSuccessfullyLoginToTheSystem() {
        dashboardPage=new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.verifyLogin());
    }
}
