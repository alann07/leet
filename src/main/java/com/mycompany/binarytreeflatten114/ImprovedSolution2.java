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

        flattenNode(root, root);
        root.left = null;
    }

    private TreeNode flattenNode(TreeNode curr, TreeNode child) {
        if (child == null) {
            return curr;
        }

        curr.val = child.val;

        TreeNode tempStoreForRightNode = null;
        TreeNode lastNode;
        if (child.left != null) {
            if (child.right != null) {
                tempStoreForRightNode = new TreeNode(child.right.val, child.right.left, child.right.right);
            }
            curr.right = new TreeNode();
            lastNode = flattenNode(curr.right, child.left);
            curr.left = null;
        } else {
            if (child.right != null) {
                if (curr.right == null) curr.right = new TreeNode();
                lastNode = flattenNode(curr.right, child.right);
            } else {
                lastNode = curr;
            }
        }
        if (tempStoreForRightNode != null) {
            if (lastNode.right == null) lastNode.right = new TreeNode();
            lastNode = flattenNode(lastNode.right, tempStoreForRightNode);
        }
        lastNode.left = null;
        return lastNode;
    }
}
