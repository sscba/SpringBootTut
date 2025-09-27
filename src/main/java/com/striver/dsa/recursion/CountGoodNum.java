package com.striver.dsa.recursion;

public class CountGoodNum {
    // Fast modular exponentiation
    private final static long MOD = 1_000_000_007;
    private static long modPow(long base, long exp) {
        if (exp == 0) return 1;

        long half = modPow(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * (base % MOD)) % MOD; //long as n can be very big
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenPos = (n +1) / 2; //long as n can be very big
        long oddPos =  n/2; //long as n can be very big

        long ans = (modPow(5,evenPos) * modPow(4,oddPos)) % MOD;

        return (int) ans  ;

    }

    public static void main(String[] args) {
        long n = 806166225;
        int ans = new CountGoodNum().countGoodNumbers(n);
        System.out.println(ans);
    }
}
