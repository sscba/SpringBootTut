package com.striver.dsa.stack;

public class TrappedRainWater {

    //Approach 1
    public static int trap(int[] height) {
        int n = height.length;
        int trappedWater = 0;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(height[i],prefixMax[i-1]);
            suffixMax[n-1-i] = Math.max(height[n-i-1], suffixMax[n-i]);
        }
        //find trapped water
        for(int i=0; i<n; i++){
            trappedWater += Math.min(prefixMax[i],suffixMax[i]) - height[i];
        }
        return trappedWater;
    }
    //Approach 2 - remove prefixMax arr instead use only suffixMar[] to find answer
    public static int trap2(int[] height) {
        int n = height.length;
        int trappedWater = 0;
        int prefixMax = Integer.MIN_VALUE;
        int[] suffixMax = new int[n];
        suffixMax[n-1] = height[n-1];
        for(int i=1; i<n; i++){
            suffixMax[n-1-i] = Math.max(height[n-i-1], suffixMax[n-i]);
        }
        //find trapped water
        for(int i=0; i<n; i++){
            prefixMax = Math.max(height[i],prefixMax);
            trappedWater += Math.min(prefixMax,suffixMax[i]) - height[i];
        }
        return trappedWater;
    }
    //Approach 3 - Two pointers
    public static int trap3(int[] heights){
        int n = heights.length;
        int lMax = 0;
        int rMax = 0;
        int total = 0;
        int l=0;
        int r=n-1;
        while(l<r){
            if(heights[l] < heights[r]){
                if(lMax >= heights[l]){
                    total += lMax - heights[l];
                }else{
                    lMax = heights[l];
                }
                l++;
            }else{
                if(rMax >= heights[r]){
                    total += rMax - heights[r];
                }else{
                    rMax = heights[r];
                }
                r--;
            }
        }
        return total;
    }



    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        System.out.println(trap3(arr));
    }
}
