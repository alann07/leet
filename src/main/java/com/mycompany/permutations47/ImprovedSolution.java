package com.mycompany.permutations47;

import java.util.*;

// 3ms Beats 45.45%, 45.24MB Beats 31.64%
// Better than the previous one after back tracking indexToAvoid as well.
public class ImprovedSolution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> indexToAvoid = new HashSet<>();
        findSolution(list, new ArrayList<>(), nums, indexToAvoid);
        return list;
    }

    private void findSolution(List<List<Integer>> list, List<Integer> tempList, int [] nums, Set<Integer> indexToAvoid) {
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if ((i>0 && !indexToAvoid.contains(i-1) && nums[i] == nums[i-1] ) || indexToAvoid.contains(i)) continue;
                tempList.add(nums[i]);
                indexToAvoid.add(i);
                findSolution(list, tempList, nums, indexToAvoid);
                indexToAvoid.remove(i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
