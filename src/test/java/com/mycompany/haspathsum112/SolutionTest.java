package com.mycompany.haspathsum112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        assertTrue(solution.hasPathSum(root, 3));
        assertTrue(solution.hasPathSum(root, 5));
        assertFalse(solution.hasPathSum(root, 4));

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3, null, new TreeNode(4)));
        assertTrue(solution.hasPathSum(root, 9));
        assertFalse(solution.hasPathSum(root, 8));

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(4), null));
        assertTrue(solution.hasPathSum(root, 9));
        assertFalse(solution.hasPathSum(root, 8));
    }
}

