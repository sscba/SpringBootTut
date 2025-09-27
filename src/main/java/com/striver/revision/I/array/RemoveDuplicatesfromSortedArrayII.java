package com.striver.revision.I.array;

/**
 * {@link RemoveDuplicatesfromSortedArrayII}
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */


public class RemoveDuplicatesfromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int counter = 0;
        int k = 0;
        for (int i = 1; i < n; i++) {
            if (nums[k] != nums[i]) {
                counter = 0;
                nums[k + 1] = nums[i];
                k++;
            } else if (nums[k] == nums[i] && counter < 1) {
                counter++;
                nums[k + 1] = nums[i];
                k++;
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = removeDuplicates(nums);
        for(int i=0; i<k ; i++) System.out.println(nums[i]);
    }
}
