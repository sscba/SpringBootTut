package com.striver.dsa.greedy;

public class ValidParenthesisString {

    public static boolean checkValidString(String s) {
        int min=0;
        int max=0;
        int n= s.length();
        for(int i=0; i<n;i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }else if(s.charAt(i) == ')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }
            if(min < 0) min =0;
            if(max < 0) return false;
        }
        return min == 0;
    }

    public static void main(String[] args) {
        String s= "(*))(***())(()*";
        System.out.println(checkValidString(s));
    }
}
