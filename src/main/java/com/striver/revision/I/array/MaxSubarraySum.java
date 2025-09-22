package com.striver.revision.I.array;

import java.util.ArrayList;
import java.util.List;

public class MaxSubarraySum {

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n;i++){
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
    public static List<Integer> maxSubArrayIndex(int[] nums) {
        int maxSum = nums[0];
        int n = nums.length;
        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int ansEnd = -1;
        int ansStart = -1;
        for(int i=0; i<n;i++){
            if(sum == 0) start = i;
            sum += nums[i];
            if(sum > maxSum){
                maxSum = sum;
                ansEnd = i;
                ansStart = start;
            }
            if(sum < 0) sum = 0;
        }
        ans.add(ansStart);
        ans.add(ansEnd);
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        List<Integer> ans = maxSubArrayIndex(arr);
        System.out.println("Start "+ ans.getFirst()+ " End "+ ans.getLast());
        for(int i = ans.getFirst();i<=ans.getLast();i++) System.out.print(arr[i]+ " ");

    }
}
