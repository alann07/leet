package com.mycompany.lettercombinations17;

import java.util.ArrayList;
import java.util.List;

// Back track algorithm. Borrowed.
// 0ms Beats 100%; 42.06MB Beats 78.41%
public class ImprovedSolution3WithBackTrack {

    private void solve(int index, String digits, String[] comb, List<String> ans, StringBuilder temp) {
        if (index == digits.length()) {
            ans.add(temp.toString());
            return;
        }

        for (char ch : comb[digits.charAt(index) - '0'].toCharArray()) {
            temp.append(ch);
            solve(index + 1, digits, comb, ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty() || digits.length()>4) return new ArrayList<>();
        String[] comb = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        solve(0, digits, comb, ans, new StringBuilder());
        return ans;
    }
}