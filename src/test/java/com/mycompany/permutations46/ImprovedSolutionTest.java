package com.mycompany.permutations46;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedSolutionTest {
    @Test
    public void testSolution() {
        ImprovedSolution solution = new ImprovedSolution();
        int[] input = new int[] {1};
        List<List<Integer>> result = solution.permute(input);
        assertEquals(1, result.size());
        System.out.println(result);

        input = new int[] {1,2};
        result = solution.permute(input);
        assertEquals(2, result.size());
        System.out.println(result);

        input = new int[] {1,2,3};
        result = solution.permute(input);
        assertEquals(6, result.size());
        System.out.println(result);

        input = new int[] {1,2,3, 4};
        result = solution.permute(input);
        assertEquals(24, result.size());
        System.out.println(result);
    }
}
