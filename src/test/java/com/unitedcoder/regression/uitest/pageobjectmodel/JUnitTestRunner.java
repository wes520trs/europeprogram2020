package com.unitedcoder.regression.uitest.pageobjectmodel;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.cubecartautomation.TestBase;
import com.unitedcoder.regression.browserutils.JenkinsBrowserMode;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JUnitTestRunner extends TestBase {
    static TestUtility utility;
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
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
        boolean useHeadless = browserMode.setHeadlessModeIfLinux(chromeOptions);
        if (!useHeadless) {
            System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        }
        //define a webdriver
        driver = new ChromeDriver(chromeOptions);
        //maximize browser window
        if (!useHeadless) {
            driver.manage().window().maximize();
        }
        driver.get(url);
        loginPage = new LoginPage(driver);
        utility = new TestUtility(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.login();

    }

    @Test
    public void addProduct() {
        dashboardPage.clickOnProductsLink();
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.addProduct());
    }

    @Test
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
