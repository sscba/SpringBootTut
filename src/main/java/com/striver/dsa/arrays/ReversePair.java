package com.striver.dsa.arrays;

public class ReversePair {

    public int solve(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > (long) 2 * nums[right]) right++;
            cnt += right - (mid + 1);
        }
        return cnt;
    }

    private int mergeSort(int[] nums, int low, int high) {
        int cnt = 0;
        if (low < high) {
            int mid = (low + high) / 2;

            cnt += mergeSort(nums, low, mid);
            cnt += mergeSort(nums, mid + 1, high);
            cnt += countPairs(nums, low, mid, high);
            merge(nums, low, mid, high);

            return cnt;
        }
        return cnt;

    }

        private void merge(int[] nums, int low, int mid, int high) {
            int leftArrSize = mid - low + 1;
            int rightArrSize = high - mid;


            int[] leftArr = new int[leftArrSize];
            int[] rightArr = new int[rightArrSize];

            for (int i = 0; i < leftArrSize; i++) {
                leftArr[i] = nums[i + low];
            }
            for (int i = 0; i < rightArrSize; i++) {
                rightArr[i] = nums[mid + 1 + i];
            }

            int i = 0;
            int j = 0;
            int k = low;

            while (i < leftArrSize && j < rightArrSize) {
                if (leftArr[i] <= rightArr[j]) {
                    nums[k] = leftArr[i++];
                } else {
                    nums[k] = rightArr[j++];

                }
                k++;
            }

            while (i < leftArrSize) {
                nums[k++] = leftArr[i++];
            }

            while (j < rightArrSize) {
                nums[k++] = rightArr[j++];
            }

        }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 1};

        int ans = new ReversePair().solve(arr);
        System.out.println("Ans: " + ans);
    }
}
