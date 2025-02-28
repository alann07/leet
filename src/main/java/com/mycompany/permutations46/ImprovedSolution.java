package com.mycompany.permutations46;

import java.util.ArrayList;
import java.util.List;

// backtrack solution (from discussion). latency unchanged, but use less memory.
// 2ms Beats 40.35% 44.34MB Beats 91.25%
public class ImprovedSolution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        findSolution(list, new ArrayList<>(), nums);
        return list;
    }

    private void findSolution(List<List<Integer>> list, List<Integer> tempList, int [] nums) {
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                findSolution(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
