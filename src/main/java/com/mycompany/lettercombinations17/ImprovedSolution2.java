package com.mycompany.lettercombinations17;

import java.util.*;

// Iteration approach. speed wise, same as recursive.
// 5ms Beats 30.72%; 42.06MB Beats 78.41%
public class ImprovedSolution2 {

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

        List<String> results = new ArrayList<>();
        for (int i=digits.length()-1; i>=0; i--) {
            String letters = map.get(digits.charAt(i));
            if (letters != null) {
                if (i==digits.length()-1) {
                    results.addAll(getArrayFromLetters(letters));
                } else {
                    results = combine(letters, results);
                }
            }
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

    private List<String> combine(String s, List<String> combinations) {
        List<String> results = new ArrayList<>();
        for (String combination : combinations) {
            for (int i=0; i<s.length(); i++) {
                results.add(s.charAt(i) + combination);
            }
        }
        return results;
    }
}
