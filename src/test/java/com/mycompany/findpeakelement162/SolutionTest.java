package com.mycompany.findpeakelement162;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        int[] nums = new int[]{1,2,3,1};
        assertEquals(2, solution.findPeakElement(nums));
        nums = new int[]{1,2,1,3,5,6,4};
        assertEquals(5, solution.findPeakElement(nums));
        nums = new int[]{1,2,3,4,5,6};
        assertEquals(5, solution.findPeakElement(nums));
        nums = new int[]{5,4,3,2,1};
        assertEquals(0, solution.findPeakElement(nums));
        nums = new int[]{1};
        assertEquals(0, solution.findPeakElement(nums));
        nums = new int[]{1,1};
        assertEquals(-1, solution.findPeakElement(nums));
        nums = new int[]{1,2};
        assertEquals(1, solution.findPeakElement(nums));
        nums = new int[]{2,1};
        assertEquals(0, solution.findPeakElement(nums));
        nums = new int[]{1,2,3};
        assertEquals(2, solution.findPeakElement(nums));
        nums = new int[]{1,3,2,1};
        assertEquals(1, solution.findPeakElement(nums));
        nums = new int[]{1,2,3,4,3};
        assertEquals(3, solution.findPeakElement(nums));
        nums = new int[]{2,3,4,3,2,1};
        assertEquals(2, solution.findPeakElement(nums));
    }
}
