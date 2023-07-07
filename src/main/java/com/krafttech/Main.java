package com.krafttech;

import java.util.*;

public class Main {
    public static void main(String[] args) {
/**
 *  //Which method would you use to learn if a string is a rotation of another string?
 *     //rotation of car->car, arc, rca
 *     //sarı->sarı,arıs,rısa,ısar  -->en baştaki harfin en sona geçmesiyle oluşan yeni kelime..sıra bozulmuyor
 *     //ve en fazla harf sayısı kadar oluyor
 */

        String str="yaman";
        String str1="manya";

        System.out.println("isRotation(str,str1) = " + isRotation(str, str1));
        System.out.println("isRotation1(str,str1) = " + isRotation1(str, str1));


    }

    public static boolean isRotation(String str1, String str2){
        if (str1.length()!=str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            str1=str1.substring(1)+str1.substring(0,1);
            if (str1.equals(str2)){
                return true;
            }
        }
        return false;
    }

    public static boolean isRotation1(String str1,String str2){
        if (str1.length()!=str2.length()) {
            return false;
        }
        return (str1+str1).contains(str2);
    }




}