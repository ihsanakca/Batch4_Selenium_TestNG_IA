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
        String s = "babad";
        System.out.println("longestPalindromic(s) = " + longestPalindromic(s));

        //mesela   asdddsc kelimesinde cevap : sddds olmalı çünkü düzü ve tersi aynı ve bu kelimede bu şartı sağlayan
        // en uzun kısım
        // kayakçılar kelimesinde kayak cevap olmalı...

    }

    public static String longestPalindromic(String str) {
        Set<String> allSubs = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String newStr = str.substring(i, j);
                System.out.println("allSubs.add(newStr) = " + allSubs.add(newStr));
            }
        }
        System.out.println("allSubs = " + allSubs);
        List<String> allPalindromicSubs = new ArrayList<>();
        for (String allSub : allSubs) {
            if (isPalindrome2(allSub)){
                allPalindromicSubs.add(allSub);
            }
        }
       // System.out.println("allPalindromicSubs = " + allPalindromicSubs);

        List<Integer> lengthOfPal=new ArrayList<>();

        for (String allPalindromicSub : allPalindromicSubs) {
            lengthOfPal.add(allPalindromicSub.length());
        }

        int max = Collections.max(lengthOfPal);

        String result = allPalindromicSubs.get(lengthOfPal.indexOf(max));


        return result;
    }
    public static boolean isPalindrome1(String str){
        String reverse="";
        for (int i = str.length()-1; i >=0 ; i--) {
            reverse+=str.charAt(i);
        }
        return str.equals(reverse);
    }

    public static boolean isPalindrome2(String str){
       return str.equals(new StringBuffer(str).reverse().toString());
    }
}