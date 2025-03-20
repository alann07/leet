package com.mycompany.btaverageoflevels637;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 */
public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        List<Double> result = solution.averageOfLevels(root);
        System.out.println(result);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2.5, result.get(1));
    }
}
