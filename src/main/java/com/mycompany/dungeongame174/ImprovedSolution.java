package com.mycompany.dungeongame174;

// top-down dp is still slow, as some cell, based on different paths, has different values nad need to recalculate and hence increase latency.
public class ImprovedSolution {
    public int calculateMinimumHP(int[][] dungeon) {
        Integer[][] dp = new Integer[dungeon.length][dungeon[0].length];
        int minVal = findSolution(dungeon, 0, 0, Integer.MAX_VALUE, 0, dp);
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
    private int findSolution(int[][] dungeon, int row, int col, int lastMin, int sum, Integer[][] dp) {
        sum += dungeon[row][col];
        lastMin = Math.min(lastMin, sum);
        if (row == dungeon.length-1 && col == dungeon[0].length-1)  {
            if (dp[row][col] == null ||  dp[row][col] < lastMin) dp[row][col] = lastMin;
            return dp[row][col];
        }

        if (row == dungeon.length-1) {
            if (dp[row][col] == null || dp[row][col] < lastMin) dp[row][col] = Math.min(lastMin, findSolution(dungeon, row, col+1, lastMin, sum, dp));
            return dp[row][col];
        }
        if (col == dungeon[0].length-1) {
            if (dp[row][col] == null || dp[row][col] < lastMin) dp[row][col] = Math.min(lastMin, findSolution(dungeon, row+1, col, lastMin, sum, dp));
            return dp[row][col];
        }

        if (dp[row][col] == null  || dp[row][col] < lastMin) dp[row][col] = Math.max(findSolution(dungeon, row, col+1, lastMin, sum, dp),
                findSolution(dungeon, row+1, col, lastMin, sum, dp));
        return dp[row][col];
    }
}
