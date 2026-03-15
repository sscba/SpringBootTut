package com.striver.dsa.dp.twodimension;

import java.util.Arrays;

public class UniquePath {

    private int solve(int row, int col,int[][] dp){
        //base case
        if(row == 0 && col == 0) return 1;
        if(row<0 || col<0) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        int up = solve(row-1,col,dp);
        int left = solve(row,col-1,dp);
        dp[row][col] = up+left;
        return dp[row][col];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(m-1,n-1,dp);
    }

    public int tabulation(int m, int n){
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int up =0; int left=0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int spaceOpt(int m, int n){
        int[] prev = new int[n];
        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0) temp[j] = 1;
                else{
                    int up =0; int left=0;
                    if(i>0) up = prev[j];
                    if(j>0) left = temp[j-1];
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }


    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int cnt = new UniquePath().spaceOpt(m,n);
        System.out.println(cnt);
    }
}
