package com.mycompany.hindex274;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        int[] citations = new int[]{1,3,1};
        assertEquals(1, solution.hIndex(citations));

        citations = new int[]{3,0,6,1,5};
        assertEquals(3, solution.hIndex(citations));

        citations = new int[]{3};
        assertEquals(1, solution.hIndex(citations));

        citations = new int[]{11, 15};
        assertEquals(2, solution.hIndex(citations));

        citations = new int[]{0};
        assertEquals(0, solution.hIndex(citations));
    }
}
