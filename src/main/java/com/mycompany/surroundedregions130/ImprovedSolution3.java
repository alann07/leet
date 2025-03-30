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
 * Clean up and not use boolean isSurrounded. Instead, just iterate 4 different direcitions However, it uses 130ms.
 * weird. TODO: visit later.
 */
public class ImprovedSolution3 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int i = 0;
        for (int j=0; j<n; j++) {
            if (visited[i][j]) continue;
            if ('O' == board[i][j]) {
                isRegionSurrounded(board, i, j, m, n, visited);
            } else {
                visited[i][j] = true;
            }
        }
        i = m-1;
        for (int j=0; j<n; j++) {
            if (visited[i][j]) continue;
            if ('O' == board[i][j]) {
                isRegionSurrounded(board, i, j, m, n, visited);
            } else {
                visited[i][j] = true;
            }
        }
        int j = 0;
        for (int i1=0; i1<m; i1++) {
            if (visited[i1][j]) continue;
            if ('O' == board[i1][j]) {
                isRegionSurrounded(board, i1, j, m, n, visited);
            } else {
                visited[i1][j] = true;
            }
        }
        j = n-1;
        for (int i1=0; i1<m; i1++) {
            if (visited[i1][j]) continue;
            if ('O' == board[i1][j]) {
                isRegionSurrounded(board, i1, j, m, n, visited);
            } else {
                visited[i1][j] = true;
            }
        }
        updateSurroundedRegion(board, m, n, visited, 'X');
    }

    private void updateSurroundedRegion(char[][] board, int m, int n, boolean[][] visited, char val) {
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = val;
                }
            }
        }
    }

    private void isRegionSurrounded(char[][] board, int i, int j, int m, int n, boolean[][] visited) {
        if (i<0 || i==m || j<0 || j==n) return;
        if (visited[i][j]) return;
        visited[i][j] = true;
        if (board[i][j] == 'X') {
            return;
        }

        isRegionSurrounded(board, i, j+1, m, n, visited);
        isRegionSurrounded(board, i, j-1, m, n, visited);
        isRegionSurrounded(board, i-1, j, m, n, visited);
        isRegionSurrounded(board, i+1, j, m, n, visited);
    }
}
