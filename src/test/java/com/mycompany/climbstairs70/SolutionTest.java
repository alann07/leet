package com.mycompany.climbstairs70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        assertEquals(1, solution.climbStairs(1));
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
        assertEquals(5, solution.climbStairs(4));
        assertEquals(1134903170, solution.climbStairs(44));
    }
}
