package com.mycompany.numbsttrees96;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedSolutionTest {

    @Test
    public void testSolution() {
        ImprovedSolution solution = new ImprovedSolution();
        assertEquals(1, solution.numTrees(1));
        assertEquals(5, solution.numTrees(3));
        assertEquals(14, solution.numTrees(4));
    }
}
