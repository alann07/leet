package com.mycompany.combine77;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals(1, solution.combine(1, 1).size());
        assertEquals(6, solution.combine(4, 2).size());
        assertEquals(4, solution.combine(4, 3).size());
    }
}
