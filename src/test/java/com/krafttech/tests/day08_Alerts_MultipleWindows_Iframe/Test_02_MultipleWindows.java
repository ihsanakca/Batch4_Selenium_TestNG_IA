package com.krafttech.tests.day08_Alerts_MultipleWindows_Iframe;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Test_02_MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        /**
         *navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click Basic Ajax in new page
         * switch to new opened page
         * verify that the page title is "Test Page For Basic Ajax Example"
         * verify that the new page's url is different
         */

        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Basic Ajax in new page")).click();
        Thread.sleep(2000);

        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();

        System.out.println("currentTab = " + currentTab);
        System.out.println("tabs = " + tabs);

        for (String tab : tabs) {
            if (!currentTab.equals(tab)){
                driver.switchTo().window(tab);
                break;
            }
        }

        String actualTitle= driver.getTitle();
        String expectedTitle="Test Page For Basic Ajax Example";

        Assert.assertEquals(actualTitle,expectedTitle);

        Assert.assertNotEquals(driver.getCurrentUrl(),"https://testpages.herokuapp.com/styled/windows-test.html");

        Thread.sleep(2000);

    }

    @Test
    public void test2() throws InterruptedException {
        /**
         * navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click all three links
         * switch to the page whose title is "Test Page For Element Attributes"
         * verify that the page title
         * verify that the new page's url is different
         */

        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Basic Ajax in new page")).click();
        driver.findElement(By.linkText("Attributes in new page")).click();
        driver.findElement(By.linkText("Alerts In A New Window From JavaScript")).click();
        Thread.sleep(2000);

        Set<String> tabs = driver.getWindowHandles();

        String targetTitle="Test Page For Element Attributes";

        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals(targetTitle)){
                break;
            }
        }

        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,targetTitle);

        Assert.assertFalse(driver.getCurrentUrl().equals("https://testpages.herokuapp.com/styled/windows-test.html"));

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    }
}
