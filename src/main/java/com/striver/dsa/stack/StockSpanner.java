package com.striver.dsa.stack;

import java.util.ArrayList;

public class StockSpanner {
    ArrayList<Integer> prices;
    public StockSpanner() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int i = prices.size()-1;
        int cnt=0;
        while(i>=0 && prices.get(i) <= price){
            cnt++;
            i--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        System.out.println("current price: "+7+" "+sp.next(7));
        System.out.println("current price: "+2+" "+sp.next(2));
        System.out.println("current price: "+1+" "+sp.next(1));
        System.out.println("current price: "+3+" "+sp.next(3));
        System.out.println("current price: "+3+" "+sp.next(3));
        System.out.println("current price: "+1+" "+sp.next(1));
        System.out.println("current price: "+8+" "+sp.next(8));

    }

}
