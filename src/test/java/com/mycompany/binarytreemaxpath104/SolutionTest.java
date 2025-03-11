package com.mycompany.binarytreemaxpath104;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {

    @Test
    public void testSolution() {
//        ImprovedSolution solution = new ImprovedSolution();
//        ImprovedSolution2 solution = new ImprovedSolution2();
//        ImprovedSolution3 solution = new ImprovedSolution3();
        Solution solution = new Solution();

        TreeNode root = null;
        assertEquals(0, solution.maxDepth(root));
        assertNull(root);

        root = new TreeNode(0);
        assertEquals(1, solution.maxDepth(root));

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertEquals(2, solution.maxDepth(root));

        root = new TreeNode(1, null, new TreeNode(3));
        assertEquals(2, solution.maxDepth(root));

        root = new TreeNode(1, new TreeNode(3), null);
        assertEquals(2, solution.maxDepth(root));

        root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        assertEquals(3, solution.maxDepth(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        assertEquals(3, solution.maxDepth(root));

        root = new TreeNode(1, new TreeNode(3, new TreeNode(2, new TreeNode(4), null), null), null);
        assertEquals(4, solution.maxDepth(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        assertEquals(3, solution.maxDepth(root));

        root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assertEquals(3, solution.maxDepth(root));
    }
}
