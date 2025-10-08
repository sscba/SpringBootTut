package com.striver.dsa.stack;

import java.util.ArrayList;
import java.util.List;


public class AsteriodCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> ls = new ArrayList<>();
        int n = asteroids.length;
        for(int i=0; i<n; i++){
            if(asteroids[i] > 0 ) ls.add(asteroids[i]);
            else{
                while(!ls.isEmpty() && ls.getLast()>0 && ls.getLast() < Math.abs(asteroids[i])){
                    ls.removeLast();
                }
                if(!ls.isEmpty() && ls.getLast() == Math.abs(asteroids[i])){
                    ls.removeLast();
                }
                else if(ls.isEmpty() || ls.getLast()<0){
                    ls.add(asteroids[i]);
                }
            }
        }
        return ls.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {8,-8};
        int[] ans = asteroidCollision(arr);
        for(int ele:ans){
            System.out.print(ele+" ");
        }
    }
}
