package com.unitedcoder.regression.homework.sprint5;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.configutility.UiUtility;
import com.unitedcoder.regression.uitest.pageobjectmodel.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UIAction {

    static String configFile = "config.properties";
    WebDriver driver;
    String url = ApplicationConfig.readConfigProperties(configFile, "qaurl");
    UiUtility utility;
    TestDataHolder dataHolder;

    @BeforeClass
    public void setUp() {
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

    @Test(invocationCount = 1)
    public void addCustomers() {
        WebElement customerList = driver.findElement(By.xpath("//a[text()='Customer List']"));
        utility.waitForElementPresent(customerList);
        customerList.click();
        WebElement addCustomer = driver.findElement(By.xpath("//a[text()='Add Customer']"));
        utility.waitForElementPresent(addCustomer);
        addCustomer.click();
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='customer[first_name]']"));
        utility.waitForElementPresent(firstNameField);
        String firstName="Tursun" + System.currentTimeMillis();
        firstNameField.sendKeys(firstName);
        dataHolder.setFirstName(firstName);
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

    @Test(invocationCount = 1)
    public void addProductCategory() {
        WebElement categoryLink = driver.findElement(By.id("nav_categories"));
        utility.waitForElementPresent(categoryLink);
        categoryLink.click();
        WebElement addCatogoryLink = driver.findElement(By.linkText("Add Category"));
        utility.waitForElementPresent(addCatogoryLink);
        addCatogoryLink.click();
        WebElement nameTextField = driver.findElement(By.id("name"));
        utility.waitForElementPresent(nameTextField);
        nameTextField.sendKeys("TRSCourse" + System.currentTimeMillis());
        WebElement saveButton = driver.findElement(By.id("cat_save"));
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        WebElement successfulMessage = driver.findElement(By.cssSelector("div.success"));
        Assert.assertTrue(successfulMessage.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        WebElement logout = driver.findElement(By.cssSelector("a[href*='logout']"));
        utility.waitForElementPresent(logout);
        logout.click();
        utility.sleep(2);
        driver.close();
        driver.quit();
    }

}
