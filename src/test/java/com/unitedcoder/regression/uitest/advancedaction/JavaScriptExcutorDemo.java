package com.unitedcoder.regression.uitest.advancedaction;

import com.unitedcoder.regression.uitest.testngframework.ScreenShotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptExcutorDemo {

    WebDriver driver;
    int timeout;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.get("https://www.twoplugs.com/");
    }

    @Test
    public void highlightElement(){
        WebElement join=driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a/span"));
        JavaScriptMethods.highLightElement(join,driver);
    }

    @Test
    public void drawElement(){
        WebElement join=driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a/span"));
        JavaScriptMethods.setElementBorder(join,driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScreenShotUtility shotUtility=new ScreenShotUtility();
        shotUtility.takeScreenShot("elementBorder.png",driver);
    }

    @Test
    public void clickWithJs(){
        driver.get("http://cubecart.unitedcoderschool.com/ecommerce/admin_w4vqap.php?_g=customers&node=email");
        WebElement loginButton=driver.findElement(By.id("login"));
        waitForElementPresent(loginButton);
        JavaScriptMethods.clickWithJS(loginButton,driver);
        System.out.println(JavaScriptMethods.getTitle(driver));
        JavaScriptMethods.generateAlert(driver,"You clicked login button without entering username and password.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
    }



    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
