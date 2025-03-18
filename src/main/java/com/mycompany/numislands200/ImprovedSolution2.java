package com.mycompany.numislands200;

/**
 *Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
 * all four edges of the grid are all surrounded by water.
 *
 * 4ms Beats 50.56%, 49.16MB Beats 88.17%. with DFS
 */
public class ImprovedSolution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int[][] visited, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] == 1 || grid[i][j] == '0') return;
        visited[i][j] = 1;
        dfs(grid, visited,i-1, j);
        dfs(grid, visited,i+1, j);
        dfs(grid, visited, i, j-1);
        dfs(grid, visited, i, j+1);
    }
}
