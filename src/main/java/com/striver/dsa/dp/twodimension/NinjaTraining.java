package com.striver.dsa.dp.twodimension;

import java.util.Arrays;

public class NinjaTraining {

    private int solve(int[][] points, int day, int last,int[][] dp){
        //base case
        if(day == 0){
            int maxi = 0;
            for(int task = 0; task < 3 ; task++){
                if(task != last) maxi = Math.max(maxi, points[0][task]);
            }
            return maxi;
        }

        if(dp[day][last] != -1) return dp[day][last];

        int maxi = 0;
        for(int task = 0; task < 3; task++){
            if(task != last){
                int cost = points[day][task] + solve(points,day-1, task,dp);
                maxi = Math.max(cost,maxi);
            }
        }
        dp[day][last] = maxi;
        return dp[day][last];
    }

    public int ninjaTraining(int[][] points){
        int days = points.length;
        int[][] dp = new int[days][4];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(points,days-1,3,dp);
    }

    public int tabulation(int[][] points){
        int n = points.length;
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int day = 1; day < n; day++){
            for(int last = 0; last < 4; last++){
                dp[day][last] = 0;

                for(int task=0; task<3; task++){
                    int cost = points[day][task] + dp[day-1][task];
                    dp[day][last] = Math.max(cost,dp[day][last]);
                }
            }
        }
        return dp[n-1][3];
    }

    public int spaceOpt(int[][] points){
        int n = points.length;
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1],points[0][2]);
        prev[1] = Math.max(points[0][0],points[0][2]);
        prev[2] = Math.max(points[0][0],points[0][1]);
        prev[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int day = 1; day < n; day++){
            int[] temp = new int[4];
            for(int last = 0; last < 4; last++){
                temp[last] = 0;

                for(int task=0; task<3; task++){
                    int cost = points[day][task] + prev[task];
                    temp[last] = Math.max(cost,temp[last]);
                }
            }
            prev = temp;
        }
        return prev[3];
    }

    public static void main(String[] args) {
        int[][] points = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        int cost = new NinjaTraining().spaceOpt(points);
        System.out.println(cost);
    }
}
