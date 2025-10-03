package com.striver.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPrefix {

    public static String convert(String s) {
        //reverse
        s = reverse(s);
        System.out.println("reverseI: "+ s);
        char[] c = s.toCharArray();
        for(int i=0; i<c.length; i++){
            if(c[i] == '('){
                c[i] = ')';
            }else if(c[i] == ')'){
                c[i]='(';
            }
        }
        s = String.valueOf(c);
        System.out.println("replace(): "+ s );
        //infixToPostfix
        s = infixToPostfix(s);
        System.out.println("infixToPostfix: "+ s);
        //reverse
        s = reverse(s);
        System.out.println("reverseII: "+ s);
        return s;
    }

    private static String infixToPostfix(String s){
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<n ; i++){
            if((s.charAt(i) <='a' && s.charAt(i) >= 'z') ||
                    (s.charAt(i) <='A' && s.charAt(i) >= 'Z') ||
                    (s.charAt(i) <='0' && s.charAt(i) >= '9') ){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                while(!st.empty() && st.peek() != '('){
                    ans.append(st.peek());
                    st.pop();
                }
                st.pop();
            }else{
                if(s.charAt(i) == '^'){
                    while(!st.empty() && getPriority(s.charAt(i)) <= getPriority(st.peek())){
                        ans.append(st.peek());
                        st.pop();
                    }
                }else{
                    while(!st.empty() && getPriority(s.charAt(i)) < getPriority(st.peek())){
                        ans.append(st.peek());
                        st.pop();
                    }
                }
                st.push(s.charAt(i));
            }
        }
        while(!st.empty()){
            ans.append(st.peek());
            st.pop();
        }
        return ans.toString();
    }
    private static int getPriority(char c) {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    private static String reverse(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int i = 0;
        while (i < n / 2) {
            char temp = c[i];
            c[i] = c[n-1-i];
            c[n-1-i] = temp;
            i++;
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        String exp = "(a+b)^(B*C+A/Z)";
        System.out.println(convert(exp));
    }
}
