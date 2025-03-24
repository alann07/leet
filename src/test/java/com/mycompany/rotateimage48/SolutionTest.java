package com.mycompany.rotateimage48;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);
        solution.rotate(matrix);
        printMatrix(matrix);
        assertEquals(7, matrix[0][0]);
        assertEquals(3, matrix[2][2]);
        assertEquals(9, matrix[2][0]);
        assertEquals(1, matrix[0][2]);
        assertEquals(8, matrix[1][0]);
        assertEquals(2, matrix[1][2]);

        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printMatrix(matrix);
        solution.rotate(matrix);
        printMatrix(matrix);
        assertEquals(15, matrix[0][0]);
        assertEquals(5, matrix[0][3]);
        assertEquals(11, matrix[3][3]);
        assertEquals(16, matrix[3][0]);
    }

    void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+", ");
            }
            System.out.println();
        }
        System.out.println("**************");
    }
}
