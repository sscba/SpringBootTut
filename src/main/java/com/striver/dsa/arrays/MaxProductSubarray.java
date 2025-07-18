package com.striver.dsa.arrays;

public class MaxProductSubarray {

    public int optimalSol(int[] nums){
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;

        for(int i=0;i<n;i++){
            if(prefix == 0) prefix =1;
            if(suffix == 0) suffix =1;
            prefix *= nums[i];
            suffix *= nums[n-i-1];

            maxProduct = Math.max(maxProduct,Math.max(prefix,suffix));
        }
        return maxProduct;


    }

    public int bruteForceSol(int[] nums){
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i =0;i<n;i++){
            int product = 1;

            for(int j=i;j<n;j++){
                product *= nums[j];
                maxProduct = Math.max(maxProduct,product);
            }
        }
        return maxProduct;

    }

    public static void main(String[] args) {
        int[] arr = {2,3,0,-1,-2,1,7,0,-1};
        int ans = new MaxProductSubarray().optimalSol(arr);
        System.out.println(ans);
    }
}
