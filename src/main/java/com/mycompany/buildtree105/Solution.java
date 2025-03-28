package com.mycompany.buildtree105;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class Solution {
//    private int preNext = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        findSolution(preorder, inorder, 0, preorder.length, 1, root);
        return root;
    }

    private void findSolution(int[] preorder, int[] inorder, int inStart, int inEnd, int preNext, TreeNode curr) {
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
            right = new TreeNode(preorder[preNext]);
            curr.right = right;
            findSolution(preorder, inorder, inStart + 1, inEnd, preNext + 1, right);
        } else if (pivot == inEnd - 1 && preNext < preorder.length) {
            left = new TreeNode(preorder[preNext]);
            curr.left = left;
            findSolution(preorder, inorder, inStart, inEnd - 1, preNext + 1, left);
        } else {

            // Handle left
            if (preNext < inEnd) {
                left = new TreeNode(preorder[preNext]);
                curr.left = left;
                findSolution(preorder, inorder, inStart, pivot, preNext + 1, left);
            }


            // Handle right
            if (preNext + 1 < inEnd) {
                right = new TreeNode(preorder[preNext + 1]);
                curr.right = right;
                findSolution(preorder, inorder, pivot + 1, inEnd, preNext + 2, right);
            }
        }

    }
}
