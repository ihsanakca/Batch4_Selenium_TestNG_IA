package com.krafttech.tests.day10_actions_fileUpload_jsExecutor;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Test_02_FileUpload {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void fileUpload(){

        driver.get("https://demoqa.com/upload-download");

        WebElement uploadFile = driver.findElement(By.id("uploadFile"));
        uploadFile.sendKeys("C:\\Users\\ihsan\\OneDrive\\Masaüstü\\ddd.txt");

        String fileName="ddd.txt";
        WebElement loadedFile = driver.findElement(By.cssSelector("#uploadedFilePath"));

        Assert.assertTrue(loadedFile.getText().contains(fileName));

    }

    @Test
    public void systemProperties(){
        Properties properties = System.getProperties();
      //  properties.list(System.out);

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
    }

    @Test
    public void fileUpload2(){
        driver.get("https://demoqa.com/upload-download");

        WebElement uploadFile = driver.findElement(By.id("uploadFile"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/ggg.txt";

        String fullPath=projectPath+"/"+filePath;

        uploadFile.sendKeys(fullPath);

        String fileName="ggg.txt";
        WebElement loadedFile = driver.findElement(By.cssSelector("#uploadedFilePath"));

        Assert.assertTrue(loadedFile.getText().contains(fileName));

    }

}
