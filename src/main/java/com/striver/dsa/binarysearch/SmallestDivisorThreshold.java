package com.striver.dsa.binarysearch;

public class SmallestDivisorThreshold {

    private int[] findMinMaxElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int ele : nums){
            min = Math.min(min,ele);
            max = Math.max(max,ele);
        }
        return new int[]{min,max};
    }

    public int solve(int[] nums,int threshold){

        int[] minMaxLimit = findMinMaxElement(nums);
        int low = 1;
        int high = minMaxLimit[1];

        while(low <= high){
            int divisor = (low+high)/2;
            //calculate the sum
            int sum =0;
            for(int ele: nums){
                sum += Math.ceil((double) ele/ (double)divisor);
            }
            System.out.println(" sum : "+ sum+ " low: "+ low + " high: "+high + " mid: "+ divisor);
            if(sum > threshold){
                low = divisor + 1;
            }else{
                high = divisor -1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,5,9};
        int threshold = 6;

        int ans = new SmallestDivisorThreshold().solve(arr,threshold);
        System.out.println(ans);
    }
}
