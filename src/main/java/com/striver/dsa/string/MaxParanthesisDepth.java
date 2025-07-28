package com.striver.dsa.string;

public class MaxParanthesisDepth {

    public int maxDepth(String s) {
        int maxDepthCnt = 0;
        int cnt = 0;
        for(char c: s.toCharArray()){
            if(c == '(') cnt++;
            else if(c == ')' ) cnt--;
            maxDepthCnt = Math.max(maxDepthCnt,cnt);
        }

        return maxDepthCnt;
    }

    public static void main(String[] args) {
        String s = "((a)+(((b))))";

        int ans = new MaxParanthesisDepth().maxDepth(s);
        System.out.println(ans);
    }
}
