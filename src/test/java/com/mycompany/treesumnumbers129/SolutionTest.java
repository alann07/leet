package com.mycompany.treesumnumbers129;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertEquals(25, solution.sumNumbers(root));

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)));
        assertEquals(146, solution.sumNumbers(root));

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        assertEquals(146, solution.sumNumbers(root));

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        assertEquals(281, solution.sumNumbers(root));
    }
}
