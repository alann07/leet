package com.mycompany.dungeongame174;

// just recursive is too slow. Need to use memorization to reduce duplicate traversing.
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int minVal = findSolution(dungeon, 0, 0, Integer.MAX_VALUE, 0);
        if (minVal > 0) return 1;
        else return 1-minVal;
    }

    /**
     *
     * @param dungeon
     * @param row
     * @param col
     * @param lastMin
     * @param sum
     * @return min of (sum, lastMin)
     */
    private int findSolution(int[][] dungeon, int row, int col, int lastMin, int sum) {
        sum += dungeon[row][col];
        lastMin = Math.min(lastMin, sum);
        if (row == dungeon.length-1 && col == dungeon[0].length-1)  {
            return lastMin;
        }

        if (row == dungeon.length-1) {
            return Math.min(lastMin, findSolution(dungeon, row, col+1, lastMin, sum));
        }
        if (col == dungeon[0].length-1) {
            return Math.min(lastMin, findSolution(dungeon, row+1, col, lastMin, sum));
        }


        return Math.max(findSolution(dungeon, row, col+1, lastMin, sum), findSolution(dungeon, row+1, col, lastMin, sum));
    }
}
