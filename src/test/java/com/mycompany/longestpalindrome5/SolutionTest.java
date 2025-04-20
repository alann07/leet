package com.mycompany.longestpalindrome5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
//        ImprovedSolution solution = new ImprovedSolution();
//        ImprovedSolution2 solution = new ImprovedSolution2();
        ImprovedSolution3 solution = new ImprovedSolution3();
        assertEquals("bb", solution.longestPalindrome("cbbd"));
        assertTrue("bab".equals(solution.longestPalindrome("babad")) ||
                "aba".equals(solution.longestPalindrome("babad")));
        assertEquals("abba", solution.longestPalindrome("babba"));
        assertEquals("aabaa", solution.longestPalindrome("aabaa"));
        assertEquals("a", solution.longestPalindrome("abcde"));
        assertEquals("a", solution.longestPalindrome("ac"));
        assertEquals("ddtattarrattatdd", solution.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }
}
