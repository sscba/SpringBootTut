package com.striver.dsa.arrays;

import java.util.HashMap;

public class Sum2 {

    public int[] twoSum(int[] arr, int target) {
        int[] ans = {0,1};
        int n = arr.length;
        HashMap<Integer,Integer> arrIndexMap = new HashMap<>();

        for(int i =0 ; i< n; i++ ){
            int rem = target - arr[i];
            if(arrIndexMap.containsKey(rem) ){
                ans[0] = i;
                ans[1] = arrIndexMap.get(rem);
                return ans;
            }else{
                arrIndexMap.put(arr[i],i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
