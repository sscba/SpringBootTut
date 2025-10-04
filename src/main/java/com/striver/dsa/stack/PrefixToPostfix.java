package com.striver.dsa.stack;

import java.util.Stack;


public class PrefixToPostfix {
    private static boolean isOperand(char c) {
        if(c>='a' && c<='z' || c>='A' && c<='Z' || c>='0' && c<='9')
            return true;
        return false;
    }
    public static String convert(String s){
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(isOperand(s.charAt(i))){
                st.push(String.valueOf(s.charAt(i)));
            }else{
                String t1 = st.peek();
                st.pop();
                String t2 = st.peek();
                st.pop();
                String replace = t1+t2+s.charAt(i);
                st.push(replace);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String s = "*/AB-+BEA";
        System.out.println(convert(s));
    }
}
