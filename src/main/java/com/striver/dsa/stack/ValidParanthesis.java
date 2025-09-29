package com.striver.dsa.stack;

import java.util.Stack;

public class ValidParanthesis {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                st.add(c);
            }else{
                if(!st.isEmpty() &&( c==')' && st.peek()!='(' || c=='}' && st.peek()!='{' || c==']' && st.peek()!='['))
                    return false;
                if(st.isEmpty())
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(({{}}[]))}";
        System.out.println(isValid(s));
    }
}
