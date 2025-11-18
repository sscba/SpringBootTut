package com.striver.dsa.greedy;

public class Candy {

    public static int candy(int[] ratings) {
        int n=ratings.length;
        int[] left= new int[n];
        int[] right= new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i=1;i<n; i++){
            //left count
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
            //right count
            if(ratings[n-1-i] > ratings[n-i]){
                right[n-1-i] = right[n-i]+1;
            }else{
                right[n-1-i] = 1;
            }
        }
        int sum = 0;
        for(int i=0; i<n ; i++){
            sum += Math.max(left[i],right[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int candy[] = {1,2,2};
        System.out.println(candy(candy));
    }
}
