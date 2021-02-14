package com.unitedcoder.regression.homework.practise;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.gecko.driver","c:\\webdriver\\geckodriver.exe");
        FirefoxOptions options=new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new FirefoxDriver(options);
        driver.get("https://jqueryui.com/");
    }

    @Test
    public void screenShot() throws IOException {
        TakesScreenshot screenshot=(TakesScreenshot)driver; //convert driver object to TakeScreenshot
        File srcFile=screenshot.getScreenshotAs(OutputType.FILE); //call getScreenShotAs method to create image file
        File destFile=new File("screenshot\\guruPractice.png"); //move image file to new destination
        FileUtils.copyFile(srcFile,destFile);
    }


    @AfterClass
    public void tearDown(){
        JSMethods.sleep(2);
        driver.close();
    }
}
