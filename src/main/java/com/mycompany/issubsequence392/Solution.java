package com.mycompany.issubsequence392;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * 1ms Beats 93.18%, 41.53MB Beats 54.49%
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length())
            return false;
        if (s.length() == 0) return true;
        if (s.length() == 0 && t.length() == 0) return true;

        int si = 0;

        for (int i=0; i<t.length(); i++) {
            if (s.charAt(si) == t.charAt(i)) {
                si++;
            } else continue;
            if (si == s.length()) break;
        }

        return si == s.length();
    }
}
