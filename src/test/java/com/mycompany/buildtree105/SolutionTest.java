package com.mycompany.buildtree105;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] preOrder = {-1};
        int[] inOrder = {-1};
        TreeNode result = solution.buildTree(preOrder, inOrder);
        assertEquals(-1, result.val);

        preOrder = new int[]{1,2};
        inOrder = new int[]{2,1};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertNull(result.right);
        assertNull(result.left.right);
        assertNull(result.left.left);

        preOrder = new int[]{1,2};
        inOrder = new int[]{1,2};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(1, result.val);
        assertEquals(2, result.right.val);
        assertNull(result.left);

        preOrder = new int[]{1,2,3};
        inOrder = new int[]{2,1,3};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertEquals(3, result.right.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertNull(result.right.left);
        assertNull(result.right.right);

        preOrder = new int[]{3,9,20,15,7};
        inOrder = new int[]{9,3,15,20,7};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(9, result.left.val);
        assertNull(result.left.right);
        assertNull(result.left.left);
        assertEquals(20, result.right.val);
        assertEquals(7, result.right.right.val);
        assertEquals(15, result.right.left.val);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);

        preOrder = new int[]{1,2,3};
        inOrder = new int[]{3,2,1};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertEquals(3, result.left.left.val);
        assertNull(result.right);
        assertNull(result.left.right);

        preOrder = new int[]{1,2,3};
        inOrder = new int[]{1,2,3};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(1, result.val);
        assertEquals(2, result.right.val);
        assertEquals(3, result.right.right.val);
        assertNull(result.left);

        preOrder = new int[]{3,1,2,4};
        inOrder = new int[]{1,2,3,4};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(3, result.val);
        assertEquals(1, result.left.val);
        assertEquals(4, result.right.val);
        assertEquals(2, result.left.right.val);
        assertNull(result.left.left);

        preOrder = new int[]{4,2,1,3};
        inOrder = new int[]{1,2,3,4};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(4, result.val);
        assertEquals(2, result.left.val);
        assertEquals(1, result.left.left.val);
        assertEquals(3, result.left.right.val);
        assertNull(result.right);

        preOrder = new int[]{4,2,1,3};
        inOrder = new int[]{4,1,2,3};
        result = solution.buildTree(preOrder, inOrder);
        assertEquals(4, result.val);
        assertEquals(2, result.right.val);
        assertEquals(1, result.right.left.val);
        assertEquals(3, result.right.right.val);
        assertNull(result.left);
    }
}
