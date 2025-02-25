package com.mycompany.numbsttrees96;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals(1, solution.numTrees(1));
        assertEquals(5, solution.numTrees(3));
        assertEquals(14, solution.numTrees(4));
    }
}
