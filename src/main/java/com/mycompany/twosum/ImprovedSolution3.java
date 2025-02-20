package com.mycompany.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * 2 ms
 */
public class ImprovedSolution3 {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length <2 || nums.length > 10000) {
            return new int[0];
        }

        if (target >1000000000 || target < -1000000000) {
            return new int[0];
        }

        int diff = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(target - nums[0], 0);
        for (int i=1; i<nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int[] result = {hashMap.get(nums[i]), i};
                return result;
            } else {
                hashMap.put(target - nums[i], i);
            }
        }

        return new int[0];
    }
}
