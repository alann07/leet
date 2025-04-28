package com.mycompany.getmaxlen1567;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        int[] nums = new int[]{1,-2,-3,4};
        assertEquals(4, solution.getMaxLen(nums));

        nums = new int[]{0,1,-2,-3,-4};
        assertEquals(3, solution.getMaxLen(nums));

        nums = new int[]{-1,-2,-3,0,1};
        assertEquals(2, solution.getMaxLen(nums));

        nums = new int[]{-1,2};
        assertEquals(1, solution.getMaxLen(nums));

        nums = new int[]{2};
        assertEquals(1, solution.getMaxLen(nums));

        nums = new int[]{1000000000,1000000000};
        assertEquals(2, solution.getMaxLen(nums));
    }
}
