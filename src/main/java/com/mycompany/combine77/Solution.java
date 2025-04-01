package com.mycompany.combine77;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Backtracking
 *
 * 17ms Beats 87.52%, 94.53MB Beats 73.71%
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n<1 || n>20 || k<1 || k>n) return null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findSolution(n, k, 1, result, temp);
        return result;
    }

    private void findSolution(int n, int k, int index, List<List<Integer>> result, List<Integer> temp) {
//        if (index>n) return;
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index; i<=n; i++) {
            temp.add(i);
            findSolution(n, k, i+1, result, temp);
            temp.remove(temp.size()-1);
        }
    }
}
