package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int openCount = 0;
        int closeCount = 0;
        generate(ans,sb,n,openCount,closeCount);
        return ans;
    }

    public void generate(List<String> ans, StringBuilder sb, int n, int openCount, int closeCount){
        //base case if all open has all closed parenthesis
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return ;
        }

        //add open parenthesis
        if(openCount < n){
            sb.append("(");
            generate(ans,sb,n,openCount+1,closeCount);
            sb.deleteCharAt(sb.length()-1);
        }

        //add close parenthesis
        if(closeCount < openCount){
            sb.append(")");
            generate(ans,sb,n,openCount,closeCount+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 10;

        List<String> ans = new GenerateParenthesis().generateParenthesis(n);

        ans.forEach(ele -> System.out.println(ele+ " "));
        System.out.println(ans.size());

    }
}
