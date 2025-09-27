package com.striver.dsa.string;

public class ReverseWordsInString {

    public String bruteSol(String str) {

        StringBuilder ans = new StringBuilder();
        String revStr = new StringBuilder(str).reverse().toString();
        int n = revStr.length();
        for (int i = 0; i < n; i++) {
            StringBuilder word = new StringBuilder();
            while (i < n && revStr.charAt(i) != ' ') {
                word.append(revStr.charAt(i));
                i++;
            }
            if (!word.isEmpty()) {
                ans.append(" " + word.reverse().toString());
            }
        }

        return ans.substring(1);
    }

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int startIndex = s.length()-1;
        while (startIndex>=0){
            //skip spaces
            while ( startIndex>=0 && s.charAt(startIndex)==' '){
                startIndex--;
            }
            //string out of bound
            if(startIndex<0){
                break;
            }

            int endIndex = startIndex;
            while ( startIndex>=0 && s.charAt(startIndex)!=' '){
                startIndex--;
            }
            // word
            if(res.length()==0){
                res.append(s.substring(startIndex+1,endIndex+1));
            } else {
                res.append(" ");
                res.append(s.substring(startIndex+1,endIndex+1));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "a   man         is cooking                  ";

        String ans = new ReverseWordsInString().reverseWords(str);
        System.out.println(ans);


    }
}
