package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence {


    public static void print(int[] arr, int i, int n, List<Integer> ans){
        //base case
        if(i>=n){
            if(ans.size() == 0 ){
                System.out.print("{}");
            }
            for(int ele : ans)
                System.out.print(ele+ " ");
            System.out.println(" ");
            return ;
        }

        //add element
        ans.add(arr[i]);
        //take
        print(arr,i+1,n,ans);

        //remove
        ans.remove(ans.size() - 1);

        //not take
        print(arr,i+1,n,ans);

    }

    public static void main(String[] args) {
        int[] arr = {3,1,2};

        ArrayList<Integer> ans = new ArrayList<>();
        print(arr,0,arr.length,ans);


    }
}
