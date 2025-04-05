package com.mycompany.rainwater42;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] height = new int[]{0,2,0,3,0};
        assertEquals(2, solution.trap(height));

        height = new int[]{0,2,0,0,3,0};
        assertEquals(4, solution.trap(height));

        height = new int[]{0,2,0,2,0,3,0};
        assertEquals(4, solution.trap(height));

        height = new int[]{0,3,0,2,0,3,0};
        assertEquals(7, solution.trap(height));

        height = new int[]{0,2,0,1,0,3,0};
        assertEquals(5, solution.trap(height));

        height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6, solution.trap(height));

        height = new int[]{4,2,0,3,2,5};
        assertEquals(9, solution.trap(height));
    }
}
