package com.mycompany.permutations47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 4ms Beats 31.14%, 45.50MB Beats 12.95%
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
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
            if (i>0 && nums.get(i) == nums.get(i-1)) continue;
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
