package com.striver.dsa.string;

public class RemoveParanthesis {

    public String solve(String s){
        int n = s.length();
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++){
            if (s.charAt(i) == '(' && cnt == 0) cnt++;
            else if(s.charAt(i) == '(' && cnt >= 1){
                ans.append(s.charAt(i));
                cnt++;
            }
            else if(s.charAt(i) == ')' && cnt > 1 ){
                ans.append(s.charAt(i));
                cnt--;
            }
            else if(s.charAt(i) == ')' && cnt==1){
                cnt--;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "(())()";
        String ans = new RemoveParanthesis().solve(str);
        System.out.println(ans);
    }
}
