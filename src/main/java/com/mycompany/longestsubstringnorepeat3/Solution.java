package com.mycompany.longestsubstringnorepeat3;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
public class Solution {

    // 75 ms.
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0 || s.length() > 50000) return 0;
        if (s.length() == 1) return 1;

        int maxLength = 0;
        Map<Character, Integer> subMap = new HashMap<>();
        subMap.put(s.charAt(0), 0);
        int currSubLength = 1;
        int currIndex = 1;

        while (true) {
            char c = s.charAt(currIndex);
            if (subMap.containsKey(c)) {
                if (currSubLength > maxLength) {
                    maxLength = currSubLength;
                }
                currIndex = subMap.get(c) + 1;
                if (maxLength > s.length()-currIndex-1) break;

                currSubLength = 0;
                subMap.clear();
            } else {
                subMap.put(c, currIndex);
                currSubLength++;
                currIndex++;
            }

            if (currIndex == s.length()) {
                if (currSubLength > maxLength) {
                    maxLength = currSubLength;
                }
                break;
            }
        }
        return maxLength;
    }
}
