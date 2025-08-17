package com.striver.dsa.arrays;

import java.util.HashMap;

public class LongestSubarraySum0 {

    public int solve(int[] nums){
        int max = 0;
        int n = nums.length;
        int sum = 0;
        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();

        for (int i = 0 ; i < n ; i++){
            sum += nums[i];
            if(prefixSumMap.containsKey(sum)){
                max = Math.max(max, i- prefixSumMap.get(sum));
            }else{
                prefixSumMap.put(sum,i);
            }
        }
        return max ;
    }

    public static void main(String[] args) {
        int[] nums = {9,-3,3,-1,6,-5};
        int subArraySum0= new LongestSubarraySum0().solve(nums);
        System.out.println(subArraySum0);
    }
}
