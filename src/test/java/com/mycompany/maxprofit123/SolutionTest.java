package com.mycompany.maxprofit123;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] input = {1,2};
        assertEquals(1, solution.maxProfit(input));

        input = new int[] {2,1};
        assertEquals(0, solution.maxProfit(input));

        input = new int[] {7,6,4,3,1};
        assertEquals(0, solution.maxProfit(input));

        input = new int[] {1,2,3};
        assertEquals(2, solution.maxProfit(input));

        input = new int[] {1,2,3,4};
        assertEquals(3, solution.maxProfit(input));

        input = new int[] {1,2,3,4,5};
        assertEquals(4, solution.maxProfit(input));

        input = new int[] {3,3,5,0,0,3,1,4};
        assertEquals(6, solution.maxProfit(input));

        input = new int[] {2,1,4};
        assertEquals(3, solution.maxProfit(input));
    }
}
