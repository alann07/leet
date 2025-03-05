package com.mycompany.jumpgame55;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImprovedSolution2Test {

    @Test
    public void testSolution() {
        ImprovedSolution3 solution = new ImprovedSolution3();
        int[] input = new int[]{2,3,1,1,4};
        assertTrue(solution.canJump(input));

        input = new int[]{3,2,1,0,4};
        assertFalse(solution.canJump(input));

        input = new int[]{3,2,5,0,4};
        assertTrue(solution.canJump(input));

        input = new int[]{3};
        assertTrue(solution.canJump(input));

        input = new int[]{0,1};
        assertFalse(solution.canJump(input));

        input = new int[]{0,0};
        assertFalse(solution.canJump(input));

        input = new int[]{2,0,0};
        assertTrue(solution.canJump(input));

        input = new int[]{0,0,0};
        assertFalse(solution.canJump(input));

        input = new int[]{1,1,1,0};
        assertTrue(solution.canJump(input));
    }
}
