package com.mycompany.sortedarraytobst108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode result = solution.sortedArrayToBST(nums);
        System.out.println(result);
//        assertEquals(-10, result.left.left.val);
//        assertEquals(5, result.right.left.val);

        nums = new int[]{1,3};
        result = solution.sortedArrayToBST(nums);
        System.out.println(result);
    }
}
