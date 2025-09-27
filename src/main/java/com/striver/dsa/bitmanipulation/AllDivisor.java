package com.striver.dsa.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class AllDivisor {

    public static List<Integer> getAllDivisor(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            if(n%i == 0){
                ans.add(i);
                if(n/i != i){
                    ans.add(n/i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 34341;
        List<Integer> ans = getAllDivisor(n);
        ans.sort((a,b) -> a-b);
        ans.forEach(ele -> System.out.print(ele+" "));
    }
}
