package com.striver.dsa.stack;

import java.util.Stack;

public class PostfixToInfix {

    public static String convert(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (isOperand(s.charAt(i))) {
                st.push(String.valueOf(s.charAt(i)));
            } else {
                String t1 = st.peek();
                st.pop();
                String t2 = st.peek();
                st.pop();
                String replace = "(" + t2 + s.charAt(i) + t1 + ")";
                st.push(replace);
            }
        }
        return st.peek();
    }

    private static boolean isOperand(char c) {
        if(c>='a' && c<='z' || c>='A' && c<='Z' || c>='0' && c<='9')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "AB-NF2/*-";
        System.out.println(convert(s));

    }
}
