package com.mycompany.mostwater11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] heights = {1,8,6,2,5,4,8,3,7};
        assertEquals(49, solution.maxArea(heights));

        heights = new int[]{1,1};
        assertEquals(1, solution.maxArea(heights));

        heights = new int[]{1,2,1};
        assertEquals(2, solution.maxArea(heights));

        heights = new int[]{3,3,4,4};
        assertEquals(9, solution.maxArea(heights));

        heights = new int[]{4,3,2,4};
        assertEquals(12, solution.maxArea(heights));

        heights = new int[]{1,8,6,2,5,4,8,3,7,9,6};
        assertEquals(64, solution.maxArea(heights));
    }
}
