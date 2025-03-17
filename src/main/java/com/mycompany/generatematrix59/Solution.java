package com.mycompany.generatematrix59;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2
 * in spiral order.
 * 0ms Beats 100.00%, 41.78MB Beats 17.08%
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n<1) return null;
        int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        int[][] result = new int[n][n];
        int val = 1;
        while( left<=right && top <= bottom) {
            for (int i=left; i<=right; i++) {
                result[top][i] = val++;
            }
            top ++;

            for (int i=top; i<=bottom; i++) {
                result[i][right] = val++;
            }
            right--;

            if (right>=left) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = val++;
                }
                bottom--;
            }

            if (bottom>=top) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = val++;
                }
                left++;
            }
        }

        return result;
    }
}
