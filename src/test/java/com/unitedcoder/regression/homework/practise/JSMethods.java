package com.unitedcoder.regression.homework.practise;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class JSMethods {

    public static void changeElementColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
        sleep(1);
    }

    public static void highLightElement(WebElement element, WebDriver driver){
        String backGroundColor=element.getCssValue("backgroundColor");
        for (int i=0; i<2; i++){
            changeElementColor("blue",element,driver);
            changeElementColor(backGroundColor,element,driver);
            changeElementColor("red",element,driver);
        }
    }

    public static void elementBorder(WebElement element, WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='4px solid red'", element);
    }

    public static void takeScreenShot(String fileName, WebDriver driver){
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File screenShotFile=screenshot.getScreenshotAs(OutputType.FILE);
        String folder="screenshot";
        DateTime dateTime=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yy-MM-dd-hh-mm");
        String timeStamp=dateTime.toString(formatter);
        fileName=fileName+"."+timeStamp;
        File finalFile=new File(folder+File.separator+fileName+".png");
        try {
            FileUtils.copyFile(screenShotFile,finalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTitle(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String title=js.executeScript("return document.title").toString();
        return title;
    }

    public static void generateAlert(WebDriver driver, String text){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("alert('"+text+"')");
    }

    public static void scrollToElementAppears(WebElement element, WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
