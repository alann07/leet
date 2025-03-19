package com.mycompany.sortedarraytobst108;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every
 * node never differs by more than one.
 *
 * 0ms Beats 100.00%, 43.62MB Beats 16.61%
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return findSolution(nums, 0, nums.length/2, nums.length-1);
    }

    private TreeNode findSolution(int[] nums, int start, int pivot, int end) {
        if (pivot == start && pivot == end) return new TreeNode(nums[pivot]);
        TreeNode curr = new TreeNode(nums[pivot]);
        if (pivot > start) curr.left = findSolution(nums, start,start + (pivot-start)/2, pivot-1);
        if (pivot < end) curr.right = findSolution(nums, pivot+1, pivot+1 + (end-pivot-1)/2, end);
        return curr;
    }
}
