package com.striver.dsa.binarysearch;

import java.util.Arrays;

public class AggresiveCows {

    public boolean canDistPossible(int[] stalls, int dist,int cows){
        int cowCnt = 1;
        int lastCowPos = stalls[0];
        for(int i = 1;i< stalls.length;i++){
            if(stalls[i] - lastCowPos >= dist){
                cowCnt++;
                lastCowPos = stalls[i];
            }

            if(cowCnt >= cows) return true;
        }

        return false;
    }
    public int solve (int[] stalls,int k){
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length-1] - stalls[0];

        while(low <= high){
            int dist = (low+high)/2;

            if(canDistPossible(stalls,dist,k)){
                low = dist + 1;
            }
            else{
                high = dist - 1;
            }
        }
        return high;

    }

    public static void main(String[] args) {
        int[] stalls = {0,3,4,7,9,10,11};
        int k = 3;

        int ans = new AggresiveCows().solve(stalls,k);
        System.out.println(ans);
    }

}
