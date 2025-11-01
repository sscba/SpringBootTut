package com.striver.dsa.slidingwindow;

public class LongestRepeatingChar {

    public static int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0; int r=0; int maxFreq=0; int maxLen=0;
        int[] hash = new int[26];
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,hash[s.charAt(r)-'A']);
            while((r-l+1)-maxFreq > k){
                hash[s.charAt(l)-'A']--;
                maxFreq=0;
                for(int i=0; i<26; i++){
                    maxFreq= Math.max(maxFreq,hash[i]);
                }
                l++;
            }
            if((r-l+1)-maxFreq <= k){
                maxLen= Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s= "ABCBABBA";
        int k =2;
        System.out.println(characterReplacement(s,k));
    }
}
