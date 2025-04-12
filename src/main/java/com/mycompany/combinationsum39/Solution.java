package com.mycompany.combinationsum39;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations
 * in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique
 * if the frequency of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less
 * than 150 combinations for the given input.
 *
 * Back tracking.
 * 2ms Beats 82.78%, 44.56MB Beats 81.51%
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<candidates.length; i++) {
            bt(candidates, i, target, result, temp, 0);
        }
        return result;
    }

    private void bt(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> temp, int sum) {
        if (index >= candidates.length) return;

        if (candidates[index] + sum == target) {
            temp.add(candidates[index]);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        if (candidates[index] + sum < target) {
            temp.add(candidates[index]);
            bt(candidates, index, target, result, temp, candidates[index] + sum);
            for (int i=index+1; i<candidates.length; i++) {
                bt(candidates, i, target, result, temp, candidates[index] + sum);
            }
            temp.remove(temp.size()-1);
        }
    }
}
