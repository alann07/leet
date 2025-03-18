package com.mycompany.numislands200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
 * all four edges of the grid are all surrounded by water.
 *
 * 11ms Beats 9.06%, 53.48MB Beats 5.51%
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        List<List<Character>> result = new ArrayList<>();
        Queue<Position> queue = new LinkedList<>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (visited[i][j] == 0) {
                    if (grid[i][j] == '1') {
                        queue.add(new Position(i, j));
                        bfs(grid, visited, queue, result);
                    }
                    else {
                        visited[i][j] = 1;
                    }
                }
            }
        }
        return result.size();
    }

    private void bfs(char[][] grid, int[][] visited, Queue<Position> queue, List<List<Character>> result) {
        List<Character> temp = new ArrayList<>();
        while(!queue.isEmpty()) {
            Position p = queue.poll();
            if (visited[p.i][p.j] == 0) {
                visited[p.i][p.j] = 1;
                if (grid[p.i][p.j] == '1') { // enqueue adjacent 4 positions
                    temp.add('1');
                    if (p.i - 1 >= 0) queue.add(new Position(p.i - 1, p.j));
                    if (p.i + 1 < grid.length) queue.add(new Position(p.i + 1, p.j));
                    if (p.j - 1 >= 0) queue.add(new Position(p.i, p.j - 1));
                    if (p.j + 1 < grid[0].length) queue.add(new Position(p.i, p.j + 1));
                }
            }
        }
        if (!temp.isEmpty()) result.add(temp);
    }


    public class Position {
        int i;
        int j;
        public Position(int row, int col) {
            this.i = row;
            this.j = col;
        }
    }
}
