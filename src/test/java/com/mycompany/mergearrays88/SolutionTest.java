package com.mycompany.mergearrays88;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        solution.merge(nums1, 3, nums2, 3);
        assertEquals(6, nums1[5]);
        assertEquals(5, nums1[4]);

        nums1 = new int[]{1};
        nums2 = new int[0];
        solution.merge(nums1, 1, nums2, 0);
        assertEquals(1, nums1[0]);

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        solution.merge(nums1, 0, nums2, 1);
        assertEquals(1, nums1[0]);
    }
}
