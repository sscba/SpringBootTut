package com.striver.dsa.matrix;

import java.util.Arrays;
import java.util.Collections;

public class RotateMatrixBy90degree {

    private void swap(int[][] arr, int i, int j) {
        int tmp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = tmp;
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }


    private void reverse(int[] arr) {
       int start = 0;
       int end = arr.length-1;

       while(start<=end){
           swap(arr,start++,end--);
       }
    }

    public void solve(int[][] mat){
        int n = mat.length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                swap(mat,i,j);
            }
        }
        //reverse every row
        for (int[] ints : mat) {
            reverse(ints);
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,1},{5,0,6},{4,3,9}};
    }

}
