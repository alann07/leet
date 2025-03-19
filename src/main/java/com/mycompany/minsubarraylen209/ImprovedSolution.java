package com.mycompany.minsubarraylen209;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of
 * a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * 1ms Beats 99.78%, 58.22MB Beats 40.10%, with sliding window technique.
 */
public class ImprovedSolution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minLength = Integer.MAX_VALUE;
        int start =0;
        int sum=0;
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i-start+1);
                sum -= nums[start];
                start++;
            }
        }

        return  minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
