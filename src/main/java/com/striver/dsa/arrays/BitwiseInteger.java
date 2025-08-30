package com.striver.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class BitwiseInteger {

    public int solve(int[] nums,int k){
        int n= nums.length;
        Map<Integer,Integer> prevXor = new HashMap<>();

        int cnt = 0;
        int totalXor = 0;
        prevXor.put(0,1);
        for(int i=0;i<n;i++){
            totalXor = totalXor ^ nums[i];
            int appearedXor = totalXor ^ k;
            cnt += prevXor.getOrDefault(appearedXor,0);

            prevXor.put(totalXor,prevXor.getOrDefault(totalXor,0)+1);

        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int ans = new BitwiseInteger().solve(arr,6);
        System.out.println(ans);
    }
}


