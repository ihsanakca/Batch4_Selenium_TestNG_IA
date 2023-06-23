package com.krattech.tests.day06_testNG_intro;

import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test_1_TestNG_FirstClass {

    /**
     1- Navigate to url: http://zero.webappsecurity.com/index.html
     2- click Signin
     2- Username=username, Password=password
     3- click submit
     4- navigate back
     5- click "Checking Account Activity"
     6- click "Transfer Funds"
     7- Get the value of required attribute of amount box and print it.
     8- click continue button
     9- try to get the message of warning which appers on the amount box...("Lütfen bu alanı doldurun") if u can, print it too...
     */

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/index.html");

        driver.findElement(By.id("signin_button")).click();

    }
}
