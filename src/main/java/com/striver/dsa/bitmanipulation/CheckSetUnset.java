package com.striver.dsa.bitmanipulation;

public class CheckSetUnset {

    public boolean check(int n, int i) {
        return ((n >> i) & 1) != 0 ;
    }

    public static void main(String[] args) {
        int n = 12;
        int i = 6;

        System.out.println(new CheckSetUnset().check(n,i));
    }
}
