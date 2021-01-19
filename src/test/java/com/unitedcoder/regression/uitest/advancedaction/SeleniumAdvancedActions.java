package com.unitedcoder.regression.uitest.advancedaction;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumAdvancedActions {
    WebDriver driver;
    int timeout=10;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://jqueryui.com/droppable/");

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement draggable=driver.findElement(By.id("draggable"));
        WebElement droppable=driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(draggable,droppable).build().perform();
//        below is the same action with dragAndDrop
//        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        // drag by two step
//        actions.dragAndDropBy(draggable,80,0).dragAndDrop(draggable,droppable).build().perform();
        Thread.sleep(2000);
        Assert.assertTrue(droppable.getText().equalsIgnoreCase("Dropped!"));
    }

    @Test
    public void classicMenuTest(){

        driver.get("https://jqueryui.com/menu/");

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement frame=driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frame);
        WebElement musicMenu=driver.findElement(By.id("ui-id-9"));
        waitForElementPresent(musicMenu);
        Actions actions=new Actions(driver);
        actions.moveToElement(musicMenu).build().perform();
        WebElement rockMenu=driver.findElement(By.id("ui-id-10"));
        waitForElementPresent(rockMenu);
        actions.moveToElement(rockMenu).build().perform();
        WebElement classic=driver.findElement(By.id("ui-id-12"));
        waitForElementPresent(classic);
        Assert.assertTrue(classic.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
