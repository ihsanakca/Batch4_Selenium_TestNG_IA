package com.krattech.tests.day05_XPathAndCSS;

import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class Test_01_CssLoc {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.krafttechexlab.com/login");

        driver.findElement(By.cssSelector("input#email")).sendKeys("mgezer@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.sendKeys("Mg12345678"+ Keys.ENTER);
        Thread.sleep(2000);
/*
        WebElement loginBtn = driver.findElement(By.cssSelector("button"));
       // loginBtn.click();
        loginBtn.submit();  //emter tuşuna basma işlevi görür..
*/
        Thread.sleep(2000);


        driver.quit();


    }
}
