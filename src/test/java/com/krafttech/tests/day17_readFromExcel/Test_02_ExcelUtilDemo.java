package com.krafttech.tests.day17_readFromExcel;

import com.krafttech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Test_02_ExcelUtilDemo {

    @Test
    public void test1(){
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam1");

        System.out.println("excelUtil.rowCount() = " + excelUtil.rowCount());

        List<String> columnsNames = excelUtil.getColumnsNames();
        System.out.println("columnsNames = " + columnsNames);

        List<Map<String, String>> dataList = excelUtil.getDataList();
        System.out.println("dataList.get(2).get(\"Your Name\") = " + dataList.get(2).get("Your Name"));

        String[][] dataArrayWithoutFirstRow = excelUtil.getDataArrayWithoutFirstRow();
        System.out.println("dataArrayWithoutFirstRow[2][1] = " + dataArrayWithoutFirstRow[2][1]);
    }

}
