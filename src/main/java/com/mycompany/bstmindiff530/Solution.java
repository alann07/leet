package com.mycompany.bstmindiff530;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values
 * of any two different nodes in the tree.
 *
 * 1ms Beats 41.48%, 44.21MB Beats 89.27%
 */
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root == null || (root.left == null && root.right == null)) return min;

        List<Integer> store = new ArrayList<>();
        findSolution(root, store);
        for (int i=1; i<store.size(); i++) {
            min = Math.min(min, store.get(i) - store.get(i-1));
        }
        return min;
    }

    private void findSolution(TreeNode curr, List<Integer> store) {
        if (curr.left != null) findSolution(curr.left, store);
        store.add(curr.val);
        if (curr.right != null) findSolution(curr.right, store);
    }
}
