package com.mycompany.inordertraversal94;

import java.util.ArrayList;
import java.util.List;

/**
 * Level: EASY
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * 0ms Beats 100.00%, 41.64MB Beats 64.51%
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        findSolution(root, result);
        return result;
    }

    private void findSolution(TreeNode curr, List<Integer> result) {
        if (curr.left != null) findSolution(curr.left, result);
        result.add(curr.val);
        if (curr.right != null) findSolution(curr.right, result);
    }
}

