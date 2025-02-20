package com.mycompany.mostwater11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedSolutionTest {
    @Test
    public void testImprovedSolution() {
        ImprovedSolution solution = new ImprovedSolution();
        int[] heights = {1,8,6,2,5,4,8,3,7};
        assertEquals(49, solution.maxArea(heights));

        heights = new int[]{1,1};
        assertEquals(1, solution.maxArea(heights));

        heights = new int[]{1,2,1};
        assertEquals(2, solution.maxArea(heights));

        heights = new int[]{1,1,1};
        assertEquals(2, solution.maxArea(heights));

        heights = new int[]{1,1,1,1};
        assertEquals(3, solution.maxArea(heights));

        heights = new int[]{1,1,1,1,1};
        assertEquals(4, solution.maxArea(heights));

        heights = new int[]{3,3,4,4};
        assertEquals(9, solution.maxArea(heights));

        heights = new int[]{4,3,2,4};
        assertEquals(12, solution.maxArea(heights));

        heights = new int[]{1,8,6,2,5,4,8,3,7,9,6};
        assertEquals(64, solution.maxArea(heights));

        heights = new int[]{6,9,7,3,8,4,5,2,6,8,1};
        assertEquals(64, solution.maxArea(heights));

        heights = new int[]{6,9,7,3,10000,10000,5,2,6,8,1};
        assertEquals(10000, solution.maxArea(heights));
    }
}
