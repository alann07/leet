package com.mycompany.rotateimage48;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * 0ms Beats 100.00%, 42.34MB Beats 40.20%
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length == 1) return;

        int length = matrix.length;
        int rotateLoops = length/2;
        int rotateLen = length-1;

        int c1, c2, c3, c4;
        int start= 0;
        int lineLoopCount = length-1;
        while (rotateLoops>0) {

            for(int i=0; i<lineLoopCount; i++) {
                // Move 4 points at 1 time
                c1 = matrix[start][start+i];
                c2 = matrix[start+i][rotateLen-start];
                c3 = matrix[rotateLen-start][rotateLen-start-i];
                c4 = matrix[rotateLen-start-i][start];
                matrix[start+i][rotateLen-start] = c1;
                matrix[rotateLen-start][rotateLen-start-i] = c2;
                matrix[rotateLen-start-i][start] = c3;
                matrix[start][start+i] = c4;
            }
            lineLoopCount-=2;
            rotateLoops--;
            start++;
        }
    }
}
