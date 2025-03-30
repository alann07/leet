package com.mycompany.surroundedregions130;

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 *
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none
 * of the region cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not
 * need to return anything.
 *
 * Dynamic programming with memorization.
 * 4ms Beats 21.15%, 49.85MB Beats 5.07%
 */
public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 1) continue;
                if ('O' == board[i][j]) {
                    if (isRegionSurrounded(board, i, j, m, n, visited)) {
                        captureRegion(board, m, n, visited);
                    } else {
                        resetRegion(board, m, n, visited);
                    }
                } else {
                    visited[i][j] = 1;
                }
            }
        }
    }

    private void resetRegion(char[][] board, int m, int n, int[][] visited) {
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 't' && visited[i][j] == 1) board[i][j] = 'O';
            }
        }
    }

    private void captureRegion(char[][] board, int m, int n, int[][] visited) {
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 't' && visited[i][j] == 1) board[i][j] = 'X';
            }
        }
    }


    private boolean isRegionSurrounded(char[][] board, int i, int j, int m, int n, int[][] visited) {
        if (i<0 || i==m || j<0 || j==n) return false;
        if (visited[i][j] == 1) return true;
        visited[i][j] = 1;

        if (board[i][j] == 'X') return true;
        else board[i][j] = 't';

        boolean boundaryCondition = (i==0 || i==m-1 || j==0 || j==n-1);
        boolean d1 = isRegionSurrounded(board, i, j+1, m, n, visited);
        boolean d2 = isRegionSurrounded(board, i, j-1, m, n, visited);
        boolean d3 = isRegionSurrounded(board, i-1, j, m, n, visited);
        boolean d4 = isRegionSurrounded(board, i+1, j, m, n, visited);
        return !boundaryCondition && d1 && d2 && d3 && d4;
    }
}
