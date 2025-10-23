package com.striver.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKUniqueInt {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k) - solve(nums,k-1);
    }

    private int solve(int[] nums,int k){
        int n = nums.length;
        int l = 0;
        int r = 0;
        int cnt = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        while(r<n){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.size()>k){
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l])==0){
                    mp.remove(nums[l]);
                }
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4};
        int k = 3;
        System.out.println(new SubarrayWithKUniqueInt().subarraysWithKDistinct(nums,k));
    }
}
