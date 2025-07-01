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
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{2,5},{7,10},{3,4},{6,8},{15,20}};
        List<List<Integer>> ans = new MergeIntervals().solve(arr);
        for(List<Integer> interval : ans){
            System.out.println(interval.get(0)+ " "+ interval.get(1));
        }


    }
}
