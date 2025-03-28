package com.mycompany.buildtree105;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Approach: use root of pre-order as pivot point and seperate 2 segement, left and right. Then recursively rebuild for
 * each segment.
 * 3ms Beats 35.34%, 44.30MB Beats 63.37%
 */
public class ImprovedSolution {
    private int preNext = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        preNext = 1;
        TreeNode root = new TreeNode(preorder[0]);
        findSolution(preorder, inorder, 0, preorder.length, root);
        return root;
    }

    private void findSolution(int[] preorder, int[] inorder, int inStart, int inEnd, TreeNode curr) {
        if (inStart == inEnd - 1 || preNext >= preorder.length) return;
        int pivot = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == curr.val) {
                pivot = i;
                break;
            }
        }
        TreeNode right, left;

        // Handle left
        if (pivot != inStart) {
            left = new TreeNode(preorder[preNext++]);
            curr.left = left;
            findSolution(preorder, inorder, inStart, pivot, left);
        }

        // Handle right
        if (pivot != inEnd-1) {
            right = new TreeNode(preorder[preNext++]);
            curr.right = right;
            findSolution(preorder, inorder, pivot + 1, inEnd, right);
        }
    }
}


//public TreeNode buildTree(int[] preorder, int[] inorder) {
//    return helper(0, 0, inorder.length - 1, preorder, inorder);
//}
//
//public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
//    if (preStart > preorder.length - 1 || inStart > inEnd) {
//        return null;
//    }
//    TreeNode root = new TreeNode(preorder[preStart]);
//    int inIndex = 0; // Index of current root in inorder
//    for (int i = inStart; i <= inEnd; i++) {
//        if (inorder[i] == root.val) {
//            inIndex = i;
//        }
//    }
//    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
//    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
//    return root;
//}