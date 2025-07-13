package com.striver.dsa.binarysearch;

public class SplitArrayBS {

    public int[] getRange(int[] nums){
        int minRange = Integer.MIN_VALUE;
        int maxRange = 0;
        for(int ele : nums){
            minRange = Math.max(ele,minRange);
            maxRange += ele;
        }
        return new int[]{minRange,maxRange};
    }

    public int solve(int[] nums,int k){
        int[] range = getRange(nums);
        int low = range[0];
        int high = range[1];

        if(k == nums.length) return low;

        //linear search
//        return linearSearch(nums,k,low,high);
        return binarySearchLogic(nums,k,low,high);
    }

    private int binarySearchLogic(int[] nums, int k, int low, int high) {
        while(low<=high){
            int maxSum = (low+high)/2;
            int partitions = getPartitionCntBySum(nums,maxSum);
            if(partitions <= k ){
                high = maxSum -1;
            }
            else{
                low = maxSum + 1;
            }

        }
        return low;
    }

    private int linearSearch(int[] nums, int k, int low, int high) {
        for(int i = low; i<=high; i++){
            int partitionsCnt = getPartitionCntBySum(nums,i);
            if(partitionsCnt==k){
                return i;
            }
        }
        return -1;
    }

    private int getPartitionCntBySum(int[] nums, int possibleSum) {
        int partitions =1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum + nums[i] <= possibleSum){
                sum += nums[i];
            }else{
                partitions++;
                sum = nums[i];
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int parts = 2;

        int ans = new SplitArrayBS().solve(arr,parts);
        System.out.println(ans);
    }
}
