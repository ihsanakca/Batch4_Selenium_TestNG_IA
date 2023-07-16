package com.krafttech.tests.day16_robotClass_softAssertion;

import com.krafttech.pages.LocatorsLoginPage;
import com.krafttech.tests.TestBase;
import com.krafttech.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class Test_03_LoginTestWithLocatorInterface extends TestBase implements LocatorsLoginPage {

    @Test
    public void loginTest_1(){
        driver.findElement(emailBox_loc).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(passwordBox_loc).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(loginBtn_loc).click();
    }

    @Test
    public void loginTest_(){
       login();
    }
}
