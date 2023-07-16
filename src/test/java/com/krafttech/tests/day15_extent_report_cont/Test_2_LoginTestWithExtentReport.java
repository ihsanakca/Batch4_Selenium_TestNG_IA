package com.krafttech.tests.day15_extent_report_cont;

import com.krafttech.pages.LoginPage;
import com.krafttech.tests.TestBase;
import com.krafttech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_2_LoginTestWithExtentReport extends TestBase {

    @Test
    public void positiveLoginTest_1(){

        extentLogger= report.createTest("TC001 Login Test");
        LoginPage loginPage=new LoginPage();

        extentLogger.info("Navigate to "+ConfigurationReader.get("url"));
        extentLogger.info("login with valid credentials");

        loginPage.userEmailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        extentLogger.info("Verify succes login with url");

        String expectedUrl="https://www.krafttechexlab.com/index";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
