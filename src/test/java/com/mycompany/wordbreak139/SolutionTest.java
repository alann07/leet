package com.mycompany.wordbreak139;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(List.of("leet","code"));
        assertTrue(solution.wordBreak(s, wordDict));

        s = "applepenapple";
        wordDict = new ArrayList<>(List.of("apple","pen"));
        assertTrue(solution.wordBreak(s, wordDict));

        s = "catsandog";
        wordDict = new ArrayList<>(List.of("cats","dog","sand","and","cat"));
        assertFalse(solution.wordBreak(s, wordDict));

        s = "aaaaaaa";
        wordDict = new ArrayList<>(List.of("aaaa","aaa"));
        assertTrue(solution.wordBreak(s, wordDict));
    }
}
