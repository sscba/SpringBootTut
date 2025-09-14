package com.striver.dsa.bitmanipulation;

public class Conversion {

    public String decimalToBinary(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            if(n % 2 == 1)
                res.append("1");
            else
                res.append("0");
            n = n/2;
        }
        res.reverse();
        return res.toString();
    }

    public int binaryToDecimal(String s){
        int i=s.length()-1;
        int num = 0;
        int pow2 = 1;

        while(i>=0){
            if(s.charAt(i) == '1')
                num += pow2;
            pow2 *= 2;
            i--;
        }
        return num;
    }

    public static void main(String[] args) {
        int a = 10;

        String bin = new Conversion().decimalToBinary(a);
        System.out.println(bin);

        int dec = new Conversion().binaryToDecimal(bin);
        System.out.println(dec);
    }
}
