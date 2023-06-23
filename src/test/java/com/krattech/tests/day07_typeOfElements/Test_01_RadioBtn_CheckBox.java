package com.krattech.tests.day07_typeOfElements;

import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_01_RadioBtn_CheckBox {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {

        /**
         * http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate option 3 element
         * verify that the element is selected
         * click the element
         * verify that the element is NOT selected
         *
         * locate option 2
         * verify that the element is NOT selected
         * click the element
         * verify that the element is selected
         */



        WebElement option3 = driver.findElement(By.cssSelector("[value='option-3']"));
        Assert.assertTrue(option3.isSelected(),"verify that option 3 is selected");
        option3.click();
        Thread.sleep(2000);
        Assert.assertFalse(option3.isSelected());

        WebElement option2 = driver.findElement(By.cssSelector("[value='option-2']"));
        Assert.assertFalse(option2.isSelected(),"verify that option 2 is NOT selected");
        option2.click();
        Thread.sleep(2000);
        Assert.assertTrue(option2.isSelected());
    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        /**
         * locate yellow element
         * verify that the element is NOT selected
         * click the element
         * verify that the element is selected
         * locate blue element
         * verify that the element is displayed
         * click the element
         * verify that the element is selected
         */

        WebElement yellow = driver.findElement(By.cssSelector("[value='yellow']"));
        assertFalse(yellow.isSelected());
        yellow.click();
        Thread.sleep(2000);
        assertTrue(yellow.isSelected());

        WebElement blue = driver.findElement(By.cssSelector("[value='blue']"));
        assertTrue(blue.isDisplayed());
        blue.click();
        Thread.sleep(2000);
        assertTrue(blue.isSelected());
        assertFalse(yellow.isSelected());

        WebElement cabbage = driver.findElement(By.cssSelector("[value='cabbage']"));
        assertFalse(cabbage.isSelected());
        assertFalse(cabbage.isEnabled());



    }
}
