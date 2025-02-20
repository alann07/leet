package com.mycompany.lettercombinations17;

import java.util.*;

// 6ms beats 8.4%. mem 42.6m, beats 10.52%
public class Solution {

    private static final Map<Character, String> map;

    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        if (digits == null ||
                digits.isEmpty() ||
                digits.length() > 4 ||
                digits.contains("0") ||
                digits.contains("1")) return new ArrayList<>();
        return recursiveFind(digits);
    }

    private List<String> recursiveFind(String digits) {
        if (digits.length() == 1) {
            System.out.println("recursive exit");
            String letters = map.get(digits.charAt(0));
            if (letters == null) return new ArrayList<>();
            return getArrayFromLetters(letters);
        }
        List<String> results = new ArrayList<>();
        if (digits.isEmpty()) {
            return results;
        }
        char digit = digits.charAt(0);
        String letters = map.get(digit);
        if (letters == null) return new ArrayList<>();
        for (int j = 0; j < letters.length(); j++) {
            List<String> subResults = combine(letters.charAt(j), recursiveFind(digits.substring(1)));
            results.addAll(subResults);
        }
        return results;
    }

    private List<String> getArrayFromLetters(String letters) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < letters.length(); i++) {
            results.add(String.valueOf(letters.charAt(i)));
        }
        return results;
    }

    private List<String> combine(char c, List<String> strings) {
        if (strings.isEmpty()) {
            System.out.println("empty strings in [combine]");
            return Collections.singletonList(String.valueOf(c));
        }
        for (int i = 0; i < strings.size(); i++) {
            strings.set(i, c + strings.get(i));
        }
        return strings;
    }
}
