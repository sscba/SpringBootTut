package com.striver.dsa.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();

        Map<Character, Character> charMapping = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char org = s.charAt(i);
            char rep = t.charAt(i);

            if (!charMapping.containsKey(org)) {
                if (!charMapping.containsValue(rep)) charMapping.put(org, rep);
                else {
                    return false;
                }
            } else {
                if (rep != charMapping.get(org)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        boolean ans = new IsomorphicString().isIsomorphic(s, t);
        System.out.println(ans);
    }
}
