package com.unitedcoder.regression.uitest.testngframework;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.cubecartautomation.TestBase;
import com.unitedcoder.regression.browserutils.JenkinsBrowserMode;
import com.unitedcoder.regression.uitest.pageobjectmodel.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JUnitConvertToTestNGRunner extends TestBase {
    static TestUtility utility;
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    private static WebDriver driver;
    ProductsPage productsPage;
    CategoriesPage categoriesPage;
    CustomerPage customerPage;
    final static String configFile = "config.properties";
    final static String url = ApplicationConfig.readConfigProperties(configFile, "qaurl");


    @BeforeClass
    public static void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        JenkinsBrowserMode browserMode = new JenkinsBrowserMode();
        if (ApplicationConfig.readConfigProperties("config.properties",
                "headless").equals("1")) {
            browserMode.setHeadlessModeOnWindows(chromeOptions);
        }
        else{
            System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        }
        driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
        loginPage = new LoginPage(driver);
        utility = new TestUtility(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.login();

    }

    @Test(enabled = false)
    public void addProduct() {
        dashboardPage.clickOnProductsLink();
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.addProduct());
    }


    @Test(enabled = false)
    public void deleteCategories() {
        dashboardPage.clickOnCategoryLink();
        categoriesPage = new CategoriesPage(driver);
        Assert.assertTrue(categoriesPage.deleteCategory());
    }

    @Test
    public void viewCustomers() {
        dashboardPage.clickOnCustomersLink();
        customerPage = new CustomerPage(driver);
        Assert.assertTrue((customerPage.viewCustomers()));
    }

    @AfterClass
    public static void tearDown() {
        dashboardPage.logout();
        driver.close();
        driver.quit();
    }
}
