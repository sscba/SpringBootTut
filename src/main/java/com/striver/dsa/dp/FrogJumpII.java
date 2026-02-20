package com.striver.dsa.dp;

import java.util.Arrays;

public class FrogJumpII {
    private int dp(int[] heights, int k, int index, int[] dp) {
        //base case
        if (index == 0) return 0;

        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(index-i >= 0){
                int steps = dp(heights,k,index-i,dp) + Math.abs(heights[index] - heights[index-i]);
                min = Math.min(min,steps);
            }
        }

        dp[index] = min;
        return dp[index];
    }

    private int recursion(int[] heights, int k, int index) {
        //base case
        if (index == 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int steps = recursion(heights, k, index - i) + Math.abs(heights[index] - heights[index - i]);
                min = Math.min(min,steps);
            }
        }
        return min;
    }

    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dp(heights, k, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 0, 15};
        int k = 2;
        int ans = new FrogJumpII().frogJump(arr,k);
        System.out.println(ans);
    }
}
