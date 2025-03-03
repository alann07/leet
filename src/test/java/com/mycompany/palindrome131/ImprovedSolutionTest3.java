package com.mycompany.palindrome131;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedSolutionTest3 {

    @Test
    public void testSolution() {
        ImprovedSolution3 solution = new ImprovedSolution3();
        List<List<String>> result;
        result = solution.partition("aab");
        System.out.println(result);
        assertEquals(2, result.size());

        result = solution.partition("a");
        System.out.println(result);
        assertEquals(1, result.size());

        result = solution.partition("baab");
        System.out.println(result);
        assertEquals(3, result.size());

//        result = solution.partition("baabaa");
//        System.out.println(result);
//        assertEquals(5, result.size());

        result = solution.partition("cdd");
        System.out.println(result);
        assertEquals(2, result.size());
    }
}
