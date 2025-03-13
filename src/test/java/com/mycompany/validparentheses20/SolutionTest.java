package com.mycompany.validparentheses20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    @Test
    public void testSolution() {
        ImprovedSolution solution = new ImprovedSolution();
//        Solution solution = new Solution();
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertTrue(solution.isValid("([])"));
        assertFalse(solution.isValid("(}"));
        assertFalse(solution.isValid("({}[)"));
        assertFalse(solution.isValid(")"));
        assertFalse(solution.isValid(")]"));

        char character = ')';
        int asciiValue = (int) character;
        System.out.println(asciiValue);
        character = ']';
        asciiValue = (int) character;
        System.out.println(asciiValue);
        character = '}';
        asciiValue = (int) character;
        System.out.println(asciiValue);

        char[] chars = new char[160];
        character = ')';
        chars[character] = '(';
    }
}
