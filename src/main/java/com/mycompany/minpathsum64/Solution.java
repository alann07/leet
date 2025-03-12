package com.mycompany.minpathsum64;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes
 * the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Dynamic Programming
 *
 * 1ms Beats 99.80%, 47.83MB Beats 32.70%
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int[][] dp = new int[grid.length][grid[0].length];
        return findSolution(grid, 0, 0, dp);
    }

    private int findSolution(int[][] grid, int x, int y, int[][] dp) {
        if (x==grid.length-1 && y==grid[0].length-1) return grid[x][y];

        if (x == grid.length-1) {
            if (dp[x][y] == 0) {
                dp[x][y] = grid[x][y] + findSolution(grid, x, y + 1, dp);
            }
            return dp[x][y];
        }

        if (y == grid[0].length-1) {
            if (dp[x][y] == 0) {
                dp[x][y] = grid[x][y] + findSolution(grid, x + 1, y, dp);
            }
            return dp[x][y];
        }

        if (dp[x][y] == 0) {
            dp[x][y] = Math.min(findSolution(grid, x, y+1, dp) + grid[x][y], findSolution(grid, x+1, y, dp) + grid[x][y]);
        }

        return dp[x][y];
    }
}
