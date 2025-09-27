package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        generatePallindrome(s,0,new ArrayList<>(),res);
        return res;
    }

    private void generatePallindrome(String s, int indx,List<String> ds, List<List<String>> res) {
        //base case
        if(indx == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=indx; i < s.length(); i++){
            if(isPallindrome(s,indx,i)){
                ds.add(s.substring(indx,i+1));
                generatePallindrome(s,i+1,ds,res);
                ds.removeLast();
            }
        }
    }

    private boolean isPallindrome(String s, int start, int end) {
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "mafmamafam";
        List<List<String>> res = new PallindromePartition().partition(s);
        for(List<String> str: res){
            System.out.println(str);
        }
    }
}
