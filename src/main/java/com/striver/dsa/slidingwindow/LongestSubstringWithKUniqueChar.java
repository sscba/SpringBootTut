package com.striver.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChar {

    public static int longestKSubstring(String s, int k) {
        int len = -1;
        int n = s.length();
        int l=0;
        int r=0;
        Map<Character,Integer> mp = new HashMap<>();
        while(r<n){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            while(mp.size()>k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                if(mp.get(s.charAt(l)) == 0){
                    mp.remove(s.charAt(l));
                }
                l++;
            }
            if(mp.size() == k){
                len = Math.max(len,r-l+1);
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "aab";
        int k = 3;
        System.out.println(longestKSubstring(s,k));
    }
}
