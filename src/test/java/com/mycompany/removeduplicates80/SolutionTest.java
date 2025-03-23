package com.mycompany.removeduplicates80;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] input = new int[]{1,1,1,2,2,3};
        assertEquals(5, solution.removeDuplicates(input));

        input = new int[]{0,0,1,1,1,1,2,3,3};
        assertEquals(7, solution.removeDuplicates(input));

        input = new int[]{-1,-1,-1,0,0,1,1,1,1,2,3,3};
        assertEquals(9, solution.removeDuplicates(input));
    }
}
