package com.striver.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l = 0;
        int r = 0;
        int cnt = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int sIndex = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (r < n) {
            if (mp.getOrDefault(s.charAt(r), 0) > 0) cnt++;
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) - 1);
            while (cnt == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                mp.put(s.charAt(l), mp.get(s.charAt(l)) + 1);
                if (mp.get(s.charAt(l)) > 0) cnt--;
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinWindowSubstr().minWindow(s,t));
    }
}
