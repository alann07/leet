package com.mycompany.searchInsert35;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,5,6};
        assertEquals(2, solution.searchInsert(nums, 5));

        nums = new int[]{1,3,5,6};
        assertEquals(1, solution.searchInsert(nums, 2));

        nums = new int[]{1,3,5,6};
        assertEquals(4, solution.searchInsert(nums, 7));

        nums = new int[]{11};
        assertEquals(0, solution.searchInsert(nums, 7));

        nums = new int[]{11};
        assertEquals(1, solution.searchInsert(nums, 12));

        nums = new int[]{11};
        assertEquals(0, solution.searchInsert(nums, 11));

        nums = new int[]{1,3};
        assertEquals(1, solution.searchInsert(nums, 2));

        nums = new int[]{3,5,7,9,10};
        assertEquals(3, solution.searchInsert(nums, 8));
    }
}
