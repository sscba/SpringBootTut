package com.striver.dsa.stack;

import java.util.Stack;

public class PostfixToPrefix {

    public static String convert(String s) {
        Stack<String> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (isOperand(s.charAt(i))) {
                st.push(String.valueOf(s.charAt(i)));
            } else {
                String t1 = st.peek();
                st.pop();
                String t2 = st.peek();
                st.pop();
                String replace = s.charAt(i) + t2 + t1;
                st.push(replace);
            }
        }
        return st.peek();
    }

    private static boolean isOperand(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        String s = "AB-DE+F*/";
        System.out.println(convert(s));
    }
}
