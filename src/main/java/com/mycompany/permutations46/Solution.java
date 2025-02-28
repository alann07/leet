package com.mycompany.permutations46;

import java.util.ArrayList;
import java.util.List;

// backtrack solution
// 2ms Beats 40.35% 44.74MB Beats 31.16%
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<Integer> numList = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            numList.add(nums[i]);
        }
        return findSolution(numList);
    }

    private List<List<Integer>> findSolution(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 1) {
            result.add(new ArrayList<>(nums));
            return result;
        }

        for (int i=0; i<nums.size(); i++) {
            int removeTarget = nums.remove(i);
            for(List<Integer> list: findSolution(nums)) {
                list.add(removeTarget);
                result.add(new ArrayList<>(list));
            }
            nums.add(i, removeTarget);
        }

        return result;
    }
}
