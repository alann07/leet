package com.mycompany.permutations46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// backtrack solution (from discussion). latency unchanged, but use less memory.
// try use Hashset, instead of List for tempList, as "contains" is O(n). See if it can reduce latency.
// 2ms Beats 40.35%
// doesn't help.
public class ImprovedSolution2 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Set<Integer> tempSet = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        findSolution(list, new ArrayList<>(), tempSet, nums);
        return list;
    }

    private void findSolution(List<List<Integer>> list, List<Integer> tempList, Set<Integer> tempSet, int [] nums) {
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempSet.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                tempSet.add(nums[i]);
                findSolution(list, tempList, tempSet, nums);
                tempSet.remove(nums[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
