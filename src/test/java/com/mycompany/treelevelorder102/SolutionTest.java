package com.mycompany.treelevelorder102;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)));
        List<List<Integer>> result = solution.levelOrder(root);
        assertEquals(3, result.size());
        System.out.println(result);

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        result = solution.levelOrder(root);
        assertEquals(3, result.size());
        System.out.println(result);

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null));
        result = solution.levelOrder(root);
        assertEquals(4, result.size());
        System.out.println(result);

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(5), new TreeNode(6)), null));
        result = solution.levelOrder(root);
        assertEquals(4, result.size());
        System.out.println(result);
    }
}