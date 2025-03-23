package com.mycompany.longestsubstringnorepeat3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedSolutionTest {

    @Test
    public void testSolution() {
        ImprovedSolution solution = new ImprovedSolution();
        assertEquals(0, solution.lengthOfLongestSubstring(null));
        assertEquals(0, solution.lengthOfLongestSubstring(""));
        assertEquals(1, solution.lengthOfLongestSubstring("a"));
        assertEquals(1, solution.lengthOfLongestSubstring(" "));
        assertEquals(1, solution.lengthOfLongestSubstring("1"));
        assertEquals(1, solution.lengthOfLongestSubstring("aa"));
        assertEquals(1, solution.lengthOfLongestSubstring("aaa"));
        assertEquals(2, solution.lengthOfLongestSubstring("aba"));
        assertEquals(2, solution.lengthOfLongestSubstring("abab"));
        assertEquals(3, solution.lengthOfLongestSubstring("ababc"));
        assertEquals(3, solution.lengthOfLongestSubstring("abcab"));
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        assertEquals(4, solution.lengthOfLongestSubstring("abcadcbb"));
    }
}
