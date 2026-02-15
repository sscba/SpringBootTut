package com.striver.revision.II.array;

public class NextPermutation {

    public void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }

    public void nextPermutation(int[] nums){
        int n = nums.length;
        int breakPoint = -1;
        //find breakPoint
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                breakPoint = i;
                break;
            }
        }
        //no break found
        if(breakPoint == -1) reverse(nums,0,n-1);

        //find greater element than breakpoint from end
        for(int i=n-1; i>breakPoint; i--){
            if(nums[breakPoint] < nums[i]){
                swap(nums,breakPoint,i);
                break;
            }
        }

        reverse(nums,breakPoint+1, n-1);
    }
}
