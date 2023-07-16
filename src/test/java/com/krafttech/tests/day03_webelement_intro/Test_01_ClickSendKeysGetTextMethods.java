package com.krafttech.tests.day03_webelement_intro;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_01_ClickSendKeysGetTextMethods {


    public static void main(String[] args) throws InterruptedException {
        /**
         * Open chore browser
         * navigate to https://www.amazon.com/
         * write "Java" to the search bar
         * click search button
         * get result for text
         * verify that the text contains "Java"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java");
        Thread.sleep(2000);

        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();
        Thread.sleep(2000);

        WebElement resultElement = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualText = resultElement.getText();
        String expectedText="Java";
        Thread.sleep(2000);

        if (actualText.contains(expectedText)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }


        driver.quit();
    }
}
