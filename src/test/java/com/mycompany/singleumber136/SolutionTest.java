package com.mycompany.singleumber136;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums = new int[]{2,2,1};
        assertEquals(1, solution.singleNumber(nums));

        nums = new int[]{2,2,1,1,3,3,4};
        assertEquals(4, solution.singleNumber(nums));

        nums = new int[]{4,1,2,1,2};
        assertEquals(4, solution.singleNumber(nums));

        nums = new int[]{1};
        assertEquals(1, solution.singleNumber(nums));

        nums = new int[]{-1,-2,-3,-4,-3,-2,-1};
        assertEquals(-4, solution.singleNumber(nums));
    }
}

