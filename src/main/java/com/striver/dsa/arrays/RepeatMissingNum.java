package com.striver.dsa.arrays;

import java.util.HashSet;

import java.util.Set;

public class RepeatMissingNum {

    public int[] solve(int[] nums){

        int n = nums.length;

        int mathSum = n*(n+1)/2;
        int missingNum = 0;
        int repNum = 0;
        int actSum = 0;

        Set<Integer> numSet = new HashSet<>();

        for(int i=0;i<n;i++){
            if(numSet.contains(nums[i])){
                repNum=nums[i];
            }else{
                numSet.add(nums[i]);
            }
            actSum += nums[i];
        }
        missingNum = mathSum - actSum + repNum;
        return new int[]{repNum,missingNum};
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,5,1};
        int[] ans = new RepeatMissingNum().solve(arr);
        System.out.println(" RepNum: "+ ans[0] + " MissingNum: "+ ans[1]);
    }
}
