package com.unitedcoder.regression.uitest.cucumberframework.customermodulesteps;

import com.unitedcoder.cubecartautomation.TestBase;
import com.unitedcoder.regression.uitest.pageobjectmodel.CustomerPage;
import com.unitedcoder.regression.uitest.pageobjectmodel.DashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CustomerListSteps extends TestBase {

    DashboardPage dashboardPage;
    CustomerPage customerPage = new CustomerPage(driver);

    @Given("User already on the dashboard page")
    public void userAlreadyOnTheDashboardPage() {
        dashboardPage = new DashboardPage(driver);
        customerPage = new CustomerPage(driver);
    }

    @When("User click on Customer List link")
    public void userClickOnCustomerListLink() {
        dashboardPage.clickOnCustomersLink();
    }

    @And("User click on Add Customer link to fill out all customer information")
    public void userClickOnAddCustomerLinkToFillOutAllCustomerInformation() {
        customerPage.addCustomer("Tursun", "S", "ttrr@gmail.com");
    }

    //add customers
    @Then("New customer should be added")
    public void newCustomerShouldBeAdded() {
        Assert.assertTrue(customerPage.customerAddedSuccessfully());
    }


    //given and when is used by add customer and delete customer at the same time
    // delete customers
    @And("User click on delete icon")
    public void userClickOnDeleteIcon() {
        customerPage.deleteCustomer();
    }

    @Then("User should be deleted successfully")
    public void userShouldBeDeletedSuccessfully() {
        Assert.assertTrue(customerPage.verifyDeletedSuccessfully());
    }
}
