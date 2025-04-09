package com.mycompany.treesumnumbers129;

/**
 * 129. Sum Root to Leaf Numbers
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 * 0ms Beats 100.00%, 41.32MB Beats 40.53%
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return -1;
        return findSolution(root, 0);
    }

    private int findSolution(TreeNode curr, int currSum) {
        if (curr == null) return 0;
        currSum = currSum * 10 + curr.val;
        if (curr.left == null && curr.right == null) return currSum;
        return findSolution(curr.left, currSum) + findSolution(curr.right, currSum);
    }
}
