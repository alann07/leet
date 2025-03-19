package com.mycompany.maxsubarray53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6, solution.maxSubArray(input));

        input = new int[]{-1};
        assertEquals(-1, solution.maxSubArray(input));

        input = new int[]{5,4,-1,7,8};
        assertEquals(23, solution.maxSubArray(input));
    }
}
