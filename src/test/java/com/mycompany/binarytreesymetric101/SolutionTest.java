package com.mycompany.binarytreesymetric101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        assertTrue(solution.isSymmetric(root));

        assertFalse(solution.isSymmetric(null));

        root = new TreeNode(1);
        assertTrue(solution.isSymmetric(root));

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertFalse(solution.isSymmetric(root));

        root = new TreeNode(1, new TreeNode(2), null);
        assertFalse(solution.isSymmetric(root));

        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3), null));
        assertTrue(solution.isSymmetric(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, null, new TreeNode(3)));
        assertTrue(solution.isSymmetric(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, new TreeNode(3), null));
        assertFalse(solution.isSymmetric(root));
    }
}
