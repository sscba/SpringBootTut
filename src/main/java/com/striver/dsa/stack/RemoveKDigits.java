package com.striver.dsa.stack;

import java.util.Stack;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == n) return "0";
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        //smaller number starts with small digits
        for(int i=0; i<n; i++){
            while(!st.empty() && k>0 && st.peek()-'0' > num.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        //handling for remaining k digits
        while(k>0 && !st.empty()){
            st.pop();
            k--;
        }
        //elements in stack is the reversed answer
        while(!st.empty()){
            res.append(st.peek());
            st.pop();
        }
        //check if res is empty
        if(res.isEmpty()) return "0";
        //remove zeroes from end (effectively removing the leading zeroes)
        while(!res.isEmpty() && res.charAt(res.length()-1) == '0'){
            res.deleteCharAt(res.length()-1);
        }
        //check if res is empty
        if(res.isEmpty()) return "0";
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String num = "104300";
        int k = 2;
        System.out.println(removeKdigits(num,k));
    }
}
