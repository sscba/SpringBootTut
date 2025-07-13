package com.striver.dsa.binarysearch;

public class PaintersPartition {

    public int solve(int[] nums,int k){
        int[] range = findRange(nums);
        int low = range[0];
        int high = range[1];

        while(low <= high){
            int time = (low+high)/2;
            int painterReq = countPainter(nums,time);
            if(painterReq > k) low = time + 1;
            else high = time -1 ;
        }
        return low;
    }

    private int countPainter(int[] nums, int time) {
        int painter =1 ;
        int boardsPainted = 0;
        for(int i =0;i<nums.length;i++){
            if(boardsPainted + nums[i] <= time ){
                boardsPainted += nums[i];
            }
            else{
                painter++;
                boardsPainted = nums[i];
            }
        }
        return painter;
    }

    private int[] findRange(int[] nums) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int ele:nums){
            min = Math.max(ele,min);
            max += ele;
        }
        return new int[]{min,max};
    }

    public static void main(String[] args) {
        int[] boards = {10,20,30,40};
        int k =3;

        int ans = new PaintersPartition().solve(boards,k);
        System.out.println(ans);

    }
}
