package com.mycompany.getmaxlen1567;

/**
 * 1567. Maximum Length of Subarray With Positive Product
 * Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
 *
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
 *
 * Return the maximum length of a subarray with positive product.
 *
 * It's slow. Time Limit Exceeded.
 */
public class Solution {
    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int maxLen = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) continue;
            maxLen = Math.max(maxLen, dp(nums, i));
        }
        return maxLen;
    }

    private int dp(int[] nums, int index) {
        int maxLength = 0;
        int i=index;
        int product = 1;
        while (i< nums.length) {
            if (nums[i] == 0) {
                return maxLength;
            } else {
                product *= nums[i]>0? 1 : -1;
                if (product > 0) {
                    maxLength = Math.max(maxLength, i-index+1);
                }
            }
            i++;
        }
        return maxLength;
    }
}
