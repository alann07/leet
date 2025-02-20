package com.mycompany.lettercombinations17;

import java.util.*;

// 5ms Beats 30.72%; 42.49MB Beats 28.02%
public class ImprovedSolution {

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

        String letters = map.get(digits.charAt(0));
        if (digits.length() == 1) {
            if (letters == null) return new ArrayList<>();
            return getArrayFromLetters(letters);
        } else {
            List<String> results = new ArrayList<>();
            List<String> nextLevel = recursiveFind(digits.substring(1));
            if (nextLevel.isEmpty()) {
                if (letters == null) return results;
                return getArrayFromLetters(letters);
            } else {
                for (int i=0; i<letters.length(); i++) {
                    results.addAll(combine(letters.charAt(i), nextLevel, false));
                }
            }
            return results;
        }
    }

    private List<String> recursiveFind(String digits) {
        if (digits.length() == 1) {
            String letters = map.get(digits.charAt(0));
            if (letters == null) return new ArrayList<>();
            return getArrayFromLetters(letters);
        }
        List<String> results = new ArrayList<>();
        if (digits.isEmpty()) {
            return results;
        }
        String letters = map.get(digits.charAt(0));
        if (letters == null) return results;

        for (int j = 0; j < letters.length(); j++) {
            List<String> subResults = combine(letters.charAt(j), recursiveFind(digits.substring(1)), true);
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

    private List<String> combine(char c, List<String> strings, boolean isReplace) {
        if (strings.isEmpty()) {
            return Collections.singletonList(String.valueOf(c));
        }

        if (isReplace) {
            for (int i = 0; i < strings.size(); i++) {
                strings.set(i, c + strings.get(i));
            }
            return strings;
        } else {
            List<String> results = new ArrayList<>();
            for (String string : strings) {
                results.add(c + string);
            }
            return results;
        }
    }
}
