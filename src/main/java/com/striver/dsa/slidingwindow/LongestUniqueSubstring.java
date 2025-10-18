package com.striver.dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    public static int longestSubstring(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen=0;
        for(int i=0 ; i<n; i++){
//            set.add(s.charAt(i));
            int r=i;
            while(r<n && !set.contains(s.charAt(r))){
                int len = r-i+1;
                maxLen  = Math.max(len,maxLen);
                set.add(s.charAt(r));
                r++;
            }
            set.clear();
        }
        return maxLen;
    }

    public static int optimal(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen=0;
        int left=0;
        int right=0;
        while(right<n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                maxLen = Math.max(maxLen,set.size());
            }else{
                set.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "bbbiu465499";
        System.out.println(optimal(s));
    }
}
