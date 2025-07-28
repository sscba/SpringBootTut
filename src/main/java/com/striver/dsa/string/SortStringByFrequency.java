package com.striver.dsa.string;

import java.util.*;
import java.util.stream.Collectors;

public class SortStringByFrequency {

    private static Map<Character, Integer> sortByValues(Map<Character, Integer> mp) {
        return mp.entrySet()
                .stream()
                .sorted((i1, i2) ->
                        i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
    }


    private static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }


    public String frequencySort(String s) {
        if(s.length() == 1) return s;
        char[] charArr = s.toCharArray();
        Map<Character,Integer> charFreqMap = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        //record all frequency
        for(char letter : charArr){
            charFreqMap.put(letter, charFreqMap.getOrDefault(letter,0)+1);
        }

        Map<Character,Integer> sortedCharFreqMap = sortByValues(charFreqMap);

        for(Map.Entry<Character,Integer> entry : sortedCharFreqMap.entrySet()){
            int freq = entry.getValue();
            while(freq > 0 ){
                ans.append(entry.getKey());
                freq--;
            }
        }

        return ans.toString();
    }

    public String frequencySortMinHeap(String s) {
        if (s.length() == 1) return s;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Min-heap: lowest frequency at the top
        PriorityQueue<Map.Entry<Character, Integer>> minHeap =
                new PriorityQueue<>(Map.Entry.comparingByValue());

        minHeap.addAll(freqMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!minHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = minHeap.poll();
            char c = entry.getKey();
            int freq = entry.getValue();
            sb.append(String.valueOf(c).repeat(freq));  // Java 11+
        }

        return sb.toString();
    }

    public String optimalSol(String s){
        if(s.length() == 1) return s;
        char[] charArr = s.toCharArray();
        Map<Character,Integer> charFreqMap = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        //record all frequency
        for(char letter : charArr){
            charFreqMap.put(letter, charFreqMap.getOrDefault(letter,0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());

        maxHeap.addAll(charFreqMap.entrySet());

        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            int freq = entry.getValue();
            while(freq > 0){
                ans.append(entry.getKey());
                freq--;
            }
        }

        return ans.toString();
    }


    public static void main(String[] args) {

        String s = "tree";

        long st = System.currentTimeMillis();
        String ans = new SortStringByFrequency().optimalSol(s);
        long et = System.currentTimeMillis();
        System.out.println(ans + " Time Taken(ms): "+ (et-st));

        //        System.out.println('s'*2);

//        Map<Character, Integer> charMap = new HashMap<>();
//        charMap.put('t', 1);
//        charMap.put('r', 1);
//        charMap.put('e', 2);
//        charMap.put('w', 3);
//        charMap.put('m', 2);
//
//        printMap(charMap);
//        System.out.println(":::::::::::::::::::");
//        charMap = sortByValues(charMap);
//
//        printMap(charMap);



    }
}
