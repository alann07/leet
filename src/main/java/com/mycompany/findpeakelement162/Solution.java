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
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
//        if (nums.length == 2) return nums[0]>nums[1]? 0;

        int start = 0, end = nums.length, pivot;
        while(start <= end) {
            pivot = start + (end - start) / 2;
            if (pivot+1 <= nums.length-1 && pivot-1>=0) {
                if (nums[pivot] > nums[pivot-1] && nums[pivot] > nums[pivot+1]) return pivot;
            }
            if (pivot == nums.length-1 && nums[pivot] > nums[pivot-1]) {
                return pivot;
            } else if (pivot-1 == 0 && nums[pivot] < nums[pivot-1]){
                return 0;
            } else if (pivot+1 == nums.length-1 && nums[pivot] < nums[pivot+1]){
                return nums.length-1;
            } else if (pivot == nums.length-1 || pivot-1 == 0) return -1;

            if (pivot == 0) {
                if (nums[pivot] > nums[pivot+1]) return pivot;
                else return -1;
            }
            if (nums[pivot+1] > nums[pivot] && nums[pivot] > nums[pivot-1]) {
                start = pivot;
            } else {
                end = pivot;
            }
        }
        return -1;
    }
}
