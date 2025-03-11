package com.mycompany.binarytreeflatten114;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {

    @Test
    public void testSolution() {
//        ImprovedSolution solution = new ImprovedSolution();
        ImprovedSolution2 solution = new ImprovedSolution2();
//        Solution solution = new Solution();

        TreeNode root = null;
        solution.flatten(root);

        assertNull(root);

        root = new TreeNode(0);
        solution.flatten(root);
        assertEquals(0, root.val);

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        solution.flatten(root);
        assertEquals(3, root.right.right.val);

        root = new TreeNode(1, null, new TreeNode(3));
        solution.flatten(root);
        assertEquals(3, root.right.val);
        assertNull(root.right.right);

        root = new TreeNode(1, new TreeNode(3), null);
        solution.flatten(root);
        assertEquals(3, root.right.val);

        root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        solution.flatten(root);
        assertEquals(2, root.right.right.val);

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        solution.flatten(root);
        assertEquals(3, root.right.right.val);

        root = new TreeNode(1, new TreeNode(3, new TreeNode(2, new TreeNode(4), null), null), null);
        solution.flatten(root);
        assertEquals(4, root.right.right.right.val);

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        solution.flatten(root);
        assertEquals(4, root.right.right.right.val);
        assertEquals(6, root.right.right.right.right.right.val);

        root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        solution.flatten(root);
        assertEquals(3, root.right.right.val);
        assertNull(root.right.right.right);
    }
}
