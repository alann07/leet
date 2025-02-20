package com.mycompany.lettercombinations17;

import java.util.*;

// Back track.
// 0ms Beats 100%; 42.17MB Beats 65.90%
public class ImprovedSolution4 {

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
        recursiveFind(digits, 0, results, new StringBuilder());
        return results;
    }

    private void recursiveFind(String digits, int index, List<String> results, StringBuilder builder) {
        if (digits.length()  == index) {
            results.add(builder.toString());
            return;
        }

        for (int i=0; i<map.get(digits.charAt(index)).length(); i++) {
            builder.append(map.get(digits.charAt(index)).charAt(i));
            recursiveFind(digits, index+1, results, builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
