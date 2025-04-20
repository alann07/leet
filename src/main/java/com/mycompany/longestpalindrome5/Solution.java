package com.mycompany.longestpalindrome5;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Purely DP / resursive. Time Limit Exceeded.
 * Need to optimize.
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;
        List<String> results = new ArrayList<>();
        dp(s, 0, results);
        int maxIndex = 0;
        int max = -1;
        for(int i=0; i<results.size(); i++) {
            String result = results.get(i);
            if (result.length() > max) {
                max = result.length();
                maxIndex = i;
            }
        }
        return results.get(maxIndex);
    }

    private void dp(String s, int index, List<String> results) {
        if (index >= s.length()) return;
        StringBuilder temp = new StringBuilder();
        for(int i=index; i<s.length(); i++) {
            temp.append(s.charAt(i));
            if (isPalindrome(temp.toString())) {
                results.add(temp.toString());
            }
        }
        dp(s, index+1, results);
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
