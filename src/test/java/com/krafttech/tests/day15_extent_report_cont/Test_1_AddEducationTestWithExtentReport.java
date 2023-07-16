package com.krafttech.tests.day15_extent_report_cont;

import com.krafttech.pages.AddEducationPage;
import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPage;
import com.krafttech.pages.UserProfilePage;
import com.krafttech.tests.TestBase;
import com.krafttech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test_1_AddEducationTestWithExtentReport extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddEducationPage addEducationPage;

    @Test
    public void addEducationTest(){
        /**
         1-open chrome browser
         2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
         3-login with parameterized/non-parameterized method
         4-Assert successful login with user name
         5-Navigate to My Profile with related method
         6-Verify that User Profile page is displayed
         7-Navigate to Add Education tab with related method
         8-Verify that add education page is displayed
         9-Fill the form with parameterized method (use actions class)
         10-Verify that added education record can be seen at user profile page... (assert with school name)
         11-Delete last added education record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        extentLogger=report.createTest("TC007 Adding New Education Test");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addEducationPage=new AddEducationPage();

        extentLogger.info("Navigate to "+ConfigurationReader.get("url"));
        extentLogger.info("login with non-parameterized method");
        loginPage.login();

        extentLogger.info("Assert successful login with user name");
        String actualUserName = dashboardPage.getElementText(dashboardPage.userName);
        String expectedUserName= ConfigurationReader.get("userName");
        assertEquals(actualUserName,expectedUserName);

        extentLogger.info("Navigate to My Profile with related method");
        dashboardPage.navigateToTabsAndModules(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        extentLogger.info("Navigate to Add Education tab with related method");
        userProfilePage.navigateEditProfileTabs("Add Education");

        extentLogger.info("Verify that add education page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(addEducationPage.addEducationButton)).isDisplayed());

        extentLogger.info("Fill the form with parameterized method (use actions class)");
        addEducationPage.fillingEducationForm();

        extentLogger.info("Verify that added education record can be seen at user profile page... (assert with school name)");
        String actualEducationRecord = userProfilePage.addedEducation("Kraft");
        String expectedEducationRecord="Kraft";
        Assert.assertEquals(actualEducationRecord,expectedEducationRecord);

        extentLogger.info("Delete last added education record");
        userProfilePage.deleteEducationRecord("Kraft");

        extentLogger.pass("Passed...!");


    }
}
