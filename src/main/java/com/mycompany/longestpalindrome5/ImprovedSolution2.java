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
 * try from big length to small. if anything is found, stop and this is the largest for this run.
 *
 * 203ms Beats 24.26%, 43.54MB Beats 58.08%
 */
public class ImprovedSolution2 {
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
        for(int i=s.length()-1; i>index; i--) {
            if (i-index>0 && isPalindrome(s, index, i)) {
                results.add(s.substring(index, i+1));
                if (i==s.length()-1) {
                    return;
                }
                break;
            }
        }
        dp(s, index + 1, results);
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (s == null || s.isEmpty()) return false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
