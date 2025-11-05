package com.striver.dsa.greedy;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0; int ten = 0;
        for(int i=0; i<n ; i++){
            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10){
                if(five > 0){
                    five--;
                }
                else{
                    return false;
                }
                ten++;
            }else{
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,5,20,20,5,5,20,5};
        System.out.println(lemonadeChange(bills));
    }
}
