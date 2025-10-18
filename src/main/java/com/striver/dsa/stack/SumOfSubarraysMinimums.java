package com.striver.dsa.stack;

import java.util.Stack;

public class SumOfSubarraysMinimums {

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod =(int) 1e9 + 7;
        int[] pse = findPse(arr);
        int[] nse = findNse(arr);
        int sum = 0;
        for(int i=0; i<n; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = ((long) left *right);
            int val = (int) ((freq*arr[i])%mod);
            sum = (sum + val)%mod;
        }
        return sum;
    }

    private static int[] findNse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0 ;i--){
            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            ans[i] = !st.empty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    private static int[] findPse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n ;i++){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            ans[i] = !st.empty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
        System.out.println(sumSubarrayMins(arr));
    }
}
