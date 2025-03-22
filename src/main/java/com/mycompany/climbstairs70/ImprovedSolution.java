package com.mycompany.climbstairs70;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * 0ms Beats 100.00%, 40.62MB Beats 27.32% (dp, reverse order, with memorization)
 */
public class ImprovedSolution {
    public int climbStairs(int n) {
        if (n<=0) return 0;
        int[] store = new int[n];
        for (int i=n-1; i>=0; i--) {
            dp(n, i, store);
        }
        return store[0];
    }

    private int dp(int n, int level, int[] store) {
        if (level >= n) {
            return 1;
        }

        if (store[level] == 0) {
            store[level] += dp(n, level + 1, store);
            if (level < n - 1) {
                store[level] += dp(n, level + 2, store);
            }
        }
        return store[level];
    }
}
