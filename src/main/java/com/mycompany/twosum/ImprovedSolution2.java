package com.mycompany.twosum;

// 31 ms
public class ImprovedSolution2 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <2 || nums.length > 10000) {
            return new int[0];
        }

        if (target >1000000000 || target < -1000000000) {
            return new int[0];
        }

        int diff = 0;
        for (int i=0; i<nums.length; i++) {
            diff = target - nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] == diff) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }

        return new int[0];
    }
}
