package com.mycompany.maxenergy3147;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedSolutionTest {
    @Test
    public void testSolution() {
        long startTime = System.currentTimeMillis();
        ImprovedSolution solution = new ImprovedSolution();
        int[] input = {5,2,-10,-5,1};
        assertEquals(3, solution.maximumEnergy(input, 3));

        input = new int[]{-2,-3,-1};
        assertEquals(-1, solution.maximumEnergy(input, 2));

        input = new int[]{-2,-3,-1};
        assertEquals(-1, solution.maximumEnergy(input, 1));

        input = new int[]{-9,-2,-6,-5,-8,3,0};
        assertEquals(3, solution.maximumEnergy(input, 1));

        input = new int[]{-1,-2,-8,6,-6,-6,-6,5,5};
        assertEquals(6, solution.maximumEnergy(input, 8));

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
