package com.mycompany.issametree100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode t1= new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2= new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertTrue(solution.isSameTree(t1, t2));

        t1= new TreeNode(1, new TreeNode(2), null);
        t2= new TreeNode(1, new TreeNode(2), null);
        assertTrue(solution.isSameTree(t1, t2));

        t1= new TreeNode(1, null, new TreeNode(2));
        t2= new TreeNode(1, new TreeNode(2), null);
        assertFalse(solution.isSameTree(t1, t2));
    }
}
