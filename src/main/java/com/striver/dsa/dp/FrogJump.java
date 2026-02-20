package com.striver.dsa.dp;

import java.util.Arrays;

public class FrogJump {

    private int jump(int[] heights, int index, int[] dp){
        //base case
        if(index == 0) return 0;

        if(dp[index] != -1) return dp[index];

        int oneStep = jump(heights,index-1,dp) + Math.abs(heights[index] - heights[index-1]);
        int twoStep = index > 1 ? jump(heights,index-2,dp) + Math.abs(heights[index] - heights[index-2]) : Integer.MAX_VALUE;

        dp[index] = Math.min(oneStep,twoStep);
        return dp[index];
    }

    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return jump(heights,n-1,dp);
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 1, 2, 6};
        int ans = new FrogJump().frogJump(arr);
        System.out.println(ans);
    }
}
