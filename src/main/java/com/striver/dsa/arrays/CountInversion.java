package com.striver.dsa.arrays;

import java.util.ArrayList;

public class CountInversion {

    public int solve(int[] nums){
        return mergeSort(nums,0,nums.length-1);
    }

    private int mergeSort(int[] nums, int low, int high) {

        int cnt =0;
        if(low>=high) return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(nums,low,mid);
        cnt += mergeSort(nums,mid+1,high);
        cnt += merge(nums,low,high,mid);

        return cnt;


    }

    private int merge(int[] nums, int low, int high, int mid) {
        int leftArrSize = mid -low +1;
        int rightArrSize = high - mid ;
        int cnt =0;

        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];

        // put elements of nums to leftArr
        for(int i=0; i<leftArrSize;i++){
            leftArr[i] = nums[i+low];
        }
        // put elements of nums to rightArr
        for(int i=0;i<rightArrSize;i++){
            rightArr[i] = nums[mid+1+i];
        }

        int leftPointer =0;
        int rightPointer = 0;
        int k = low;
        //compare element of left and right Arr and merge
        while(leftPointer < leftArrSize && rightPointer < rightArrSize){
            if(leftArr[leftPointer] > rightArr[rightPointer]){
                //add right element to nums[] and count cnt
                cnt += (mid - leftPointer + 1);
                nums[k] = rightArr[rightPointer++];

            }else{
                nums[k] = leftArr[leftPointer++];
            }
            k++;
        }

        //copy remaining leftArr element if any
        while(leftPointer < leftArrSize){
            nums[k++] = leftArr[leftPointer++];
        }

        //copy remaining rightArr element if any
        while(rightPointer < rightArrSize){
            nums[k++] = rightArr[rightPointer++];
        }

        return cnt;

    }

    private static int merge1(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }

    public static int mergeSort1(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort1(arr, low, mid);  // left half
        cnt += mergeSort1(arr, mid + 1, high); // right half
        cnt += merge1(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    public static int numberOfInversions(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort1(a, 0, n - 1);
    }


    public static void main(String[] args) {
        int[] arr = {5,2,3,4,1};
        int ans = new CountInversion().solve(arr);
        System.out.println("Pairs: "+ ans);

        int ans1 = CountInversion.numberOfInversions(arr,arr.length);
        System.out.println("Striver Pairs: "+ ans1);
    }
}
