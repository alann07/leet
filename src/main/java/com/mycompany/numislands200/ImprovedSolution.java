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
 * 9ms Beats 11.97%, 49.22MB Beats 85.10%, with solution to remove result List from previous solution.
 * 6ms Beats 25.17%, 52.44MB Beats 14.89%, after only enque if next adjacent is '1'. so never put '0' into the queue.
 */
public class ImprovedSolution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Position> queue = new LinkedList<>();
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (visited[i][j] == 0) {
                    if (grid[i][j] == '1') {
                        queue.add(new Position(i, j));
                        bfs(grid, visited, queue);
                        count++;
                    }
                    else {
                        visited[i][j] = 1;
                    }
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int[][] visited, Queue<Position> queue) {
        while(!queue.isEmpty()) {
            Position p = queue.poll();
            if (visited[p.i][p.j] == 0) {
                visited[p.i][p.j] = 1;
                if (grid[p.i][p.j] == '1') { // enqueue adjacent 4 positions
                    if (p.i - 1 >= 0) enQueueNext(grid, visited, queue, p.i-1, p.j);
                    if (p.i + 1 < grid.length) enQueueNext(grid, visited, queue, p.i+1, p.j);
                    if (p.j - 1 >= 0) enQueueNext(grid, visited, queue, p.i, p.j-1);
                    if (p.j + 1 < grid[0].length) enQueueNext(grid, visited, queue, p.i, p.j+1);
                }
            }
        }
    }

    private void enQueueNext(char[][] grid, int[][] visited, Queue<Position> queue, int i, int j) {
        if (visited[i][j] == 0) {
            if (grid[i][j] == '1')
                queue.add(new Position(i, j));
            else
                visited[i][j] = 1;
        }
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
