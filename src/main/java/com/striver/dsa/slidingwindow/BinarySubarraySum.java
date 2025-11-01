package com.striver.dsa.slidingwindow;

public class BinarySubarraySum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums, goal) - solve(nums, goal - 1);
    }

    public int solve(int[] nums, int goal) {
        if (goal < 0) return 0;
        int l = 0;
        int r = 0;
        int cnt = 0;
        int sum = 0;
        int n = nums.length;
        while (r < n) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(new BinarySubarraySum().numSubarraysWithSum(arr,goal));
    }
}
