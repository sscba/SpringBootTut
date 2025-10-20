package com.striver.dsa.slidingwindow;

public class NiceSubarray {

    public int numberOfSubarrays(int[] nums, int k){
        return solve(nums,k) - solve(nums,k-1);
    }

    public int solve(int[] nums, int goal) {
        if (goal < 0) return 0;
        int l = 0;
        int r = 0;
        int cnt = 0;
        int sum = 0;
        int n = nums.length;
        while (r < n) {
            sum += (nums[r]%2);
            while (sum > goal) {
                sum -= (nums[l]%2);
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,1,2,2,1,2,2,2};
        int k=2;
        System.out.println(new NiceSubarray().numberOfSubarrays(arr,k));
    }
}
