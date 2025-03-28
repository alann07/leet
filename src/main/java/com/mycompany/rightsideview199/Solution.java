package com.mycompany.rightsideview199;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * 1ms Beats 70.75%, 42.38MB Beats 26.84%
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        List<List<Integer>> paths = new ArrayList<>();
        findSolution(root, paths, result);
        // process "paths". The first is the one to the right most of the tree, so it's a base.
        int visibleLenth = paths.get(0).size();
        for (int i=1; i< paths.size(); i++) {
            if (paths.get(i).size() > visibleLenth) {
                visibleLenth = paths.get(i).size();
                for (int j=paths.get(0).size(); j<visibleLenth; j++) {
                    paths.get(0).add(paths.get(i).get(j));
                }
            }
        }

        return paths.get(0);
    }

    private void findSolution(TreeNode curr, List<List<Integer>> paths, List<Integer> temp) {
        if (curr.left == null && curr.right == null) {
            temp.add(curr.val);
            paths.add(new ArrayList<>(temp));
            return;
        }
        temp.add(curr.val);
        if (curr.right != null) {
            findSolution(curr.right, paths, temp);
            temp.remove(temp.size()-1);
        }
        if (curr.left != null) {
            findSolution(curr.left, paths, temp);
            temp.remove(temp.size()-1);
        }
    }
}
