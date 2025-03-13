package com.mycompany.kthlargest215;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        ImprovedSolution solution = new ImprovedSolution();
//        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        assertEquals(5, solution.findKthLargest(nums, 2));

        nums = new int[]{3,2,3,1,2,4,5,5,6};
        assertEquals(4, solution.findKthLargest(nums, 4));
    }
}
