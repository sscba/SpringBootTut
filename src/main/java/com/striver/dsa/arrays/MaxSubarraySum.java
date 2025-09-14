package com.striver.dsa.arrays;

public class MaxSubarraySum {

    public int maxSum(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum = arr[0];

        for(int i=1;i<arr.length;i++){
            sum += arr[i];
            maxSum = Math.max(sum,maxSum);

            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    public int maxSumSubarrayLen(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum = arr[0];
        int start = 0;
        int ansStart=-1, ansEnd=-1;
        for(int i=1;i<arr.length;i++){

            if(sum == 0) start = i; //whenever sum is 0 new subarray starts

            sum += arr[i];
            if(maxSum < sum){
                maxSum = sum;
                //whenever maxsum is updated ending expands from start
                ansStart= start;
                ansEnd = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n ");

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr ={-2, 1, -3, 4, -1, 2, 1, -5, -4,1,-2,3,-3,1,1,1,4,1,-2,1,-5};

        int ans = new MaxSubarraySum().maxSumSubarrayLen(arr);
        System.out.println(ans);
    }
}
