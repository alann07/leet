package com.mycompany.minsubarraylen209;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        int[] nums = new int[]{2,3,1,2,4,3};
        assertEquals(2, solution.minSubArrayLen(7, nums));

        nums = new int[]{2,3,1,2,2,4,3,1};
        assertEquals(2, solution.minSubArrayLen(7, nums));

        nums = new int[]{1,4,4};
        assertEquals(1, solution.minSubArrayLen(4, nums));

        nums = new int[]{1,1,1,1,1,1,1,1};
        assertEquals(0, solution.minSubArrayLen(11, nums));

        nums = new int[]{1,2,3,4,5};
        assertEquals(1, solution.minSubArrayLen(5, nums));

        nums = new int[]{1,2,3,4,5};
        assertEquals(3, solution.minSubArrayLen(11, nums));

        nums = new int[]{5,4,3,2,1};
        assertEquals(3, solution.minSubArrayLen(11, nums));

        nums = new int[]{5,4,3,2,1};
        assertEquals(2, solution.minSubArrayLen(6, nums));

        nums = new int[]{5,4,3,2,1};
        assertEquals(1, solution.minSubArrayLen(3, nums));

        nums = new int[]{1,2,3,4};
        assertEquals(3, solution.minSubArrayLen(9, nums));

        nums = new int[]{5,1,3,5,10,7,4,9,2,8};
        assertEquals(2, solution.minSubArrayLen(15, nums));
    }
}
