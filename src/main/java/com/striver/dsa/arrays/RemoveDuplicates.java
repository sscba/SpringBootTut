package com.striver.dsa.arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) return n;
        int k = 0;
        for (int i = 1; i < n; i++) {
            if (nums[k] != nums[i]) {
                nums[k + 1] = nums[i];
                k++;
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        int k = new RemoveDuplicates().removeDuplicates(arr);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
