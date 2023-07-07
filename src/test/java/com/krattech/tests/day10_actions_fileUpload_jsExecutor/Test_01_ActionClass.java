package com.krattech.tests.day10_actions_fileUpload_jsExecutor;

import com.krattech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test_01_ActionClass {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverOver() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        Thread.sleep(2000);
        WebElement hoverPara = driver.findElement(By.id("hoverpara"));

       // Actions actions=new Actions(driver);

        actions.moveToElement(hoverPara).perform();

        WebElement text=driver.findElement(By.id("hoverparaeffect"));
        System.out.println("text.getText() = " + text.getText());

    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement drag = driver.findElement(By.cssSelector("div#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("div#droppable"));

        Thread.sleep(2000);
     //   Actions actions=new Actions(driver);

      //  actions.dragAndDrop(drag,drop).perform();
        actions.moveToElement(drag).clickAndHold().moveToElement(drop).release().build().perform();

        Thread.sleep(2000);

        System.out.println("drop.getText() = " + drop.getText());

    }

    @Test
    public void doubleClick(){

        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.cssSelector("button#clicker"));

        actions.doubleClick(clicker).perform();

        actions.moveToElement(clicker,5,5).click().perform();  //----> 5 pixel sağa 5 pixel aşağıya

    }

    @Test
    public void actionsFillForm(){
        driver.get("https://www.krafttechexlab.com/forms/elements");
        WebElement firstElement = driver.findElement(By.cssSelector("[name='text']"));

        actions.click(firstElement)
                .sendKeys("Ahmet Ay"+ Keys.TAB)
                .sendKeys("ahmetay@ahmet.com"+Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys("02522525222"+Keys.TAB+Keys.TAB)
                .sendKeys("01222022"+Keys.TAB)
                .sendKeys("1212p"+Keys.TAB+Keys.TAB)
                .sendKeys("Batch 4 burdaydı"+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB)
                .sendKeys("aaaa@aaa.com"+Keys.TAB)
                .sendKeys("123456"+Keys.TAB)
                .sendKeys("No comment"+Keys.TAB+Keys.TAB+Keys.ENTER).perform();

        WebElement result = driver.findElement(By.tagName("pre"));
        System.out.println("result.getText() = " + result.getText());
    }

    @Test
    public void rightClickOpenNewWindow() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        Thread.sleep(2000);

        WebElement evilTesterPage= driver.findElement(By.linkText("EvilTester.com"));

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(evilTesterPage)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        ArrayList<String> tab=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
}
