package com.mycompany.findmaximizedcapital502;

/**
 * 502. IPO
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
 * LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited
 * resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way
 * to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i]
 * is needed to start it.
 *
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will
 * be added to your total capital.
 *
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the
 * final maximized capital.
 *
 * The answer is guaranteed to fit in a 32-bit signed integer.
 *
 * The memorization part is variable with different combinations. Therefore, not applicable.
 *
 */
public class ImprovedSolution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits==null || profits.length == 0 || capital == null || capital.length == 0) return w;
        int max = -1;
        if (k> profits.length) k = profits.length;
        int[] store = new int[profits.length];
        boolean[] visited =  new boolean[profits.length];
        for (int i=profits.length-1; i>=0; i--) {
            max = Math.max(max, dp(k, w, profits, capital, i, 0, store, visited));
            store[i] = max;
            visited[i] = true;
        }
        return max;
    }

    private int dp(int k, int w, int[] profits, int[] capital, int index, int count, int[] store, boolean[] visited) {
        if (index >= profits.length || ++count > k || w < capital[index]) return w;
        if (count == k) return w+profits[index];
        int total = w;
        int subMax = 0;
        total += profits[index];
        int m1 = dp(k, total, profits, capital, index+1, count, store, visited);
        int m2 = dp(k, total, profits, capital, index+2, count, store, visited);
        subMax = Math.max(m1, m2);
        return subMax;
    }
}
