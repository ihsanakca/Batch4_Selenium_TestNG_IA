package com.krattech.tests.day01_automationIntro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_01_OpenBrowser {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com");
        driver.get("https://facebook.com");

        //sayfanın title ı alalım

       String actualTitle= driver.getTitle();
       String expectedTitle="Facebook – log in or sign up";

       if (actualTitle.equals(expectedTitle)){
           System.out.println("Pass");
       }else{
           System.out.println("Failed");
       }
        WebDriver driver1=new ChromeDriver();
        driver1.get("https://www.google.com");  ///driver quit() aynı driver üzerinde açılan tabları kapatır. driver1 bu örnekte kapanmaz

       driver.quit();


    }
}
