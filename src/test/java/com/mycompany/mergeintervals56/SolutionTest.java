package com.mycompany.mergeintervals56;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution2 solution = new ImprovedSolution2();
        int[][] intervals = new int[][]{{4,5},{1,4}};
        int[][] results = solution.merge(intervals);
        assertEquals(1, results.length);

        intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        results = solution.merge(intervals);
        assertEquals(3, results.length);

        intervals = new int[][]{{1,4},{4,5}};
        results = solution.merge(intervals);
        assertEquals(1, results.length);

        intervals = new int[][]{{4,5},{1,4}};
        results = solution.merge(intervals);
        assertEquals(1, results.length);

        intervals = new int[][]{{1,4},{2,3}};
        results = solution.merge(intervals);
        assertEquals(1, results.length);
        assertEquals(4, results[0][1]);
    }
}
