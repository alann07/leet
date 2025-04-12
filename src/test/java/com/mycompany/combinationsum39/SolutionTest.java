package com.mycompany.combinationsum39;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] input = new int[]{2,3,6,7};
        List<List<Integer>> result = solution.combinationSum(input, 7);
        System.out.println(result);
        assertEquals(2, result.size());

        input = new int[]{2,3,5};
        result = solution.combinationSum(input, 8);
        System.out.println(result);
        assertEquals(3, result.size());

        input = new int[]{2};
        result = solution.combinationSum(input, 1);
        System.out.println(result);
        assertEquals(0, result.size());

        input = new int[]{3,5,8};
        result = solution.combinationSum(input, 11);
        System.out.println(result);
        assertEquals(2, result.size());

        input = new int[]{8,7,4,3};
        result = solution.combinationSum(input, 11);
        System.out.println(result);
        assertEquals(3, result.size());
    }
}

