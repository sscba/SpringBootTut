package com.striver.dsa.binarysearch;

public class MinimumElementSortedArray {

    public int solve(int[] nums){
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = (low+high)/2;

            //left side is sorted
            if(nums[low] <= nums[mid]){
                min = Math.min(min,nums[low]);
                low = mid+1;
            }
            //right side is sorted
            else{

                min= Math.min(min,nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1};

        int ans = new MinimumElementSortedArray().solve(arr);
        System.out.println(ans);
    }
}
