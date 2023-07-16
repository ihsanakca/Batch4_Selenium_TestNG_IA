package com.krafttech.tests.day17_readFromExcel;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPage;
import com.krafttech.tests.TestBase;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_04_LoginTestWithDataProvider extends TestBase {

    @DataProvider
    public Object[][] userData(){
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam1");
        String[][] data = excelUtil.getDataArrayWithoutFirstRow();
        return data;
    }

    @Test(dataProvider = "userData")
    public void positiveLoginTest_1(String yourName,String yourEmail,String password){

        extentLogger= report.createTest("TC001 Login Test");
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();

        extentLogger.info("Navigate to "+ ConfigurationReader.get("url"));
        extentLogger.info("login with valid credentials");

        loginPage.userEmailBox.sendKeys(yourEmail);
        loginPage.passwordBox.sendKeys(password);
        loginPage.loginBtn.click();

        extentLogger.info("Verify success login with username");

        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName=yourName;

        Assert.assertEquals(actualUserName,expectedUserName);
    }
}
