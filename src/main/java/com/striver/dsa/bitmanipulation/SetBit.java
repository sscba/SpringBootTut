package com.striver.dsa.bitmanipulation;

public class SetBit {
    public int set(int n, int i) {
        return (n | (1 << i));
    }

    public int clear(int n, int i) {
        return n & (~(1 << i));
    }
    public int toggle(int n, int i) {
        return n ^ ((1 << i));
    }
    public int removeLastSetBit(int n){
        return n & (n-1);
    }

    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE) return false;
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        int n = 9;
        int i = 1;

        System.out.println(new SetBit().set(n, i));
        System.out.println(new SetBit().clear(n, i));
        System.out.println(new SetBit().toggle(n, i));
        System.out.println(new SetBit().removeLastSetBit(n));
        System.out.println(new SetBit().isPowerOfTwo(2147483647));
    }
}
