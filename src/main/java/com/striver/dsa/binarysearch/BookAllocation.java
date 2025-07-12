package com.striver.dsa.binarysearch;

import java.lang.reflect.Array;
import java.util.Collections;

public class BookAllocation {

    public int solve(int[] arr,int k){
        int[] range = findRange(arr);
        int low = range[0];
        int high = range[1];

        while(low <= high){
            int pages = (low + high)/2;
            int studentCnt = getStudentCount(arr,pages);
            if(studentCnt <= k){
                high = pages -1;
            }else{
                low = pages + 1;
            }
        }
        return low;
    }

    private int getStudentCount(int[] arr, int pages) {
        int studentCnt = 1;
        int pagesAllocated = 0;
        for(int i =0 ;i<arr.length;i++){
            if(pagesAllocated + arr[i] <= pages){
                pagesAllocated += arr[i];
            }else{
                studentCnt++;
                pagesAllocated = arr[i];
            }
        }
        return studentCnt;
    }

    private int[] findRange(int[] arr) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int ele : arr){
            min = Integer.max(ele,min);
            max +=ele;
        }

        return new int[]{min,max};
    }

    public static void main(String[] args) {
        int books[] = {12,34,67,90};
        int k = 2;
        int ans = new BookAllocation().solve(books,k);
        System.out.println(ans);
    }
}
