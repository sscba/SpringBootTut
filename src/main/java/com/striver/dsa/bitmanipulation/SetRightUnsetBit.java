package com.striver.dsa.bitmanipulation;

public class SetRightUnsetBit {

    static int setRightmostUnsetBit(int n)
    {
        // Special case: if n is 0, set the rightmost bit to 1
        if(n == 0)
            return 1;

        // If all bits of 'n' are set (number is of the form 2^k - 1),
        // return the next number with one higher bit set (2*n + 1)
        if((n & (n+1)) == 0){
            return (n<<1) + 1;
        }

        // Otherwise, set the rightmost unset bit by n | (n + 1)
        return (n| (n+1)) ;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(setRightmostUnsetBit(n));
    }
}
