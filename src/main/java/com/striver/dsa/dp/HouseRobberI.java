package com.striver.dsa.dp;

import java.util.Arrays;

public class HouseRobberI {

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

    public int rob(int[] money) {
        int n = money.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return money[0];

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return nonAdjacentSum(money,n-1,dp);
    }

    public static void main(String[] args) {
        int[] money = {2,7,9,3,1};
        int ans = new HouseRobberI().rob(money);
        System.out.println(ans);
    }
}
