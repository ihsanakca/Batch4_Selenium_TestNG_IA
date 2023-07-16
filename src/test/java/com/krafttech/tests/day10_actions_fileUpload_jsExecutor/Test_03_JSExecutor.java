package com.krafttech.tests.day10_actions_fileUpload_jsExecutor;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_03_JSExecutor {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void jsExecutorTest() throws InterruptedException {

        /**
         * navigate to https://www.krafttechexlab.com/forms/elements
         * scroll 1000 px down
         * change the Range position (actions ile)
         * change the Disabled Range position
         * scroll to the Number label
         * change the color from blue to red
         * select the Disabled Radio 3 button
         * scroll to the submit button
         * scroll again to the number label
         * scroll to the submit button and click on it
         * take the new page title and url
         * verify that the page title contains "Kraft"
         *
         * not: all steps should be done with js executor except step 3 and last one.
         */

        driver.get("https://www.krafttechexlab.com/forms/elements");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1000);");
        Thread.sleep(2000);

        WebElement customRange = driver.findElement(By.cssSelector("#customRange1"));
      //  js.executeScript("arguments[0].scrollIntoView();", customRange);
        actions.dragAndDropBy(customRange,-500,0).perform();
        Thread.sleep(2000);

        WebElement disabledRange = driver.findElement(By.id("disabledRange"));
        js.executeScript("arguments[0].setAttribute('min', '5')", disabledRange);
        Thread.sleep(2000);

        WebElement numberElement=driver.findElement(By.xpath("//label[text()='Number']"));
        js.executeScript("arguments[0].scrollIntoView();", numberElement);
        Thread.sleep(2000);

        WebElement exampleColorInput = driver.findElement(By.id("exampleColorInput"));
        js.executeScript("arguments[0].setAttribute('value', '#ff0000')", exampleColorInput);
        Thread.sleep(2000);

        WebElement disableRadioBtn = driver.findElement(By.id("gridRadios"));
        js.executeScript("arguments[0].setAttribute('checked', 'true')", disableRadioBtn);
        Thread.sleep(2000);

        WebElement submitBtn=driver.findElement(By.xpath("//button[text()='Submit Form']"));
        js.executeScript("arguments[0].scrollIntoView();", submitBtn);
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", numberElement);
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()",submitBtn);

        Thread.sleep(2000);

        String title = js.executeScript("return document.title;").toString();
        String url = js.executeScript("return document.URL;").toString();

        Assert.assertTrue(title.contains("Kraft"));
    }
}
