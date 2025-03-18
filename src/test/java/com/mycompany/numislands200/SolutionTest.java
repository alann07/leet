package com.mycompany.numislands200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        char[][] grid = new char[][] {{'1','1','0'},{'0','1','0'}};
        assertEquals(1, solution.numIslands(grid));

        grid = new char[][] {{'1','0','0'},{'0','1','0'}};
        assertEquals(2, solution.numIslands(grid));

        grid = new char[][] {{'0','0','0'},{'0','0','0'}};
        assertEquals(0, solution.numIslands(grid));

        grid = new char[][] {{'1','1','1'},{'1','1','1'}};
        assertEquals(1, solution.numIslands(grid));

        grid = new char[][] {{'1'}};
        assertEquals(1, solution.numIslands(grid));

        grid = new char[][] {{'0'},{'1'},{'0'}};
        assertEquals(1, solution.numIslands(grid));

        grid = new char[][] {{'1'},{'0'},{'1'}};
        assertEquals(2, solution.numIslands(grid));
    }
}
