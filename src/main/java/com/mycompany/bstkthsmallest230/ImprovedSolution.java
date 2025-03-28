package com.mycompany.bstkthsmallest230;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed)
 * of all the values of the nodes in the tree.
 *
 * Approach: in order traverse, but count the kth value position directly, so that no need of an array,
 * but need to add 3 global varaibles in order to stop execution.
 * 0ms Beats 100.00%, 44.46MB Beats 59.94%
 */
public class ImprovedSolution {
    private int target;
    private boolean found;
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        target = -1;
        found = false;
        count = 0;
        inOrder(root, k);
        return target;
    }

    private void inOrder(TreeNode curr, int k) {
        if (found || curr == null) return;
        inOrder(curr.left, k);
        count++;
        if (count == k) {
            found = true;
            target = curr.val;
            return;
        }
        inOrder(curr.right, k);
    }
}
