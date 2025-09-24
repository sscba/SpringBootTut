package com.striver.dsa.bitmanipulation;

public class BitFlipsToConvertNumber {

    public static int minBitFlips(int start, int goal) {
        int num = start^goal;
        int cnt = 0;
        while(num != 0){
            num = num & (num-1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int start = 1000;
        int goal = 798;
        System.out.println(minBitFlips(start,goal));
    }
}
