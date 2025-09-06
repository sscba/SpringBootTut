package com.striver.dsa.recursion;



public class QuickSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    private static void quickSort(int[] arr, int st, int ed) {
        if (st < ed) {
            int partition = getPartition(arr, st, ed);
            quickSort(arr, st, partition-1);
            quickSort(arr, partition + 1, ed);
        }
    }

    private static int getPartition(int[] arr, int st, int ed) {
        int i = st;
        int j = ed;
        int pivot = st;

        while (i < j) {
            while(i<ed && arr[i] <= arr[pivot]) i++;
            while(j>st && arr[j] > arr[pivot]) j--;
            if(i<j) swap(arr,i,j);
        }
        swap(arr,pivot,j);
        return j;

    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 7, 6, 5, 3, 1};

        QuickSort.sort(arr);
        for(int a: arr){
            System.out.print(a+" ");
        }
    }
}
