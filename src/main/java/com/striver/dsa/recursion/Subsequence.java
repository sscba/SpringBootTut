package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subSeq = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        backtrack(ans,subSeq,nums,0);
        return ans;

    }

    public void generate(int[] nums, List<List<Integer>> ans, List<Integer> subSeq, int n, int i) {
        if (i >= n) {
            ans.add(subSeq);
            return;
        }

        subSeq.add(nums[i]);  //take
        generate(nums, ans, subSeq, n, i + 1);

        subSeq.remove(subSeq.size() - 1);
        generate(nums, ans, subSeq, n, i + 1);
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current)); // add current subset

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // choose
            backtrack(result, current, nums, i + 1); // explore
            current.remove(current.size() - 1); // un-choose
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> ans = new Subsequence().subsets(nums);
        ans.forEach(ele -> System.out.println(ele + " "));
        System.out.println(ans.size());
    }
}
