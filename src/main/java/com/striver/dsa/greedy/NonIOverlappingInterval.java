package com.striver.dsa.greedy;

import java.util.Arrays;

public class NonIOverlappingInterval {

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int lastTime = intervals[0][1];
        int cnt = 1;
        for(int i = 1; i<n ; i++){
            if(intervals[i][0] >= lastTime){
                cnt += 1;
                lastTime = intervals[i][1];
            }
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        int[][] interval = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(interval));
    }
}
