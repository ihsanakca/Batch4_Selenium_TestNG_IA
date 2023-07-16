package com.krafttech.tests.day16_robotClass_softAssertion;

import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Test_01_RobotClass {

    @Test
    public void basicAuthentication() throws AWTException, InterruptedException {
        WebDriver driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/digest_auth");

        Robot robot=new Robot();

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

        WebElement element = driver.findElement(By.tagName("p"));
        String actualText = element.getText();
        String expectedText="Congratulations! You must have the proper credentials.";

        Assert.assertEquals(actualText,expectedText);

       // driver.quit();
    }

    @Test
    public void basicAuthenticationTest2(){
        WebDriver driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");

        WebElement element = driver.findElement(By.tagName("p"));
        String actualText = element.getText();
        String expectedText="Congratulations! You must have the proper credentials.";

        Assert.assertEquals(actualText,expectedText);

        driver.quit();
    }

    @Test
    public void test2() throws AWTException {

        WebDriver driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));

        Robot robot=new Robot();

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);    //--- buyuk a yazmak icin
        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        driver.quit();
    }
}
