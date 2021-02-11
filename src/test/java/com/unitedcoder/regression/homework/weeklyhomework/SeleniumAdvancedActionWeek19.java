package com.unitedcoder.regression.homework.weeklyhomework;

/*
Referen URL:  http://jqueryui.com/
        Resizable
        Menu
        Slider
*/

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

public class SeleniumAdvancedActionWeek19 {
    WebDriver driver;
    int timeout = 10;
    Actions actions;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void resizableTest(){

        driver.get("https://jqueryui.com/resizable/");

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");
        sleep(2);

        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement horizontal=driver.findElement(By.xpath("//*[@class='ui-resizable-handle ui-resizable-e']"));
        waitForElementPresent(horizontal);
        actions=new Actions(driver);
//        actions.clickAndHold(Horizontal).moveToElement(Horizontal,200,0).release().build().perform();
        actions.dragAndDropBy(horizontal,200,0).build().perform();
        sleep(1);
        WebElement vertical= driver.findElement(By.xpath("//*[@class='ui-resizable-handle ui-resizable-s']"));
        waitForElementPresent(vertical);
        actions.clickAndHold(vertical).moveToElement(vertical,0,200).release().build().perform();
        sleep(1);
        WebElement corner=driver.findElement(By.xpath("//*[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
        waitForElementPresent(corner);
        actions.clickAndHold(corner).moveToElement(corner,-200,-200).release().build().perform();
        sleep(2);
    }

    @Test
    public void menuTest(){

        driver.get("https://jqueryui.com/menu/");

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        sleep(1);

        WebElement musicMenu=driver.findElement(By.xpath("//div[text()='Music']"));
        waitForElementPresent(musicMenu);
        actions=new Actions(driver);
        actions.moveToElement(musicMenu).build().perform();
        sleep(1);
        WebElement jazzMenu=driver.findElement(By.xpath("//div[text()='Jazz']"));
        waitForElementPresent(jazzMenu);
        actions.moveToElement(jazzMenu).build().perform();
        sleep(1);
        WebElement modernMenu=driver.findElement(By.xpath("//div[text()='Modern']"));
        waitForElementPresent(modernMenu);
        actions.moveToElement(modernMenu).build().perform();
        Assert.assertTrue(modernMenu.isDisplayed());
        sleep(2);
    }

    @Test
    public void sliderTest(){
        driver.get("https://jqueryui.com/slider/");

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");

        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement slider= driver.findElement(By.xpath("//span[contains(@class,\"slider\")]"));
        waitForElementPresent(slider);
        int before=slider.getLocation().getX();
        System.out.println("Slider original location: "+before);
        actions=new Actions(driver);
//        actions.clickAndHold(slider).moveToElement(slider,50,0).release().build().perform();
        actions.dragAndDropBy(slider,150,0).dragAndDropBy(slider,200,0).build().perform();
        int after=slider.getLocation().getX();
        System.out.println("Slider original location: "+after);
        Assert.assertNotSame(before,after);
        sleep(2);
    }


    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }


    public void sleep(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
