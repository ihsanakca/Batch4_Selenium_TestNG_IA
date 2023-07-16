package com.krafttech.tests.day13_pom_1;

import com.krafttech.pages.LoginPage;
import com.krafttech.tests.TestBase;
import com.krafttech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_1_LoginTest extends TestBase {

    @Test
    public void positiveLoginTest_1(){

        LoginPage loginPage=new LoginPage();

        loginPage.userEmailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        String expectedUrl="https://www.krafttechexlab.com/index";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Test
    public void positiveLoginTest_2(){

        LoginPage loginPage=new LoginPage();

        loginPage.inputs.get(0).sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.inputs.get(1).sendKeys(ConfigurationReader.get("password"));
        loginPage.inputs.get(2).click();

        String expectedUrl="https://www.krafttechexlab.com/index";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
