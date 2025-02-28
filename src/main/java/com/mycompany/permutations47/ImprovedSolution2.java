package com.mycompany.permutations47;

import java.util.*;

// 2ms Beats 74.91%, 44.94MB Beats 58.46%
// Use boolean array instead of hashset can improve by another 1ms.
public class ImprovedSolution2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        boolean[] indexToAvoid = new boolean[nums.length];
        findSolution(list, new ArrayList<>(), nums, indexToAvoid);
        return list;
    }

    private void findSolution(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean[] indexToAvoid ) {
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if (indexToAvoid[i]) continue;
                if (i>0 && nums[i] == nums[i-1] && !indexToAvoid[i-1]) continue;
                tempList.add(nums[i]);
                indexToAvoid[i] = true;
                findSolution(list, tempList, nums, indexToAvoid);
                indexToAvoid[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
