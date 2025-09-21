package com.striver.revision.I.array;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k = 0;
        for(int i=0;i<n;i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int k = removeElement(nums,val);
        for(int i=0; i < k ; i++) System.out.println(nums[i]);
    }
}
