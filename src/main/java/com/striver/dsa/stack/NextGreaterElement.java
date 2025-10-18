package com.striver.dsa.stack;

import java.util.Stack;

public class NextGreaterElement {

    public static int[] nge(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0 ; i--){
            while(!st.empty() && st.peek() <= nums[i]){
                st.pop();
            }
            //stack empty
            if(st.empty()) ans[i] = -1;
            else{
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1,6,4,8,7,9,5,2};
        int[] ans = nge(nums);
        for(int ele : ans){
            System.out.print(ele+" ");
        }
    }
}
