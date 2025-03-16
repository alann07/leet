package com.mycompany.spiralorder54;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 0ms Beats 100.00%, 41.48MB Beats 80.47%
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] traversed = new int[n][m];
        int i=0, j=0;
        List<Integer> result = new ArrayList<>();
        int direction = 1; // 1 to the right, 2, down, 3, to the left, 4. left. 5. not moveable
        while (true) {
            result.add(matrix[i][j]);
            traversed[i][j] = 1;
            int[] nextPosAndDirection = getNextPostionAndDirection(n, m, i, j, traversed, direction);
            if (nextPosAndDirection[2] == 5) break;
            direction = nextPosAndDirection[2];
            i = nextPosAndDirection[0];
            j = nextPosAndDirection[1];
        }
        return result;
    }

    private int[] getNextPostionAndDirection(int rowBorder, int colBorder, int i, int j, int[][] traversed, int direction) {
        if (direction == 1) {
            if (j+1 < colBorder) {
                if (traversed[i][j+1]==0) {
                    j++;
                } else {
                    i++;
                    direction = 2;
                }
            } else {
                if (i+1<rowBorder && traversed[i+1][j]==0) {
                    i++;
                    direction = 2;
                } else {
                    direction = 5;
                }
            }
        } else if (direction == 2) {
            if (i+1 < rowBorder) {
                if (traversed[i+1][j]==0) {
                    i++;
                } else {
                    j--;
                    direction = 3;
                }
            } else {
                if (j-1 >= 0 && traversed[i][j-1]==0) {
                    j--;
                    direction = 3;
                } else {
                    direction = 5;
                }
            }
        } else if (direction == 3) {
            if (j-1 >= 0) {
                if (traversed[i][j-1]==0) {
                    j--;
                } else {
                    i--;
                    direction = 4;
                }
            } else {
                if (i-1>=0 && traversed[i-1][j]==0) {
                    i--;
                    direction = 4;
                } else {
                    direction = 5;
                }
            }
        } else { // direction = 4
            if (i-1 >= 0) {
                if (traversed[i-1][j]==0) {
                    i--;
                } else {
                    j++;
                    direction = 1;
                }
            } else {
                if (j+1 <= colBorder && traversed[i][j+1]==0) {
                    j++;
                    direction = 1;
                } else {
                    direction = 5;
                }
            }
        }
        if (i>=rowBorder || j>= colBorder || i < 0 || j < 0 || traversed[i][j] == 1) direction = 5;

        return new int[]{i, j, direction};
    }
}
