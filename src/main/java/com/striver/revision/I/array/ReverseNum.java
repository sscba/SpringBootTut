package com.striver.revision.I.array;

public class ReverseNum {

    public static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int digit = x%10;
            x = x/10;
            //check overflow
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && digit == 7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && digit == 8)) return 0;
            rev = rev*10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        int n = -3213422;
        System.out.println(reverse(n));
    }
}
