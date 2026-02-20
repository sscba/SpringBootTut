package com.striver.dsa.dp;

import java.util.Arrays;

public class MaxNonAdjacentSum {

    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return nonAdjacentSum(nums,n-1,dp);
    }

    private int nonAdjacentSum(int[] nums,int index, int[] dp){
        //base case
        if(index==0) return nums[index];
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];
        int pick = nums[index] + nonAdjacentSum(nums,index-2,dp);
        int notPick = nonAdjacentSum(nums,index-1,dp);

        dp[index] = Math.max(pick,notPick);
        return dp[index];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 9};
        int ans = new MaxNonAdjacentSum().nonAdjacent(nums);
        System.out.println(ans);
    }
}
