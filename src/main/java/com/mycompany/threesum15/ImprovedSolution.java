package com.mycompany.threesum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// sort first, then back-tracking, 949ms
public class ImprovedSolution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3 || nums.length > 3000) return null;

        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        if (nums[0] > 0 || nums[nums.length-1] < 0) return results;

        List<Integer> builder = new ArrayList<>();
        findSolution(nums, 0, results, builder);
        return results;
    }

    private void findSolution(int[] nums, int index, List<List<Integer>> results, List<Integer> temp) {
        if (temp.size() == 3) {
            if (temp.get(0) + temp.get(1) + temp.get(2) == 0) {
                results.add(new ArrayList<>(temp));            }
            return;
        }

        int diff = 0;
        if (temp.size() == 2) {
            diff = 0 - temp.get(0) - temp.get(1);
        }
        for (int i=index; i<nums.length; i++) {
            if (i>index && nums[i] == nums[i-1]) continue;
            if (temp.size() == 2) { // skip the rest if rightmost is still too small or next one is too big. reduced from 33s -> 11s.
                if (nums[nums.length-1] < diff
                        || nums[i] > diff) {
                    return;
                } else if (nums[i] < diff) {
                    continue;
                }
                if (nums[i] == diff) {
                    List<Integer> newSum = new ArrayList<>(temp);
                    newSum.add(nums[i]);
                    results.add(newSum);
                    return;
                }
            } else {
                temp.add(nums[i]);
                findSolution(nums, i + 1, results, temp);
                temp.remove(temp.size() - 1);
            }

            if (temp.size() == 2 && nums[i]==diff) {
                return;
            }
        }
    }
}
