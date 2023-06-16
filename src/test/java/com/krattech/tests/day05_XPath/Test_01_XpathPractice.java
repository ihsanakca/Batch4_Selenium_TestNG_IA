package com.krattech.tests.day05_XPath;

import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_01_XpathPractice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();


        driver.get("https://www.krafttechexlab.com/login");

        WebElement form = driver.findElement(By.xpath("//form[@class='row g-3 needs-validation']"));
        System.out.println("form.getText() = " + form.getText());


    }
}
