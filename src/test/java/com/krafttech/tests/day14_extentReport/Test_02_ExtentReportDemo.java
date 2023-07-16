package com.krafttech.tests.day14_extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_02_ExtentReportDemo {
    //Bu class rapor oluşturmak ve raporla ilgili metadata'yı tanımlamak için kullanılır.(Rapora özel)
    ExtentReports report;
    //Bu class raporumuzun formatını html olarak düzenler.
    ExtentHtmlReporter htmlReporter;
    //Her test ile ilgili log kayıtlarını tutmamızı sağlar (Teste özel)
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //class'ı başlatalım.
        report=new ExtentReports();

        //raporun kayıt edileceği yeri belirleyelim..
        String projectPath = System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        //HTML raporumuzu path ile oluşturalım
        htmlReporter=new ExtentHtmlReporter(reportPath);

        //HTML raporumuzu report nesnesiyke ilişkilendirelim...
        report.attachReporter(htmlReporter);

        //raporun başlığını düzenleyelim
        htmlReporter.config().setReportName("Smoke Test");

        //raporun metadatasını düzenleyelim
        report.setSystemInfo("Enviroment","UAT");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Umut İhsan");
        report.setSystemInfo("PO","Onur Bey");

    }

    @Test
    public void testName() {
        //mevcut testimizin ismini girelim
        extentLogger=report.createTest("Demo Test");

        //test adımlarımızı girelim
        extentLogger.info("Browser'ı aç");
        //code here
        extentLogger.info("url git");
        //code here
        extentLogger.info("emaili gir");
        //code here
        extentLogger.info("şifreyi gir");
        //code here
        extentLogger.info("login ol");
        //code here

        //eğer test buraya kadar gelmişse o testi "GEÇTİ" olarak belirleyelim.
        extentLogger.pass("Passed..!");

    }

    @AfterMethod
    public void tearDown(){
        report.flush();
    }
}
