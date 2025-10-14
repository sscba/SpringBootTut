package com.striver.dsa.stack;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefixSum = new int[rows][cols];
        for(int j=0; j<cols; j++){
            int sum =0;
            for(int i=0; i<rows; i++){
                sum+=(matrix[i][j]-'0');
                if(matrix[i][j] == '0'){
                    sum=0;
                }
                prefixSum[i][j] = sum;
            }
        }
        //process prefixSum Matrix row by row and find largest rectangle area
        int area=0;
        for(int i=0; i<rows; i++){
            area = Math.max(area,largestRectangleArea(prefixSum[i]));
        }
        return area;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        java.util.Stack<Integer> st = new Stack<>();
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
        char[][] mat = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(mat));
    }
}
