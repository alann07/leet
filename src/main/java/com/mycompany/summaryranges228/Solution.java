package com.mycompany.summaryranges228;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is,
 * each element of nums is covered by exactly one of the ranges, and there is no integer x such that x
 * is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 * 6ms Beats 29.59%, 41.77MB Beats 69.43%
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums==null || nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }

        int start=0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                if (i== nums.length-1) {
                    result.add(nums[start] + "->" + nums[i]);
                }
            } else {
                if (i-start == 1) {
                    result.add(Integer.toString(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[i-1]);
                }
                if (i == nums.length-1) {
                    result.add(Integer.toString(nums[i]));
                }
                start = i;
            }
        }
        return result;
    }
}
