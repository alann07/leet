package com.mycompany.combine77;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Backtracking
 * Below solution is from forum. It use an array directly, and avoid unnecessary calls. 14ms is better.
 * 14ms Beats 95.92%, 94.66MB Beats 57.71%
 */
public class ImprovedSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] curr = new int[k];
        dfs(1, 0, n, k, curr, result);
        return result;
    }

    private void dfs(int start, int depth, int n, int k, int[] curr, List<List<Integer>> result) {
        if (depth == k) {
            List<Integer> combination = new ArrayList<>();
            for (int num : curr) combination.add(num);
            result.add(combination);
            return;
        }

        // Pruning to avoid unnecessary iterations
        for (int i = start; i <= n - (k - depth) + 1; i++) {
            curr[depth] = i;
            dfs(i + 1, depth + 1, n, k, curr, result);
        }
    }
}
