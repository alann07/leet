package com.mycompany.numbsttrees96;

// dp with memorization.
// 0ms Beats 100.00% 40.52MB Beats 37.10%
public class ImprovedSolution {
    public int numTrees(int n) {

        int[][] dp = new int[n][n];
        return findSolution(0, n, dp);
    }

    public int findSolution(int start, int end, int[][] dp) {
        if (start == end) return 0;
        if (end - start == 1) {
            return 1;
        }
        if (end - start == 2) {
            return 2;
        }

        int count = 0;
        for (int i=start; i<end; i++) {
            if (i>start && dp[start][i-1] == 0) {
                dp[start][i-1] = findSolution(start, i, dp);
                if (dp[start][i-1] == 0) dp[start][i-1] = 1;
            }
            if (i+1 <end && dp[start][i+1] == 0) {
                dp[i+1][end-1] = findSolution(i+1, end, dp);
                if (dp[i+1][end-1] == 0) dp[i+1][end-1] = 1;
            }
            if (i> start && i+1 < end-1) {
                count += dp[start][i-1] * dp[i + 1][end - 1];
            } else if (i<=start) {
                count += dp[i + 1][end - 1];
            } else {
                count += dp[start][i-1];
            }
//            dp[start][i] = count;
        }
        return count;
    }
}
