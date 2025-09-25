package com.striver.dsa.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int subsets = 1 << n; // 2^n
        for(int bit=0; bit<subsets; bit++){
            List<Integer> ls = new ArrayList<>();
            for(int i=0; i<n; i++){
                if((bit & (1<<i)) != 0){
                    ls.add(nums[i]);
                }
            }
            res.add(ls);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr= {1,2,3};
        List<List<Integer>> ans = subsets(arr);
        for(List<Integer> ls : ans){
            ls.forEach((ele)-> System.out.print(ele+" "));
            System.out.println(" ");
        }
    }
}
