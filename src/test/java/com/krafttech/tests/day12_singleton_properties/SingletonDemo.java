package com.krafttech.tests.day12_singleton_properties;

public class SingletonDemo {

    private SingletonDemo(){}

    private static String driver;

    public static String getDriver(){
        if (driver==null){
            System.out.println("driver is null, assign it a value");
            driver="firefox";
        }else{
            System.out.println("it has value, just return current value");
        }
        return driver;
    }
}
