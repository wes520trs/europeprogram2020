package com.unitedcoder.regression.uitest.testngframework;

import com.unitedcoder.cubecartautomation.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultListener extends TestBase implements ITestListener {

    static List<ITestNGMethod> passedTest=new ArrayList<>();
    static List<ITestNGMethod> failedTest=new ArrayList<>();
    static List<ITestNGMethod> skippedTest=new ArrayList<>();
    ScreenShotUtility screenShotUtility=new ScreenShotUtility();

    public void onTestSuccess(ITestResult result) {
        passedTest.add(result.getMethod());
        System.out.println("Total passed test: "+passedTest.size());
    }

    public void onTestFailure(ITestResult result) {
        failedTest.add(result.getMethod());
        System.out.println("Total failed test: "+failedTest.size());
        screenShotUtility.takeScreenShot(result.getMethod().getMethodName(),
                (WebDriver)result.getTestContext().getAttribute("myDriver"));
        System.out.println("context of Result Class driver is: "+result.getTestContext().getAttribute("myDriver").toString());
    }

    public void onTestSkipped(ITestResult result) {
        skippedTest.add(result.getMethod());
        System.out.println("Total skipped test: "+skippedTest.size());
    }
}
