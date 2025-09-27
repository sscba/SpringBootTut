package com.striver.dsa.bitmanipulation;

public class FindXOR {

    public static int findXor(int L,int R){
        int ans = 0;
        for(int i=L; i<=R; i++){
            ans = ans^i;
        }
        return ans;
    }
    public static int optimal(int L,int R){
        return xor(L-1) ^ xor(R);
    }
    private static int xor(int n){
        if(n%4 == 1) return 1;
        if(n%4 == 2) return n+1;
        if(n%4 == 3) return 0;
        return n;
    }

    public static void main(String[] args) {
        int l = 1;
        int r = 3;
        System.out.println(findXor(l,r));
        System.out.println(optimal(l,r));
    }
}
