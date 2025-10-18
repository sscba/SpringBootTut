package com.striver.dsa.stack;

import java.util.Stack;

public class SumOfSubarrayRanges {

    public static long bruteForce(int[] nums){
        long ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j=i; j<n; j++){
                min = Math.min(min,nums[j]);
                max = Math.max(max,nums[j]);
                ans += (max - min);
            }
        }
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        return sumOfSubarrayMaxs(nums) - sumofSubarraymins(nums);
    }

    private long sumofSubarraymins(int[] nums) {
        int[] psee = findPSEE(nums);
        int[] nse = findNSE(nums);
        int n = nums.length;
        long sum = 0;
        for(int i=0; i<n; i++){
            int left = i-psee[i];
            int right = nse[i] - i;
            long freq = 1L*right*left;
            sum += (freq*nums[i]);
        }
        return sum;
    }

    private long sumOfSubarrayMaxs(int[] nums) {
        int[] pge = findPGEE(nums);
        int[] nge = findNGE(nums);
        int n = nums.length;
        long sum = 0;
        for(int i=0; i<n; i++){
            int left = i-pge[i];
            int right = nge[i] - i;
            long freq = 1L*right*left;
            sum += (freq*nums[i]);
        }
        return sum;
    }

    private int[] findNGE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            ans[i] = !st.empty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    private int[] findPGEE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.empty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            ans[i] = !st.empty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    private int[] findNSE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            ans[i] = !st.empty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    private int[] findPSEE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.empty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            ans[i] = !st.empty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] arr = {4,-2,-3,4,1};
        System.out.println(new SumOfSubarrayRanges().subArrayRanges(arr));
    }
}
