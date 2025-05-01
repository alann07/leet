package com.mycompany.maxpoints149;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        int[][] points = {{1,1},{2,2},{3,3}};
        assertEquals(3, solution.maxPoints(points));

        points = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        assertEquals(4, solution.maxPoints(points));

        points = new int[][]{{1,1},{3,1},{5,1},{4,1},{2,1},{1,4}};
        assertEquals(5, solution.maxPoints(points));

        points = new int[][]{{1,1},{1,3},{1,5},{1,4},{1,2},{4,1}};
        assertEquals(5, solution.maxPoints(points));

        points = new int[][]{{0,0}};
        assertEquals(1, solution.maxPoints(points));

        points = new int[][]{{1,1}};
        assertEquals(1, solution.maxPoints(points));

        points = new int[][]{{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}};
        assertEquals(5, solution.maxPoints(points));
    }
}
