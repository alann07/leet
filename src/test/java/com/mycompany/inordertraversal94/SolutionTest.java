package com.mycompany.inordertraversal94;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = solution.inorderTraversal(root);
        assertEquals(3, result.size());
        System.out.println(result);

        root = new TreeNode(1);
        result = solution.inorderTraversal(root);
        assertEquals(1, result.size());
        System.out.println(result);

        root = null;
        result = solution.inorderTraversal(root);
        assertEquals(0, result.size());
        System.out.println(result);
    }
}
