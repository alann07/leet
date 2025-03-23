package com.mycompany.mergearrays88;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that
 * should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * 0ms Beats 100.00%, 42.14MB Beats 77.31%
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;

        int i = m-1;
        int j = n-1;
        int index = nums1.length-1;
        while (i>=0 || j>=0) {
            int a = Integer.MIN_VALUE;
            if (i>=0) {
                a = nums1[i];
            }
            int b = Integer.MIN_VALUE;
            if (j>=0) {
                b = nums2[j];
            }
            if (a > b) {
                nums1[index] = a;
                i--;
            } else {
                nums1[index] = b;
                j--;
            }
            index--;
        }
    }
}
