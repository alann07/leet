package com.mycompany.inverttree226;

/**
 * 226. Invert Binary Tree
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * 0ms Beats 100.00%, 40.97MB Beats 90.14%
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
