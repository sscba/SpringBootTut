package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    public List<Integer> subsetSum(int[] arr){
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int sum = 0;
        getSum(arr,n,0,ans,sum);
        ans.sort((o1,o2) -> o1-o2);
        return ans;
    }

    private void getSum(int[] arr, int n, int i, List<Integer> ans, int sum) {
        //base case
        if(n == i){
            ans.add(sum);
            return;
        }
        sum += arr[i];
        getSum(arr,n,i+1,ans,sum);
        sum -= arr[i];
        getSum(arr,n,i+1,ans,sum);
    }

    public static void main(String[] args) {
        int[] arr = {5,1,2};

        List<Integer> ans = new SubsetSum().subsetSum(arr);
        ans.forEach(ele -> System.out.print(ele +" "));
    }
}
