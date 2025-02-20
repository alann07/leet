package com.mycompany.threesum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 46ms Beats 27.77% 51.35MB Beats 83.72%
// 43ms Beats 28.69% 51.24MB Beats 92.35%
// 41ms Beats 29.72%
public class ImprovedSolution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3 || nums.length > 3000) return null;

        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        if (nums[0] > 0 || nums[nums.length-1] < 0) return results;

        int j, k, sum;

        for (int i=0; i< nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            j = i + 1; k= nums.length-1;
            while (j < k) {
                if (k<=nums.length-2 && nums[k]==nums[k+1]) {
                    k--;
                    continue;
                }
                if (j>i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }

                sum = nums[i] + nums[j] + nums[k];

                if (sum ==0) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                } else if (sum < 0) {
                    if (nums[i] + nums[k-1] + nums[k] < 0) {
                        break;
                    }
                    j++;
                } else {
                    if (nums[i] + nums[j] + nums[j+1] > 0) {
                        break;
                    }
                    k--;
                }

            }
        }

        return results;
    }

}
