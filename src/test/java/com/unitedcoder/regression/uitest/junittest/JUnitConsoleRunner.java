package com.unitedcoder.regression.uitest.junittest;

import org.apache.commons.io.FileUtils;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.File;
import java.io.IOException;

public class JUnitConsoleRunner {
    // run junit test useing junit core package
    public static void main(String[] args) {
        StringBuilder testLog=new StringBuilder();
        testLog.append("<html><head><title>CubeCart test report</title>Cube Cart Test Report</head><body>");
        testLog.append("<p>").append("Test Excuted By: "+System.getProperty("user.name")).append("</p>");
        testLog.append("<p>").append("Test executed on: ").append(System.getProperty("os.name")).append("</p>");
        testLog.append("<table border=2 style='width:500; height:100'>");
        testLog.append("<tr><th>Total test</th><th>Total passed</th><th>Total failed</th></tr>");
        testLog.append("<tr>");
        Result testResult= JUnitCore.runClasses(JUnitTestDemo.class);
//        we can run two tests at the same time
//        Result testResult= JUnitCore.runClasses(JUnitTestDemo.class,CubeCartJUnitFramework.class);
//        Result testResult= JUnitCore.runClasses(JUnitTestDemo.class);
        int totalFailures=testResult.getFailureCount();
        int ignoredTest=testResult.getIgnoreCount();
        int totalPassed=testResult.getRunCount()-totalFailures;
//        if (totalFailures==0){
//            testLog.append("<tr bgcolor='#006600'>"); //green
//        }else
//            testLog.append("<tr bgcolor='#ff3300'>"); //red
        testLog.append("<td>").append(testResult.getRunCount()).append("</td>");
        testLog.append("<td bgcolor='#006600'>").append(totalPassed).append("</td>");
        testLog.append("<td bgcolor='#ff3300'>").append(totalFailures).append("</td>");
        testLog.append("</tr></table></body></html>");
        if (totalFailures==0){
            System.out.println("All tests passed.");
        }else {
            System.out.printf("%d tests failed",totalFailures);
        }
        for (Failure failedTest:testResult.getFailures()
             ) {
            testLog.append("<p> Failed Test: ").append(failedTest.getMessage());
            testLog.append(failedTest.getDescription().getMethodName()).append("</p>");
        }
//        FileUtils.writeStringToFile(new File("testdata\\cubecartreport.html"),testLog.toString());
        try {
            FileUtils.writeStringToFile(new File("testdata\\cubecartreport.html"),testLog.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
