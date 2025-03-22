package com.mycompany.rob198;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        int[] nums = new int[]{1,2,3,1};
        assertEquals(4, solution.rob(nums));

        nums = new int[]{2,7,9,3,1};
        assertEquals(12, solution.rob(nums));

        nums = new int[]{0,0,0};
        assertEquals(0, solution.rob(nums));
    }
}
