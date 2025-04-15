package com.mycompany.sortcolors75;

/**
 * 75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * 0ms Beats 100.00%, 42.18MB Beats 30.60%
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int red=0, white=0, blue=0;
        for (int i=0; i< nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                default:
                    blue++;
            }
        }
        updateColors(nums, 0, red, 0);
        updateColors(nums, red, red+white, 1);
        updateColors(nums, white+red, red+white+blue, 2);
    }

    private void updateColors(int[] nums, int start, int end, int val) {
        for(int i=start; i<end; i++) {
            nums[i] = val;
        }
    }
}
