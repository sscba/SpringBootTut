package com.striver.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {

    public int solve(int[] arr,int k){
        int n = arr.length;

        Map<Integer,Integer> previousOccuredSumCnt= new HashMap<>();
        previousOccuredSumCnt.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            prefixSum += arr[i];
            count += previousOccuredSumCnt.getOrDefault(prefixSum -k,0);
            previousOccuredSumCnt.put(prefixSum -k , previousOccuredSumCnt.getOrDefault(prefixSum -k,0)+1);
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,-3,1,1,1,4,1,-2,1};
        SubarraySumK sumK = new SubarraySumK();
        System.out.println(sumK.solve(arr,3));
    }
}
