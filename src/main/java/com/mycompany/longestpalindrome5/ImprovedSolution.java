package com.mycompany.longestpalindrome5;

import java.util.HashSet;
import java.util.Set;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Saved some space and loop times.
 *
 * 996ms Beats 12.90%, 46.44MB Beats 14.17%
 */
public class ImprovedSolution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        Set<String> results = new HashSet<>();
        dp(s, 0, results);
        String ans = null;
        int max = -1;
        if (results.isEmpty()) return s.substring(0,1);
        for(String result: results) {
            if (result.length() > max) {
                max = result.length();
                ans = result;
            }
        }
        return ans;
    }

    private void dp(String s, int index, Set<String> results) {
        if (index >= s.length()) return;
        StringBuilder temp = new StringBuilder();
        for(int i=index; i<s.length(); i++) {
            temp.append(s.charAt(i));
            if (i-index>0 && isPalindrome(temp.toString())) {
                results.add(temp.toString());
                if (i==s.length()-1) {
                    return;
                }
            }
        }
        dp(s, index + 1, results);
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
