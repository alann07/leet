package com.mycompany.bstmindiff530;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values
 * of any two different nodes in the tree.
 *
 * In order traversal. No additioal store as previous solution.
 * Use abs, so no need to distinguish negative diff.
 * 0ms Beats 100.00%, 44.73MB Beats 32.29%
 */
public class ImprovedSolution {
    private int min;
    private int prevVal;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        prevVal = Integer.MAX_VALUE;
        if (root == null || (root.left == null && root.right == null)) return min;

        findSolution(root);

        return min;
    }

    private void findSolution(TreeNode curr) {
        if (curr == null) return;
        findSolution(curr.left);
        min = Math.min(min, Math.abs(curr.val - prevVal));
        prevVal = curr.val;
        findSolution(curr.right);
    }
}
