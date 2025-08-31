package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinary {

    public List<String> generate(int n){
        List<String> ans = new ArrayList<>();
        if(n<0) return ans;
        if(n==0) {
            ans.add("");
            return ans;
        }

        StringBuilder sb = new StringBuilder();
        dfs(n,false,sb,ans);
        return ans;
    }

    private void dfs(int n, boolean prevOne, StringBuilder sb, List<String> ans) {
        if(n==0){
            ans.add(sb.toString());
            return ;
        }

        //append 0 always possible
        sb.append('0');
        dfs(n-1,false,sb,ans);
        sb.deleteCharAt(sb.length()-1);

        //add one only if prev wasn't one
        if(!prevOne){
            sb.append('1');
            dfs(n-1,true,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new GenerateBinary().generate(n);
        System.out.println(ans.size());
        ans.forEach(ele -> System.out.println(ele+" "));

    }
}
