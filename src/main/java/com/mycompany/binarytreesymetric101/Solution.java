package com.mycompany.binarytreesymetric101;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * 0ms Beats 100.00%, 42.08MB Beats 29.66%
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return  isChildrenMirrored(root.left, root.right)? true : false;
    }

    private boolean isChildrenMirrored(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left != null && right != null) {
            if (left.val != right.val) return false;
            else
                return isChildrenMirrored(left.right, right.left) && isChildrenMirrored(left.left, right.right);
        } else {
            return false;
        }
    }
}
