package com.mycompany.minmutation433;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        assertEquals(1, solution.minMutation("AACCGGTT",
                "AACCGGTA",
                new String[]{"AACCGGTA"}));

        assertEquals(2, solution.minMutation("AACCGGTT",
                "AAACGGTA",
                new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
}
