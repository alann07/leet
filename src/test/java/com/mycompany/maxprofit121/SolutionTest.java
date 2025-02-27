package com.mycompany.maxprofit121;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] input = {7,1,5,3,6,4};
        assertEquals(5, solution.maxProfit(input));

        input = new int[] {7,6,4,3,1};
        assertEquals(0, solution.maxProfit(input));

        input = new int[] {2,4,1};
        assertEquals(2, solution.maxProfit(input));

        input = new int[] {2,1,2,1,0,1,2};
        assertEquals(2, solution.maxProfit(input));
    }
}
