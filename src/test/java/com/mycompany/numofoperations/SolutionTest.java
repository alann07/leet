package com.mycompany.numofoperations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals(2, solution.findMinOperations("b"));
        assertEquals(2, solution.findMinOperations("a"));
        assertEquals(1, solution.findMinOperations("ab"));
        assertEquals(4, solution.findMinOperations("ba"));
        assertEquals(3, solution.findMinOperations("abb"));
        assertEquals(6, solution.findMinOperations("bba"));
        assertEquals(6, solution.findMinOperations("bbb"));
    }
}
