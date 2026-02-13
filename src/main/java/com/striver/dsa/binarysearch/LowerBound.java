package com.striver.dsa.binarysearch;

public class LowerBound {

    public int lowerBound(int[] arr,int n){
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] == n){
                ans = mid;
                end = mid-1;
            }else if(arr[mid] > n) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

    public int upperBound(int[] arr,int n){
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] == n){
                ans = mid;
                start = mid+1;
            }else if(arr[mid] > n) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3,4,5};
        LowerBound bound = new LowerBound();
        int ans  =bound.lowerBound(arr,2);
        System.out.println(ans);
    }
}
