package com.mycompany.binarytreeflatten114;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to
 * the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * Try move left tree to right node and append original right node under it.
 *
 * 0ms Beats 100.00%, 42.52MB Beats 17.61%
 */
public class ImprovedSolution2 {

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode temp = null;
        if (root.right != null) {
            temp = new TreeNode(root.right.val, root.right.left, root.right.right);
        }

        TreeNode lastNode = null;
        if (root.left != null) {
            root.right = new TreeNode();
            lastNode = flattenNode(root.right, root.left);
        } else {
            lastNode = root;
        }
        if (temp != null) {
            if (lastNode.right == null) lastNode.right = new TreeNode();
            flattenNode(lastNode.right, temp);
        }
        root.left = null;
    }

    private TreeNode flattenNode(TreeNode curr, TreeNode child) {
        if (child == null) {
            return curr;
        } else if (curr == null) {
            curr = new TreeNode();
        }
        curr.val = child.val;
        curr.left = null;

        TreeNode temp = null;
        if (child.right != null) {
            temp = new TreeNode(child.right.val, child.right.left, child.right.right);
        }

        TreeNode lastNode = null;
        if (child.left != null) {
            curr.right = new TreeNode();
            lastNode = flattenNode(curr.right, child.left);
        } else {
            lastNode = curr;
        }
        if (temp != null) {
            if (lastNode.right == null) lastNode.right = new TreeNode();
            lastNode = flattenNode(lastNode.right, temp);
        }
        lastNode.left = null;
        return lastNode;
    }

//    private void getPreOrderResult(TreeNode curr, List<Integer> result) {
//        result.add(curr.val);
//        if (curr.left != null) getPreOrderResult(curr.left, result);
//        if (curr.right != null) getPreOrderResult(curr.right, result);
//    }
}
