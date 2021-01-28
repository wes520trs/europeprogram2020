package com.unitedcoder.regression.uitest.advancedaction;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdvancedActionDemo1 {
    WebDriver driver;
    int timeout;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void amazonTest() throws InterruptedException {
        WebElement accountList=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("iphone").
                doubleClick().sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);
        actions.moveToElement(accountList).build().perform();
        Thread.sleep(3000);
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
