package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubseqWithSumK {

    public static List<List<Integer>> solve(int[] arr, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        int n = arr.length;

        get(arr,n,k,0,res,ans,sum);

//        int count = count(arr,n,k,0,sum);
//        System.out.println(count);
        return res;
    }

    public static void get(int[] arr, int n, int k, int i, List<List<Integer>> res, List<Integer> ans, int sum) {
        //base case
        if(i == n){
            if(sum == k){
                res.add(new ArrayList<>(ans));
//                return true;
            }
            return ;
        }

        ans.add(arr[i]);
        sum += arr[i];
        get(arr,n,k,i+1,res,ans,sum);
        ans.remove(ans.size()-1);
        sum -= arr[i];
        get(arr,n,k,i+1,res,ans,sum);
//        return false;
    }

    public static boolean getOne(int[] arr, int n, int k, int i, List<List<Integer>> res, List<Integer> ans, int sum) {
        //base case
        if(i == n){
            if(sum == k){
                res.add(new ArrayList<>(ans));
                return true;
            }
            return false;
        }

        ans.add(arr[i]);
        sum += arr[i];
        if(getOne(arr,n,k,i+1,res,ans,sum)) return true;
        ans.remove(ans.size()-1);
        sum -= arr[i];
        if(getOne(arr,n,k,i+1,res,ans,sum)) return true;
        return false;
    }

    public static int count(int[] arr, int n, int k, int i, int sum) {
        //base case
        if(i == n){
            if(sum == k){
                return 1;
            }
            return 0;
        }
        sum += arr[i];
        int l = count(arr,n,k,i+1,sum);

        sum -= arr[i];
        int r = count(arr,n,k,i+1,sum) ;
        return l+r;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int k = 3;

        List<List<Integer>> res = solve(arr,k);

        for(List<Integer> list : res){
            list.forEach(ele -> System.out.print(ele + " "));
            System.out.println("");
        }

    }
}
