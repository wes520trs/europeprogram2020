package com.unitedcoder.regression.databasetest;

import com.unitedcoder.classconcepts.ProductContent;
import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.configutility.UiUtility;
import com.unitedcoder.regression.uitest.pageobjectmodel.DashboardPage;
import com.unitedcoder.regression.uitest.pageobjectmodel.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseUIVerification {

    static String configFile = "config.properties";
    WebDriver driver;
    String url = ApplicationConfig.readConfigProperties(configFile, "qaurl");
    UiUtility utility;
    DashboardPage dashboardPage;
    static String dbURL = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.dbURL");
    static String dbPort = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.dbPort");
    static String userName = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.userName");
    static String password = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.password");
    static String defaultSchema = ApplicationConfig.readConfigProperties(configFile, "cubeCartProd.defaultSchema");
    Connection connection;
    TestDataHolder dataHolder;
    @BeforeClass
    public void setup() {
        connection=ConnectionManager.connectToDataBaseServer(
                dbURL,dbPort,userName,password,defaultSchema,ConnectionType.MYSQLSERVER);
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        utility = new UiUtility(driver);
        WebElement userNameField = driver.findElement(By.id("username"));
        String userName = ApplicationConfig.readConfigProperties(configFile, "username");
        utility.waitForElementPresent(userNameField);
        userNameField.sendKeys(userName);
        WebElement passwordField = driver.findElement(By.id("password"));
        String password = ApplicationConfig.readConfigProperties(configFile, "password");
        utility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login"));
        utility.waitForElementPresent(loginButton);
        loginButton.click();
    }

    @Test(description = "Admin user should be able to add new products",
    groups = "UI test")
    public void addProductTest() {
        dashboardPage=new DashboardPage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
        dataHolder=new TestDataHolder();
        dashboardPage.clickOnProductsLink();
        String productName="Shoes"+System.currentTimeMillis();
        dataHolder.setProductName(productName);
        productsPage.addProducts(productName,"MZ1023");
        Assert.assertTrue(productsPage.verifyNewProductAdded());
    }

    @Test(description = "Admin user should be able to verify product in the data base.",
    dependsOnGroups = "UI test")
    public void verifyProducts() throws SQLException {
        DataAccess access=new DataAccess();
        boolean productExist=access.getProductName(dataHolder.getProductName(),connection);
        Assert.assertTrue(productExist);
    }

    @AfterClass
    public void tearDown(){
        dashboardPage.logout();
        driver.close();
        driver.quit();
        ConnectionManager.closeDataBaseConnection(connection);
    }
}
