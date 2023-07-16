package com.krafttech.tests.day11_webTables;

import com.krafttech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_01_WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void webTablesTest(){
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the data of specific cell by using row and column numbers
         */

        driver.get("https://the-internet.herokuapp.com/tables");

        int numberOfColumn=getNumberOfColumns();
        int numberOfRow=getNumberOfRows();

        String dataOfCellStr=dataOfCell(2,3);
       // System.out.println("dataOfCell = " + dataOfCellStr);

        for (int i = 1; i <= numberOfRow; i++) {
            for (int j = 1; j <numberOfColumn; j++) {
                System.out.print(dataOfCell(i, j)+" ");
            }
            System.out.println();
        }


    }

    private String dataOfCell(int row,int column) {
        String xpath="//table[@id='table1']/tbody/tr["+row+"]/td["+column+"]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        return cell.getText();
    }

    private int getNumberOfRows() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return rows.size();
    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return columns.size();
    }
}
