package com.striver.dsa.bitmanipulation;

public class CountSetBit {

    public int countBruteSol(int n){
        int cnt = 0;
        while(n > 0 ){
            if((n & 1) == 1) cnt++;
            n = n>>1;
        }
        return cnt;
    }

    public int countOptimal(int n){
        int cnt = 0;
        while(n > 0 ){
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 1279097789;
        long st = System.currentTimeMillis();
        System.out.println(new CountSetBit().countOptimal(n));
        long ed = System.currentTimeMillis();
        System.out.println("Time: "+ (ed-st));
    }
}
