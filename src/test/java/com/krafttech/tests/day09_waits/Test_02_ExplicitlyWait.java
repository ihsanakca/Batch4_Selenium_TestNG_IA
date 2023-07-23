package com.krafttech.tests.day09_waits;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Test_02_ExplicitlyWait {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void explicitlyWait_1() {

        /**
         * navigate to https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
         * click the Start button and wait until the One button will be activated
         * click the One button and wait until the Two button will be activated
         * click the Two button and wait until the Three button will be activated
         * verify that the "All Buttons Clicked" message is taken.
         */

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        WebDriverWait wait=new WebDriverWait(driver,10);

        WebElement startBtn = driver.findElement(By.id("button00"));
        wait.until(ExpectedConditions.elementToBeClickable(startBtn)).click();
      //  startBtn.click();

        WebElement oneBtn = driver.findElement(By.id("button01"));
        wait.until(ExpectedConditions.elementToBeClickable(oneBtn)).click();

        WebElement twoBtn = driver.findElement(By.id("button02"));
        wait.until(ExpectedConditions.elementToBeClickable(twoBtn)).click();

        WebElement threeBtn = driver.findElement(By.id("button03"));
       // wait.until(ExpectedConditions.elementToBeClickable(threeBtn)).click();
        new WebDriverWait(driver,12).until(ExpectedConditions.elementToBeClickable(threeBtn)).click();

        WebElement message = driver.findElement(By.id("buttonmessage"));

        String actualMessage= message.getText();
        String  expectedMessage="All Buttons Clicked";

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void explicitlyWait_2() {
        /**
         * Wait Task
         * navigate to https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
         * locate all buttons to a web element list (start, one, two, three) (findElements)
         * Let's click the buttons respectively
         * after the click to  the last button : "All Buttons Clicked" message should be seen at the page.
         * Note: Do not use Thread.sleep(), just use dynamic waits
         *
         *  https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html sayfasına gidelim
         *  bütün butonları bir list'e alalım (start, one, two, three) (findElements)
         *  butonlara sırasıyla tıklayalım
         *  son butona tıklandıktan sonra "All Buttons Clicked" mesajının ekrana geldiğini text ile doğrulayalım.
         *  Not: Thread.sleep() metodunu kullanmayalım sadece dinamik yani akıllı wait kullanalım...
         */
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        WebDriverWait wait=new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button"),4));
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));

        System.out.println("buttons.size() = " + buttons.size());


        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(1))).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(2))).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(3))).click();


        WebElement message = driver.findElement(By.id("buttonmessage"));

        String actualMessage= message.getText();
        String  expectedMessage="All Buttons Clicked";

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void explicitlyWait_3(){

        /**
         * eğer element henüz dom'da yoksa locate edemeyiz. hata alırız. bu durumlarda
         * wait metodlarına web element yerine By.locator göndermek çözüm olabilir.
         *
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click second link
         * click start button
         * use explicitly wait for the hello element and get the text (do not use any other wait)
         * verify that the element has the text of "Hello World!"
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebDriverWait wait=new WebDriverWait(driver,10);

        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

        WebElement hello= driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        System.out.println("hello.getText() = " + hello.getText());


    }

    @Test
    public void fluentWait() {
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click second link
         * click start button
         * use fluent wait for the hello element and get the text (do not use any other wait)
         * verify that the element has the text of "Hello World!"
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(driver -> driver.findElement(By.xpath("//h4[text()='Hello World!']")));
        System.out.println("element.getText() = " + element.getText());



    }
}