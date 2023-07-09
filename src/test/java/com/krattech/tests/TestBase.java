package com.krattech.tests;

import com.krattech.utilities.ConfigurationReader;
import com.krattech.utilities.Driver;
import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}
