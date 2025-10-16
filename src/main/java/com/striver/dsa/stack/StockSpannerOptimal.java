package com.striver.dsa.stack;

import java.util.ArrayList;
import java.util.Stack;

class Pairs{
    int val;
    int ind;
    public Pairs(int val,int ind){
        this.val = val;
        this.ind = ind;
    }
}

public class StockSpannerOptimal {
    Stack<Pairs> prices;
    int ind;
    public StockSpannerOptimal() {
        prices = new Stack<>();
        ind = -1;
    }

    public int next(int price) {
        ind = ind + 1;
        while(!prices.empty() && prices.peek().val <= price){
            prices.pop();
        }
        int ans = ind - (!prices.empty() ? prices.peek().ind : -1);
        prices.push(new Pairs(price,ind));
        return ans;
    }

    public static void main(String[] args) {
        StockSpannerOptimal sp = new StockSpannerOptimal();
        System.out.println("current price: "+7+" "+sp.next(7));
        System.out.println("current price: "+2+" "+sp.next(2));
        System.out.println("current price: "+1+" "+sp.next(1));
        System.out.println("current price: "+3+" "+sp.next(3));
        System.out.println("current price: "+3+" "+sp.next(3));
        System.out.println("current price: "+1+" "+sp.next(1));
        System.out.println("current price: "+8+" "+sp.next(8));

    }
}
