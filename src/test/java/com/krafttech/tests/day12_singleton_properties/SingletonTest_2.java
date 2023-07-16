package com.krafttech.tests.day12_singleton_properties;

import com.krafttech.utilities.Driver;
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
