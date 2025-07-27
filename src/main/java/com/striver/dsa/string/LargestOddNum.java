package com.striver.dsa.string;

public class LargestOddNum {
    public String largestOddNumber(String num){
        int i = num.length() -1;

        while(i>=0){
            if(Integer.parseInt(String.valueOf(num.charAt(i))) %2  != 0){
                return num.substring(0,i+1);
            }
            i--;
        }
        return "";
    }

    public static void main(String[] args) {
        String nums = "3124242";

        String ans = new LargestOddNum().largestOddNumber(nums);
        System.out.println(ans);

    }
}
