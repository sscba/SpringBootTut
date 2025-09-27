package com.striver.dsa.recursion;

public class Powxn {

    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        if (n < 0) {
            return 1/(x * myPow(x, -(n + 1)));
        }

        double half = myPow(x,n/2);

        if(n%2 == 0){
            return half*half;
        }else{
            return half*half*x;
        }
    }

    public static void main(String[] args) {
        double x = 2.100;
        int n = -3;

        double ans = new Powxn().myPow(x, n);
        System.out.println(ans);


    }
}
