package com.mycompany.jumpgame55;

/**
 * DP
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in
 * the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Change dp to Boolean and records both true and false status, but not improving
 * 78ms Beats 12.84%
 */
public class ImprovedSolution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        Boolean[] blocked = new Boolean[nums.length];
        return findSolution(nums, 0, blocked);
    }

    private boolean findSolution(int[] nums, int index, Boolean[] blocked) {
        if (index >= nums.length-1) return true;
        int jump = nums[index];
        if (jump <= 0) {
            blocked[index] = true;
            return false;
        }
        if (jump>= nums.length-index-1) return true;
        for (int j=1; j<=jump;j++) {
            if (blocked[index+j] != null && blocked[index+j]) continue;
            if (blocked[index+j] != null && !blocked[index+j]) return true;
            if (findSolution(nums, index+j, blocked)) {
                blocked[index+j] = false;
                return true;
            }
            else blocked[index+j] = true;
        }
        return false;
    }
}
