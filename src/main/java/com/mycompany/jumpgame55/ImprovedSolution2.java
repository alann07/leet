package com.mycompany.jumpgame55;

/**
 * DP
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in
 * the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * NO DP. (idea from forum)
 * 2ms Beats 79.59% 45.62MB Beats 69.65%
 */
public class ImprovedSolution2 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int curr = nums[0];
        if (curr == 0) return false;
        for (int i=1; i< nums.length; i++) {
            if (curr> nums.length-1-i) return true;
            if (nums[i] >= curr) curr = nums[i];
            else curr--;
            if (i!= nums.length-1 && curr==0) return false;
        }
        return true;
    }
}
