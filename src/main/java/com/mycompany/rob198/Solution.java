package com.mycompany.rob198;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
 * rob tonight without alerting the police.
 *
 * Below db with memorization solution is slow.
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] store = new int[nums.length];
        int max = -1;
        for(int i= nums.length-1; i>=0; i--) {
            max = Math.max(max, dp(nums, i, store));
        }
        return max;
    }

    private int dp(int[] nums, int index, int[] store) {
        if (index == nums.length-1) {
            store[index] = nums[index];
            return store[index];
        }

        if (store[index] == 0) {
            store[index] = nums[index];
            int a = index + 2 < nums.length ? dp(nums, index + 2, store) : 0;
            int b = index + 3 < nums.length ? dp(nums, index + 3, store) : 0;
            store[index] += Math.max(a, b);
        }
        return store[index];
    }
}
