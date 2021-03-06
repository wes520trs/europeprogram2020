package com.unitedcoder.regression.homework.sprint5;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.configutility.UiUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DataBaseUIVerification {

    Connection myConn;
    TestDataHolder dataHolder=new TestDataHolder();
    WebDriver driver;
    UiUtility utility;
    static String configFile = "config.properties";
    String url = ApplicationConfig.readConfigProperties(configFile, "qaurl");

    @BeforeClass
    public void setUp() {
        //connect to data base
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://148.72.106.125:3306/i4296639_cc1",
                    "testautomation", "automation123!");
            Statement myStmt = myConn.createStatement();
            if (!myConn.isClosed()) {
                System.out.println("Data connection is established.");
            } else {
                System.out.println("Data base connection is failed to build.");
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        //login to the CubeCart
        System.setProperty("webdriver.gecko.driver", "c:\\webdriver\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new FirefoxDriver(options);
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

    @Test(description = "adding customer by using CubeCart UI",
    groups = {"add customer"}, priority = 1)
    public void addCustomersOnUI() {
        WebElement customerList = driver.findElement(By.xpath("//a[text()='Customer List']"));
        utility.waitForElementPresent(customerList);
        customerList.click();
        WebElement addCustomer = driver.findElement(By.xpath("//a[text()='Add Customer']"));
        utility.waitForElementPresent(addCustomer);
        addCustomer.click();
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='customer[first_name]']"));
        utility.waitForElementPresent(firstNameField);
        String firstName = "Tursun" + System.currentTimeMillis();
        firstNameField.sendKeys(firstName);
        dataHolder.setFirstName(firstName);
        System.out.println("First name from dataHolder: " + dataHolder.getFirstName());
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='customer[last_name]']"));
        utility.waitForElementPresent(lastNameField);
        lastNameField.sendKeys("Sabir");
        WebElement emailField = driver.findElement(By.xpath("//input[@name='customer[email]']"));
        utility.waitForElementPresent(emailField);
        emailField.sendKeys("trs" + System.currentTimeMillis() + "@gmail.com");
        WebElement saveButton = driver.findElement(By.xpath("//input[@name='save']"));
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        WebElement successfulMassage = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(successfulMassage.isDisplayed());
    }

    @Test(description = "Verify customer with data base",
            groups = "add customer", priority = 2)
    public void VerifyCustomerInfo() throws SQLException {
        Statement statement = null; //equal to query
        ResultSet resultSet = null; //use data only during the connection with data base
        CachedRowSet cachedRowSet = null; //use data without connection
        cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        statement = myConn.createStatement();
        String sqlScript = "select customer_id, first_name, last_name, email " +
                "from cc_CubeCart_customer where first_name='"+dataHolder.getFirstName()+"'";
        System.out.println("query text is: " + sqlScript);
        resultSet = statement.executeQuery(sqlScript);
        System.out.println("String value of resultSet: " + resultSet.toString());
        System.out.println("row nomber of resultSet: " + resultSet.getRow());
        System.out.println("getType of resultSet: " + resultSet.getType());
        if (resultSet == null) {
            System.out.println("No records found");
        } else {
            cachedRowSet.populate(resultSet); //fill out - populate
            System.out.println("String of cachedRowSet: " + cachedRowSet.toString());
            System.out.println("Collection of cachedRowSet: " + cachedRowSet.toCollection());
        }
        int count = 0;
        while (true) {
            if (!cachedRowSet.next()) {
                break;
            }
            int customerID = cachedRowSet.getInt("customer_id");
            String firstName = cachedRowSet.getString("first_name");
            String lastName = cachedRowSet.getString("last_name");
            String email = cachedRowSet.getString("email");
            System.out.println(String.format("customerID=%d firstName=%s lastName=%s email=%s",
                    customerID, firstName, lastName, email));
            count = cachedRowSet.getRow();
            System.out.println("first name from dataholder is: " + dataHolder.getFirstName() +
                    "\n first name from cachedRoeSet is: " + firstName);
            Assert.assertEquals(firstName, dataHolder.getFirstName());
        }
        System.out.println("Total rows: " + count);
    }

    @Test(description = "adding category by using CubeCart UI",
    groups = "add category")
    public void addProductCategory() {
        WebElement categoryLink = driver.findElement(By.id("nav_categories"));
        utility.waitForElementPresent(categoryLink);
        categoryLink.click();
        WebElement addCategory = driver.findElement(By.linkText("Add Category"));
        utility.waitForElementPresent(addCategory);
        addCategory.click();
        WebElement nameTextField = driver.findElement(By.id("name"));
        utility.waitForElementPresent(nameTextField);
        String catName="TRSCourse" + System.currentTimeMillis();
        nameTextField.sendKeys(catName);
        dataHolder.setCatName(catName);
        WebElement saveButton = driver.findElement(By.id("cat_save"));
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        WebElement successfulMessage = driver.findElement(By.cssSelector("div.success"));
        Assert.assertTrue(successfulMessage.isDisplayed());
    }

    @Test(description = "verify category with data base", groups = "add category")
    public void VerifyCategoryInfo() throws SQLException {
        Statement statement = null; //equal to query
        ResultSet resultSet = null; //use data only during the connection with data base
        CachedRowSet cachedRowSet = null; //use data without connection
        cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        statement = myConn.createStatement();
        String sqlScript = "select cat_id, cat_name from cc_CubeCart_category " +
                "where cat_name='"+dataHolder.getCatName()+"'";
        System.out.println("query text is: " + sqlScript);
        resultSet = statement.executeQuery(sqlScript);
        System.out.println("String value of resultSet: " + resultSet.toString());
        System.out.println("row number of resultSet: " + resultSet.getRow());
        System.out.println("getType of resultSet: " + resultSet.getType());
        if (resultSet == null) {
            System.out.println("No records found");
        } else {
            cachedRowSet.populate(resultSet); //fill out - populate
            System.out.println("String of cachedRowSet: " + cachedRowSet.toString());
            System.out.println("Collection of cachedRowSet: " + cachedRowSet.toCollection());
        }
        int count = 0;
        while (true) {
            if (!cachedRowSet.next()) {
                break;
            }
            int categoryID = cachedRowSet.getInt("cat_id");
            String categoryName = cachedRowSet.getString("cat_name");
            System.out.println(String.format("CategoryID=%d CategoryName=%s",
                    categoryID, categoryName));
            count = cachedRowSet.getRow();
            System.out.println("Category name from dataholder is: " + dataHolder.getCatName() +
                    "\n Category name from cachedRoeSet is: " + categoryName);
            Assert.assertEquals(categoryName, dataHolder.getCatName());
        }
        System.out.println("Total rows: " + count);
    }


    @AfterClass
    public void closeDataBaseAndQuitWebDriver() {
        // logout from CubeCart
        WebElement logout = driver.findElement(By.cssSelector("a[href*='logout']"));
        utility.waitForElementPresent(logout);
        logout.click();
        utility.sleep(2);
        driver.close();
//        driver.quit();
        //disconnect data base
        try {
            if (myConn.isClosed()) {
                System.out.println("Data base connection has been closed.");
            } else {
                myConn.close();
                System.out.println("Connection is closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
