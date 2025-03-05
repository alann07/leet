package com.mycompany.jumpgame55;

/**
 * DP
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in
 * the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * NO DP. (idea from forum). Not using any i. But it doesn't compare curr position with overall rest of length and hence
 * a bit slower than solution2.
 *
 */
public class ImprovedSolution3 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int curr = 0;
        for (int val: nums) {
            if (curr < 0) return false;
            if (val > curr) curr = val;
            curr--;
        }
        return true;
    }
}
