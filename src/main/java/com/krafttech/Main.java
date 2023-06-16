package com.krafttech;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "red2 blue5 black1 green3 gold4";
        System.out.println("orderColors(str) = " + orderColors(str));
    }

//result-->black red green gold blue

    public static String orderColors(String str) {
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(words[i].length() - 1) + words[i];
        }
        Arrays.sort(words);
      //  System.out.println("Arrays.toString(words) = " + Arrays.toString(words));

        for (int i = 0; i < words.length ; i++) {
            words[i] =words[i].replace(words[i].substring(0,1), "");
        }

       // System.out.println("Arrays.toString(words) = " + Arrays.toString(words));

    /*    String result="";
        for (String word : words) {
            result+=word+" ";
        }
        return result.trim();*/

        String joined = String.join(" ", words);

        return joined;

    }
}