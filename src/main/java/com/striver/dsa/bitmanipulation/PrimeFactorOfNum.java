package com.striver.dsa.bitmanipulation;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorOfNum {

    public static List<Integer> primeFactors(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                ans.add(i);
                while(n%i == 0){
                    n = n/i;
                }
            }
        }
        if(n!=1) ans.add(n);
        return ans;
    }

    public static void main(String[] args) {
        int N = 87210;
        List<Integer> ans = primeFactors(N);
        ans.forEach(ele -> System.out.print(ele+ " "));
    }
}
