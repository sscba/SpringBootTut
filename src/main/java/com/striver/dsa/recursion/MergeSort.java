package com.striver.dsa.recursion;

import java.util.ArrayList;

public class MergeSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int leftArrSize = mid - start + 1;
        int rightArrSize = end - mid;

        ArrayList<Integer> leftArr = new ArrayList<>(leftArrSize);
        ArrayList<Integer> rightArr = new ArrayList<>(rightArrSize);

        for (int i = 0; i < leftArrSize; i++) {
            leftArr.add(arr[start + i]);
        }
        for (int i = 0; i < rightArrSize; i++) {
            rightArr.add(arr[i + mid + 1]);
        }

        int i = 0, j = 0;
        int k = start;

        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr.get(i) > rightArr.get(j)) {
                arr[k] = rightArr.get(j);
                j++;
            } else {
                arr[k] = leftArr.get(i);
                i++;
            }
            k++;
        }

        //add remaining elements
        //left arr
        while (i < leftArrSize) {
            arr[k++] = leftArr.get(i++);
        }
        //right arr
        while (j < rightArrSize) {
            arr[k++] = rightArr.get(j++);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 3, 0, 9, 76, 54};

        MergeSort.sort(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }

    }
}
