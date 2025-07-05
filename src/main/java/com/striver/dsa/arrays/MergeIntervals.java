package com.striver.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public List<List<Integer>> solve (int[][] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        //sort
        Arrays.sort(nums, (a,b)-> a[0] - b[0]);

        for(int i=0;i<n;i++){
            int start = nums[i][0];
            int end = nums[i][1];

            //check end already in range
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }

            for(int j = i+1;j<n;j++){
                if(end >= nums[j][0]){
                    end = Math.max(end,nums[j][1]);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        return ans;
    }

    public int[][] leetcode(int[][] nums) {
        int n = nums.length;
        List<int[]> ans = new ArrayList<>();

        // Sort by start of interval
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            int start = nums[i][0];
            int end = nums[i][1];

            // Skip if current interval is completely covered by last added interval
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) {
                continue;
            }

            // Merge overlapping intervals
            for (int j = i + 1; j < n; j++) {
                if (end >= nums[j][0]) {
                    end = Math.max(end, nums[j][1]);
                }else{
                    break;
                }
            }

            ans.add(new int[]{start, end});
        }

        // Convert List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] leetcodeOptimise(int[][] nums) {
        int n = nums.length;
        List<int[]> ans = new ArrayList<>();

        // Sort by start of interval
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            //creating new ans element
            if(ans.isEmpty() || nums[i][0] > ans.get(ans.size()-1)[1]){
                ans.add(nums[i]);
            }
            //expanding the interval by checking max of ans end and current elements end
            else{
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1],nums[i][1]);
            }

        }
        // Convert List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{2,5},{7,10},{3,4},{6,8},{15,20}};
        List<List<Integer>> ans = new MergeIntervals().solve(arr);
        for(List<Integer> interval : ans){
            System.out.println(interval.get(0)+ " "+ interval.get(1));
        }


    }
}
