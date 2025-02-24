package com.mycompany.dungeongame174;

// use bottom-up approach.
// 0ms Beats 100.00%, 45.15MB Beats 65.34%
public class ImprovedSolution2 {
    public int calculateMinimumHP(int[][] dungeon) {
        Integer[][] dp = new Integer[dungeon.length][dungeon[0].length];
        return findSolution(dungeon, 0, 0, dp);
    }

    /**
     *
     * @param dungeon
     * @param row
     * @param col
     * @return min of (sum, lastMin)
     */
    private int findSolution(int[][] dungeon, int row, int col, Integer[][] dp) {
        if (row == dungeon.length-1 && col == dungeon[0].length-1)  {
            if (dp[row][col] == null) {
                dp[row][col] = Math.max(1-dungeon[row][col], 1);
            }
            return dp[row][col];
        }

        // Last row
        if (row == dungeon.length-1) {
            if (dp[row][col] == null) {
                dp[row][col] = Math.max(findSolution(dungeon, row, col + 1, dp) - dungeon[row][col], 1);
            }
            return dp[row][col];
        }

        // Last col
        if (col == dungeon[0].length-1) {
            if (dp[row][col] == null)  {
                dp[row][col] = Math.max(findSolution(dungeon, row + 1, col, dp) - dungeon[row][col], 1);
            }
            return dp[row][col];
        }

        if (dp[row][col] == null) {
            int right = Math.max(findSolution(dungeon, row, col+1, dp) - dungeon[row][col] , 1);
            int down = Math.max(findSolution(dungeon, row+1, col, dp) - dungeon[row][col] , 1);
            dp[row][col] = Math.min(right, down);
        }
        return dp[row][col];
    }
}
