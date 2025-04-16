package com.mycompany.findmaximizedcapital502;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
//        ImprovedSolution solution = new ImprovedSolution();
        ImprovedSolution2 solution = new ImprovedSolution2();
        int[] profits = new int[]{1,2,3}, capital = new int[]{0,1,1};
        assertEquals(4, solution.findMaximizedCapital(2, 0, profits, capital));

        profits = new int[]{1,2,3};
        capital = new int[]{0,1,2};
        assertEquals(6, solution.findMaximizedCapital(3, 0, profits, capital));

        profits = new int[]{1,2,3};
        capital = new int[]{0,1,2};
        assertEquals(7, solution.findMaximizedCapital(3, 1, profits, capital));

        profits = new int[]{1,2,3};
        capital = new int[]{0,1,2};
        assertEquals(6, solution.findMaximizedCapital(2, 1, profits, capital));

        profits = new int[]{1,2,3};
        capital = new int[]{0,1,2};
        assertEquals(6, solution.findMaximizedCapital(10, 0, profits, capital));

        profits = new int[]{1,2,3};
        capital = new int[]{0,9,10};
        assertEquals(1, solution.findMaximizedCapital(2, 0, profits, capital));

        profits = new int[]{1,2,3};
        capital = new int[]{0,9,10};
        assertEquals(1, solution.findMaximizedCapital(1, 0, profits, capital));
    }
}
