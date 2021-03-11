package com.unitedcoder.regression.uitest.cucumberframework.backendteststeps;

import com.unitedcoder.configutility.ApplicationConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataBaseTestStep {

    static String configFile = "config.properties";
    static String dbURL = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.dbURL");
    static String dbPort = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.dbPort");
    static String userName = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.userName");
    static String password = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.password");
    static String defaultSchema = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.defaultSchema");
    @Given("A user has access to the cc_CubeCart_inventory table")
    public void aUserHasAccessToTheCc_CubeCart_inventoryTable() {
        
    }

    @When("User query the query script in the cc_CubeCart_inventory table")
    public void userQueryTheQueryScriptInTheCc_CubeCart_inventoryTable() {
        
    }

    @Then("User should see the product info")
    public void userShouldSeeTheProductInfo() {
    }
}
