package com.striver.dsa.binarysearch;

import javax.xml.stream.events.StartDocument;

public class SearchInRotatedArray {

    public int solve(int[] nums,int target){

        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = (low + high)/2;

            if(nums[mid] == target) return mid;

            //left half is sorted
            if(nums[low]<=nums[mid]){
                //present between low and mid
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }
                //not present between low and mid
                else{
                    low = mid + 1;
                }

            }
            //right half is sorted
            else{
                //present between mid and high
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,0,1,2};

        int ans = new SearchInRotatedArray().solve(arr,2);
        System.out.println("Ans: "+ ans + " element: "+ arr[ans]);
    }
}
