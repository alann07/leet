package com.mycompany.binarytreeflatten114;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to
 * the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * 1ms Beats 18.41%, 42.22MB Beats 49.30%
 */
public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) return;

        List<Integer> result = new ArrayList<>();
        getPreOrderResult(root, result);
        TreeNode curr = root;
        if (curr.left != null) curr.left = null;
        for(int i=1; i<result.size(); i++) {
            curr.right = new TreeNode(result.get(i));
            curr = curr.right;
        }
    }

    private void getPreOrderResult(TreeNode curr, List<Integer> result) {
        result.add(curr.val);
        if (curr.left != null) getPreOrderResult(curr.left, result);
        if (curr.right != null) getPreOrderResult(curr.right, result);
    }
}
