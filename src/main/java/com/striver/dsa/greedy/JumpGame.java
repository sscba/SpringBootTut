package com.striver.dsa.greedy;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for(int i=0; i<n; i++){
            if(maxIndex < i) return false;
            maxIndex = Math.max(maxIndex,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,0,2,5};
        System.out.println(canJump(arr));
    }
}
