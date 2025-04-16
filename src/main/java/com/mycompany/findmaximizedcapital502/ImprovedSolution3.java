package com.mycompany.findmaximizedcapital502;

import java.util.*;

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
 * Smart use of MaxHeap!!!
 * Refer to
 * https://leetcode.com/problems/ipo/solutions/3219987/day-54-c-priority-queue-easiest-beginner-friendly-sol/?envType=study-plan-v2&envId=top-interview-150
 * 107
 * ms
 * Beats
 * 52.24%
 */
public class ImprovedSolution3 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        PriorityQueue<Integer> maximizeCapital = new PriorityQueue<>(Collections.reverseOrder());
        while (k-- > 0) {
            while (i < n && projects[i][0] <= w) {
                maximizeCapital.offer(projects[i][1]);
                i++;
            }
            if (maximizeCapital.isEmpty()) {
                break;
            }
            w += maximizeCapital.poll();
        }
        return w;
    }
}
