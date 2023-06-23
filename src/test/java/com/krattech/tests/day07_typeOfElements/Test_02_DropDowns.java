package com.krattech.tests.day07_typeOfElements;

import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Test_02_DropDowns {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void withSelectTag() {

        /**
         * navigate to https://www.amazon.com/"
         * locate the dropdown menu nearby the search box
         * select the Baby department by using text then print the department name
         * select the Books department by using index then print the department name
         * select the Health & Household department by using value attribute then print the department name
         * get all options to a list
         * print all departments name
         * get the text of fifth element and verify that the text is Books
         */

        driver.get("https://www.amazon.com/");

        WebElement searchDropdownBox = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(searchDropdownBox);

        select.selectByVisibleText("Baby");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        select.selectByIndex(5);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        select.selectByValue("search-alias=hpc-intl-ship");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        List<WebElement> options = select.getOptions();

        options.forEach(option -> System.out.println(option.getText()));

        System.out.println("options.get(5).getText() = " + options.get(5).getText());

    }

    @Test
    public void withoutSelectTag() {
        /**
         * navigate to https://demoqa.com/select-menu
         * select Group 1, option 2 from first dropdown
         * click to the element
         * verify that the element text is "Group 1, option 2"
         */

        driver.get("https://demoqa.com/select-menu");

        WebElement dropMenu = driver.findElement(By.xpath("//div[text()='Select Option']"));
        dropMenu.click();

        WebElement group1Option2 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        System.out.println("group1Option2.getText() = " + group1Option2.getText());
        group1Option2.click();
        WebElement group1Option2_1 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        System.out.println("group1Option2_1.getText() = " + group1Option2_1.getText());


    }

    @Test
    public void staleElement() throws InterruptedException {


        driver.get("https://demoqa.com/select-menu");

        WebElement element = driver.findElement(By.xpath("//div[text()='Select Menu']"));
        System.out.println(element.getText());
        driver.navigate().refresh();
        Thread.sleep(4000);
        System.out.println(element.getText());  //stale elemet hatası verir..
    }
}
