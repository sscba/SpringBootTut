package com.striver.dsa.slidingwindow;

public class MaxConsecutiveOneIII {

    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l=0;
        int r=0;
        int cnt=0;
        int maxLen=0;
        while(r<n){
            if(nums[r]==0) cnt++;
            while(cnt>k){
                if(nums[l]==0) cnt--;
                l++;
            }
            if(cnt<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }

    public static int optimal(int[] nums,int k){
        int l=0;
        int r=0;
        int n= nums.length;
        int maxLen =0;
        int zeroes=0;
        while(r<n){
            if(nums[r]==0) zeroes++;
            if(zeroes>k){
                if(nums[l]==0) zeroes--;
                l++;
            }
            if(zeroes<=k){
                maxLen= Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(optimal(nums,k));
    }
}
