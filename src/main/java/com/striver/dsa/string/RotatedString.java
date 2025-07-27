package com.striver.dsa.string;

public class RotatedString {

    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String concatStr = s.concat(s);
        return concatStr.contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cedab";

        boolean ans = new RotatedString().rotateString(s,goal);
        System.out.println(ans);


    }
}
