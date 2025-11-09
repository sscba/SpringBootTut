package com.striver.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class NMeetingOneRoom {

    public static int meetingSchedule(int[] start,int[] end){
        int n = start.length;
        List<int[]> meetingTime = new ArrayList<>();
        for(int i=0; i<n; i++){
            meetingTime.add(new int[]{end[i],start[i],i});
        }
        meetingTime.sort((a,b) -> a[0]-b[0]);
        int cnt = 0;
        int lastTime = -1;
        for(int i=0; i<n; i++){
            if(lastTime < meetingTime.get(i)[1]){
                cnt++;
                lastTime = meetingTime.get(i)[0];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,5,7,9,9};
        System.out.println(meetingSchedule(start,end));
    }
}
