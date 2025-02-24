package com.mycompany.regularexpmatching10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecondSolutionTest {

    @Test
    public void testSolution() {
        long startTime = System.currentTimeMillis();
        SecondSolution solution = new SecondSolution();
        boolean result = solution.isMatch("aa", "a");
        assertFalse(result);

        result = solution.isMatch("aa", "a*");
        assertTrue(result);

        result = solution.isMatch("", "a*");
        assertTrue(result);

        result = solution.isMatch("", ".*");
        assertTrue(result);

        result = solution.isMatch("", "a*b");
        assertFalse(result);

        result = solution.isMatch("", ".b");
        assertFalse(result);

        result = solution.isMatch("", "a");
        assertFalse(result);

        result = solution.isMatch("", ".");
        assertFalse(result);

        result = solution.isMatch("aa", "a.");
        assertTrue(result);

        result = solution.isMatch("aa", "b.");
        assertFalse(result);

        result = solution.isMatch("ab", ".*");
        assertTrue(result);

        result = solution.isMatch("abc", ".*");
        assertTrue(result);

        result = solution.isMatch("abcdbc", ".*");
        assertTrue(result);

        result = solution.isMatch("abcdbc", "d.*");
        assertFalse(result);

        result = solution.isMatch("abcdbc", "abc.*");
        assertTrue(result);

        result = solution.isMatch("abcdbc", "abc.*c");
        assertTrue(result);

        result = solution.isMatch("abcdbc", "abc*c");
        assertFalse(result);

        result = solution.isMatch("abcdbc", "abc.*f");
        assertFalse(result);

        result = solution.isMatch("abcdbc", "abc.*c");
        assertTrue(result);

        result = solution.isMatch("abcdddbbbc", "abc.*d.*c");
        assertTrue(result);

        result = solution.isMatch("abcdddbbbc", "abc.*d*c");
        assertTrue(result);

        result = solution.isMatch("a", "ab*");
        assertTrue(result);

        result = solution.isMatch("a", "cb*");
        assertFalse(result);

        result = solution.isMatch("ab", "a*b*");
        assertTrue(result);

        result = solution.isMatch("aab", "a*b*");
        assertTrue(result);

        result = solution.isMatch("ac", "cb*");
        assertFalse(result);

        result = solution.isMatch("aaa", "aaaa");
        assertFalse(result);

        result = solution.isMatch("bbb", "aaaa");
        assertFalse(result);

        result = solution.isMatch("aaa", "a.a.a");
        assertFalse(result);

        result = solution.isMatch("ababa", "a.a.a");
        assertTrue(result);

        result = solution.isMatch("bfc", "a*b.c");
        assertTrue(result);

        result = solution.isMatch("bc", "a*b.c");
        assertFalse(result);

        result = solution.isMatch("a", "ab*a");
        assertFalse(result);

        result = solution.isMatch("a", ".*..a**a");
        assertFalse(result);

        result = solution.isMatch("aaa", "a*a");
        assertTrue(result);

        result = solution.isMatch("aaa", "a*a*");
        assertTrue(result);

        result = solution.isMatch("ab", ".*..");
        assertTrue(result);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
