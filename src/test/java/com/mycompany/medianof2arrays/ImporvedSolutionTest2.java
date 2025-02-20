package com.mycompany.medianof2arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImporvedSolutionTest2 {

    @Test
    public void testSolution() {
        ImprovedSolution2 solution = new ImprovedSolution2();
        int[] nums1 = {1,3}, nums2 = {2};

        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2, result);

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};

        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result);

        nums1 = new int[]{1, 3};
        nums2 = new int[]{2};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2, result);

        nums1 = new int[]{1, 3, 5, 7, 9};
        nums2 = new int[]{2, 4, 6, 8, 10};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(5.5, result);

        nums1 = new int[]{1,2,3,4,5};
        nums2 = new int[]{6,7,8,9,10,11,12,13,14,15,16,17};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(9, result);

        nums1 = new int[]{6,7,8,9,10,11,12,13,14,15,16,17};
        nums2 = new int[]{1,2,3,4,5};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(9, result);

        nums1 = new int[]{2,2,4,4};
        nums2 = new int[]{2,2,4,4};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3, result);

        nums1 = new int[]{2,2,4,4,8};
        nums2 = new int[]{2,2,4,4};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4, result);

        nums1 = new int[]{2,2,4,4,8,10};
        nums2 = new int[]{2,2,4,4};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4, result);

        nums1 = new int[]{0,0,0,0,0};
        nums2 = new int[]{-1,0,0,0,0,0,1};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(0, result);

        nums2 = new int[]{0,0,0,0,0};
        nums1 = new int[]{-1,0,0,0,0,0,1};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(0, result);

        nums1 = new int[]{1,2,3,4,5};
        nums2 = new int[]{1,2,3,4,5};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3, result);

        nums1 = new int[]{-1,2,3,4,5};
        nums2 = new int[]{0,1,2,3,4,5};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3, result);

        nums1 = new int[]{1};
        nums2 = new int[]{2,3,4,5};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3, result);

        nums1 = new int[]{1};
        nums2 = new int[]{2,3,4};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result);

        nums1 = new int[]{2,3,4};
        nums2 = new int[]{1};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result);

        nums1 = new int[]{2};
        nums2 = new int[]{1,3,4};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result);

        nums1 = new int[]{1,3,4};
        nums2 = new int[]{2};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result);

        nums1 = new int[]{1,3,4,5};
        nums2 = new int[]{2};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3, result);

        nums1 = new int[]{2};
        nums2 = new int[]{1,3,4,5};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3, result);

        nums1 = new int[]{2};
        nums2 = new int[]{1,3,4,5,6};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3.5, result);

        nums1 = new int[]{1,3,4,5,6};
        nums2 = new int[]{2};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3.5, result);

        nums1 = new int[]{2};
        nums2 = new int[]{1,3,4,5,6,7,8};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4.5, result);

        nums1 = new int[]{1,3,4,5,6,7,8};
        nums2 = new int[]{2};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4.5, result);

        nums1 = new int[]{3};
        nums2 = new int[]{1,2,4,5,6};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3.5, result);

        nums1 = new int[]{1,2,4,5,6};
        nums2 = new int[]{3};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(3.5, result);

        nums1 = new int[]{3};
        nums2 = new int[]{1,2,4,5,6,7};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4, result);

        nums1 = new int[]{1,2,4,5,6,7};
        nums2 = new int[]{3};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4, result);

        nums1 = new int[]{6};
        nums2 = new int[]{1,2,3,4,5,7};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4, result);

        nums1 = new int[]{1,2,3,4,5,7};
        nums2 = new int[]{6};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4, result);

        nums1 = new int[]{3};
        nums2 = new int[]{1,2,4,5,6,7,8};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4.5, result);

        nums1 = new int[]{1,2,4,5,6,7,8};
        nums2 = new int[]{3};
        result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(4.5, result);
    }
}
