package com.striver.dsa.dp;

import java.util.Arrays;

public class HouseRobbery {

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

    public int houseRobber(int[] money) {
        int n = money.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return money[0];

        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];

        for(int i=0; i<n; i++){
            if(i!=0) temp1[i-1] = money[i];
            if(i!=n-1) temp2[i] = money[i];
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        return Math.max(nonAdjacentSum(temp1,temp1.length-1,dp1), nonAdjacentSum(temp2,temp2.length-1,dp2));
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int ans = new HouseRobbery().houseRobber(nums);
        System.out.println(ans);
    }
}
