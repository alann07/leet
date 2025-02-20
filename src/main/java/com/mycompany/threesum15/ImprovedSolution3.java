package com.mycompany.threesum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 40ms Beats 30.24% 51.28MB Beats 92.35%
public class ImprovedSolution3 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3 || nums.length > 3000) return null;

        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        if (nums[0] > 0 || nums[nums.length-1] < 0) return results;

        int j, k, sum, median;

        for (int i=0; i< nums.length; i++) {
            if (nums[i] >0) break;
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
                median = (j+k) / 2;

                if (sum ==0) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                } else if (sum < 0) {
                    if (nums[i] + nums[k-1] + nums[k] < 0) {
                        break;
                    }
                    if (nums[i] + nums[median] + nums[k] < 0) {
                        j = median + 1;
                    } else if (nums[i] + nums[median] + nums[k] == 0) {
                        results.add(Arrays.asList(nums[i], nums[median], nums[k]));
                        j = median+1;
                        k--;
                    } else {
                        j++;
                    }
                } else {
                    if (nums[i] + nums[j] + nums[j+1] > 0) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[median] > 0) {
                        k = median - 1;
                    } else if (nums[i] + nums[j] + nums[median] == 0) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[median]));
                        j++;
                        k = median-1;
                    } else {
                        k--;
                    }
                }

            }
        }

        return results;
    }

}
