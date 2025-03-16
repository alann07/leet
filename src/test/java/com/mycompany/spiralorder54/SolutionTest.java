package com.mycompany.spiralorder54;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[][]matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
        assertEquals(9, result.size());

        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        result = solution.spiralOrder(matrix);
        System.out.println(result);
        assertEquals(12, result.size());

        matrix = new int[][]{{1,2,3,4}};
        result = solution.spiralOrder(matrix);
        System.out.println(result);
        assertEquals(4, result.size());

        matrix = new int[][]{{1},{2},{3},{4}};
        result = solution.spiralOrder(matrix);
        System.out.println(result);
        assertEquals(4, result.size());

        matrix = new int[][]{{1}};
        result = solution.spiralOrder(matrix);
        System.out.println(result);
        assertEquals(1, result.size());
    }
}
