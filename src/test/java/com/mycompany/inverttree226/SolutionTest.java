package com.mycompany.inverttree226;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode result = solution.invertTree(root);
        assertEquals(2, result.val);
        assertEquals(3, result.left.val);
        assertEquals(1, result.right.val);

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3, null, new TreeNode(4)));
        result = solution.invertTree(root);
        assertEquals(2, result.val);
        assertEquals(3, result.left.val);
        assertEquals(4, result.left.left.val);
        assertEquals(1, result.right.val);

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(4), null));
        result = solution.invertTree(root);
        assertEquals(2, result.val);
        assertEquals(3, result.left.val);
        assertEquals(4, result.left.right.val);
        assertEquals(1, result.right.val);
    }
}

