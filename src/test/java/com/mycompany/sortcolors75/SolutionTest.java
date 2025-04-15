package com.mycompany.sortcolors75;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums = new int[]{2,0,2,1,1,0};
        solution.sortColors(nums);
        assertEquals(0, nums[0]);
        assertEquals(0, nums[1]);
        assertEquals(1, nums[2]);
        assertEquals(2, nums[4]);

        nums = new int[]{2,0,1};
        solution.sortColors(nums);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);

        nums = new int[]{2,0};
        solution.sortColors(nums);
        assertEquals(0, nums[0]);
        assertEquals(2, nums[1]);

        nums = new int[]{2,2};
        solution.sortColors(nums);
        assertEquals(2, nums[0]);
        assertEquals(2, nums[1]);
    }
}

