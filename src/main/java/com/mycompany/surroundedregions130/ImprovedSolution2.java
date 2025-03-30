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
 * Only search islands on the outer layer of the board. Only they are not surrounded. Any inner regions without
 * touching the border are surrounded. Hence greatly reduce the computation.
 * 2ms Beats 85.69%, 45.34MB Beats 73.91%
 */
public class ImprovedSolution2 {
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

    private boolean isRegionSurrounded(char[][] board, int i, int j, int m, int n, boolean[][] visited) {
        if (i<0 || i==m || j<0 || j==n) return false;
        if (visited[i][j]) return true;

        if (board[i][j] == 'X') {
            visited[i][j] = true;
            return true;
        }
        else {
            visited[i][j] = true;
        }

        boolean boundaryCondition = (i==0 || i==m-1 || j==0 || j==n-1);
        boolean d1 = isRegionSurrounded(board, i, j+1, m, n, visited);
        boolean d2 = isRegionSurrounded(board, i, j-1, m, n, visited);
        boolean d3 = isRegionSurrounded(board, i-1, j, m, n, visited);
        boolean d4 = isRegionSurrounded(board, i+1, j, m, n, visited);
        return !boundaryCondition && d1 && d2 && d3 && d4;
    }
}
