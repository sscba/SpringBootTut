package com.striver.dsa.string;

public class LongestPalindromeSubstring {

    public String longestPalindrome(String s){
        int n = s.length();
        int maxPalindromeLen = Integer.MIN_VALUE;
        int firstEleIndx = 0;
        int lastEleIndx = 0;
        for(int i = 0;i<n-1;i++){
            for(int j =i+1;j<n;j++){
                if(checkPalindrome(s.substring(i,j+1))){
                    int currPalindromeLen = j-i+1;
                    if(currPalindromeLen > maxPalindromeLen){
                        firstEleIndx = i;
                        lastEleIndx = j;
                        maxPalindromeLen=currPalindromeLen;
                    }
                }
            }
        }
        return s.substring(firstEleIndx,lastEleIndx+1);
    }

    private boolean checkPalindrome(String substring) {
        int n = substring.length();
        int i=0;
        while(i<n/2){
            if(substring.charAt(i) != substring.charAt(n-i-1)) return false;
            i++;
        }
        return true;
    }

    public String optimalSol(String s){
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int resLen = 0;
        int start=0;
        int end=0;

        for(int i=0;i<n;i++){
            int l = i;
            int r = i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > resLen){
                    start=l;
                    end=r;
                    resLen = r-l+1;
                }
                l--;
                r++;
            }

            //even len palindrome
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > resLen){
                    start=l;
                    end=r;
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
        }
    return s.substring(start,end+1);
    }

    public static void main(String[] args) {
        String s = "babad";
        String ans = new LongestPalindromeSubstring().optimalSol(s);
        System.out.println(ans);
    }
}
