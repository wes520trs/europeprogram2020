package com.unitedcoder.regression.uitest.cucumberframework.inventorymodulesteps;

import com.unitedcoder.cubecartautomation.TestBase;
import com.unitedcoder.regression.uitest.pageobjectmodel.DashboardPage;
import com.unitedcoder.regression.uitest.pageobjectmodel.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsSteps extends TestBase {

    DashboardPage dashboardPage;
    ProductsPage productsPage;

    @Given("User already on the dashboard page")
    public void userAlreadyOnTheDashboardPage() {
        dashboardPage = new DashboardPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @When("User click on Products link")
    public void userClickOnProductsLink() {
        dashboardPage.clickOnProductsLink();
    }

    @And("User click on Add Product tab to fill out product information")
    public void userClickOnAddProductTabToFillOutProductInformation() {
        productsPage.addProducts("trsBook", "trs001");
    }

    @Then("New product should be added")
    public void newProductShouldBeAdded() {
        productsPage.verifyNewProductAdded();
    }

    @And("User click on delete icon")
    public void userClickOnDeleteIcon() {
        productsPage.deleteProduct();
    }

    @Then("Product should be deleted successfully")
    public void productShouldBeDeletedSuccessfully() {
        productsPage.verifyProductDeleted();
    }
}
