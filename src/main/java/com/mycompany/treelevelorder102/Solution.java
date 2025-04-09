package com.mycompany.treelevelorder102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * 0ms Beats 100.00%, 45.30MB Beats 12.68%
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        bfs(root, result, 0);
        return result;
    }

    private void bfs(TreeNode root, List<List<Integer>> result, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) bfs(root.left, result, level+1);
        if (root.right != null) bfs(root.right, result, level+1);
    }
}
