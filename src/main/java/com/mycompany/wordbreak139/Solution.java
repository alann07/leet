package com.mycompany.wordbreak139;

import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * 6ms Beats 61.10%, 44.54MB Beats 46.79%
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) return false;
        Boolean[] store = new Boolean[s.length()];
        for(int i=s.length()-1; i>=0; i--) {
            dp(s, i, i+1, wordDict, store);
        }
        return store[0];
    }

    private boolean dp(String s, int start, int end, List<String> wordDict, Boolean[] store) {

        if (end > s.length()) return false;

        if (start == s.length()-1 && store[start] == null) {
            store[start] = wordDict.contains(s.substring(start, end));
            return store[start];
        }

        if (store[start] == null) {
            if (wordDict.contains(s.substring(start, end))) {
                if (end == s.length()) {
                    store[start] = true;
                } else if (store[end]) {
                    store[start] = true;
                } else {
                    store[start] = dp(s, start, end+1, wordDict, store);
                }
            } else {
                store[start] = dp(s, start, end+1, wordDict, store);
            }
        }
        return store[start];
    }
}
