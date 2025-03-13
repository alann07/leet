package com.mycompany.kthlargest215;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Result below with sorting.
 * 22ms Beats 92.52%, 58.06MB Beats 56.08%
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
