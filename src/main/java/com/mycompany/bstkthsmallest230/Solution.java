package com.mycompany.bstkthsmallest230;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed)
 * of all the values of the nodes in the tree.
 *
 * Approach: in order traverse will return a sorted array
 * 1ms Beats 31.79%, 43.67MB Beats 99.84%
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        List<Integer> all = new ArrayList<>();
        inOrder(root, all);
        return all.get(k-1);
    }

    private void inOrder(TreeNode curr, List<Integer> all) {
        if (curr == null) return;
        inOrder(curr.left, all);
        all.add(curr.val);
        inOrder(curr.right, all);
    }
}
