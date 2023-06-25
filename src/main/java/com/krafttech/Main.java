package com.krafttech;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Given a string s, return the longest palindromic substring in s.
         * Example 1:
         * <p>
         * Input: s = "babad"
         * Output: "bab"
         * Explanation: "aba" is also a valid answer.
         * Example 2:
         * <p>
         * Input: s = "cbbd"
         * Output: "bb"
         */
        String s = "asaattaak";   //b ba bab baba babad a ab aba ....
        System.out.println("longestPalindromic(s) = " + longestPalindromic(s));

        //mesela   asdddsc kelimesinde cevap : sddds olmalı çünkü düzü ve tersi aynı ve bu kelimede bu şartı sağlayan
        // en uzun kısım
        // kayakçılar kelimesinde kayak cevap olmalı...

    }

    public static String longestPalindromic(String str) {
        List<String> allSubs = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String newStr = str.substring(i, j);
                if (isPalindrome1(newStr) && newStr.length() > max) {
                    allSubs.add(0,newStr);
                    max=newStr.length();
                }
            }
        }
        System.out.println("allSubs = " + allSubs);
        return allSubs.get(0);
    }

    public static boolean isPalindrome1(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return str.equals(reverse);
    }

    public static boolean isPalindrome2(String str) {
        return str.equals(new StringBuffer(str).reverse().toString());
    }
}