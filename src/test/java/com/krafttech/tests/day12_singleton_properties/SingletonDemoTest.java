package com.krafttech.tests.day12_singleton_properties;

import org.testng.annotations.Test;

public class SingletonDemoTest {

    @Test
    public void test1(){

        String s1 = SingletonDemo.getDriver();
        System.out.println("s1 = " + s1);

        String s2 = SingletonDemo.getDriver();
        System.out.println("s2 = " + s2);

        String s3 = SingletonDemo.getDriver();
        System.out.println(s3);
    }

    @Test
    public void test2(){

        String s1 = "Ahmet";
        s1=s1.replace("h","z");

    }
}
