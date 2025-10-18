package com.striver.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static int[] nse(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = n-1; i>=0; i--){
            while(!st.empty() && st.peek() >= nums[i]){
                st.pop();
            }
            if(!st.empty()) ans[i] = st.peek();
            st.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {35,14,1,22,4,16,8,6,45,32};
        int[] arr = nse(nums);
        for(int e : arr){
            System.out.print(e+" ");
        }
    }
}
