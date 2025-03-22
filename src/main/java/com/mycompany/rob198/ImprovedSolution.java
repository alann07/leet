package com.mycompany.rob198;

/**
 * 0ms Beats 100.00%, 40.93MB Beats 76.38%
 * The previous solution didn't check whether store[index+2] and start[index+3] calcuated or not.
 */
public class ImprovedSolution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] store = new int[nums.length];
        int max = 0;
        for(int i= nums.length-1; i>=0; i--) {
            if (nums[i] > 0) {
                max = Math.max(max, dp(nums, i, store));
            }
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
            int a=0;
            if (index+2 < nums.length) {
                if (store[index+2] > 0) a = store[index+2];
                else a = dp(nums, index + 2, store);
            }
            int b=0;
            if (index+3 < nums.length) {
                if (store[index+3] > 0) b = store[index+3];
                else a = dp(nums, index + 3, store);
            }
            store[index] += Math.max(a, b);
        }
        return store[index];
    }
}
