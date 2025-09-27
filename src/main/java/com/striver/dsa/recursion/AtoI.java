package com.striver.dsa.recursion;

public class AtoI {

    public int myAtoi(String s) {
        int i = 0 ;
        int n = s.length();

        //remove whitespaces
        while(i<n && s.charAt(i) == ' ') i++;

        //sign
        int sign = 1;
        if(i<n && s.charAt(i) == '-'){
            sign = -1 ;
            i++;
        }else if(i<n && s.charAt(i) == '+'){
            i++;
        }

        long ans = 0 ;
        ans = solve(s,i,ans,sign);
        return (int) ans;
    }

    private long solve(String s, int i, long ans, int sign) {
        if(ans*sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(ans*sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(i>=s.length() || s.charAt(i) < '0' || s.charAt(i) >'9') return sign*ans;

        ans = solve(s,i+1,(ans*10 + (s.charAt(i)-'0')),sign);
        return ans;
    }

    public static void main(String[] args) {
        String s = "         -00000040000 312";

        int ans = new AtoI().myAtoi(s);
        System.out.println(ans);
    }
}
