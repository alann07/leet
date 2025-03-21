package com.mycompany.searchInsert35;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * 0ms Beats 100.00%, 43.32MB Beats 18.79% (binary search, or divide and conquer)
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;

        return findSolution(nums, 0, nums.length-1, target);
    }

    private int findSolution(int[] nums, int start, int end, int target) {
        if (end == start) {
            if (nums[start] < target) return start+1;
            if (nums[start] > target) return start;
            return start;
        }
        if (target < nums[start]) return start;
        if (target > nums[end]) return end+1;
        int pivot = start + (end-start)/2;
        if (nums[pivot] == target) return pivot;
        if (nums[pivot] > target) return findSolution(nums, start, pivot-1, target);
        else return findSolution(nums, pivot+1, end, target);
    }
}
