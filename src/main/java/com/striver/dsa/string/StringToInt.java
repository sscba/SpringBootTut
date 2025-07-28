package com.striver.dsa.string;

public class StringToInt {

    public int atoi(String s){
        int i=0;
        int n= s.length();

        //skip spaces
        while(i<n && s.charAt(i)== ' '){
            i++;
        }

        if(i==n) return 0;

        //sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        int result=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            //check overflow
            if(result > (Integer.MAX_VALUE - digit)/10){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result*10 + digit;
            i++;

        }
        return result*sign;
    }

    public static void main(String[] args) {
        String s = "             -04223123dskacn";

        int ans = new StringToInt().atoi(s);
        System.out.println(ans);
    }
}
