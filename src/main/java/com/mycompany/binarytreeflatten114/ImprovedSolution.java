package com.mycompany.binarytreeflatten114;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to
 * the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * For ImprovedSolution, I am trying to use a temp node to hold all the processing results, whihc is a failure,
 * because it can't remember the top node.
 */
public class ImprovedSolution {

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root;
        getPreOrderResult(root, temp);
    }

    private TreeNode getPreOrderResult(TreeNode curr, TreeNode temp) {
        if (temp == null) temp = new TreeNode();
        temp.val = curr.val;
        if (curr.left != null) {
            temp.right = getPreOrderResult(curr.left, temp.right);
            temp = temp.right;
        }
        if (curr.right != null) {
            temp.right = getPreOrderResult(curr.right, temp.right);
            temp = temp.right;
        }
        return temp;
    }
}
