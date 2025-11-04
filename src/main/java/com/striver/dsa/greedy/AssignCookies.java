package com.striver.dsa.greedy;

import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while (l < s.length && r < g.length) {
            if(s[l] >= g[r]) r++;
            l++;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] g = {4, 5, 3, 3, 1};
        int[] s = {4, 2, 1, 2, 1, 3};
        System.out.println(findContentChildren(g,s));
    }
}
