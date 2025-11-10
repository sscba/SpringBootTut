package com.striver.dsa.greedy;

public class JumpGameII {

    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int r = 0;
        int farthest = 0;
        for (int i = 0; i < n-1; i++) {
            farthest = Math.max(i + nums[i], farthest);
            if(i == r){
                r = farthest;
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 3, 4, 5, 4, 2, 1, 1};
        System.out.println(jump(arr));
    }
}
