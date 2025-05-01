package com.mycompany.rotatearray189;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
//        ImprovedSolution solution = new ImprovedSolution();
        ImprovedSolution2 solution = new ImprovedSolution2();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        solution.rotate(nums, 3);
        assertEquals(5, nums[0]);
        assertEquals(6, nums[1]);
        assertEquals(7, nums[2]);
        assertEquals(1, nums[3]);

        nums = new int[]{-1,-100,3,99};
        solution.rotate(nums, 2);
        assertEquals(3, nums[0]);
        assertEquals(99, nums[1]);

        nums = new int[]{-1,-100,3,99};
        solution.rotate(nums, 0);
        assertEquals(-1, nums[0]);
        assertEquals(-100, nums[1]);
    }
}

