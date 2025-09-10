package com.striver.dsa.string;

public class LongestPrefixStr {

    private int maxElementsToTraverse(String[] strs){
        int ans = Integer.MAX_VALUE;

        for(String str : strs){
            ans = Math.min(ans,str.length());
        }
        return ans;
    }

    public String longestCommonPrefix(String[] strs) {
        int n = maxElementsToTraverse(strs);
        int strsLen = strs.length;
        StringBuilder ans = new StringBuilder();
        for(int i =0;i<n;i++){
            char character = strs[0].charAt(i);
            boolean allSameCharacter = isCharacterSameForAllStrs(strs,i,character,strsLen);
            if(allSameCharacter){
                ans.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return ans.toString();
    }

    private boolean isCharacterSameForAllStrs(String[] strs,int i, char character, int strsLen) {
        for(int j =0;j<strsLen;j++){
            if(strs[j].charAt(i) != character) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str = {"carrrrrrrrrrr","car"};

        String ans = new LongestPrefixStr().longestCommonPrefix(str);
        System.out.println(ans);
    }
}
