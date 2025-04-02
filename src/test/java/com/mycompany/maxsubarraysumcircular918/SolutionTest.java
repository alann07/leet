package com.mycompany.maxsubarraysumcircular918;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        int[] nums = new int[]{1,-2,3,-2};
        assertEquals(3, solution.maxSubarraySumCircular(nums));

        nums = new int[]{5,-3,5};
        assertEquals(10, solution.maxSubarraySumCircular(nums));

        nums = new int[]{-3,-2,-3};
        assertEquals(-2, solution.maxSubarraySumCircular(nums));

        nums = new int[]{2,-2,2,7,8,0};
        assertEquals(19, solution.maxSubarraySumCircular(nums));

        nums = new int[]{0,5,8,-9,9,-7,3,-2};
        assertEquals(16, solution.maxSubarraySumCircular(nums));
    }
}
