package com.mycompany.buildtree105;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Approach: use root of pre-order as pivot point and seperate 2 segement, left and right. Then recursively rebuild for
 * each segment.
 * 3ms Beats 35.34%, 44.30MB Beats 63.37%
 */
public class Solution {
    private int preNext = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        preNext = 1;
        TreeNode root = new TreeNode(preorder[0]);
        findSolution(preorder, inorder, 0, preorder.length, root);
        return root;
    }

    private void findSolution(int[] preorder, int[] inorder, int inStart, int inEnd, TreeNode curr) {
        if (inStart == inEnd - 1) return;
        int pivot = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == curr.val) {
                pivot = i;
                break;
            }
        }
        TreeNode right, left;
        if (pivot == inStart && inStart + 1 < inEnd) {
            right = new TreeNode(preorder[preNext++]);
            curr.right = right;
            findSolution(preorder, inorder, inStart + 1, inEnd, right);
        } else if (pivot == inEnd - 1 && preNext < preorder.length) {
            left = new TreeNode(preorder[preNext++]);
            curr.left = left;
            findSolution(preorder, inorder, inStart, inEnd - 1, left);
        } else {

            // Handle left
            if (preNext < preorder.length) {
                left = new TreeNode(preorder[preNext++]);
                curr.left = left;
                findSolution(preorder, inorder, inStart, pivot, left);
            }


            // Handle right
            if (preNext < preorder.length) {
                right = new TreeNode(preorder[preNext++]);
                curr.right = right;
                findSolution(preorder, inorder, pivot + 1, inEnd, right);
            }
        }

    }
}
