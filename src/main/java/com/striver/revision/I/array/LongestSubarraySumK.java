package com.striver.revision.I.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumK {

    public static int getLongestSubarray(int[] a, long k) {
        int maxLen = 0;
        int n = a.length;
        long sum = 0;
        Map<Long,Integer> presumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if(sum == k) maxLen = Math.max(maxLen,i+1);
            else if(presumMap.containsKey(sum-k)){
                maxLen = Math.max(maxLen,i-presumMap.get(sum-k));
            }
            if(!presumMap.containsKey(sum)) presumMap.put(sum,i);
        }
        return maxLen;
    }

    public static int slidingWindow(int[] a,int k){
        int left = 0;
        int right = 0;
        int sum = a[0];
        int n = a.length;
        int maxLen = 0;
        while(right < n){
            while(left <= right && sum>k){
                sum -= a[left];
                left++;
            }
            if(sum == k) maxLen = Math.max(maxLen,right-left+1);
            right++;
            if(right<n) sum += a[right];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 1, 2, 3, 4, 5};
        int k = 4;
        int ans = slidingWindow(nums,k);
        System.out.println(ans);
    }
}
