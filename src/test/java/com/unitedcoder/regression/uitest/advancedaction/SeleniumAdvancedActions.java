package com.unitedcoder.regression.uitest.advancedaction;

import com.unitedcoder.regression.uitest.testngframework.ScreenShotUtility;
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

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumAdvancedActions {
    WebDriver driver;
    int timeout = 10;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://jqueryui.com/droppable/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(draggable, droppable).build().perform();
//        below is the same action with dragAndDrop
//        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        // drag by two step
//        actions.dragAndDropBy(draggable,80,0).dragAndDrop(draggable,droppable).build().perform();
        Thread.sleep(2000);
        Assert.assertTrue(droppable.getText().equalsIgnoreCase("Dropped!"));
    }

    @Test
    public void classicMenuTest() {

        driver.get("https://jqueryui.com/menu/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frame);
        WebElement musicMenu = driver.findElement(By.id("ui-id-9"));
        waitForElementPresent(musicMenu);
        Actions actions = new Actions(driver);
        actions.moveToElement(musicMenu).build().perform();
        WebElement rockMenu = driver.findElement(By.id("ui-id-10"));
        waitForElementPresent(rockMenu);
        actions.moveToElement(rockMenu).build().perform();
        WebElement classic = driver.findElement(By.id("ui-id-12"));
        waitForElementPresent(classic);
        Assert.assertTrue(classic.isDisplayed());
    }

    @Test
    public void multipleWindowTest() throws InterruptedException {
        driver.get("http://forum.seleniummaster.com/testfiles/windowtest.html");
        WebElement openWindowLink = driver.findElement(By.linkText("Open Window"));
        String currentWindow = driver.getWindowHandle();
        waitForElementPresent(openWindowLink);
        Thread.sleep(3000);
        openWindowLink.click();
        for (String childWindow : driver.getWindowHandles()) {
            System.out.println("window name is: " + childWindow);
            if (!childWindow.equalsIgnoreCase(currentWindow)) {
                driver.switchTo().window(childWindow);
                WebElement confirmButton = driver.findElement(By.name("Abutton1"));
                waitForElementPresent(confirmButton);
                Assert.assertTrue(confirmButton.isDisplayed());
            }
        }
    }

    @Test
    public void iterateMultipleWindowTest() throws InterruptedException {
        driver.get("http://forum.seleniummaster.com/testfiles/windowtest.html");
        WebElement openWindowLink = driver.findElement(By.linkText("Open Window"));
        waitForElementPresent(openWindowLink);
        Thread.sleep(3000);
        openWindowLink.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String firstWindow = iterator.next(); //Current window, next is starting from index 0, not 1
        System.out.println("first window is: " + firstWindow);
        String newWindow = iterator.next();
        System.out.println("new window is: " + newWindow);
        driver.switchTo().window(newWindow);
        WebElement confirmButton = driver.findElement(By.name("Abutton1"));
        waitForElementPresent(confirmButton);
        Assert.assertTrue(confirmButton.isDisplayed());
    }

    @Test(description = "This test is for select multiple elements")
    public void selectableItems() throws InterruptedException {
        driver.get("https://jqueryui.com/selectable/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        List<WebElement> items = driver.findElements(By.xpath("//ol[@id=\"selectable\"]/li\n"));
        int itemCount = items.size();
        int counter = 0;
        for (WebElement eachItem : items) {
            waitForElementPresent(eachItem);
            eachItem.click();
            counter++;
            Thread.sleep(2000);
        }
        System.out.println("counter=" + counter);
        Assert.assertTrue(itemCount == counter);
    }

    @Test(description = "This test is for multiple link")
    public void multipleLinkTest() throws InterruptedException {

        driver.get("https://jqueryui.com/selectable/");

        List<WebElement> links = driver.findElements(By.xpath("//div[@id='sidebar']//a"));
        List<String> urls = new ArrayList<>();
        int itemCount = links.size();
        int counter = 0;
        for (WebElement eachLink : links) {
            String url = eachLink.getAttribute("href");
            urls.add(url);
        }
        for (String url : urls) {
            driver.navigate().to(url);
            Thread.sleep(2000);
            ScreenShotUtility shotUtility = new ScreenShotUtility();
            shotUtility.takeScreenShot(url.replace("https://jqueryui.com/", "").
                    replaceAll("/", ""), driver);
            counter++;
            if (counter >= 10)
                break;
        }
        Assert.assertTrue(counter > 1);
    }

    @Test
    public void verifyStatusCode() throws IOException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for (WebElement eachLink : links) {
            String url = eachLink.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode > 400) {
                System.out.println("The link with Text " + eachLink.getText() +
                        " is broken link " + " With response code: " + responseCode);
            }
        }
    }


    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
