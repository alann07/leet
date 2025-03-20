package com.mycompany.btaverageoflevels637;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 *
 * 2ms Beats 94.39%, 45.70MB Beats 61.72% (BFS without using Queue).
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        List<Integer> count = new ArrayList<>();

        bfs(root, 0, result, count);
        for(int i=0; i<result.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;
    }

    private void bfs(TreeNode curr, int level, List<Double> result, List<Integer> count ) {
        if (level == result.size()) {
            result.add(level, (double) 0);
            count.add(level, 0);
        }
        result.set(level, result.get(level) + curr.val);
        count.set(level, count.get(level) + 1);
        if (curr.left != null) bfs(curr.left, level+1, result, count);
        if (curr.right != null) bfs(curr.right, level+1, result, count);
    }
}
