package com.striver.dsa.arrays;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class LeaderElementArray {
    public ArrayList<Integer>
    printLeadersBruteForce(int[] arr, int n){

        ArrayList<Integer> ans= new ArrayList<>();

        // Last element of an array is always a leader,
        // push into ans array.
        int max = arr[n - 1];

        ans.add(arr[n-1]);

        // Start checking from the end whether a number is greater
        // than max no. from right, hence leader.
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {32,1,2,3,4,5,43,2,1,0};
        ArrayList<Integer> ans = new LeaderElementArray().printLeadersBruteForce(arr,arr.length);
    }
}
