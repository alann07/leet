package com.mycompany.binarytreemaxpath104;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * 0ms Beats 100.00%, 42.30MB Beats 97.91%
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(1+maxDepth(root.right), 1+maxDepth(root.left));
    }
}
