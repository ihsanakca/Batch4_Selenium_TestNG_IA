package com.krafttech;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /**
         * örnek: String s="((()))" valid
         * String s="((()))("  invalid
         * String s="()(()(()))" valid
         * String s="((())())" valid
         * String s="((())()()" invalid
         * String s="(()))()()(()" invalid
         */
        String s="(()))()()(()";

        System.out.println("isValidParentheses_1(s) = " + isValidParentheses_1(s));

    }

    public static boolean isValidParentheses(String str) {
        while (str.contains("()")) {
            str = str.replace("()", "");
        }
        return str.isEmpty();
    }
    public static boolean isValidParentheses_1(String str){
        char[] chars = str.toCharArray();
        int count=0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                count++;
            }
            if (chars[i]==')'){
                count--;
            }
            if (count<0){
               return false;
            }

        }
        return count==0;
    }


}