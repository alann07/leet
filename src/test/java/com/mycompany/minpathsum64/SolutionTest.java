package com.mycompany.minpathsum64;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        assertEquals(7, solution.minPathSum(grid));

        grid = new int[][]{{1,2,3},{4,5,6}};
        assertEquals(12, solution.minPathSum(grid));

        grid = new int[][]{{1},{2},{3}};
        assertEquals(6, solution.minPathSum(grid));

        grid = new int[][]{{1,2,3}};
        assertEquals(6, solution.minPathSum(grid));
    }
}
