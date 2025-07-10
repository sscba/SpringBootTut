package com.striver.dsa.binarysearch;

public class KthMissingNumber {

    public int solve (int[] arr, int k){
        int low = 0 ;
        int high = arr.length -1;
        while(low<=high){
            int mid = (low+high)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k) {
                low = mid + 1;
            }
            else{
                high = mid -1 ;
            }
        }
        return high + 1 + k;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,7,11};
        int k = 9;

        int ans = new KthMissingNumber().solve(nums,k);
        System.out.println(ans);
    }
}
