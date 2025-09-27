package com.striver.revision.I.array;

public class CheckRotatedArr {

    public static boolean check(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) cnt++;
        }
        if(nums[0] < nums[nums.length-1]) cnt++;
        return cnt<=1;
    }

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2,6};
        System.out.println(check(arr));
    }
}
