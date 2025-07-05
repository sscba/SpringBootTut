package com.striver.dsa.arrays;

public class Merge2SortedArray {

    public void merge(int[] num1,int[] num2,int m,int n){
        int i= m-1;
        int j= n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(num1[i] > num2[j]){
                num1[k--] = num1[i--];
            }
            else {
                num1[k--] = num2[j--];
            }

        }
        while(j>=0){
            num1[k--] = num2[j--];
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,2,4,5,0,0,0,0};
        int[] arr2 = {2,3,6,9};
        int m = 5;
        int n=4;
    }
}
