package com.krafttech.tests.day17_readFromExcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Test_01_ExcelDemo {

    public String readFromExcelCell(String path,String sheet,int row,int column) throws IOException {

        FileInputStream fis=new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheet(sheet);
        String cellValue = sheet1.getRow(row).getCell(column).getStringCellValue();
        return cellValue;
    }

    @Test
    public void test1() throws IOException {
        String s = readFromExcelCell("src/test/resources/LoginList.xlsx", "QaTeam2", 2, 1);
        System.out.println("s = " + s);
    }
}
