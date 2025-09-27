package com.striver.dsa.bitmanipulation;

public class OddEvenNum {

    public String check(int n) {
        return (n & 1) == 1 ? "Odd" : "Even";
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new OddEvenNum().check(n));
    }
}
