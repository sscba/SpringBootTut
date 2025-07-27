package com.striver.dsa.string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public boolean bruteSol(String s, String t){
        if(s.length() != t.length()) return false;
        Map<Character,Integer> charFreq = new HashMap<>();

        int n = s.length();
        //record char freq
        for(int i = 0; i<n; i++){
            charFreq.put(s.charAt(i),charFreq.getOrDefault(s.charAt(i),0)+1);
        }

        //check String t has same freq char
        for(int i=0;i<n;i++){
            if(!charFreq.containsKey(t.charAt(i))) return false;
            charFreq.put(t.charAt(i),charFreq.get(t.charAt(i))-1);
        }

        //check all entries in map is cancelled out
        for(Map.Entry<Character,Integer> entry : charFreq.entrySet()){
            if(entry.getValue() != 0 ) return false;
        }
        return true;

    }

    public boolean betterSol(String s, String t){
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "naagmra";

        boolean ans = new Anagram().betterSol(s,t);
        System.out.println(ans);
    }
}
