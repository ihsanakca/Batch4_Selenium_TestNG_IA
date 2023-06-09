package com.krafttech;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "128 2 3693 65 89 25 10";
        System.out.println(sumOfString(str));

    }

    /**
     * 11  2 21  11 17 7  1
     * String str="128 2 3693 65 89 25 10"; str içerisindeki boşlukla ayrılmış sayıların sayı değerleri
     * toplanarak küçükten büyüğe dizili olarak yeniden bir stringe tanımlayan metod nedir? Bu soru
     * için cevap String result="1 2 7 11 11 17 21"; şeklinde olmalıdır.
     */
    public static String sumOfString(String str) {
        String[] strArr = str.split(" ");
        int sum = 0;
        String result = "";

        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length(); j++) {
                sum += Integer.parseInt(strArr[i].substring(j, j + 1));
//                sum += Integer.parseInt(strArr[i].charAt(j)+"");
//                sum += Character.getNumericValue(strArr[i].charAt(j));
            }
            intArr[i] = sum;
            sum = 0;
        }
        Arrays.sort(intArr);

        for (int i : intArr) {
            result += i + " ";
        }
        return result.trim();
    }
}