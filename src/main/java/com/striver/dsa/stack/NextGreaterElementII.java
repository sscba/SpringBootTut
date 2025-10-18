package com.striver.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=2*n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if(i<n){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i%n]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,114,2,88,3,2,1,3,4,7,9,4,42,67,27,2,24,45};
        int nge[] = nextGreaterElements(nums);
        for(int num : nge){
            System.out.print(num+" ");
        }
    }
}
