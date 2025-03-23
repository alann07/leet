package com.mycompany.issubsequence392;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertTrue(solution.isSubsequence("", ""));
        assertTrue(solution.isSubsequence("", "ahbgdc"));
        assertTrue(solution.isSubsequence("a", "ahbgdc"));
        assertTrue(solution.isSubsequence("abc", "ahbgdc"));
        assertTrue(solution.isSubsequence("abcde", "abcde"));
        assertFalse(solution.isSubsequence("axc", "ahbgdc"));
        assertFalse(solution.isSubsequence("axcewdsf", "axc"));
    }
}
