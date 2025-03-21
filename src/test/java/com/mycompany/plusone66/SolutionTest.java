package com.mycompany.plusone66;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] digits = new int[]{1,2,3};
        int[] result = solution.plusOne(digits);
        for (int i=0; i<result.length; i++)
            System.out.println(result[i] + ",");
        assertEquals(3, result.length);
        assertEquals(4, result[2]);

        digits = new int[]{9};
        result = solution.plusOne(digits);
        for (int i=0; i<result.length; i++)
            System.out.println(result[i] + ",");
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);

        digits = new int[]{9,9};
        result = solution.plusOne(digits);
        for (int i=0; i<result.length; i++)
            System.out.println(result[i] + ",");
        assertEquals(3, result.length);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);
        assertEquals(0, result[2]);
    }
}
