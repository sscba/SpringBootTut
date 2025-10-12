package com.striver.dsa.stack;

import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = findPse(heights);
        int[] nse = findNse(heights);
        int area = 0;
        for(int i=0; i<n; i++){
            int length = nse[i] - pse[i]-1;
            int height = heights[i];
            area = Math.max(area,length*height);
        }
        return area;
    }

    private int[] findPse(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n ; i++){
            while(!st.empty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            ans[i] = !st.empty() ? st.peek():-1;
            st.push(i);
        }
        return ans;
    }
    private int[] findNse(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0 ; i--){
            while(!st.empty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            ans[i] = !st.empty()? st.peek():n;
            st.push(i);
        }
        return ans;
    }

    public int optimal(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int area = 0;
        for(int i=0; i<n; i++){
            while(!st.empty() && heights[st.peek()] >= heights[i]){
                int nse = i;
                int element = st.peek();
                st.pop();
                int pse = !st.empty()?st.peek():-1;
                area = Math.max(area,heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.empty()){
            int nse = n;
            int element = st.peek();
            st.pop();
            int pse = !st.empty()?st.peek():-1;
            area = Math.max(area,heights[element]*(nse-pse-1));
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleArea().optimal(heights));
    }
}
