package com.mycompany.bstmindiff530;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        TreeNode root = new TreeNode(1);
        assertEquals(Integer.MAX_VALUE, solution.getMinimumDifference(root));

        root = new TreeNode(4, new TreeNode(1), new TreeNode(6));
        assertEquals(2, solution.getMinimumDifference(root));

        root = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(8));
        assertEquals(1, solution.getMinimumDifference(root));

        root = new TreeNode(236, new TreeNode(104, null, new TreeNode(227)), new TreeNode(701, null, new TreeNode(911)));
        assertEquals(9, solution.getMinimumDifference(root));


        root = new TreeNode(600, new TreeNode(424, null, new TreeNode(499)), new TreeNode(612, null, new TreeNode(689)));
        assertEquals(12, solution.getMinimumDifference(root));
    }
}
