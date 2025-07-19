package com.striver.dsa.binarysearch;

public class KthElementIn2SortedArray {

    public int betterSol(int[] arr1,int[] arr2,int k){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int indx = -1;
        int i=0;
        int j=0;
        int ele=-1;
        while(i<n1 && j<n2){
            if(arr1[i] <= arr2[j]){
                ele=arr1[i++];
            }else{
                ele = arr2[j++];
            }
            indx++;
            if(indx == k-1) return ele;
        }

        while(i < n1){
            if(indx == k-1) return arr1[i];
            i++;
            indx++;
        }

        while(j < n2){
            if(indx == k-1) return arr2[j];
            j++;
            indx++;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,16,17,19};
        int[] arr2 = {1,2,4,9,10,14,17,19};

        int ans = new KthElementIn2SortedArray().betterSol(arr1,arr2,6);
        System.out.println(ans);

    }
}
