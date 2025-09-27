package com.striver.revision.I.array;

public class NextPermutation {

    private static void reverse(int[] arr,int start,int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

    public static void nextPermutation(int[] arr){
        int n = arr.length;
        int breakPoint = -1;
        //find breakPoint where ith element is smaller than i+1th element
        for(int i=n-2; i>=0 ; i--){
            if(arr[i] < arr[i+1]){
                breakPoint = i;
                break;
            }
        }
        if(breakPoint == -1) {
            reverse(arr,0,n-1);
            return;
        }
        //find first larger element than breakPoint element
        for(int i= n-1;i> breakPoint; i--){
            if(arr[breakPoint] < arr[i]){
                swap(arr,breakPoint,i);
                break;
            }
        }
        //reverse arr from breakPoint+1 to end
        reverse(arr,breakPoint+1,n-1);
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,3};
        nextPermutation(arr);
        for(int ele: arr){
            System.out.print(ele+" ");
        }
    }
}
