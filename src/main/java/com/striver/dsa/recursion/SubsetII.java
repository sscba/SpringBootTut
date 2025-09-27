package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums,n,0,new ArrayList<>(),ans);
        return ans;
    }

    public void generateSubsets(int[] nums,int n, int i,List<Integer> ds,List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));

        for(int j = i; j<n; j++){
            if(j>i && nums[j] == nums[j-1]) continue;

            ds.add(nums[j]);
            generateSubsets(nums,n,j+1,ds,ans);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,2,1,2,6,5,4};

        List<List<Integer>> ans = new SubsetII().subsetsWithDup(arr);
        for (List<Integer> ele : ans) {
            System.out.println(ele);
        }

    }
}
