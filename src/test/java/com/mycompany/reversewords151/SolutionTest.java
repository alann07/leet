package com.mycompany.reversewords151;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
        assertEquals("example good a", solution.reverseWords("a good   example"));
        assertEquals("example good a", solution.reverseWords("    a good   example"));
        assertEquals("world hello", solution.reverseWords("  hello world  "));
    }
}
