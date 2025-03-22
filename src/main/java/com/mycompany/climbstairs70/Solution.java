package com.mycompany.climbstairs70;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Below approach taok 2 sec to finish test case n=44. too slow. Need to add memorization.
 */
public class Solution {
    private int count;
    public int climbStairs(int n) {
        if (n<=0) return 0;
        count = 0;
        dp(n, 0);
        return count;
    }

    private void dp(int n, int level) {
        if (level >= n) {
            count++;
            return;
        }

        dp(n, level + 1);
        if (level < n-1) {
            dp(n, level + 2);
        }
    }
}
