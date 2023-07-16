package com.krafttech.tests.day04_basic_locators;

import com.github.javafaker.Faker;
import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicLocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        /**
         * task
         * open a chrome browser
         * navigate to https://www.krafttechexlab.com/login
         * locate email box with id and send a full name by using java faker to the box
         * locate email box with name and clear current name and send a new full name by using java faker to the box
         * locate login button with tag name and click the button
         * locate Remember me element with class name and get the text of element and print it
         * locate Create an account link with link text and click it
         * locate Log in link with partial link text with "Log" text and click it
         */

        Faker faker = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();


        driver.navigate().to("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(faker.name().fullName());
        Thread.sleep(2000);
        WebElement emailBox2 = driver.findElement(By.name("email"));
        emailBox2.clear();
        emailBox2.sendKeys(faker.name().nameWithMiddle());
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(2000);
        WebElement rememberMe = driver.findElement(By.className("form-check-label"));
        System.out.println("rememberMe.getText() = " + rememberMe.getText());

        WebElement createAnAccount = driver.findElement(By.linkText("Create an account"));
        createAnAccount.click();
        Thread.sleep(2000);
        WebElement logInLink = driver.findElement(By.partialLinkText("Log"));
        logInLink.click();
        Thread.sleep(2000);
        driver.close();

    }
}
