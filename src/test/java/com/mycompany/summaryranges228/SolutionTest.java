package com.mycompany.summaryranges228;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] input = new int[]{0,1,2,4,5,7};
        List<String> result = solution.summaryRanges(input);
        System.out.println(result);
        assertEquals(3, result.size());

        input = new int[]{0,2,3,4,6,8,9};
        result = solution.summaryRanges(input);
        System.out.println(result);
        assertEquals(4, result.size());

        input = new int[0];
        result = solution.summaryRanges(input);
        System.out.println(result);
        assertEquals(0, result.size());

        input = new int[]{1};
        result = solution.summaryRanges(input);
        System.out.println(result);
        assertEquals(1, result.size());

        input = new int[]{1,2,3,4,5};
        result = solution.summaryRanges(input);
        System.out.println(result);
        assertEquals(1, result.size());
    }
}
