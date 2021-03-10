package com.unitedcoder.regression.browserutils;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class JenkinsBrowserMode {

    public boolean setHeadlessModeIfLinux(ChromeOptions chromeOptions) {
        String osName = System.getProperty("os.name");//get operating system type
        if (osName.toLowerCase().contains("linux")) {
            System.out.println("Using headless chrome driver");
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            chromeOptions.addArguments(Arrays.asList("--headless", "--disable-gpu"));
            chromeOptions.addArguments("window-size=1200,1100");
            return true;
        } else
            return false;
    }

    public boolean setHeadlessModeOnWindows(ChromeOptions chromeOptions) {
        System.out.println("Using headless chrome driver on Windows if headless=1");
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        chromeOptions.addArguments(Arrays.asList("--headless", "--disable-gpu"));
        chromeOptions.addArguments("window-size=1200,1100");
        return true;
    }


}
