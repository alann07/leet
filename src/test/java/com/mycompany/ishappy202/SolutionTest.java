package com.mycompany.ishappy202;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertTrue(solution.isHappy(19));
        assertTrue(solution.isHappy(10000000));
        assertTrue(solution.isHappy(133));
        assertFalse(solution.isHappy(2));
    }
}
