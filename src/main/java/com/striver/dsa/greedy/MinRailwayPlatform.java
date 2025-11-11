package com.striver.dsa.greedy;

import java.util.Arrays;

public class MinRailwayPlatform {

    public static int platforms(int[] arr, int[] dep){
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0; int j=0;
        int maxCnt = 0;
        int cnt = 0;
        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }
            maxCnt = Math.max(cnt,maxCnt);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        int[] arr = {900,945,955,1100,1500,1800};
        int[] dep = {920,1200,1130,1150,1900,2000};
        System.out.println(platforms(arr,dep));
    }
}
