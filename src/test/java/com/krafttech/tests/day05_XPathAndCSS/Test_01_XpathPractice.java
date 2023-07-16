package com.krafttech.tests.day05_XPathAndCSS;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_01_XpathPractice {
    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    public static void main(String[] args) throws InterruptedException {

        /**
         * navigate to https://demowebshop.tricentis.com/desktops
         * click on Simple Computer Add to cart button by using item name in the locator
         * close driver
         */


        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/desktops");

        Thread.sleep(2000);

        //navigateTabMenu("Jewelry");

        Thread.sleep(2000);

      //  addToCart("Create Your Own Jewelry");

        navigateAndAdd("Jewelry","Create Your Own Jewelry");

        Thread.sleep(2000);

        driver.close();

    }

    public static void addToCart(String productName) throws InterruptedException {
        WebElement product = driver.findElement(By.xpath("//a[text()='" + productName + "']/ancestor::div[@*='details" +
                "']//input"));
        product.click();
        Thread.sleep(2000);
    }

    public static void navigateTabMenu(String tabName){
        driver.findElement(By.partialLinkText(tabName)).click();

    }


    public static void navigateAndAdd(String tabName, String productName) throws InterruptedException {
        driver.findElement(By.partialLinkText(tabName)).click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//a[text()='" + productName + "']/ancestor::div[@*='details" +
                "']//input"));
        product.click();
    }


}
