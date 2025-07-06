package com.striver.dsa.binarysearch;

public class PeakElement {

    public int findPeak(int[] nums){
        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int low = 1;
        int high = n-2;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] > nums[mid-1]){
                low = mid +1;
            }
            else if(nums[mid] < nums[mid-1]) {
                high = mid - 1;
            }
        }
    return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,10,6,5};

        int ans = new PeakElement().findPeak(arr);
        System.out.println(ans);
    }
}
