package com.mycompany.lettercombinations17;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedSolutionTest4 {

    @Test
    public void testLetterCombinations5() {
        long startTime = System.currentTimeMillis();
        ImprovedSolution4 solution = new ImprovedSolution4();
        List<String> results = solution.letterCombinations("2");
        assertEquals(3, results.size());
        assertEquals("a", results.get(0));
        assertEquals("b", results.get(1));
        assertEquals("c", results.get(2));
        System.out.println(results);

        results = solution.letterCombinations("");
        System.out.println(results);
        assertEquals(0, results.size());

        results = solution.letterCombinations("1");
        System.out.println(results);
        assertEquals(0, results.size());

        results = solution.letterCombinations("23456");
        System.out.println(results);
        assertEquals(0, results.size());

        results = solution.letterCombinations("23");
        System.out.println(results);
        assertEquals(9, results.size());

        results = solution.letterCombinations("22");
        System.out.println(results);
        assertEquals(9, results.size());

        results = solution.letterCombinations("234");
        System.out.println(results);
        assertEquals(27, results.size());

        results = solution.letterCombinations("2345");
        System.out.println(results);
        assertEquals(81, results.size());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
