package com.mycompany.generatematrix59;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(3);
        printMatrics(result);
        assertEquals(3, result.length);
        assertEquals(3, result[0].length);

        result = solution.generateMatrix(4);
        printMatrics(result);
        assertEquals(4, result.length);
        assertEquals(4, result[0].length);

        result = solution.generateMatrix(5);
        printMatrics(result);
        assertEquals(5, result.length);
        assertEquals(5, result[0].length);

        result = solution.generateMatrix(1);
        printMatrics(result);
        assertEquals(1, result.length);
        assertEquals(1, result[0].length);
    }

    void printMatrics(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }
}
