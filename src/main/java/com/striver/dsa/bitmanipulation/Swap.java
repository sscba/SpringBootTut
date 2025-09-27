package com.striver.dsa.bitmanipulation;

public class Swap {

    static void swap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a: "+ a+ " b: "+ b);
    }

    public static void main(String[] args) {
        int n1 = 13;
        int n2 = 15;
        System.out.println("n1: "+n1+" n2: "+n2);
        swap(n1,n2);
//        System.out.println("n1: "+n1+" n2: "+n2);
    }
}
