package com.krattech.tests.day08_Alerts_MultipleWindows_Iframe;

import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_03_Iframes {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void iframeWithIdAndWebElement() {

        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by id
         * take the "iFrame" heading and print it
         * return to main html
         * switch to second frame by web element
         * take the "Nested Page Example" heading and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        driver.switchTo().frame("thedynamichtml");
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().parentFrame();

        WebElement secondFrame = driver.findElement(By.xpath("//iframe[@src='frames/frames-header.html']"));

        driver.switchTo().frame(secondFrame);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }

    @Test
    public void iframeWithIndex() {

        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by index
         * take the "iFrame" heading and print it
         * return to main html  (default content)
         * switch to second frame by index
         * take the "Nested Page Example" heading and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().defaultContent();

        WebElement secondFrame = driver.findElement(By.xpath("//iframe[@src='frames/frames-header.html']"));

        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }

    @Test
    public void nestedFrames() {

        /**
         * navigate to https://testpages.herokuapp.com/styled/frames/frames-test.html
         * switch to top frame by name attribute
         * take the "Nested Frames Example" heading and print it
         * return to main html
         * switch to left frame by name attribute
         * take the "Left" heading and print it
         * return to main html
         * switch to middle frame by index
         * take the "Middle" heading and print it
         * return to main html
         * switch to right frame by web element
         * take the "Right" heading and print it
         * return to main html
         * switch to footer frame by index
         * take the "EvilTester.com" link text and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");

        driver.switchTo().frame("top");
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("left");
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().defaultContent();

        WebElement rightFrame = driver.findElement(By.cssSelector("[src='get-list?name=Right&list=50']"));
        driver.switchTo().frame(rightFrame);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame(4);
        System.out.println(driver.findElement(By.linkText("EvilTester.com")).getText());

    }

    @Test
    public void nestedFrame2() {
        /**
         * navigate to https://demoqa.com/nestedframes
         * switch to parent frame by id
         * take the "Parent frame" heading and print it
         * switch to child frame by index
         * take the "Child frame" heading and print it
         * switch to parent frame related method
         * take the "Parent frame" heading and print it again
         */

        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
}
/**
 * No Such Element Exception aldığımızda
 * 1- Locator might be wrong or dynamic or not correct-Locator/konumlandırıcı
 yanlış veya dinamik olabilir veya doğru olmayabilir.
 * 2- Not enough wait time - Yeterli bekleme süresi yok
 * 3- There is a frame or iframe -Bir frame veya iframe var !
 - Html'de bir HTML sayfasının içinde bir diğer HTML yapısı olabilir.
 - Bu, <iframe> veya <frame> etiketi ile sağlanır.
 - Frame varsa, selenyum frame içinde ne olduğunu kontrol edemez.
 - Önce iframe'i değiştirmeliyiz. (switchTo() metodu ile)
 - iframe'e geçtiğimizde, selenium biz geri değiştirene kadar ana HTML sayfasını ve diğer frame yapılarını göremez,
 - Bir seferde sadece bir frame değiştirebiliriz ve torunlara doğrudan geçilmez.
 - kardeş/sibling arası geçiş/switch olmaz sadece ebeveynden çocuğa/parentchild.
 - child frameden bir üste yani parenta switchTo().parentFrame(); ile geçeriz.
 - en üstteki ana HTML (default) yapısına ise switchTo().defaultContent(); ile geçebiliriz.
 - bulunduğumuz frame'den bir üste ya da en üste (ana HTML) geçiş vardır. iki, üç vb. üstlere geçiş yoktur.
 */
