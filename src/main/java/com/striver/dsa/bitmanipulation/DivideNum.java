package com.striver.dsa.bitmanipulation;

public class DivideNum {

    public int divide(int dividend, int divisor) {
        // special overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = 1;
        //check ans sign
        if ((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        //logic
        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1)))
                cnt++;
            ans += (1L << cnt);
            n = n - (d << cnt);
        }
        if (ans > Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
        if (ans > Integer.MAX_VALUE && sign == -1) return Integer.MIN_VALUE;

        return sign * (int)ans;
    }

    public static void main(String[] args) {
        int dividend = 224;
        int divisor = 15;

        int ans = new DivideNum().divide(dividend, divisor);
        System.out.println(ans);
    }
}
