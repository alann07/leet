package com.mycompany.minsubarraylen209;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of
 * a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * It works, but too slow, received Time Limit Exceeded. It's O(nxn)
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minLength = 100000;
        for (int i=0; i< nums.length; i++) {
            minLength = Math.min(minLength, findSolution(nums, i, target, minLength));
        }
        return  minLength == 100000 ? 0 : minLength;
    }

    private int findSolution(int[] nums, int startIndex, int target, int minLength) {
        int currMax = -100000;
        for (int i=startIndex; i< nums.length; i++) {
            currMax = Math.max(currMax+nums[i], nums[i]);
            if (currMax >= target) {
                return i-startIndex+1;
            }
        }
        return minLength;
    }
}
