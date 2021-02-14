package com.unitedcoder.regression.uitest.advancedaction;

import com.unitedcoder.configutility.ApplicationConfig;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class JavaScriptMethods {

    public static void highLightElement(WebElement element,WebDriver driver){
        String backGroundColor=element.getCssValue("backgroundColor");
        for(int i=0;i<3;i++){
            changeElementColor("#D42D1B",element,driver);
            changeElementColor(backGroundColor,element,driver);
        }
    }

    public static void changeElementColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;//downcasting
        js.executeScript("arguments[0].style.backgroundColor= '"+color+"'",element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setElementBorder(WebElement element,WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='4px solid blue'",element);
    }
    public void takeScreenShot(String fileName, WebDriver driver){
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File screenShotFile=screenshot.getScreenshotAs(OutputType.FILE);
        String folder= ApplicationConfig.readConfigProperties("config.properties",
                "imagefolder");
        DateTime date=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SS");
        String timeStamp=date.toString(formatter);
        fileName=fileName+"."+timeStamp;
        File finalFile=new File(folder+File.separator+fileName+".png");
        try {
            FileUtils.copyFile(screenShotFile,finalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clickWithJS(WebElement element, WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
    }

    public static String getTitle(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String title=js.executeScript("return document.title").toString();
        return title;
    }

    public static void generateAlert(WebDriver driver, String message){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("alert('"+message+"')");
    }

    public static void scrollToElementAppears(WebElement element, WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrolltoView(true);",element);
    }



}
