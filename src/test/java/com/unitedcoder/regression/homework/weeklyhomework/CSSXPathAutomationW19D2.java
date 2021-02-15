package com.unitedcoder.regression.homework.weeklyhomework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CSSXPathAutomationW19D2 {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.gecko.driver","c:\\webdriver\\geckodriver.exe");
        FirefoxOptions options=new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new FirefoxDriver(options);
        driver.get("https://jqueryui.com/demos/");
    }

    @Test
    public void automationWithXpath(){
//        scroll to elements and frame appears
        WebElement datePicker=driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Datepicker']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",datePicker);
        sleep(1);
        datePicker.click();
        sleep(1);
        WebElement dateRange=driver.findElement(By.xpath("//a[text()='Select a Date Range']"));
        js.executeScript("arguments[0].scrollIntoView(true)",dateRange);
        sleep(1);
        dateRange.click();
        WebElement iframe=driver.findElement(By.xpath("//iframe[contains(@class,\"demo\")]"));
        js.executeScript("arguments[0].scrollIntoView(true)",iframe);
        driver.switchTo().frame(iframe);
        sleep(2);

//        set date value
        WebElement from=driver.findElement(By.xpath("//input[@id='from']"));
        from.click();
        String fromDate="02/20/2018";
        from.sendKeys(fromDate);
        WebElement to=driver.findElement(By.xpath("//input[@id='to']"));
        to.click();
        String toDate="03/20/2018";
        to.sendKeys(toDate);

//        take screen shot of date field with element border
        js.executeScript("arguments[0].style.border='4px solid red'",from);
        js.executeScript("arguments[0].style.border='4px solid red'",to);
        sleep(1);
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("screenshot\\homeworkW19D2DatePicker.png");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        use assertion for verify
        String fromDateValue=from.getAttribute("value");
        String toDateValue=to.getAttribute("value");
        Assert.assertTrue(fromDate.equals(fromDateValue)&&toDate.equalsIgnoreCase(toDateValue));
    }

    @Test
    public void automationWithCSS(){
//        scroll to elements and frame appears
        WebElement datePicker=driver.findElement(By.cssSelector("#sidebar a[href*='datepicker']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",datePicker);
        sleep(1);
        datePicker.click();
        sleep(1);
        WebElement dateRange=driver.findElement(By.cssSelector("a[href*='date-range']"));
        js.executeScript("arguments[0].scrollIntoView(true)",dateRange);
        sleep(1);
        dateRange.click();
        WebElement iframe=driver.findElement(By.cssSelector(".demo-frame"));
        js.executeScript("arguments[0].scrollIntoView(true)",iframe);
        driver.switchTo().frame(iframe);
        sleep(2);

//        set date value
        WebElement from=driver.findElement(By.cssSelector("#from.hasDatepicker"));
        from.click();
        String fromDate="02/20/2018";
        from.sendKeys(fromDate);
        WebElement to=driver.findElement(By.cssSelector("#to.hasDatepicker"));
        to.click();
        String toDate="03/20/2018";
        to.sendKeys(toDate);

//        take screen shot of date field with element border
        js.executeScript("arguments[0].style.border='4px solid red'",from);
        js.executeScript("arguments[0].style.border='4px solid red'",to);
        sleep(1);
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("screenshot\\homeworkW19D2DatePicker.png");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        use assertion for verify
        String fromDateValue=from.getAttribute("value");
        String toDateValue=to.getAttribute("value");
        Assert.assertTrue(fromDate.equals(fromDateValue)&&toDate.equalsIgnoreCase(toDateValue));
    }


    @AfterClass
    public void tearDown(){
        sleep(2);
        driver.close();
    }





    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
