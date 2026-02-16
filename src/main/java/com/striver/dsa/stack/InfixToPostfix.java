package com.striver.dsa.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {

    public String convert(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if((s.charAt(i) >='A' && s.charAt(i)<='Z')
                    || (s.charAt(i) >='a' && s.charAt(i)<='z')
            || (s.charAt(i) >='0' && s.charAt(i)<='9')){
                ans.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.peek());
                    st.pop();
                }
                if(!st.isEmpty())
                    st.pop();
            }else{
                while(!st.isEmpty() && getPriorityMap(s.charAt(i)) <= getPriorityMap(st.peek())){
                    ans.append(st.peek());
                    st.pop();
                }
                st.push(s.charAt(i));
            }
        }

        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop();
        }
        return ans.toString();
    }

    private int getPriorityMap(char c) {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        String ans = new InfixToPostfix().convert(s);
        System.out.println(ans);
    }
}
