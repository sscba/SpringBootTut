package com.striver.dsa.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class Primes {
    public static int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        for(int i=2; i*i < n;i++){
            if(primes[i]){
                for(int j=i*i; j<n; j+=i){
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2; i<=n; i++){
            if(primes[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 978078923;
        System.out.println(countPrimes(n));
    }
}
