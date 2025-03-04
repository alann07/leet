package com.mycompany.numbsttrees96;

// Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
// DP with only recursive is slow.
// 1240ms Beats 9.54% 40.48MB Beats 48.99%
public class Solution {
    public int numTrees(int n) {
        return findSolution(0, n);
    }

    public int findSolution(int start, int end) {
        if (start == end) return 0;
        if (end - start == 1) return 1;
        if (end - start == 2) return 2;

        int count = 0;
        for (int i=start; i<end; i++) {
            int left = findSolution(start, i);
            if (left == 0) left =1;
            int right = findSolution(i+1, end);
            if (right == 0) right =1;
            count += left * right;
        }
        return count;
    }
}
