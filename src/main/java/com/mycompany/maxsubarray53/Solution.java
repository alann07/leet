package com.mycompany.maxsubarray53;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * 1ms Beats 99.52%, 57.30MB Beats 31.71%. Use Kadane's Algorithm.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int currMax = -100000;
        int maxSoFar = -100000;
        for (int i=0; i< nums.length; i++) {
            currMax = Math.max(currMax+nums[i], nums[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        return maxSoFar;
    }
}
