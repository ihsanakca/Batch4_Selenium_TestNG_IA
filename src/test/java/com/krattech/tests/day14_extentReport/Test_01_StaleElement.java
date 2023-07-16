package com.krattech.tests.day14_extentReport;

import com.krattech.utilities.ConfigurationReader;
import com.krattech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.CacheRequest;

public class Test_01_StaleElement {

    @Test
    public void test1() {
        /**
         * go to kraft login page
         * enter your email and pass
         * refresh page
         * enter email and pass again
         * click login
         * enter the web page
         *
         * how to handle stale element problem...
         * stale element hatasını nasıl çözeriz..
         */


        WebDriver driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("yourPassword"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[text()='Login']"));

        email.sendKeys(ConfigurationReader.get("userEmail"));
        password.sendKeys(ConfigurationReader.get("password"));

        driver.navigate().refresh();

        try {
            email.sendKeys(ConfigurationReader.get("userEmail"));
            password.sendKeys(ConfigurationReader.get("password"));
        } catch (Exception e) {
            email = driver.findElement(By.id("email"));
            password = driver.findElement(By.id("yourPassword"));
            loginBtn = driver.findElement(By.xpath("//*[text()='Login']"));

            email.sendKeys(ConfigurationReader.get("userEmail"));
            password.sendKeys(ConfigurationReader.get("password"));
            loginBtn.click();

            e.printStackTrace();
        }

        driver.quit();
    }
}
