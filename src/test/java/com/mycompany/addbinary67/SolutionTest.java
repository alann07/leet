package com.mycompany.addbinary67;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        assertEquals("10", solution.addBinary("1", "1"));
        assertEquals("1", solution.addBinary("0", "1"));
        assertEquals("10000", solution.addBinary("1", "1111"));
        assertEquals("100", solution.addBinary("11", "1"));
        assertEquals("10101", solution.addBinary("1010", "1011"));
    }
}
