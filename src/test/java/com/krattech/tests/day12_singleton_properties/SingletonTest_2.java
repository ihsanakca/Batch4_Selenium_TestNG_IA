package com.krattech.tests.day12_singleton_properties;

import com.krattech.utilities.Driver;
import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SingletonTest_2 {


    @Test
    public void test1() {

        // WebDriver driver = WebDriverFactory.getDriver("chrome");
        Driver.get().get("https://www.google.com.tr");
    }

    @Test
    public void test2() {
        // WebDriver driver = WebDriverFactory.getDriver("chrome");
        Driver.get().get("https://www.amazon.com.tr");
    }
}
