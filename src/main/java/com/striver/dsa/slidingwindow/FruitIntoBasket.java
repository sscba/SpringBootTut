package com.striver.dsa.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int l=0;
        int r=0;
        int maxFruits=0;
        while(r<n){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
            while(mp.size()>2){
                mp.put(fruits[l],mp.get(fruits[l])-1);
                if(mp.get(fruits[l]) == 0) mp.remove(fruits[l]);
                l++;
            }
            if(mp.size()<=2){
                maxFruits = Math.max(maxFruits,r-l+1);
            }
            r++;
        }
        return maxFruits;
    }

    public int optimal(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int l=0;
        int r=0;
        int maxFruits=0;
        while(r<n){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
            if(mp.size()>2){
                mp.put(fruits[l],mp.get(fruits[l])-1);
                if(mp.get(fruits[l]) == 0) mp.remove(fruits[l]);
                l++;
            }
            else{
                maxFruits = Math.max(maxFruits,r-l+1);
            }
            r++;
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        int ans = new FruitIntoBasket().optimal(fruits);
        System.out.println(ans);
    }

}
