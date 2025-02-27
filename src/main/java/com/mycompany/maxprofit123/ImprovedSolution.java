package com.mycompany.maxprofit123;

// Solution from leet discussion
// 2ms Beats 91.78%
public class ImprovedSolution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0], last = 0;
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - last);
                last = dp[i];
                dp[i] = Math.max(dp[i-1],  prices[i] - min);
            }
        }
        return dp[prices.length - 1];
    }
}
