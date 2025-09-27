package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumLetter {

    public Map<Character, String> getDigitCharMapping() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = getDigitCharMapping();
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        generateCombinations(digits, 0, ans, new StringBuilder(), map);
        return ans;
    }

    public void generateCombinations(String digits, int Indx, List<String> ans, StringBuilder ds, Map<Character, String> map) {
        //base case
        if (Indx >= digits.length()) {
            ans.add(ds.toString());
            return;
        }

        char digit = digits.charAt(Indx);
        String letters = map.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            ds.append(letters.charAt(i));
            generateCombinations(digits, Indx + 1, ans, ds, map);
            ds.deleteCharAt(ds.length() - 1);
        }


    }

    public static void main(String[] args) {
        String digits = "23";

        List<String> ans = new PhoneNumLetter().letterCombinations(digits);
        for (String ele : ans) {
            System.out.println(ele);
        }

    }
}
