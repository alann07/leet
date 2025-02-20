package com.mycompany.threesum15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// back-tracking 63ms too slow, backtracking
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3 || nums.length > 3000) return null;

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> builder = new ArrayList<>();
        findSolution(nums, 0, results, builder);
        return results;
    }

    private void findSolution(int[] nums, int index, List<List<Integer>> results, List<Integer> temp) {
        if (temp.size() == 3) {
            if (temp.get(0) + temp.get(1) + temp.get(2) == 0) {
                dedup(temp, results);
            }
            return;
        }

        for (int i=index; i<nums.length; i++) {
            temp.add(nums[i]);
            findSolution(nums, i+1, results, temp);
            temp.remove(temp.size()-1);
        }
    }

    private void dedup(List<Integer> temp, List<List<Integer>> results) {
        for(List<Integer> result: results) {
            if(result.containsAll(temp) && temp.containsAll(result)) {
                return;
            }
        }
        results.add(new ArrayList<>(temp));
    }

//    private boolean isDup(List<Integer> result, List<Integer> temp) {
//        Set<Integer> set1 =  new HashSet<>(result);
//        Set<Integer> set2 =  new HashSet<>(temp);
//        if (set1.equals(set2)) {
//            return true;
//        }
//        return false;
//    }
}
