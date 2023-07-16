package com.krafttech.tests.day17_readFromExcel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_03_DataProviderDemo {
    @DataProvider
    public Object[][] testData_1(){
        String [][] notes={
                {"Hasan Sarı","50","100"},
                {"Veysel Candan","80","90"},
                {"Hanife Kara","90","95"}
        };
        return notes;
    }

    @Test(dataProvider = "testData_1")
    public void testNotes_1(String ad,String vize, String finalNot){
        System.out.println(ad+" "+vize+" "+finalNot);
    }

    @DataProvider (name = "OgrenciSinavNotlari")
    public Object[][] testData_2(){
        Object [][] notes={
                {"Hasan Sarı",50,100},
                {"Veysel Candan",80,90},
                {"Hanife Kara",90,95}
        };
        return notes;
    }


    @Test(dataProvider = "OgrenciSinavNotlari")
    public void testNotes_2(String ad,int vize, int finalNot){
        System.out.println(ad+" "+vize+" "+finalNot+" Yıl Sonu Notu= "+((vize*0.4)+(finalNot*0.6)));
    }
}
