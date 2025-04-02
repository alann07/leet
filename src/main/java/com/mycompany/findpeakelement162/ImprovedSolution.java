package com.mycompany.findpeakelement162;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple
 * peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly
 * greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * 0ms Beats 100.00%, 42.50 MB Beats 55.77%
 */
public class ImprovedSolution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int start = 0, end = nums.length, pivot;
        while(start <= end) {
            pivot = start + (end - start) / 2;
            if (pivot== nums.length-1) {
                if (nums[pivot] > nums[pivot - 1]) return pivot;
                else {
                    end--;
                    continue;
                }
            }
            if (pivot== 0) {
                if (nums[pivot] > nums[pivot + 1]) return pivot;
                else {
                    start++;
                    continue;
                }
            }
            if (nums[pivot] > nums[pivot-1] && nums[pivot] > nums[pivot+1]) return pivot;

            if (nums[pivot+1] >= nums[pivot]) {
                start = pivot+1;
            } else {
                end = pivot-1;
            }
        }
        return -1;
    }
}
