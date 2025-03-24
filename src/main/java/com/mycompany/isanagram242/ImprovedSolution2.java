package com.mycompany.isanagram242;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Below solution is from forum. It uses array as hash, since it's all lower case letters.
 * It takes 5ms, which is a lot better than 12ms in "Solution".
 *
 * if using             if (s.charAt(i) != t.charAt(i)) {}, it actually takes longer, 7ms.
 *
 * */
public class ImprovedSolution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
