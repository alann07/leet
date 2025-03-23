package com.mycompany.removeduplicates80;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique
 * element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be
 * placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first
 * k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1)
 * extra memory.
 *
 * 0ms Beats 100.00%, 46.51MB Beats 62.38%
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length == 1) return 1;
        if (nums.length == 2) return 2;

        int prev2 = nums[0];
        int prev1 = nums[1];
        int curr;
        int k=2;
        for (int i=2; i< nums.length; i++) {
            curr = nums[i];
            if (curr != prev2 || curr != prev1) {
                nums[k] = nums[i];
                prev2 = prev1;
                prev1 = nums[k];
                k++;
            }
        }

        return k;
    }
}
