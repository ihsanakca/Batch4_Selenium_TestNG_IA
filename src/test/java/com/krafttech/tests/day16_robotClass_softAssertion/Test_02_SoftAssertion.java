package com.krafttech.tests.day16_robotClass_softAssertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_02_SoftAssertion {

    SoftAssert softAssert=new SoftAssert();
    @Test
    public void test1(){
        softAssert.assertEquals(1,1);
        softAssert.assertEquals("aa","ab");
        softAssert.assertEquals(1,1);
        softAssert.assertTrue(0==0);
        softAssert.assertTrue(0==1);
        softAssert.assertFalse(1>2);
        softAssert.assertFalse(1<2);

        softAssert.assertAll("demo soft assertion");
    }
}
