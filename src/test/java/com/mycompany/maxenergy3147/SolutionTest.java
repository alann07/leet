package com.mycompany.maxenergy3147;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        int[] input = {5,2,-10,-5,1};
        assertEquals(3, solution.maximumEnergy(input, 3));

        input = new int[]{-2,-3,-1};
        assertEquals(-1, solution.maximumEnergy(input, 2));

        input = new int[]{-2,-3,-1};
        assertEquals(-1, solution.maximumEnergy(input, 1));

        input = new int[]{-9,-2,-6,-5,-8,3,0};
        assertEquals(3, solution.maximumEnergy(input, 1));

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
