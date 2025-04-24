package com.mycompany.kclosest973;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
        ImprovedSolution solution = new ImprovedSolution();
        int[][] points = new int[][]{{1,3},{-2,2}};
        int[][] results = solution.kClosest(points, 1);
        assertEquals(-2, results[0][0]);
        assertEquals(2, results[0][1]);

        points = new int[][]{{3,3},{5,-1},{-2,4}};
        results = solution.kClosest(points, 2);
        assertEquals(-2, results[0][0]);
        assertEquals(4, results[0][1]);
        assertEquals(3, results[1][0]);
        assertEquals(3, results[1][1]);
    }
}
