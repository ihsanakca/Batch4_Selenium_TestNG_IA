package com.krafttech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "red24 blue54 black188 green33 gold33";
       // System.out.println(orderColors_1(str));

        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(11);
        System.out.println(list);

        System.out.println("list.stream().distinct().count() = " + list.stream().distinct().toList());

        list.removeIf(e->e<6);

        System.out.println(list);    }

//result-->black red green gold blue

    public static String orderColors(String str) {
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(words[i].length() - 1) + words[i];
        }
        Arrays.sort(words);
        //  System.out.println("Arrays.toString(words) = " + Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replace(words[i].substring(0, 1), "");
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

    // String str = "red24 blue54 black188 green33 gold33";  [32,25,369,35]
    public static String orderColors_1(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (Integer.parseInt(words[i].replaceAll("[^0-9]", "")) >
                        Integer.parseInt(words[j].replaceAll("[^0-9]", ""))) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(words));
        String joined = String.join(" ", words).replaceAll("[0-9]", "");
        return joined;
    }
}