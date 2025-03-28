package com.mycompany.bstkthsmallest230;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        TreeNode root = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4));
        assertEquals(1, solution.kthSmallest(root, 1));

        root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)),
                new TreeNode(6));
        assertEquals(3, solution.kthSmallest(root, 3));
    }
}
