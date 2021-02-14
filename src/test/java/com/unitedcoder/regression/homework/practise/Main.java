package com.unitedcoder.regression.homework.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {

    WebDriver driver;
    int timeout;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com");
    }

    @Test
    public void scrollToElement(){
        WebElement menu=driver.findElement(By.linkText("Learn R"));
        JSMethods.scrollToElementAppears(menu,driver);
        JSMethods.sleep(2);
    }

    @Test
    public void highLightElement(){
        WebElement tutorialsLink=driver.findElement(By.cssSelector("#navbtn_tutorials"));
        JSMethods.highLightElement(tutorialsLink,driver);
    }

    @Test
    public void showElement(){
        WebElement tutorialsLink=driver.findElement(By.cssSelector("div.w3-bar"));
        JSMethods.elementBorder(tutorialsLink,driver);
        JSMethods.sleep(2);
        JSMethods.takeScreenShot("w3school",driver);
    }

    @Test
    public void getTitle(){
        System.out.println("web page title is: " + JSMethods.getTitle(driver));
    }

    @Test
    public void alert(){
        JSMethods.generateAlert(driver,"please accept to continue.");
        JSMethods.sleep(2);
        driver.switchTo().alert().accept();
        JSMethods.sleep(2);
    }



    @AfterClass
    public void tearDown(){
        JSMethods.sleep(2);
        driver.close();
//        driver.quit();
    }

}
